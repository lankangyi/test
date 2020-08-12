package com.qf.boot.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageDTO {
    private Integer count;//分页总数
    private Object data;//数据
    private Integer code=0;
    private String msg;

    public static PageDTO setPageData(Integer count,Object data){
        return new PageDTO(count,data,0,"");
    }
    public static PageDTO setPageData(Integer count,Object data,String msg){
        return new PageDTO(count,data,0,msg);
    }


}
