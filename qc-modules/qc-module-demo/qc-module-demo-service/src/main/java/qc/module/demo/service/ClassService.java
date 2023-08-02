package qc.module.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qc.module.demo.dto.classes.ClassesDto;
import qc.module.demo.entity.Classes;
import qc.module.demo.entity.Dept;
import qc.module.demo.mapper.ClassMapper;
import qc.module.demo.repository.ClassRepository;

import java.util.List;

@Service
public class ClassService {
    private ClassRepository classRepository;
    
    @Autowired
    public void setClassRepository(ClassRepository classRepository){
        this.classRepository=classRepository;
    }
    /**
     * 获取所有班级
     */
    public List<ClassesDto> all(){
        LambdaQueryWrapper<Classes> wrapper = new LambdaQueryWrapper<>();
        
        //排序
        wrapper.orderByAsc(Classes::getNAME);
        //查询数据
        List<Classes> ens=classRepository.selectList(wrapper);

        if (ens != null && ens.size() > 0x0)
            return ClassMapper.MAPPER.toDtoList(ens);

        return null;
    }

    /**
     * 判断指定的ID是否存在
     *
     * @param no 
     * @return true表示已存在，false表示不存在
     */
    public boolean hasIdExist(String no) {
        LambdaQueryWrapper<Classes> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Classes::getNO, no);

        Classes en = classRepository.selectOne(wrapper);
        if (en != null)
            return true;

        return false;
    }
}
