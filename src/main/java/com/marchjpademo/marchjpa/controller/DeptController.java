package com.marchjpademo.marchjpa.controller;

import com.marchjpademo.marchjpa.model.Department;
import com.marchjpademo.marchjpa.repositories.DeptRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {

    @Autowired
    private DeptRepo deptRepo;

    @PostMapping(value="/savedept")
    public String saveDept(@RequestBody Department department){
        deptRepo.save(department);
        return "dept saved";
    }
}
