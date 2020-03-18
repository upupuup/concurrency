package com.and.geekdesign.fiftyeight;

/**
 * @Description: 模板方法。抽象类，炒菜
 * @Author: jiangzhihong
 * @CreateDate: 2020/3/18 20:47
 */
public abstract class FriedDish {
    final void cookProcess() {
        //第一步：倒油
        this.pourOil();
        //第二步：热油
        this.HeatOil();
        //第三步：倒蔬菜
        this.pourVegetable();
        //第四步：倒调味料
        this.pourSauce();
        //第五步：翻炒
        this.fry();
    }

    //第一步：倒油是一样的，所以直接实现
    void pourOil() {
        System.out.println("倒油");
    }

    //第二步：热油是一样的，所以直接实现
    void HeatOil() {
        System.out.println("热油");
    }

    //第三步：倒蔬菜是不一样的（一个下包菜，一个是下菜心），所以声明为抽象方法，具体由子类实现
    abstract void pourVegetable();

    //第四步：倒调味料是不一样的（一个下辣椒，一个是下蒜蓉），所以声明为抽象方法，具体由子类实现
    abstract void pourSauce();

    //第五步：翻炒是一样的，所以直接实现
    void fry(){
        System.out.println("炒啊炒啊炒到熟啊");
    }
}
