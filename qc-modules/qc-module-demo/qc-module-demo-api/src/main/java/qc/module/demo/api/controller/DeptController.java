package qc.module.demo.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import qc.module.demo.dto.dept.DeptDto;
import qc.module.demo.service.DeptService;

import java.util.List;

/**
 * DeptController
 *
 * @author QuCheng Tech
 * @since 2023/5/31
 */
@RestController
@RequestMapping("/dept")
public class DeptController {
    private DeptService deptService;

    @Autowired
    public void setDeptService(DeptService deptService) {
        this.deptService = deptService;
    }

    /**
     * 获取所有部门信息
     *
     * @return 部门信息集合
     * @author QuCheng Tech
     * @since 2023/6/1
     */
    @GetMapping("/all")
    private List<DeptDto> getAll() {
        return deptService.getAll();
    }
}
