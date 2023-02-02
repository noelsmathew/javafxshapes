
package com.example.demo1;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

class MyCircle extends MyOval {

    private double X;
    private double Y;
    private double R1;
    private double R2;


    MyCircle(double X, double Y, double R1, double R2, Color colors) {
        super(X, Y, R1, R2, colors);
        this.X = X;
        this.Y = Y;
        this.R1 = R1;
        this.R2 = R2;

    }

    public void Draw(GraphicsContext GC) {
        GC.setFill(super.getColor());
        GC.fillOval(X, Y, R1, R1);
    }

    @Override
    public String ToString() {
        String circ = "This shape is a Circle";
        return circ;
    }

    @Override
    public Rectangle getMyBoundingRectangle() {
        Rectangle rect = new Rectangle();
        rect.setX(X);
        rect.setY(Y);
        rect.setWidth((R1));
        rect.setHeight(R1);
        return rect;
    }

    public void drawBoundingRectangle(GraphicsContext BR) {
        BR.setFill(Main.MyColor.BLACK.getCol());
        BR.fillRect(X, Y, R1, R1);
    }

    @Override
    public boolean pointInMyShape(MyPoint point) {

       double distance= Math.sqrt(Math.pow((point.getX()-X),2)+Math.pow((point.getY()-Y),2));
        if(distance>R1)
        {
            return false;
        }
        else
        {
            return true;
        }

//distance between point passed in an center> radius not


    }
}
