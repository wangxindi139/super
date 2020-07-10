package com.goods.service;

import com.goods.dao.GoodsDao;
import com.goods.dao.GoodsDaoImplement;
import com.goods.entity.Goods;

import java.math.BigDecimal;
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
        int bm = scanner.nextInt();
        String s = scanner.nextLine();
        Goods goods = new Goods(id,bm,s);
        if (goodsDao.addGoods(goods)){
            System.out.println("增加成功！");
        } else{
            System.out.println("增加失败！");
        }
    }

    //删除商品
    public void deleteProductService() {
        if (goodsDao.showGoods()){
            System.out.println("请输入要删除的id");
            int id = scanner.nextInt();
            if (goodsDao.delectGoods(id)){
                System.out.println("删除成功！");
                goodsDao.showGoods();
            }else {
                System.out.println("无此信息，删除失败！");
            }
        }else {
            System.out.println("暂无信息！");
        }
    }

    //修改商品
    public void modifuGoodsSevice(){
        if (goodsDao.showGoods()){
            System.out.println("请输入修改的id;");
            int id = scanner.nextInt();
            if (goodsDao.selectGoodsId(id)){
                System.out.println("请依次输入要修改的id，编码，品名(用空格符分开)");
                int bm = scanner.nextInt();
                String name = scanner.nextLine();
                Goods goods = new Goods(id,bm,name);
                if (goodsDao.modifyGoods(goods)){
                    System.out.println("修改成功！");
                    goodsDao.showGoods();
                }else {
                    System.out.println("修改失败!");
                }
            }else {
                System.out.println("商品不存在！修改失败！");
            }
        }else {
            System.out.println("暂无信息！");
        }
    }

    //按编号浏览
    public void  selectProductService(){
        System.out.println("请输入要查询的编号：");
        int id = scanner.nextInt();
        if (goodsDao.selectGoodsId(id)){
            System.out.println("查询成功！");
        }else {
            System.out.println("无信息，查询失败！");
        }
    }
}
