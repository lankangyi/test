package com.qf.boot.controller.pages.back.goods;


import com.qf.boot.pojo.dto.ResponseDTO;
import com.qf.boot.pojo.entity.Goods;
import com.qf.boot.pojo.query.GoodsQuery;
import com.qf.boot.pojo.dto.PageDTO;

import com.qf.boot.pojo.vo.GoodsVO;
import com.qf.boot.service.GoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/pages/back/good")
public class GoodsController {

    @Resource
    GoodsService goodsService;

    @RequestMapping("ajaxGoodList")
    @ResponseBody
    PageDTO ajaxGoodList(GoodsQuery query) {
        return goodsService.ajaxGoodList(query);
    }


    @RequestMapping("showGoodsInfo/{goodsId}")
    @ResponseBody
    GoodsVO showGoodsInfo(@PathVariable Long goodsId, GoodsQuery query) {
        return goodsService.showGoodsInfo(query);
    }
    @RequestMapping("updateGoods/{goodsId}")
    @ResponseBody
    ResponseDTO updateGoods(@PathVariable Long goodsId, Goods goods) {
        return goodsService.updateGoods(goods);
    }


}
