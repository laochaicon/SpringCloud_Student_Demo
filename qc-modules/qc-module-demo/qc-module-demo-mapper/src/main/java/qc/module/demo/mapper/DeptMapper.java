package qc.module.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import qc.module.demo.dto.dept.DeptDto;
import qc.module.demo.entity.Dept;

import java.util.List;

/**
 * DeptMapper
 *
 * @author QuCheng Tech
 * @since 2023/5/31
 */
@Mapper
public interface DeptMapper {
    DeptMapper MAPPER = Mappers.getMapper(DeptMapper.class);

    DeptDto toDto(Dept en);

    List<DeptDto> toDtoList(List<Dept> list);
}
