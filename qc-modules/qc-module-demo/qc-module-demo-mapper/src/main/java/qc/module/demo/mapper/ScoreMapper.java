package qc.module.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.mapstruct.factory.Mappers;
import qc.module.demo.dto.student.StudentScoreDto;
import qc.module.demo.entity.Score;

import java.util.List;

@Mapper
public interface ScoreMapper {
    ScoreMapper MAPPER = Mappers.getMapper(ScoreMapper.class);

    List<StudentScoreDto> toDtoList(List<Score> list);
}
