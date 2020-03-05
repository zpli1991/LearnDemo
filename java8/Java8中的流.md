# Stream（流）

Stream 是 Java API 的新成员，它允许你以声明性方式处理数据集合（通过查询语句来表达，而不是临时编写一个实现）。就现在来说，你可以把它们看成遍历数据集的高级迭代器。

Java8 中的 Stream API 主要有以下两个优点：

- 代码是以声明性方式编写的，这样看起来更加简洁、易读。这种方式下我们只需要表达我们想要达到什么目标（比如提取、过滤、排序、遍历）而不是详细说明如何实现这样一个操作（利用 if 条件判断、循环遍历等控制流语句）。
- 我们可以把几个基础操作链接起来，来表达复杂的数据处理流水线，同时保持代码清晰可读。

```java
package org.zpli.java8.stream;

import org.zpli.java8.stream.entity.Dish;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description: Stream使用范例
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
    }
}

class Dish {

    // 名称
    private String name;

    // 是否是素菜
    private boolean vegetarian;

    // 包含多少卡路里
    private int calories;

    // 类型
    private Type type;

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", vegetarian=" + vegetarian +
                ", calories=" + calories +
                ", type=" + type +
                '}';
    }

    public enum Type {
        MEAT("肉"), FISH("鱼"), OTHER("其他");
        private String name;

        Type(String name) {
            this.name = name;
        }
    }
}
```

**Stream**的操作符大体上分为两种：**中间操作符**和**终止操作符**

### 中间操作符

对于数据流来说，中间操作符在执行制定处理程序后，数据流依然可以传递给下一级的操作符。

中间操作符包含8种(排除了parallel,sequential,这两个操作并不涉及到对数据流的加工操作)：

> 1. map(mapToInt,mapToLong,mapToDouble) 转换操作符，把比如A->B，这里默认提供了转int，long，double的操作符。
> 2. flatmap(flatmapToInt,flatmapToLong,flatmapToDouble) 拍平操作比如把 int[]{2,3,4} 拍平 变成 2，3，4 也就是从原来的一个数据变成了3个数据，这里默认提供了拍平成int,long,double的操作符。
> 3. limit 限流操作，比如数据流中有10个 我只要出前3个就可以使用。
> 4. distinct 去重操作，对重复元素去重，底层使用了equals方法。
> 5. filter 过滤操作，把不想要的数据过滤。
> 6. peek 挑出操作，如果想对数据进行某些操作，如：读取、编辑修改等。
> 7. skip 跳过操作，跳过某些元素。
> 8. sorted(unordered) 排序操作，对元素排序，前提是实现Comparable接口，当然也可以自定义比较器。

### 终止操作符

数据经过中间加工操作，就轮到终止操作符上场了；终止操作符就是用来对数据进行收集或者消费的，数据到了终止操作这里就不会向下流动了，终止操作符只能使用一次。

> 1. collect 收集操作，将所有数据收集起来，这个操作非常重要，官方的提供的Collectors 提供了非常多收集器，可以说Stream 的核心在于Collectors。
> 2. count 统计操作，统计最终的数据个数。
> 3. findFirst、findAny 查找操作，查找第一个、查找任何一个 返回的类型为Optional。
> 4. noneMatch、allMatch、anyMatch 匹配操作，数据流中是否存在符合条件的元素 返回值为bool 值。
> 5. min、max 最值操作，需要自定义比较器，返回数据流中最大最小的值。
> 6. reduce 规约操作，将整个数据流的值规约为一个值，count、min、max底层就是使用reduce。
> 7. forEach、forEachOrdered 遍历操作，这里就是对最终的数据进行消费了。
> 8. toArray 数组操作，将数据流的元素转换成数组。



**申明，以下方法说明都以 menuList 集合为例：**

```java
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
```

注意点：

- 和迭代器类似，流只能遍历一次。遍历完之后，我们就可以说这个流已经被消费掉了。你可以从原始数据源那里再获得一个新的流来重新遍历一遍，就像迭代器一样（这里假设它是集合之类的可重复的源，如果是I/O通道就不行了）。

```java
Stream<Dish> stream = menuList.stream();
stream.forEach(dish -> System.out.println(dish.getName() + ":" + dish.getCalories()));
//再次遍历报错：java.lang.IllegalStateException
stream.forEach(dish -> System.out.println(dish.getName() + ":" + dish.getCalories()));
```

## filter（筛选）、limit（限制）、skip（跳跃）、collect（转换）、forEach（遍历）

Stream API支持使用filter方法筛选。该操作会接受一个谓词（一个返回boolean的函数）作为参数，并返回一个包括所有符合谓词的元素的流。

```java
	List<Dish> menuList = Arrays.asList(
                new Dish("猪肉", false, 800, Dish.Type.MEAT),
                new Dish("牛肉", false, 700, Dish.Type.MEAT),
                new Dish("鸡肉", false, 400, Dish.Type.MEAT));        

 	/**
     * 使用filter()方法筛选执行元素
     * 输出如下：
     * Dish{name='薯条', vegetarian=true, calories=530, type=OTHER}
     * Dish{name='米饭', vegetarian=true, calories=350, type=OTHER}
     * Dish{name='水果', vegetarian=true, calories=120, type=OTHER}
     * Dish{name='比萨饼', vegetarian=true, calories=550, type=OTHER}
     */
    @Test
    public void testFilter(){
        List<Dish> vegetarianMenu = menuList.stream()
                .filter(Dish::isVegetarian) // 筛选出素食菜肴
                .collect(Collectors.toList())// 将Stream转换为List 
        		.forEach(System.out::println);// 遍历
    }

	/**
     * 使用limit(n)方法，返回一个不超过给定长度的流
     * 输出如下：
     * 猪肉:800
     * 牛肉:700
     * 鸡肉:400
     */
    @Test
    public void testLimit(){
        //提取卡路里超过300的前3个的菜肴
        List<Dish> threeDishs = menuList.stream()
                .filter(dish -> dish.getCalories() > 300)
                .limit(3)
                .collect(Collectors.toList());
        		.forEach(dish -> System.out.println(dish.getName() + ":" + 									dish.getCalories()));
    }

	/**
     * 使用skip(n)方法，返回一个扔掉了前n个元素的流
     * 输出如下：
     * 薯条:530
     * 米饭:350
     * 比萨饼:550
     * 龙利鱼:450
     */
    @Test
    public void testSkip(){
        //跳过超过300卡路里的头三道菜，并返回剩下的
        List<Dish> threeDishs = menuList.stream()
                .filter(dish -> dish.getCalories() > 300)
                .skip(3)
                .collect(Collectors.toList());
        		.forEach(dish -> System.out.println(dish.getName() + ":" + 									dish.getCalories()));
    }
```

## sorted（排序）、distinct(去重)

对 Stream 的排序通过 sorted 进行，它比数组的排序更强之处在于你可以首先对 Stream 进行各类 map、filter、limit、skip 甚至 distinct 来减少元素数量后，再排序，这能帮助程序明显缩短执行时间。

```java
menuList.stream().sorted(Comparator.comparingInt(Dish::getCalories))
    
menuList.stream().sorted(Comparator.comparing(Dish::getCalories)).distinct()；
```



## map（映射）

流支持map方法，它会接受一个函数作为参数。这个函数会被应用到每个元素上，并将其映射成一个新的元素（使用映射一词，是因为它和转换类似，但其中的细微差别在于它是“创建一个新版本”而不是去“修改”）。

```java
	@Test
    public void testMap(){
        menuList.stream().map(Dish::getName).forEach(System.out::println);
    }

	/**
     * 检查是否至少匹配一个元素
     * 输出如下：
     * 菜单中至少存在一个素菜
     */
    @Test
    public void testAnyMatch(){
        if(menuList.stream().anyMatch(Dish::isVegetarian)){
            System.out.println("菜单中至少存在一个素菜");
        }
    }

 	/**
     * 检查是否都匹配一个元素
     * 输出如下：
     * 菜单中所有菜的热量都低于1000卡路里
     */
    @Test
    public void testAllMatch(){
        if(menuList.stream().allMatch(dish -> dish.getCalories() < 1000)){
            System.out.println("菜单中所有菜的热量都低于1000卡路里");
        }
 
        //或者使用noneMatch
        if(menuList.stream().noneMatch(dish -> dish.getCalories() >= 1000)){
            System.out.println("菜单中所有菜的热量都低于1000卡路里");
        }
    }
```

