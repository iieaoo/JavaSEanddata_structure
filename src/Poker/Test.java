package Poker;

import sun.security.provider.Sun;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: Test
 * Package: demo4
 * Description:
 * List<Poker>    ArrayList<Poker> 区别
 *     可以发生向上转型 如果拿接口来接受对象 动态绑定
 *     那接口来接收 可以收到不同的对象 只要实现了这个接口的都可以
 *     list只能调用父类自己的方法
 *
 *     ArrayList<Poker>当前类都能调用
 *     优：
 *       给定下标的时候，查找速度非常快
 *     缺：
 *       插入 删除 要挪动元素才能插入
 *       每次扩容也是浪费资源的   10-》15  放11个元素
 * @Author 全家乐
 * @Create 2023/5/11 16:25
 * Version 1.0
 */
public class Test {
    public static void func(List<Integer> list) {}
    public static void func2(ArrayList<Integer> list) {}

    public static void main(String[] args) {
        func(new ArrayList<>());
        func(new LinkedList<>());

        func2(new ArrayList<>());
       // func2(new LinkedList<>());//error

        List<Poker> pokers1 = new ArrayList<>();
        ArrayList<Poker> pokers2 = new ArrayList<>();
    }
    public static void main1(String[] args) {
        Game game = new Game();
        List<Poker> pokers = game.buyPoker();
        System.out.println(pokers);

        //洗牌
        game.shuffle(pokers);
        System.out.println("洗牌");
        System.out.println(pokers);
        //揭牌
        List<List<Poker>> hand = game.game(pokers);
        System.out.println("揭牌：");
        for (int i = 0; i < hand.size(); i++) {
            System.out.println("第"+i+"个人的牌"+hand.get(i));
        }
        //剩下的牌
        System.out.println("剩下的牌：");
        System.out.println(pokers);
    }
}
