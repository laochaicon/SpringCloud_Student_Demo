package qc.module.demo.api.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import qc.common.core.exception.QCPromptException;
import qc.module.demo.dto.user.UserAddDto;
import qc.module.demo.dto.user.UserDto;
import qc.module.demo.dto.user.UserQueryConditionDto;
import qc.module.demo.dto.user.UserStatusDto;
import qc.module.demo.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Api
@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService service) {
        this.userService = service;
    }

    /**
     * 获取用户的所有状态集合，用于前端查询条件列表显示
     *
     * @return 状态集合
     * @author QuCheng Tech
     * @since 2023/6/1
     */
    @RequestMapping(value = "/status", method = {RequestMethod.GET})
    public List<UserStatusDto> status() {
        List<UserStatusDto> result = new ArrayList<>();

        UserStatusDto allStatus = new UserStatusDto() {
        };
        allStatus.setKey(0x1);
        allStatus.setValue("全部");
        result.add(allStatus);

        UserStatusDto enableStatus = new UserStatusDto() {
        };
        enableStatus.setKey(0x2);
        enableStatus.setValue("启用");
        result.add(enableStatus);

        UserStatusDto disableStatus = new UserStatusDto() {
        };
        disableStatus.setKey(0x3);
        disableStatus.setValue("禁用");
        result.add(disableStatus);

        return result;
    }

    /**
     * 根据条件查询用户
     *
     * @param condition 查询条件
     * @return 用户集合
     * @author QuCheng Tech
     * @since 2023/6/1
     */
    @RequestMapping(value = "/query", method = {RequestMethod.GET, RequestMethod.POST})
    public List<UserDto> query(@RequestBody UserQueryConditionDto condition) {
        return userService.query(condition);
    }

    /**
     * 获取指定用户信息，从param参数中传值
     *
     * @param id 用户ID
     * @return 用户信息
     * @author QuCheng Tech
     * @since 2023/6/1
     */
    @RequestMapping(value = "/get", method = {RequestMethod.GET})
    public UserDto getByParam(@RequestParam int id) throws QCPromptException {
        return userService.get(id);
    }

    /**
     * 获取指定用户信息，从url中传值
     *
     * @param id 用户ID
     * @return 用户信息
     * @author QuCheng Tech
     * @since 2023/6/1
     */
    @RequestMapping(value = "/get/{id}", method = {RequestMethod.GET})
    public UserDto getByPath(@PathVariable(required = true) int id) throws QCPromptException {
        return userService.get(id);
    }

    /**
     * 新增用户
     *
     * @param dto 新增用户信息
     * @return 成功返回null，失败返回错误信息
     * @author QuCheng Tech
     * @since 2023/6/1
     */
    @RequestMapping(value = "/add", method = {RequestMethod.POST})
    public String add(@RequestBody UserAddDto dto) {
        return userService.add(dto);
    }

    /**
     * 修改用户
     *
     * @param dto 用户信息
     * @return 成功返回null，失败返回错误信息
     * @author QuCheng Tech
     * @since 2023/6/1
     */
    @RequestMapping(value = "/update", method = {RequestMethod.PUT})
    public String update(@RequestBody UserDto dto) {
        return userService.update(dto);
    }

    /**
     * 删除用户
     *
     * @param id 用户ID
     * @return 成功返回null，失败返回错误信息
     * @author QuCheng Tech
     * @since 2023/6/1
     */
    @RequestMapping(value = "/delete", method = {RequestMethod.DELETE})
    public String delete(@RequestParam int id) {
        return userService.delete(id);
    }

}
