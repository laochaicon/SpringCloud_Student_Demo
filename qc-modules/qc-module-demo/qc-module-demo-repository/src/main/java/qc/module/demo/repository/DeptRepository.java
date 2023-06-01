package qc.module.demo.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import qc.module.demo.entity.Dept;

@Mapper
public interface DeptRepository extends BaseMapper<Dept> {
}
