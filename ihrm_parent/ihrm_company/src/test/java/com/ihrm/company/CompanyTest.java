package com.ihrm.company;

import com.ihrm.company.dao.CompanyDao;
import com.ihrm.domain.company.Company;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CompanyTest {

    @Autowired
    private CompanyDao companyDao;

    @Test
    public void testGet(){
        Company company1 = companyDao.findById("1").get();
        System.out.println(company1);
    }

    @Test
    public void testSave(){
        Company company = new Company();
        company.setId("1");
        company.setName("第一家公司");
        company.setManagerId("111");
        company.setCompanyPhone("1111");
        company.setBalance(1000.0);
        company.setState(1);
        company.setCreateTime(new Date());
        companyDao.save(company);
    }
}
