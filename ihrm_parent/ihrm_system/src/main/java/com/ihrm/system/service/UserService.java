package com.ihrm.system.service;

import com.ihrm.common.utils.IdWorker;
import com.ihrm.domain.system.User;
import com.ihrm.system.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserService{

    @Autowired
    private UserDao userDao;
    @Autowired
    private IdWorker idWorker;

    /**
     * 添加
     * @param user
     */
    public void save(User user){
        String id = idWorker.nextId() + "";
        user.setId(id);
        user.setPassword("123456"); //设置初始密码
        user.setEnableState(1);
        userDao.save(user);
    }

    /**
     * 更新用户
     * @param user
     */
    public void update(User user){
        //根据ID查询用户
        User targetUser = userDao.findById(user.getId()).get();
        if (targetUser != null && !StringUtils.isEmpty(targetUser.getId())){
            //2.设置部门属性
            targetUser.setUsername(user.getUsername());
            targetUser.setPassword(user.getPassword());
            targetUser.setDepartmentId(user.getDepartmentId());
            targetUser.setDepartmentName(user.getDepartmentName());
            //3.更新部门
            userDao.save(targetUser);
        }
    }

    /**
     * 3.根据id查询用户
     */
    public User findById(String id) {
        return userDao.findById(id).get();
    }

    public Page<User> findAll(Map<String, Object> map, int pageNo, int pageSize){
        Specification<User> specification = new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList = new ArrayList<>();
                //如果企业ID不为空，就创造查询条件
                if (!StringUtils.isEmpty(map.get("companyId"))){
                    predicateList.add(criteriaBuilder.equal(root.get("companyId").as(String.class), (String)map.get("companyId")));
                }
                if (!StringUtils.isEmpty(map.get("departmentId"))){
                    predicateList.add(criteriaBuilder.equal(root.get("departmentId").as(String.class), (String)map.get("departmentId")));
                }
                if (!StringUtils.isEmpty(map.get("hasDept"))){
                    if ("0".equals((String)map.get("hasDept"))){
                        predicateList.add(criteriaBuilder.isNull(root.get("departmentId")));
                    }else {
                        predicateList.add(criteriaBuilder.isNotNull(root.get("departmentId")));
                    }
                }
                return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        };
        //分页
        Page<User> userPage = userDao.findAll(specification, new PageRequest(pageNo-1, pageSize));
        return userPage;
    }

    /**
     * 5.根据id删除用户
     */
    public void deleteById(String id) {
        userDao.deleteById(id);
    }
}
