package demo1;

/**
 * ClassName: Piece
 * Package: demo1
 * Description:
 *  三子棋
 * @Author 全家乐
 * @Create 2023/4/27 16:56
 * Version 1.0
 */
public class Piece {
    private String color;

    public Piece(String color) {
        this.color = color;
    }
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "这是一个三子棋";
    }
}
