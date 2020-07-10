package com.goods.service;

import com.goods.dao.GoodsDao;
import com.goods.dao.GoodsDaoImplement;

import java.util.Scanner;

public class GoodsService {
    Scanner scanner = new Scanner(System.in);
    GoodsDao goodsDao = new GoodsDaoImplement();

    //浏览商品
    public void showGoodsService(){
        if (!goodsDao.showGoods()){
            System.out.println("暂无信息！");
        }
    }

    //增加商品
    public void addGoodsService(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请依次输入商品名称:id,编码,品名(空格分开)");
        int id = scanner.nextInt();

    }
}
