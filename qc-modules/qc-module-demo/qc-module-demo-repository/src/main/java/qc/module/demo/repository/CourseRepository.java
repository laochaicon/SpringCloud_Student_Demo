package qc.module.demo.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import qc.module.demo.entity.Course;

@Mapper
public interface CourseRepository extends BaseMapper<Course> {
    
}
