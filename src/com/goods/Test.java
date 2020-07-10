package com.goods;

import com.goods.service.GoodsService;
import com.goods.service.MenuService;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MenuService menuService = new MenuService();
        GoodsService goodsService = new GoodsService();

        while (true){
            menuService.showMenu();
            System.out.println("请选择操作：");
            int choice = scanner.nextInt();
            switch (choice){

            }
        }
    }


}
