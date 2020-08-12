package com.qf.boot.dao;

import com.qf.boot.pojo.entity.Goods;
import com.qf.boot.pojo.query.GoodsQuery;
import com.qf.boot.pojo.vo.GoodsVO;

import java.util.List;

public interface GoodsDao {
    int deleteByPrimaryKey(Long goodsId);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Long goodsId);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    List<GoodsVO> selectGoods();

    List<GoodsVO> ajaxGoodList(GoodsQuery query);

    Integer ajaxGoodListCount(GoodsQuery query);

    GoodsVO selectByPK(GoodsQuery query);
}