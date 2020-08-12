package com.qf.boot.service.impl;

import com.qf.boot.dao.GoodsDao;
import com.qf.boot.pojo.dto.PageDTO;
import com.qf.boot.pojo.dto.ResponseDTO;
import com.qf.boot.pojo.entity.Goods;
import com.qf.boot.pojo.query.GoodsQuery;
import com.qf.boot.pojo.vo.GoodsVO;
import com.qf.boot.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
@Slf4j
public class GoodsServiceImpl implements GoodsService {
    @Resource
    GoodsDao goodsDao;
    @Override
    public List<GoodsVO> getBoodsBy() {

        return goodsDao.selectGoods();
    }

    @Override
    public PageDTO ajaxGoodList(GoodsQuery query) {
       List<GoodsVO> list = goodsDao.ajaxGoodList(query);
       Integer count  = goodsDao.ajaxGoodListCount(query);
        return PageDTO.setPageData(count,list);
    }

    @Override
    public GoodsVO showGoodsInfo(GoodsQuery query) {
        return goodsDao.selectByPK(query);
    }

    @Override
    public ResponseDTO updateGoods(Goods goods) {
        return ResponseDTO.get(goodsDao.updateByPrimaryKeySelective(goods)==1);
    }


}
