# java8newFeature
jdk8新特性总结

## 目录
### 1. Java8新特性_简介
### 2. Java8新特性_为什么使用 Lambda 表达式
#### 2.1  为什么使用lambda 表达式?
    1.	大大减少结构性的重复代码
#### 2.2  没有lambda表达式之前的简化方式
    1. 策略设计模式
    2. 匿名内部类
    3. Lambda 表达式
    4. Stream API
### 3. Java8新特性_Lambda 基础语法
### 5. Java8新特性_四大内置核心函数式接口
### 6. Java8新特性_方法引用与构造器引用与数组引用
### 7. Java8新特性_创建 Stream
	1. 创建 Stream
	2. 中间操作
	3. 终止操作(终端操作)
### 8. Java8新特性_Stream中间操作_筛选与切片
	filter——接收 Lambda ， 从流中排除某些元素。
	limit——截断流，使其元素不超过给定数量。
	skip(n) —— 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
	distinct——筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
### 9. Java8新特性_Stream中间操作_映射
	map——接收 Lambda ， 将元素转换成其他形式或提取信息。接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
	flatMap——接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流,类似于Arraylist的addAll(), 最终只得到一个流
### 10. Java8新特性_Stream中间操作_排序
	sorted()——自然排序(Comparable): 按照Comparable接口实现的方式去排, 比如String就实现这个接口
	sorted(Comparator com)——定制排序, 按自己制定的方式去排
### 11. Java8新特性_Stream终止操作_查找与匹配
	allMatch——检查是否匹配所有元素
	anyMatch——检查是否至少匹配一个元素
	noneMatch——检查是否没有匹配的元素
	findFirst——返回第一个元素
	findAny——返回当前流中的任意元素
	count——返回流中元素的总个数
	max——返回流中最大值
	min——返回流中最小值
### 12. Java8新特性_Stream终止操作_归约与收集
	归约reduce(T identity, BinaryOperator) / reduce(BinaryOperator) ——可以将流中元素反复结合起来，得到一个值。
	map 和reduce 的连接通常称为map-reduce 模式，因Google 用它来进行网络搜索而出名。
	collect——将流转换为其他形式(比如集合)。接收一个 Collector接口的实现，用于给Stream中元素做汇总的方法
	多种API调用
### 13. Java8新特性_Stream API 练习
### 14. Java8新特性_并行流与串行流
	采用“工作窃取”模式（work-stealing）
### 15. Java8新特性_Optional 容器类
	 一、Optional 容器类：用于尽量避免空指针异常
	  	Optional.of(T t) : 创建一个 Optional 实例
	  	Optional.empty() : 创建一个空的 Optional 实例
	  	Optional.ofNullable(T t):若 t 不为 null,创建 Optional 实例,否则创建空实例
	  	isPresent() : 判断是否包含值
	  	orElse(T t) :  如果调用对象包含值，返回该值，否则返回t
	  	orElseGet(Supplier s) :如果调用对象包含值，返回该值，否则返回 s 获取的值
	  	map(Function f): 如果有值对其处理，并返回处理后的Optional，否则返回 Optional.empty()
	  	flatMap(Function mapper):与 map 类似，要求返回值必须是Optional
### 16. Java8新特性_接口中的默认方法与静态方法
	Java 8中允许接口中包含具有具体实现的方法，该方法称为“默认方法”，默认方法使用default关键字修饰
	Java8 中，接口中允许添加静态方法