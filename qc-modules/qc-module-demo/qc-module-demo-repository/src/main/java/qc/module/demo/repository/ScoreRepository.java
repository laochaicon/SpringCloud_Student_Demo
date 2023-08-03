package qc.module.demo.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import qc.module.demo.entity.Score;

@Mapper
public interface ScoreRepository extends BaseMapper<Score> {
}
