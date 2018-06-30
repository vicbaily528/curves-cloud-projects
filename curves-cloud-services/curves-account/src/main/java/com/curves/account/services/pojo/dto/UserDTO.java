package com.curves.account.services.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "UserDTO", description = "用户对象")
public class UserDTO {

    @ApiModelProperty(value = "ID")
    private String uuid;
    @ApiModelProperty(value = "用户名称")
    private String username;

    @ApiModelProperty(value = "用户密码")
    private String userpass;

    @ApiModelProperty(value = "用户年龄")
    private Integer userage;

    @ApiModelProperty(value = "部门编号")
    private String deptUuid;

    @ApiModelProperty(value = "电话")
    private String phone;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "是否删除")
    private Integer bisdelete;
}
