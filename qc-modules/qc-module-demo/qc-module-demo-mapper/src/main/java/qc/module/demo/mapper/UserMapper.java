package qc.module.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import qc.module.demo.dto.user.UserAddDto;
import qc.module.demo.dto.user.UserDto;
import qc.module.demo.entity.User;

import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "expiredtm", ignore = true)
        //时间需要手动转换
    User toEntity(UserDto dto);

    @Mapping(target = "id", ignore = true)
//新增时没有ID
    @Mapping(target = "expiredtm", ignore = true)
        //时间需要手动转换
    User toEntity(UserAddDto dto);

    @Mapping(target = "expiredtm", source = "expiredtm", dateFormat = "yyyy-MM-dd HH:mm:ss")
    UserDto toDto(User en);

    List<UserDto> toDtoList(List<User> list);
}
