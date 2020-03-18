package com.and.geekdesign.fiftyeight;

/**
 * @Description: 炒手撕包菜的类
 * @Author: jiangzhihong
 * @CreateDate: 2020/3/18 20:53
 */
public class ShreddedCabbage extends FriedDish {
    @Override
    public void  pourVegetable(){
        System.out.println("下锅的蔬菜是包菜");
    }
    @Override
    public void  pourSauce(){
        System.out.println("下锅的酱料是辣椒");
    }
}
