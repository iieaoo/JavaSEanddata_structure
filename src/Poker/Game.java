package Poker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * ClassName: Gaeme
 * Package: demo4
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/5/11 16:28
 * Version 1.0
 */
public class Game {
    private static final String[] suits = {"♥","♣","♠","♦"};

    public List<Poker> buyPoker() {
        List<Poker> pokers = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j <= 13; j++) {
                Poker poker = new Poker(suits[i],j);
                pokers.add(poker);
            }
        }
        return pokers;
    }

    public void shuffle(List<Poker> pokers) {
        for (int i = pokers.size()-1; i > 0; i--) {
            Random random = new Random();
            int index = random.nextInt(i);
            swap(pokers,i,index);
        }
    }

    private void swap(List<Poker> pokers, int i, int j) {
        Poker temp = pokers.get(i);
        pokers.set(i,pokers.get(j));
        pokers.set(j,temp);
    }
    public List<List<Poker>> game(List<Poker> pokers) {

        List<List<Poker>> hand = new ArrayList<>();

        List<Poker> hand1 = new ArrayList<>();
        List<Poker> hand2 = new ArrayList<>();
        List<Poker> hand3 = new ArrayList<>();

        hand.add(hand1);
        hand.add(hand2);
        hand.add(hand3);

        //最外层循环 控制 轮数
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                //删除哪个下标的值，就把哪个下标的值进行返回
                Poker removePoker = pokers.remove(0);
                hand.get(j).add(removePoker);
            }
        }
        return hand;
    }

}
