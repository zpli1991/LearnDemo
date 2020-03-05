package org.zpli.java8.stream;

import org.zpli.java8.stream.entity.Dish;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description: TODO
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/3/5 9:35
 */
public class StreamDemo2 {

    public static void main(String[] args) {

        List<Dish> menuList = Arrays.asList(
                new Dish("猪肉", false, 800, Dish.Type.MEAT),
                new Dish("牛肉", false, 700, Dish.Type.MEAT),
                new Dish("鸡肉", false, 400, Dish.Type.MEAT),
                new Dish("薯条", true, 530, Dish.Type.OTHER),
                new Dish("米饭", true, 350, Dish.Type.OTHER),
                new Dish("水果", true, 120, Dish.Type.OTHER),
                new Dish("比萨饼", true, 550, Dish.Type.OTHER),
                new Dish("大虾", false, 300, Dish.Type.FISH),
                new Dish("龙利鱼", false, 450, Dish.Type.FISH));

        // 提取低卡路里的菜肴名称，低于450符合要求

        // ------------ java8 以前实现 ------------
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for (Dish dish : menuList) {
            if (dish.getCalories() < 450) {
                lowCaloricDishes.add(dish);
            }
        }

        lowCaloricDishes.sort(new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return o1.getCalories() - o2.getCalories();
            }
        });

        for (Dish dish : lowCaloricDishes) {
            System.out.println(dish);
        }

        System.out.println("\n ------------ 此处是分割线 ------------ \n");
        // ------------ java8 实现 ------------
        menuList.stream()
                // 过滤出来卡路里小于 450 的菜肴
                .filter(x -> x.getCalories() < 450)
                // 对过滤出来的结果进行排序
                .sorted(Comparator.comparing(Dish::getCalories))
                // 将 Stream 转换为 List
                .collect(Collectors.toList())
                // 遍历输出结果
                .forEach(x -> System.out.println(x));

        menuList.stream().map(Dish::getName).forEach(System.out::println);

    }
}



