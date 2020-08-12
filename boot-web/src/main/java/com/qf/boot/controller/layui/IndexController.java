package com.qf.boot.controller.layui;

import com.qf.boot.pojo.vo.UserVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("pages")
public class IndexController {

    @RequestMapping("/layer")
    String layer(Model model){
        return "pages/layui-layer";
    }
    @RequestMapping("/userTable")
    String table(Model model){
        return "pages/layui-table";
    }

    @RequestMapping("/goodTable")
    String good(Model model){
        return "pages/back/good/good-list";
    }
}
