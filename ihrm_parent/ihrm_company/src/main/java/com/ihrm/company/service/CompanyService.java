package com.ihrm.company.service;

import com.ihrm.common.utils.IdWorker;
import com.ihrm.company.dao.CompanyDao;
import com.ihrm.domain.company.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private IdWorker idWorker;

    //增加
    public void add(Company company){
        String id = idWorker.nextId() + "";
        company.setId(id);
        company.setName(company.getName());
        company.setManagerId("222");
        company.setAuditState("1");
        company.setState(1);
        company.setBalance(10000.0);
        company.setCreateTime(new Date());
        companyDao.save(company);
    }

    //根据id删除
    public void deleteById(String id){
        Company company = companyDao.findById(id).get();
        if (company != null && company.getId() != null){
            companyDao.deleteById(id);
        }
    }

    //根据id修改
    public Company update(Company company){
        Company temp = companyDao.findById(company.getId()).get();
        temp.setName(company.getName());
        temp.setCompanyPhone(company.getCompanyPhone());
        return companyDao.save(temp);
    }

    //根据id查询
    public Company findById(String id){
        return companyDao.findById(id).get();
    }

    //查询所有
    public List<Company> findAll(){
        return companyDao.findAll();
    }
}
