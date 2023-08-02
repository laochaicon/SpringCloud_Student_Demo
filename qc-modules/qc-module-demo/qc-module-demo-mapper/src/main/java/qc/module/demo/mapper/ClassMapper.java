package qc.module.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import qc.module.demo.dto.classes.ClassesDto;
import qc.module.demo.entity.Classes;

import java.util.List;

@Mapper
public interface ClassMapper {
    ClassMapper MAPPER= Mappers.getMapper(ClassMapper.class);
    
    ClassesDto toDto(Classes en);
    
    List<ClassesDto> toDtoList(List<Classes> ens);
}
