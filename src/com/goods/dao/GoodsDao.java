package com.goods.dao;

import com.goods.entity.Goods;

public interface GoodsDao {
    boolean showGoods();
    boolean addGoods(Goods goods);
    boolean delectGoods(int id);
    boolean modifyGoods(Goods goods);
    boolean selectGoodsId(int id);
}
