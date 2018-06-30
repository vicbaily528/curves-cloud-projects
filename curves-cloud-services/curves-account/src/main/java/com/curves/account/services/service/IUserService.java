package com.curves.account.services.service;

import com.curves.account.services.pojo.entity.UserEntity;

import java.util.List;

/**
 * @author vic
 */
public interface IUserService {
    /**
     * 分页查询
     * @return
     */
    List<UserEntity> selectUsersByPage();

    /**
     * 根据主键删除数据
     * @param uuid 主键
     * @return int 影响条数
     */
    int deleteByPrimaryKey(String uuid);

    /**
     * 根据组件批量删除对象
     * @param uuids 主键
     * @return int 影响条数
     */
    int deleteByPrimaryKeys(List<String> uuids);

    /**
     * 新增对象
     * @param record 对象
     * @return int 影响条数
     */
    int insert(UserEntity record);

    /**
     * 通过主键查询对象
     * @param uuid 主键
     * @return UsersDo 对象
     */
    UserEntity selectByPrimaryKey(String uuid);

    /**
     * 对象更新
     * @param record 对象
     * @return int 影响条数
     */
    int updateByPrimaryKey(UserEntity record);
}
