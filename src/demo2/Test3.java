package demo2;

/**
 * ClassName: Test3
 * Package: demo1
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/5/9 15:06
 * Version 1.0
 */
class Alg<E extends Comparable<E>> {    //将来指定的参数类型(E)，一定是实现了这个接口的
    public E findMax(E[] array) {
        E max = array[0];
        for (int i =1; i < array.length; i++) {
            if (max.compareTo(array[i]) < 0) {   //E 引用类型，不能通过》 《 比较
                max = array[i];
            }
        }
        return max;
    }
}
class Alg2 {
    public <E extends Comparable<E>> E findMax(E[] array) {
        E max = array[0];
        for (int i =1; i < array.length; i++) {
            if (max.compareTo(array[i]) < 0) {   //E 引用类型，不能通过》 《 比较
                max = array[i];
            }
        }
        return max;
    }
}
class Alg3 {
    public static  <E extends Comparable<E>> E findMax(E[] array) {
        E max = array[0];
        for (int i =1; i < array.length; i++) {
            if (max.compareTo(array[i]) < 0) {   //E 引用类型，不能通过》 《 比较
                max = array[i];
            }
        }
        return max;
    }
}
class A<E extends Number>{

}
public class Test3 {
    public static void main(String[] args) {
        //不依赖于对象，不需要实例化对象
        Integer[] array = {1,4,12,4,57,2,9};
        Integer val = Alg3.<Integer>findMax(array);//<Integer>可以省略 直接通过类名
        System.out.println(val);
    }
    public static void main2(String[] args) {
        Alg2 alg2 = new Alg2();
        Integer[] array = {1,4,12,4,57,2,9};
        Integer val = alg2.<Integer>findMax(array);//<Integer>可以省略
        System.out.println(val);
    }
    public static void main1(String[] args) {
        Alg<Integer> alg = new Alg<>();
        Integer[] array = {1,4,12,4,57,2,9};
        Integer val = alg.findMax(array);
        System.out.println(val);

        A<Number> a1 = new A<>();
        A<Integer> a2 = new A<>();
        A<Double> a3 = new A<>();
    }
}
