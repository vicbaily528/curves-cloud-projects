package com.curves.account.services.mapper;

import com.curves.account.services.pojo.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author vic
 */
@Mapper
@Component
public interface UsersMapper {

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
    int deleteByPrimaryKey(@Param("uuid") String uuid);

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
    UserEntity selectByPrimaryKey(@Param("uuid") String uuid);

    /**
     * 对象更新
     * @param record 对象
     * @return int 影响条数
     */
    int updateByPrimaryKey(UserEntity record);
}