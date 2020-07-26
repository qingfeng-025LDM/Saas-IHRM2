package com.ihrm.company.controller;

import com.ihrm.common.controller.BaseController;
import com.ihrm.common.entity.Result;
import com.ihrm.common.entity.ResultCode;
import com.ihrm.company.service.CompanyService;
import com.ihrm.company.service.DepartmentService;
import com.ihrm.domain.company.Company;
import com.ihrm.domain.company.Department;
import com.ihrm.domain.company.response.DeptListResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/company")
public class DepartmentController extends BaseController {

    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private CompanyService companyService;

    /**
     * 新增
     * @param department
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/department", method = RequestMethod.POST)
    public Result add(@RequestBody Department department){
        department.setCompanyId(companyId);
        departmentService.add(department);
        return new Result(ResultCode.SUCCESS);
    }

    /**
     * 根据ID删除
     * @param id
     * @return
     */
    @RequestMapping(value = "/department/{id}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable("id") String id){
        departmentService.delete(id);
        return new Result(ResultCode.SUCCESS);
    }

    /**
     * 修改
     * @param department
     * @return
     */
    @RequestMapping(value = "/department/{id}", method = RequestMethod.PUT)
    public Result update(@PathVariable("id") String id, @RequestBody Department department){
        department.setId(id);
        departmentService.update(department);
        return new Result(ResultCode.SUCCESS);
    }

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    @RequestMapping(value = "/department/{id}", method = RequestMethod.GET)
    public Result findById(@PathVariable("id") String id){
        Department department = departmentService.findById(id);
        return new Result(ResultCode.SUCCESS, department);
    }

    @ResponseBody
    @RequestMapping(value = "/department", method = RequestMethod.GET)
    public Result findListByComparyId(){
        Company company = companyService.findById(companyId);
        List<Department> deptList = departmentService.findAll(companyId);
        //构造返回结果
        DeptListResult deptListResult = new DeptListResult(company, deptList);
        return new Result(ResultCode.SUCCESS, deptListResult);
    }
}
