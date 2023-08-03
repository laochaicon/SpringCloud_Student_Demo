package qc.module.demo.api.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import qc.common.core.exception.QCPromptException;
import qc.module.demo.dto.student.StudentAddDto;
import qc.module.demo.dto.student.StudentDto;
import qc.module.demo.dto.student.StudentQueryConditionDto;
import qc.module.demo.service.StudentService;

import java.util.ArrayList;
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
     * @param condition 查询条件
     * @return 学生集合
     */
    @RequestMapping(value = "/query", method = {RequestMethod.GET, RequestMethod.POST})
    public List<StudentDto> query(@RequestBody StudentQueryConditionDto condition) {
        return  studentService.query(condition);
    }

    /**
     * 获取指定学生信息，从param参数中传值
     * @param id 学生ID
     * @return 学生信息
     */
    @RequestMapping(value = "/get", method = {RequestMethod.GET})
    public StudentDto getByParam(@RequestParam int id) throws QCPromptException {
        return studentService.get(id);
    }
    
    /**
     * 新增学生
     *
     * @param dto 新增学生信息
     * @return 成功返回null，失败返回错误信息
     */
    @RequestMapping(value = "/add", method = {RequestMethod.POST})
    public String add(@RequestBody StudentDto dto) {
        return studentService.add(dto);
    }
    
    /**
     * 修改学生
     *
     * @param dto 学生信息
     * @return 成功返回null，失败返回错误信息
     */
    @RequestMapping(value = "/update", method = {RequestMethod.PUT})
    public String update(@RequestBody StudentDto dto) {
        return studentService.update(dto);
    }

    /**
     * 删除学生
     * @param no 学生NO
     * @return 成功返回null，失败返回错误信息
     */
    @RequestMapping(value = "/delete", method = {RequestMethod.DELETE})
    public String delete(@RequestParam int no) {
        return studentService.delete(no);
    }

    /**
     * 通过学生id 查询学生成绩
     * @param id  学生学号
     * @return
     */
    



}
