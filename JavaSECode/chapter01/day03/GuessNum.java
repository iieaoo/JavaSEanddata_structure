package day03;

import java.util.Random;
import java.util.Scanner;

/**
 * ClassName: GuessNum
 * Package: day03
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/4/20 21:29
 * Version 1.0
 */
public class GuessNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        //Math.random
        int randNum = random.nextInt(100);//[0,100)
        //System.out.println(randNum);
        while (true) {
            int num = sc.nextInt();
            if (num > randNum) {
                System.out.println("猜大了");
            } else if (num == randNum) {
                System.out.println("猜对了");
                break;
            } else {
                System.out.println("猜小了");
            }
        }
    }
}
