package com.curves.account.services.pojo.entity;

import lombok.Data;

/**
 * @author vic
 */
@Data
public class UserEntity {
    private String uuid;

    private String username;

    private String userpass;

    private Integer userage;

    private String deptUuid;

    private String phone;

    private String email;

    private Integer bisdelete;
}
