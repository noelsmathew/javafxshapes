
package com.example.demo1;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

class MyOval extends MyShape
{

    private double X;
    private double Y;
    private double R1 ;
    private double R2;



    MyOval(double X, double Y, double R1, double R2, Color colors)
    {

        super(X,Y,colors);

        this.R1=R1;
        this.R2=R2;
    }
    @Override
    public double Perimeter(double X, double Y,double R1, double R2)
    {

        return (Math.PI*((R1/2)+(R2/2)));
    }
    @Override
    public double Area(double X, double Y,double R1, double R2)
    {
        return(Math.PI*(R1/2)*(R2/2));
    }
    public void CenterPoint()
    {//double X, double Y,double R1, double R2
        System.out.println("The center point of the oval is "+X+" "+Y);
    }
    public double MinorAxis(double X, double Y,double R1, double R2)
    {
        return R1;
    }
    public double MajorAxis(double X, double Y,double R1, double R2)
    {
        return R2;
    }
    @Override
    public String ToString()
    {
        String oval="This shape is an Oval";
        return oval;
    }
    public Rectangle getMyBoundingRectangle()
    {
        Rectangle rect= new Rectangle();
        rect.setX(X);
        rect.setY(Y);
        rect.setWidth((R1));
        rect.setHeight(R2);
        return rect; }

    public void drawBoundingRectangle(GraphicsContext BR)
    { BR.setFill(Main.MyColor.BLACK.getCol());
        //BR.setStroke(Color.GREEN);
        BR.fillRect(X,Y,R1,R2);}
    @Override
    public boolean pointInMyShape(MyPoint point) {
        double Xval=X;
        double Yval=Y;
        if(point.getX()<X||point.getY()<Y)
        {
            System.out.println("This point is not in the shape");
            return false;
        }

        while(point.getX()!=X)
        {
            if(X>R1)
            {
                System.out.println("This point is not in the shape");
                return false;
            }
            X++;
        }
        while(point.getY()!=Y)
        {
            if(Y>R2)
            {
                System.out.println("This point is not in the shape");
                return false;
            }
            Y++;
        }
        if(point.getY()==Y&&point.getX()==X)
        {
            System.out.println("This point is in the shape");
            return true;
        }
        return false;
    }
public void Draw(GraphicsContext S)
{
    S.setFill(super.getColor());
    S.fillOval(X,Y,R1,R2); }
}
