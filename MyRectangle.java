package com.example.demo1;

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

class MyRectangle extends MyShape {
   double X;
    double Y;
    double value;
    MyColor color;
    private double W;
    private double H;

    MyRectangle(double X, double Y, double W, double H, Color colors) {
        super(X, Y, colors);
        this.W = W;
        this.H = H;
    }

    public double Perimeter(double X, double Y, double H, double W) {
        value = 2 * H + 2 * W;
        return (value);
    }

    public double Area(double X, double Y, double H, double W) {
        return (H * W);
    }

    public double getX() {
        return X;
    }

    public double getY() {
        return Y;
    }

    public double getHeight() {
        return H;
    }

    public double getWidth() {
        return W;
    }

    @Override
    public String ToString() {
        String rect = "This shape is a Rectangle";
        return rect;
    }

    public Rectangle getMyBoundingRectangle() {
        Rectangle rect = new Rectangle();
        rect.setX(X);
        rect.setY(Y);
        rect.setWidth((W));
        rect.setHeight(H);
        return rect;
    }

    public void drawBoundingRectangle(GraphicsContext BR) {
        BR.setFill(Main.MyColor.BLACK.getCol());
        BR.fillRect(X, Y, H, W);

    }

    @Override
    public boolean pointInMyShape(MyPoint point) {
        double Xval = X;
        double Yval = Y;
        if (point.getX() < X || point.getY() < Y) {
            //System.out.println("This point is not in the shape");
            return false;
        }
        while (point.getX() != Xval) {
            if (Xval > W) {
               // System.out.println("This point is not in the shape");
                return false;
            }
            Xval++;
        }
        while (point.getY() != Yval) {
            if (Yval > H) {
              //  System.out.println("This point is not in the shape");
                return false;
            }
            Yval++;
        }

        return true;
    }

    public MyPoint getTLC(double X, double Y) {
        MyPoint tlc = new MyPoint(X, Y);
        System.out.println("The top left corner point is (" + X + ", " + Y + ")");
        return tlc;
    }

    public void Draw(GraphicsContext S) {
        S.setFill(super.getColor());
        S.fillRect(X, Y, H, W);
    }


}
