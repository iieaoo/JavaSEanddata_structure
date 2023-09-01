package Poker;

/**
 * ClassName: Poker
 * Package: demo4
 * Description:
 *  洗牌
 * @Author 全家乐
 * @Create 2023/5/11 15:34
 * Version 1.0
 */
public class Poker {
    private String suit;//花色
    private int rank;//数字

    public Poker(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "{ " + suit + " " + rank + " "+" }";
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
