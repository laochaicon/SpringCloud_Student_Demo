package qc.module.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qc.module.demo.dto.dept.DeptDto;
import qc.module.demo.entity.Dept;
import qc.module.demo.mapper.DeptMapper;
import qc.module.demo.repository.DeptRepository;

import java.util.List;

/**
 * DeptService
 *
 * @author QuCheng Tech
 * @since 2023/5/31
 */
@Service
public class DeptService {
    private DeptRepository repository;

    @Autowired
    public void setDeptRepository(DeptRepository repository) {
        this.repository = repository;
    }

    /**
     * 获取所有部门信息，仅包含状态为可用的
     *
     * @return 部门信息集合
     * @author QuCheng Tech
     * @since 2023/6/1
     */
    public List<DeptDto> getAll() {
        LambdaQueryWrapper<Dept> wrapper = new LambdaQueryWrapper<>();
        //查询条件，如果状态不是所有的，仅查询正常状态的
        wrapper.eq(Dept::getEnable, true);
        //排序
        wrapper.orderByAsc(Dept::getOdr);
        wrapper.orderByAsc(Dept::getName);

        //查询数据
        List<Dept> ens = repository.selectList(wrapper);

        if (ens != null && ens.size() > 0x0)
            return DeptMapper.MAPPER.toDtoList(ens);

        return null;
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
        LambdaQueryWrapper<Dept> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Dept::getId, id);

        Dept en = repository.selectOne(wrapper);
        if (en != null)
            return true;

        return false;
    }
}
