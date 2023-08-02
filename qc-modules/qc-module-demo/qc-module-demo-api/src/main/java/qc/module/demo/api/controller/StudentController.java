package qc.module.demo.api.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import qc.common.core.exception.QCPromptException;
import qc.module.demo.dto.student.StudentAddDto;
import qc.module.demo.dto.student.StudentDto;
import qc.module.demo.dto.student.StudentQueryConditionDto;
import qc.module.demo.service.StudentService;

import java.util.List;

@Api
@RestController
@RequestMapping("/student")
public class StudentController {
    private StudentService studentService;
    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
    
    /**
     * 根据条件查询学生
     *
     * @param condition 查询条件
     * @return 学生集合
     */
    @RequestMapping(value = "/query", method = {RequestMethod.GET, RequestMethod.POST})
    public List<StudentDto> query(@RequestBody StudentQueryConditionDto condition) {
        return studentService.query(condition);
    }

    /**
     * 获取指定学生信息，从param参数中传值
     *
     * @param id 学生ID
     * @return 学生信息
     */
    @RequestMapping(value = "/get", method = {RequestMethod.GET})
    public StudentDto getByParam(@RequestParam int id) throws QCPromptException {
        return studentService.get(id);
    }

}
