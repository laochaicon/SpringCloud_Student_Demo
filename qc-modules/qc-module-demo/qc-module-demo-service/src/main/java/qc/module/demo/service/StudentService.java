package qc.module.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qc.common.core.exception.QCPromptException;
import qc.common.core.unify.QCUnifyReturnValue;
import qc.module.demo.dto.student.StudentAddDto;
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
                            condition.getKeywords()).or().like(Student::getHOMEADDRESS,
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

    /**
     * 新增学生
     */
    public String add(StudentDto dto) {
        if (dto == null)
            return QCUnifyReturnValue.Warn("对象不能为空");
        if (StringUtils.isBlank(dto.getNAME()))
            return QCUnifyReturnValue.Warn("学生姓名不能为空");
        //判断名称不能重复
        if (isNameHasExist(dto.getNAME(), Integer.valueOf(dto.getNO())))
            return QCUnifyReturnValue.Warn("学生名称已存在，名称不能相同");

        //DTO转换为Entity
        Student en = StudentMapper.MAPPER.toEntity(dto);

        if (repository.insert(en) < 0x1)
            return QCUnifyReturnValue.Warn("新增学生失败");

        return QCUnifyReturnValue.Success();
    }


    /**
     * 修改学生信息
     *
     * @param dto 学生信息
     * @return 成功返回null
     */
    public String update(StudentDto dto) {
        if (dto == null)
            return QCUnifyReturnValue.Warn("对象不能为空");
        if (dto.getNO() == null)
            return QCUnifyReturnValue.Warn("学生NO不能为空");
        if (StringUtils.isBlank(dto.getNAME()))
            return QCUnifyReturnValue.Warn("学生姓名不能为空");

        //DTO转换为Entity
        Student en = StudentMapper.MAPPER.toEntity(dto);
        //判断修改的学生信息是否存在
        if (!hasIdExist(Integer.valueOf(en.getNO())))
            return QCUnifyReturnValue.Warn("修改的学生NO不存在");
        //判断姓名不能重复
        if (isNameHasExist(dto.getNAME(), Integer.valueOf(en.getNO())))
            return QCUnifyReturnValue.Warn("学生姓名已存在，名称不能相同");
        

        return QCUnifyReturnValue.Success();
    }

    /**
     * 删除学生
     *
     * @param studentNO 用户ID
     * @return 成功返回null
     */
    public String delete(int studentNO) {
        if (!hasIdExist(studentNO))
            return QCUnifyReturnValue.Warn("删除的学生NO不存在");

        repository.deleteById(studentNO);

        return QCUnifyReturnValue.Success();
    }



    /**
     * 判断指定的NO是否存在
     */
    public boolean hasIdExist(Integer NO) {
        LambdaQueryWrapper<Student> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Student::getNO, NO);

        Student en = repository.selectOne(wrapper);
        if (en != null)
            return true;

        return false;
    }

    /**
     * @param name 名称
     * @param no   ID，新增时设置ID为0，修改时设置ID为记录ID
     * @return true表示名称已存在，false表示名称不存在
     */
    boolean isNameHasExist(String name, Integer no) {
        //验证名称是否重复条件：name=name and id<>id
        LambdaQueryWrapper<Student> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Student::getNAME, name);
        wrapper.ne(Student::getNO, no);

        Student en = repository.selectOne(wrapper);
        if (en != null)
            return true;
        return false;
    }


}
