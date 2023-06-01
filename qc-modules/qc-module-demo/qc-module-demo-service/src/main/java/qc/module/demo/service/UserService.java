package qc.module.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qc.common.core.exception.QCPromptException;
import qc.common.core.unify.QCUnifyReturnValue;
import qc.common.core.utils.DateUtil;
import qc.module.demo.dto.user.UserAddDto;
import qc.module.demo.dto.user.UserDto;
import qc.module.demo.dto.user.UserQueryConditionDto;
import qc.module.demo.entity.User;
import qc.module.demo.mapper.UserMapper;
import qc.module.demo.repository.UserRepository;

import java.util.Date;
import java.util.List;

@Service
public class UserService {
    private UserRepository repository;

    @Autowired
    public void setUserRepository(UserRepository repository) {
        this.repository = repository;
    }

    private DeptService deptService;

    @Autowired
    public void setDeptService(DeptService deptService) {
        this.deptService = deptService;
    }

    /**
     * 根据查询条件查询用户信息
     *
     * @param condition 查询条件
     * @return 用户集合
     * @author QuCheng Tech
     * @since 2023/6/1
     */
    public List<UserDto> query(UserQueryConditionDto condition) {
        //查询条件可以为空，表示查询所有用户
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        if (condition != null) {
            //判断是否有状态条件：2表示启用，3表示禁用，输入其他表示查询所有
            boolean hasStatusCondition = false;
            if (condition.getStatus() == 0x2 || condition.getStatus() == 0x3)
                wrapper.eq(User::getEnable, condition.getStatus() == 0x2 ? true : false);
            //判断是否有关键字条件，如果有需要匹配用户名称、登录名、手机号中的一种
            if (!StringUtils.isBlank(condition.getKeywords())) {
                wrapper.and(q -> {
                    q.like(User::getName, condition.getKeywords()).or().like(User::getCode, condition.getKeywords()).or().like(User::getPhone, condition.getKeywords());
                });
            }
        }
        //排序
        wrapper.orderByAsc(User::getName);

        //查询
        List<User> ens = repository.selectList(wrapper);

        if (ens != null && ens.size() > 0x0) {
            return UserMapper.MAPPER.toDtoList(ens);
        }

        return null;
    }

    /**
     * 获取指定ID的用户信息
     *
     * @param userId 用户ID
     * @return 用户信息
     * @author QuCheng Tech
     * @since 2023/6/1
     */
    public UserDto get(int userId) throws QCPromptException {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getId, userId);

        User user = repository.selectOne(wrapper);

        if (user != null)
            return UserMapper.MAPPER.toDto(user);

        throw new QCPromptException("指定的用户信息不存在");
    }

    /**
     * 新增用户
     *
     * @param dto 用户信息
     * @return 成功返回null
     * @author QuCheng Tech
     * @since 2023/6/1
     */
    public String add(UserAddDto dto) {
        if (dto == null)
            return QCUnifyReturnValue.Warn("对象不能为空");
        if (StringUtils.isBlank(dto.getName()))
            return QCUnifyReturnValue.Warn("用户名称不能为空");
        //判断名称不能重复
        if (isNameHasExist(dto.getName(), 0x0))
            return QCUnifyReturnValue.Warn("用户名称已存在，名称不能相同");

        //判断部门是否存在
        if (!deptService.hasIdExist(dto.getDeptid()))
            return QCUnifyReturnValue.Warn("指定的部门信息不存在");

        //DTO转换为Entity
        User en = UserMapper.MAPPER.toEntity(dto);
        //新增时需设置ID
        en.setId(genereateId());
        //判断过期时间
        if (!StringUtils.isBlank(dto.getExpiretime())) {
            Date expireTime = DateUtil.parseDate(dto.getExpiretime());
            en.setExpiredtm(expireTime);
        }

        if (repository.insert(en) < 0x1)
            return QCUnifyReturnValue.Warn("新增用户失败");

        return QCUnifyReturnValue.Success();
    }

    /**
     * 修改用户信息
     *
     * @param dto 用户信息
     * @return 成功返回null
     * @author QuCheng Tech
     * @since 2023/6/1
     */
    public String update(UserDto dto) {
        if (dto == null)
            return QCUnifyReturnValue.Warn("对象不能为空");
        if (dto.getId() < 0x1)
            return QCUnifyReturnValue.Warn("用户ID不能为空");
        if (StringUtils.isBlank(dto.getName()))
            return QCUnifyReturnValue.Warn("用户名称不能为空");

        //DTO转换为Entity
        User en = UserMapper.MAPPER.toEntity(dto);
        //判断修改的用户信息是否存在
        if (!hasIdExist(en.getId()))
            return QCUnifyReturnValue.Warn("修改的用户ID不存在");
        //判断名称不能重复
        if (isNameHasExist(dto.getName(), en.getId()))
            return QCUnifyReturnValue.Warn("用户名称已存在，名称不能相同");

        //判断部门是否存在
        if (!deptService.hasIdExist(dto.getDeptid()))
            return QCUnifyReturnValue.Warn("指定的部门信息不存在");

        repository.updateById(en);

        return QCUnifyReturnValue.Success();
    }

    /**
     * 删除用户
     *
     * @param userId 用户ID
     * @return 成功返回null
     * @author QuCheng Tech
     * @since 2023/6/1
     */
    public String delete(int userId) {
        if (!hasIdExist(userId))
            return QCUnifyReturnValue.Warn("删除的用户ID不存在");

        repository.deleteById(userId);

        return QCUnifyReturnValue.Success();
    }

    /**
     * 判断指定的ID是否存在
     *
     * @param id ID
     * @return true表示已存在，false表示不存在
     * @author QuCheng Tech
     * @since 2023/5/26
     */
    public boolean hasIdExist(Integer id) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getId, id);

        User en = repository.selectOne(wrapper);
        if (en != null)
            return true;

        return false;
    }

    /**
     * @param name 名称
     * @param id   ID，新增时设置ID为0，修改时设置ID为记录ID
     * @return true表示名称已存在，false表示名称不存在
     * @author QuCheng Tech
     * @since 2023/5/25
     */
    boolean isNameHasExist(String name, Integer id) {
        //验证名称是否重复条件：name=name and id<>id
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getName, name);
        wrapper.ne(User::getId, id);

        User en = repository.selectOne(wrapper);
        if (en != null)
            return true;

        return false;
    }

    /**
     * 生成记录ID，获取数据库表中的最大记录ID+1
     *
     * @return 生成记录ID
     * @author QuCheng Tech
     * @since 2023/5/25
     */
    Integer genereateId() {
        Integer maxRecordId = getMaxId();
        return maxRecordId + 1;
    }

    /**
     * 获取数据库表中的最大ID值，没有记录时返回0
     *
     * @return 返回数据库表中的最大ID值
     * @author QuCheng Tech
     * @since 2023/5/25
     */
    Integer getMaxId() {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.select(User::getId);
        wrapper.orderByDesc(User::getId);
        User en = repository.selectOne(wrapper);
        if (en != null)
            return en.getId();

        return 0x0;
    }
}
