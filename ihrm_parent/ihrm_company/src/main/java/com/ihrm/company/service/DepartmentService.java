package com.ihrm.company.service;

import com.ihrm.common.service.BaseService;
import com.ihrm.common.utils.IdWorker;
import com.ihrm.company.dao.DepartmentDao;
import com.ihrm.domain.company.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DepartmentService extends BaseService {

    @Autowired
    private DepartmentDao departmentDao;
    @Autowired
    private IdWorker idWorker;

    /**
     * 增加
     */
    public void add(Department department){
        String id = idWorker.nextId() + "";
        department.setId(id);
        departmentDao.save(department);
    }

    /**
     * 删除
     * @param id
     */
    public void delete(String id){
        Department department = departmentDao.findById(id).get();
        if (department != null && department.getId() != null){
            departmentDao.deleteById(id);
        }
    }

    /**
     * 修改
     * @param department
     */
    public void update(Department department){
        Department tempDepartment = departmentDao.findById(department.getId()).get();
        tempDepartment.setName("技术部");
        tempDepartment.setCreateTime(new Date());
        departmentDao.save(tempDepartment);
    }

    /**
     * 查询单个部门
     */
    public Department findById(String id){
        return departmentDao.findById(id).get();
    }

    /**
     * 根据企业ID查询部门列表
     */
    public List<Department> findAll(String companyId){
        return departmentDao.findAll(getSpecification(companyId));
    }
}
