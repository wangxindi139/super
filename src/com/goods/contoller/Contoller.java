package com.goods.contoller;

import com.goods.service.GoodsService;
import com.goods.service.MenuService;

import java.util.Scanner;

public class Contoller {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MenuService menuService = new MenuService();
        GoodsService goodsService = new GoodsService();

        boolean flag = false;
        while (true){
            if (flag){
                break;
            }
            menuService.showMenu();
            System.out.println("请输入你的选择：");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    goodsService.showGoodsService();//浏览全页
                    break;
                case 2:
                    goodsService.addGoodsService();
                    break;
                case 3:
                    goodsService.deleteProductService();
                    break;
                case 4:
                    goodsService.modifuGoodsSevice();
                    break;
                case 5:
                    goodsService.selectProductService();
                    break;
                case 0:
                    System.out.println("退出系统！欢迎使用，Bye!");
                    System.exit(0);
                default:
                    System.out.println("输入有误，请重新输入！");
                    break;
            }
        }
    }
}
