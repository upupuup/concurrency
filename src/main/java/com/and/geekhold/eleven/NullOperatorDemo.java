package com.and.geekhold.eleven;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

/**
 * @Description: 空值处理
 * @Author: jiangzhihong
 * @CreateDate: 2020/4/2 20:15
 */
public class NullOperatorDemo {
    private static Logger log = LoggerFactory.getLogger(NullOperatorDemo.class);

    public static void main(String[] args) {
        Foo foo = new Foo();
        foo.setBar(null);

        Optional.ofNullable(foo)
                .map(Foo::getBar)
                .filter(bar -> "ok".equals(bar.getBarChild()))
                .ifPresent(result -> log.info("ok"));

//        if (foo.getBar().getBarChild().equals("ok")) {
//            log.info("ok");
//        }
    }

}

class Foo {
    private Bar bar;

    public Bar getBar() {
        return bar;
    }

    public void setBar(Bar bar) {
        this.bar = bar;
    }
}

class Bar {
    private String barChild;

    public String getBarChild() {
        return barChild;
    }

    public void setBarChild(String barChild) {
        this.barChild = barChild;
    }
}
