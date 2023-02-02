package com.example.demo1;
import javafx.scene.canvas.Canvas;
import javafx.scene.shape.Rectangle;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public abstract class MyShape implements MyShapeInterface
{
    private MyPoint point;
    private Color colors;
    MyShape(double X, double Y, Color colors)
    {
        this.point=new MyPoint(X,Y);
        this.colors=colors;
    }
    abstract double Perimeter(double X, double Y,double L, double W);
    abstract double Area(double X, double Y,double L, double W);
    abstract String ToString();

    public double getX()
    {return point.getX();}
    public double getY()
    {return point.getY();}
public Color getColor(){return colors;}
public void setColor(Color Color)
{this.colors=colors;}
public abstract Rectangle getMyBoundingRectangle();
    public abstract void Draw(GraphicsContext S);
}










