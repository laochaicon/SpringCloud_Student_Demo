package qc.module.demo.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import qc.module.demo.entity.Classes;

@Mapper
public interface ClassRepository extends BaseMapper<Classes> {
}
