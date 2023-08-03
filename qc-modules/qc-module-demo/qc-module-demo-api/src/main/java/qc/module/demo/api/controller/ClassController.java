package qc.module.demo.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import qc.module.demo.dto.classes.ClassesDto;
import qc.module.demo.service.ClassService;

import java.util.List;

@RestController
@RequestMapping("/class")
public class ClassController {
    private ClassService classService;

    @Autowired
    public void setClassService(ClassService classService) {
        this.classService = classService;
    }

    //查询所有班级
    @GetMapping("/all")
    private List<ClassesDto> all() {
        return classService.getAll();
    }

}
