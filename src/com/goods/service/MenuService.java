package com.goods.service;

public class MenuService {

    // 系统菜单
    public void showMenu() {
        System.out.println(
                "**************商品管理系统主菜单**************\r\n" +
                        "		[1]-浏览商品-\r\n" +
                        "		[2]-增加商品-\r\n" +
                        "		[3]-删除商品-\r\n" +
                        "		[4]-修改商品-\r\n" +
                        "		[5]-查询商品-\r\n" +
                        "		[0]-退出系统-\r\n" +
                        "**********************************************"
        );
    }

}
