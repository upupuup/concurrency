package com.and.geekhold.ten;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Description: 第十讲
 * @Author: jiangzhihong
 * @CreateDate: 2020/3/31 20:20
 */
public class OperatorListDemo {
    private static Logger log = LoggerFactory.getLogger(OperatorListDemo.class);

    private static List<List<Integer>> data = new ArrayList<>();

    /**
     * 结果不一样是因为可以把int装箱成Integer，不能把int的数组装箱成Integer。
     * Arrays.asList 方法传入的是一个泛型 T 类型可变参数，最终 int 数组整体作为了一个对象成为了泛型类型 T
     */
    public static void test1() {
        // 输出的结果 list:[[I@2328c243] size:1 class:class [I
        int[] arr = {1, 2, 3};
        List list = Arrays.asList(arr);

        // Java8可以使用stream来转换
        // List list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        log.info("list:{} size:{} class:{}", list, list.size(), list.get(0).getClass());

        // 输出的结果 list:[1, 2, 3] size:3 class:class java.lang.Integer
        Integer[] arr2 = {1, 2, 3};
        List list2 = Arrays.asList(arr2);
        log.info("list:{} size:{} class:{}", list2, list2.size(), list2.get(0).getClass());
    }

    /**
     * Arrays.asList 返回的 List 不支持增删操作。
     * 底层是数组，没有重写add方法，add里只抛出UnsupportedOperationException。
     * 对原数组修改也会把list的改变，因为asList是直接使用数组
     */
    public static void test2() {
        String[] arr = {"2", "3", "4"};
        List<String> list = Arrays.asList(arr);
        // 修复的方式，重新 new 一个 ArrayList 初始化 Arrays.asList 返回的 List 即可
        // List list = new ArrayList(Arrays.asList(arr));
        arr[1] = "4";
        try {
            list.add("5");
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("arr:{}, list:{}", Arrays.toString(arr), list);
    }

    /**
     *
     */
    private static void oom() {
        for (int i = 0; i < 1000; i++) {
            List<Integer> rawList = IntStream.rangeClosed(1, 100000).boxed().collect(Collectors.toList());
            data.add(rawList.subList(0, 1));
        }
    }


    public static void main(String[] args) {
        test1();
//        test2();
        oom();
    }
}
