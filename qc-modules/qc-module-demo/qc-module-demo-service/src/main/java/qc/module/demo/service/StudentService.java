package qc.module.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qc.common.core.exception.QCPromptException;
import qc.module.demo.dto.student.StudentDto;
import qc.module.demo.dto.student.StudentQueryConditionDto;
import qc.module.demo.entity.Student;
import qc.module.demo.mapper.StudentMapper;
import qc.module.demo.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository repository;

    @Autowired
    public void setRepository(StudentRepository repository) {
        this.repository = repository;
    }
    

    @Autowired
    public void setClassService(ClassService classService) {
        this.classService = classService;
    }

    private ClassService classService;

    /**
     * 根据查询条件查询学生信息
     */

    public List<StudentDto> query(StudentQueryConditionDto condition) {
        //查询条件可以为空，表示查询所有用户
        LambdaQueryWrapper<Student> wrapper = new LambdaQueryWrapper<>();
        if (condition != null) {
            //班级编码，可以不指定


            //判断是否有关键字条件，如果有需要匹配学生姓名、学号、手机号、家庭地址中的一个
            if (!StringUtils.isBlank(condition.getKeywords())) {
                wrapper.and(q -> {
                    q.like(Student::getNAME,
                            condition.getKeywords()).or().like(Student::getNO,
                            condition.getKeywords()).or().like(Student::getPHONE,
                            condition.getKeywords()).or().like(Student::getHOMEADDERSS,
                            condition.getKeywords());
                });
            }
        }
        //排序
        wrapper.orderByAsc(Student::getNAME);

        //查询
        List<Student> ens = repository.selectList(wrapper);

        if (ens != null && ens.size() > 0x0) {
            return StudentMapper.MAPPER.toDtoList(ens);
        }

        return null;
    }
    /**
     * 获取指定ID的学生
     */
    public StudentDto get(int studentNO) throws QCPromptException {
        LambdaQueryWrapper<Student> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Student::getNO, studentNO);

        Student student = repository.selectOne(wrapper);

        if (student != null)
            return StudentMapper.MAPPER.toDto(student);

        throw new QCPromptException("指定的学生信息不存在");
    }




}
