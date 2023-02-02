package com.example.demo1;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;
import javafx.scene.canvas.Canvas;

import java.util.ArrayList;

public interface MyShapeInterface {
    Rectangle getMyBoundingRectangle(); //returns bounding rectangle

    boolean pointInMyShape(MyPoint point);

    static ArrayList<MyPoint> intersectMyShape(MyShape shape1, MyShape shape2) {
        Rectangle rect1 = shape1.getMyBoundingRectangle();
        Rectangle rect2 = shape2.getMyBoundingRectangle();

        ArrayList<MyPoint> common = new ArrayList<>();
        for (int k = (int) rect1.getX(); k < rect1.getWidth() + rect1.getX(); k++) {
            for (int n = (int) rect1.getY(); n < rect1.getHeight() + rect1.getY(); n++) {
                MyPoint com = new MyPoint(k, n);
                System.out.println(com.getX() + " ," + com.getY() + " " + shape1.pointInMyShape(com) + " " + shape2.pointInMyShape(com));

                if (shape1.pointInMyShape(com) && shape2.pointInMyShape(com)) {
                    common.add(com);
                }
            }
        }
        if (common.size() == 0) {
            return null;
        }
        return common;
    }

    default Canvas drawIntersectMyShapes(MyShape shape1, MyShape shape2) {
        ArrayList<MyPoint> overlap = intersectMyShape(shape1, shape2);
        if (overlap == null) {
            return null;
        }
        double height = 0;
        double width = 0;
        for (MyPoint size : overlap) {
            if (size.getX() > width) {
                width = size.getX();
            }
            if (size.getY() > height) {
                height = size.getY();
            }
        }
        width += 10;
        height += 10;
        System.out.println(width + " " + height);
        Canvas IS = new Canvas(width, height);
        GraphicsContext gc = IS.getGraphicsContext2D();
        for (MyPoint com : overlap) {
            System.out.println(com.getX() + " " + com.getY());
            gc.setFill(Main.MyColor.YELLOW.getCol());
            gc.strokeLine(com.getX(), com.getY(), com.getX() + 1, com.getY() + 1);
        }
        System.out.println(width + " " + height);
        return IS;
    }
}

