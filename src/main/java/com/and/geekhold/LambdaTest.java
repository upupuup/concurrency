package com.and.geekhold;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toSet;

/**
 * @Description:
 * @Author: jiangzhihong
 * @CreateDate: 2020/3/18 22:52
 */
public class LambdaTest {
    public static void main(String[] args) {
        // 实现了字符串拼接操作，生成一定位数的随机字符串。
        Random random = new Random();
        System.out.println(random.ints(0, 100)
                .filter(i -> (i < 50 || i > 60) && (i < 90 || i > 95))
                .mapToObj(i -> (char) i)
                .limit(20)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString()
        );

        // 通过 Collectors.toSet 静态方法收集为 Set 去重，得到去重后的下单用户，再通过 Collectors.joining 静态方法实现字符串拼接。
        List<Order> orders = new ArrayList();
        System.out.println(orders.stream()
            .map(order -> order.getCustomerName())
            .collect(toSet())
            .stream().collect(joining(",", "[", "]"))
        );
    }
}
