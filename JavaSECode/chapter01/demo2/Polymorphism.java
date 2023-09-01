package demo2;

/**
 * ClassName: Polymorphism
 * Package: demo2
 * Description:
 *多态条件：（缺一不可）
 *  1、必须在继承体系下
 *  2、子类必须要对父类中的方法进行重写
 *  3、通过父类的引用调用重写的方法
 * 理论上来说，等号两端的数据类型必须一直，但是向上转型（通过父类的的引用，只能引用父类自己的成员，不能访问子类特有的成员）
 * 动态绑定：
 *  1、向上转型
 *  2、重写
 *  3、通过父类引用 调用这个父类和子类重写的方法
 * 重写注意点：
 *  1、private修饰的方法不能重写
 *  2、static修饰的方法不能重写
 *  3、子类的访问修饰限定权限大于等于父类的权限 （private < 默认 <protected < public）
 *  4、被final修饰的方法（密封）不能被重写
 * @Author 全家乐
 * @Create 2023/4/27 20:15
 * Version 1.0
 */
class Animal2 {
    public String name;
    public int age;

    public void eat() {
        System.out.println(name+"正在吃饭！");
    }
}
class Dog extends Animal2 {
    public void wangwang() {
        System.out.println(name+"wangwang");
    }
    /*
    重写：
        1、方法名称相同
        2、参数列表相同
        3、返回值相同
     */
    public void eat() {
        System.out.println(name+"正在吃狗粮！");
    }
}
class Bird extends Animal2 {
    public String wing;
    public void fly() {
        System.out.println(name + "正在飞");
    }

     @Override
    public void eat() {
        System.out.println(name + "正在吃鸟粮");
    }
}


public class Polymorphism {
    public static void main(String[] args) {
        //向下转型
        Animal2 animal2 = new Dog();
        Dog dog = (Dog)animal2; //强转，向下转型：非常不安全
        dog.name = "shisan";
        dog.wangwang();
        if(animal2 instanceof Bird) { //可以理解为animal这个引用，是不是引用了bird这个对象，如果为true就可以转换
            Bird bird = (Bird) animal2;
            bird.fly();
        }
    }
    public static void function(Animal2 animal2) {
        animal2.eat();
    }
    public static void main5(String[] args) {
        Animal2 animal2 = new Dog();
        animal2.name = "shisan";
        function(animal2);
        Animal2 animal3 = new Bird();
        animal3.name = "yuanyuna";
        animal3.eat();
    }
    public static void func(Animal2 animal2) {

    }
    public static Animal2 func2() {
        return new Dog();
    }

    public static void main4(String[] args) {
        Dog dog = new Dog();
        dog.name = "shisan";
        dog.eat();
        Bird bird = new Bird();
        bird.name = "yuanyuna";
        bird.eat();
    }
    public static void main3(String[] args) {
        Dog dog = new Dog();
        func(dog);
    }
    public static void main2(String[] args) {
        Animal2 animal2 = new Dog();
        animal2.name = "shisan";
        animal2.eat();
        //animal2.wangwang();   error 父类没有这个
        System.out.println("================");
        Animal2 animal3 = new Bird();
        animal3.name = "yuanyuan";
        animal3.eat();
    }
    public static void main1(String[] args) {
        Dog dog = new Dog();
        dog.name = "shisan";
        dog.eat();
        dog.wangwang();

        Animal2 animal2 = dog;  //子类给父类 向上转型

        Bird bird = new Bird();
        bird.name = "yuanyuan";
        Animal2 animal3 = bird;
    }
}
