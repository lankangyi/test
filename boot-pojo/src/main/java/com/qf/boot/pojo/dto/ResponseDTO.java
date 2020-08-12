package com.qf.boot.pojo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDTO implements Serializable {

    private String msg;
    private Boolean res=true;
    private Integer code=200;
    private Object data;

    public static ResponseDTO success(){
        return new ResponseDTO("成功",true,200,null);
    }

    public static ResponseDTO success(Object data,String msg){
        return new ResponseDTO(msg,true,200,data);
    }

    public static ResponseDTO success(String msg){
        return new ResponseDTO(msg,true,200,null);
    }


    public static ResponseDTO fail(){
        return new ResponseDTO("失败",false,100,null);
    }

    public static ResponseDTO fail(String msg){
        return new ResponseDTO(msg,false,100,null);
    }
    public static ResponseDTO fail(String msg ,Object data){
        return new ResponseDTO(msg,false,100,data);
    }


    public static ResponseDTO get(boolean res){
        return res?success():fail();
    }

}
