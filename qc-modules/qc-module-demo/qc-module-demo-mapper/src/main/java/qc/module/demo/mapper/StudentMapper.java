package qc.module.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import qc.module.demo.dto.student.StudentDto;
import qc.module.demo.entity.Student;

import java.util.List;

@Mapper
public interface StudentMapper {
    StudentMapper MAPPER= Mappers.getMapper(StudentMapper.class);
    //时间需要手动转换
    @Mapping(target = "birthday", source = "birthday", dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Mapping(target = "inSchoolDay", source = "inSchoolDay", dateFormat = "yyyy-MM-dd HH:mm:ss")
    Student toEntity(StudentDto dto);

    @Mapping(target = "birthday", source = "birthday", dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Mapping(target = "inSchoolDay", source = "inSchoolDay", dateFormat = "yyyy-MM-dd HH:mm:ss")
    StudentDto toDto(Student en);
    
    List<StudentDto> toDtoList(List<Student> list);
    
}
