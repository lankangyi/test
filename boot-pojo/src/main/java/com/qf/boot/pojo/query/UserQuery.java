package com.qf.boot.pojo.query;

import lombok.Data;

@Data
public class UserQuery extends PageQuery {
    private String nickName,phone,password,code,principal;
    private Integer userId;
}
