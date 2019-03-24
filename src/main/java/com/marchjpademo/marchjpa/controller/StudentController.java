package com.marchjpademo.marchjpa.controller;

import com.marchjpademo.marchjpa.model.Department;
import com.marchjpademo.marchjpa.model.Student;
import com.marchjpademo.marchjpa.repositories.DeptRepo;
import com.marchjpademo.marchjpa.repositories.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private DeptRepo deptRepo;

    @PostMapping(value="/save")
    public String saveStudent(@RequestBody Student student){
        studentRepo.save(student);
        return "Data saved";
    }

    @GetMapping(value="/getstudents")
    public List<Student> getData(){
        List<Student> list=studentRepo.findAll();
        return list;
    }

    @PostMapping(value="/savestu")
    public String saveStudent1(@RequestParam String name,
                               @RequestParam String city,
                               @RequestParam MultipartFile multipartFile,
                               @RequestParam Integer deptId){

        String fileName=multipartFile.getOriginalFilename();
        String imagePath=null;
        File file=new File("/Users/abhi/Desktop/imageupload/"+fileName);

        try {
            multipartFile.transferTo(file);
            imagePath=file.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Student student=new Student();
       // student.setId(3);
        student.setName(name);
        student.setCity(city);
        student.setImagePath(imagePath);

        Department d=deptRepo.findById(deptId).orElse(new Department());
        student.setDepartment(d);
        studentRepo.save(student);
        return "Data saved";
    }

}
