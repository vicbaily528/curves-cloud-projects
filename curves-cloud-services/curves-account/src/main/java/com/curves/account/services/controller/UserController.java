package com.curves.account.services.controller;

import com.curves.account.services.pojo.dto.UserDTO;
import com.curves.account.services.pojo.entity.UserEntity;
import com.curves.account.services.service.IUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author vic
 */
@RestController
@RequestMapping("/account")
@Api(value = "MainController", description = "Account接口描述")
public class UserController {
    @Autowired
    IUserService iUserService;

    @Autowired
    ModelMapper modelMapper;

    /**
     * 分页查询
     *
     * @param pageNum  当前页数
     * @param pageSize 每页条数
     * @return PageInfo<UsersDo> 分页结果
     */
    @GetMapping("/selectUserByPage/{pageNum}/{pageSize}")
    @ApiOperation(value = "分页查询", httpMethod = "GET", notes = "分页查询")
    public PageInfo<UserEntity> selectUserByPage(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize, @RequestBody UserDTO record) {
        PageHelper.startPage(pageNum, pageSize);
        UserEntity usersDo = modelMapper.map(record, UserEntity.class);
        List<UserEntity> usersDoList = iUserService.selectUsersByPage();
        PageInfo<UserEntity> pageInfo = new PageInfo<>(usersDoList);
        return pageInfo;
    }

    /**
     * 保存用户信息
     *
     * @param record 对象
     * @return int 数据处理条数
     */
    @PostMapping("/user")
    @ApiOperation(value = "保存用户信息", httpMethod = "POST", notes = "保存用户信息")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "body", dataType = "UserDTO", name = "record", value = "用户对象", required = true)})
    public int insert(@RequestBody UserDTO record) {
        UserEntity usersDo = modelMapper.map(record, UserEntity.class);
        return iUserService.insert(usersDo);
    }

    /**
     * 通过主键查询对象
     *
     * @param uuid 主键
     * @return UsersDo 对象
     */
    @GetMapping("/selectByPrimaryKey/{uuid}")
    @ApiOperation(value = "通过主键查询对象", httpMethod = "GET", notes = "通过主键查询对象")
    public UserEntity selectByPrimaryKey(@PathVariable("uuid") String uuid) {
        return iUserService.selectByPrimaryKey(uuid);
    }

    /**
     * 更新对象
     *
     * @param record 对象
     * @return int 影响条数
     */
    @PutMapping("/user")
    @ApiOperation(value = "更新对象", httpMethod = "PUT", notes = "通过主键查询对象")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "body", dataType = "UserDTO", name = "record", value = "用户对象", required = true)})
    public int updateByPrimaryKey(@RequestBody UserDTO record) {
        UserEntity usersDo = modelMapper.map(record, UserEntity.class);
        return iUserService.updateByPrimaryKey(usersDo);
    }

    /**
     * 通过主键删除对象
     *
     * @param uuid 主键
     * @return int 影响条数
     */
    @DeleteMapping("/user/{uuid}")
    @ApiOperation(value = "通过主键删除对象", httpMethod = "DELETE", notes = "通过主键查询对象")
    public int deleteByPrimaryKey(@PathVariable("uuid") String uuid) {
        return iUserService.deleteByPrimaryKey(uuid);
    }

    /**
     * 通过主键批量删除对象
     *
     * @param uuids 主键
     * @return int 影响条数
     */
    @DeleteMapping("/user")
    @ApiOperation(value = "通过主键批量删除对象", httpMethod = "DELETE", notes = "通过主键查询对象")
    public int deleteByPrimaryKeys(@RequestBody List<String> uuids) {
        return iUserService.deleteByPrimaryKeys(uuids);
    }

}
