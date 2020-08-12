package com.qf.boot.pojo.query;

import lombok.Data;

@Data
public class PageQuery {

    private Integer page = 1;
    private Integer limit = 10;
    private Integer start = 0;//偏移量

    public Integer getStart() {
        return (page - 1) * limit;
    }
}
