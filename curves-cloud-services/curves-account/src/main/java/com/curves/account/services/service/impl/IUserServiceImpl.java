package com.curves.account.services.service.impl;

import com.curves.account.services.mapper.UsersMapper;
import com.curves.account.services.pojo.entity.UserEntity;
import com.curves.account.services.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author vic
 */
@Service
@Transactional
public class IUserServiceImpl implements IUserService {

    @Autowired
    private UsersMapper usersMapper;

    /**
     * 分页查询
     * @return List<UsersDo> 分页结果
     */
    @Override
    public List<UserEntity> selectUsersByPage() {
        return usersMapper.selectUsersByPage();
    }

    /**
     * 通过主键删除对象
     * @param uuid 主键
     * @return int 影响条数
     */
    @Override
    public int deleteByPrimaryKey(String uuid) {
        return usersMapper.deleteByPrimaryKey(uuid);
    }

    /**
     * 通过主键批量删除对象
     * @param uuids 主键
     * @return int 影响条数
     */
    @Override
    public int deleteByPrimaryKeys(List<String> uuids) {
        return usersMapper.deleteByPrimaryKeys(uuids);
    }

    /**
     * 保存用户信息
     * @param record 对象
     * @return int 数据处理条数
     */
    @Override
    public int insert(UserEntity record) {
        return usersMapper.insert(record);
    }

    /**
     * 通过主键查询对象
     * @param uuid 主键
     * @return UsersDo 对象
     */
    @Override
    public UserEntity selectByPrimaryKey(String uuid) {
        return usersMapper.selectByPrimaryKey(uuid);
    }

    /**
     * 更新对象
     * @param record 对象
     * @return int 影响条数
     */
    @Override
    public int updateByPrimaryKey(UserEntity record) {
        return usersMapper.updateByPrimaryKey(record);
    }
}
