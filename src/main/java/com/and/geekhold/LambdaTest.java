package com.and.geekhold;

import java.time.LocalDateTime;
import java.util.*;

import static java.util.stream.Collectors.*;

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

        Order order = new Order();
        order.setId(1L);
        order.setCustomerName("小江");
        order.setPlacedAt(LocalDateTime.of(2020, 03, 19, 10, 11));
        order.setTotalPrice(2.2);

        List<OrderItem> orderItemList = new ArrayList<>();

        OrderItem orderItem = new OrderItem();
        orderItem.setProductQuantity(10);
        orderItemList.add(orderItem);

        OrderItem orderItem1 = new OrderItem();
        orderItem1.setProductQuantity(12);
        orderItemList.add(orderItem1);

        order.setOrderItemList(orderItemList);

        orders.add(order);

        Order order1 = new Order();
        order1.setId(2L);
        order1.setCustomerName("小小");
        order1.setPlacedAt(LocalDateTime.of(2020, 03, 19, 11, 11));
        order1.setTotalPrice(3.2);
        order1.setOrderItemList(orderItemList);
        orders.add(order1);

        Order order2 = new Order();
        order2.setId(3L);
        order2.setCustomerName("小小");
        order2.setPlacedAt(LocalDateTime.of(2020, 03, 19, 12, 11));
        order2.setTotalPrice(1.2);
        order2.setOrderItemList(orderItemList);
        orders.add(order2);

        // 所有下单的用户，使用toSet去重后实现字符串拼接。获取顾客姓名，然后使用set去重
        System.out.println(orders.stream()
            .map(o -> o.getCustomerName())
            .collect(toSet())
            .stream().collect(joining(",", "[", "]"))
        );

        // 使用toMap获取订单ID+下单用户名的Map
        orders.stream().collect(toMap(Order::getId, Order::getCustomerName)).entrySet().forEach(System.out::println);
        orders.stream().map(Order::getCustomerName).forEach(System.out::println);

        // 使用toMap获取下单用户名+最近一次下单时间的Map
        orders.stream().collect(toMap(Order::getCustomerName, Order::getPlacedAt, (x, y) -> x.isAfter(y) ? x : y)).entrySet().forEach(System.out::println);
        orders.stream().collect(toMap(Order::getCustomerName, Order::getTotalPrice, (x, y) -> (x > y ? x : y))).entrySet().forEach(System.out::println);

        // 订单平均购买的商品数量
        System.out.println(orders.stream().collect(averagingInt(
                o -> (int) o.getOrderItemList().stream()
                .collect(summingInt(OrderItem::getProductQuantity))
        )));

    }
}
