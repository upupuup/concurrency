package com.and.geekdesign.fiftyeight;

/**
 * @Description: 炒蒜蓉菜心的类
 * @Author: jiangzhihong
 * @CreateDate: 2020/3/18 20:55
 */
public class GarlicVegetables extends FriedDish {
    @Override
    public void  pourVegetable(){
        System.out.println("下锅的蔬菜是菜心");
    }
    @Override
    public void  pourSauce(){
        System.out.println("下锅的酱料是蒜蓉");
    }
}
