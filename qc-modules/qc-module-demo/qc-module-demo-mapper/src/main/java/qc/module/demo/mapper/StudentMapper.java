package qc.module.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import qc.module.demo.dto.student.StudentAddDto;
import qc.module.demo.dto.student.StudentDto;
import qc.module.demo.dto.student.StudentScoreDto;
import qc.module.demo.dto.user.UserAddDto;
import qc.module.demo.dto.user.UserDto;
import qc.module.demo.entity.Student;
import qc.module.demo.entity.User;

import java.util.List;

@Mapper
public interface StudentMapper {
    StudentMapper MAPPER= Mappers.getMapper(StudentMapper.class);
    @Mapping(target = "BIRTHDAY",ignore = true)
    @Mapping(target = "INSCHOOKDAY",ignore = true)
    //手动转换时间
    Student toEntity(StudentDto dto);

    @Mapping(target = "id", ignore = true)
    //新增时没有ID
    @Mapping(target = "birthday", ignore = true)
    @Mapping(target = "inschoolday", ignore = true)
    //时间需要手动转换
    Student toEntity(StudentAddDto dto);

    @Mapping(target = "birthday", source = "birthday", dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Mapping(target = "inschoolday", source = "inschoolday", dateFormat = "yyyy-MM-dd HH:mm:ss")
    StudentDto toDto(Student en);
    
    List<StudentDto> toDtoList(List<Student> list);
    
}
