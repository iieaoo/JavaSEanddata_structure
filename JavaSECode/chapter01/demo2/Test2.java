package demo2;

/**
 * ClassName: Test2
 * Package: demo2
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/4/27 21:46
 * Version 1.0
 */
class Shape {
    public void draw() {
        System.out.println("画图形");
    }
}
class Rect extends Shape {
    @Override
    public void draw() {
        System.out.println("画矩形");
    }
}
class Cycle extends Shape {
    @Override
    public void draw() {
        System.out.println("画圆型");
    }
}
class Flower extends Shape {
    @Override
    public void draw() {
        System.out.println("画花朵");
    }
}
public class Test2 {
    public static void drawMap(Shape shape) {
        shape.draw();
    }
    public static void drawMap2() {
        Rect rect = new Rect();
        Cycle cycle = new Cycle();
        Flower flower = new Flower();
        String[] shapes = {"cycle","rect","cycle","rect","flower"};
        for (String shape : shapes) {
            if(shape.equals("cycle")) {
                cycle.draw();
            }else if (shape.equals("rect")) {
                rect.draw();
            }else if (shape.equals("flower")) {
                flower.draw();
            }
        }
    }
    public static void drawMap() {
        Rect rect = new Rect();
        Cycle cycle = new Cycle();
        Flower flower = new Flower();

        Shape[] shapes = {cycle,rect,cycle,rect,flower};

        for (Shape shape : shapes) {
            shape.draw();
        }
    }
    public static void main(String[] args) {
        drawMap();
       /* Rect rect = new Rect();
        drawMap(rect);
        Cycle cycle = new Cycle();
        drawMap(cycle);
        Flower flower = new Flower();
        drawMap(flower);*/
    }
}
