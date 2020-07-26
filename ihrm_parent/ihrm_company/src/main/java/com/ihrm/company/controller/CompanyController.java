package com.ihrm.company.controller;

import com.ihrm.common.entity.Result;
import com.ihrm.common.entity.ResultCode;
import com.ihrm.company.service.CompanyService;
import com.ihrm.domain.company.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    /**
     * 保存信息
     * @param company
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Result saveCompany(@RequestBody Company company){
        companyService.add(company);
        return new Result(ResultCode.SUCCESS);
    }

    /**
     * 根据id删除信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result delCompany(@PathVariable(value = "id") String id){
        companyService.deleteById(id);
        return new Result(ResultCode.SUCCESS);
    }

    /**
     * 修改信息
     * @param id
     * @param company
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Result updateCompany(@PathVariable(value = "id") String id, @RequestBody Company company){
        company.setId(id);
        companyService.update(company);
        return new Result(ResultCode.SUCCESS);
    }

    /**
     * 根据id查询信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result findById(@PathVariable(value = "id") String id){
        Company company = companyService.findById(id);
        return new Result(ResultCode.SUCCESS, company);
    }

    /**
     * 查询所有
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Result findAll(){
        List<Company> companyList = companyService.findAll();
        return new Result(ResultCode.SUCCESS, companyList);
    }
}
