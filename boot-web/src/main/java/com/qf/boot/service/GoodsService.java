package com.qf.boot.service;

import com.qf.boot.pojo.dto.ResponseDTO;
import com.qf.boot.pojo.entity.Goods;
import com.qf.boot.pojo.query.GoodsQuery;
import com.qf.boot.pojo.dto.PageDTO;
import com.qf.boot.pojo.vo.GoodsVO;

import java.util.List;


public interface GoodsService {
    static PageDTO ajaxGoodsList(GoodsQuery query) {
        return null;
    }

    List<GoodsVO> getBoodsBy();

    PageDTO ajaxGoodList(GoodsQuery query);

    GoodsVO showGoodsInfo(GoodsQuery query);


    ResponseDTO updateGoods(Goods goods);
}
