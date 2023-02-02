
package com.example.demo1;
import javafx.scene.shape.Arc;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.ArcType;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

class MyArc extends MyShape{
    private MyPoint Center;
    private double X;
    private double Y;
    private double Length;
    private double Width;
    private double StartAng;
    private double ArcExtent;

    MyArc(MyPoint Center, double Length, double Width, double StartAng, double ArcExtent, Color colors)
    {
        super(Center.getX(), Center.getY(), colors);
        this.Center=Center;
        this.Length=Length;
        this.Width=Width;
        this.StartAng=StartAng;
        this.ArcExtent=ArcExtent;
    }

    public MyPoint getCenter() {
        return Center;
    }

    public void setCenter(MyPoint center) {
        Center = center;
    }

    @Override
    public double getX() {
        return X;
    }

    public void setX(double x) {
        X = x;
    }

    @Override
    public double getY() {
        return Y;
    }

    public void setY(double y) {
        Y = y;
    }

    public double getLength() {
        return Length;
    }

    public void setLength(double length) {
        Length = length;
    }

    public double getWidth() {
        return Width;
    }

    public void setWidth(double width) {
        Width = width;
    }

    public double getStartAng() {
        return StartAng;
    }

    public void setStartAng(double startAng) {
        StartAng = startAng;
    }

    public double getArcExtent() {
        return ArcExtent;
    }

    public void setArcExtent(double arcExtent) {
        ArcExtent = arcExtent;
    }

    public double ArcLength(double Length, double Width, double StartAng, double ArcExtent)
    {
        return Length * StartAng;
    }
public double Perimeter(double Length, double Width,double StartAng, double ArcExtent ){
        return (Length + 2*Width);
}

public double Area(double Length, double Width,double StartAng, double ArcExtent )
{
    return (Math.pow(Width,2)*(StartAng/2));
}

public String ToString()
    {
        String arc="This shape is an arc";
        return arc;
    }
    @Override
    public Rectangle getMyBoundingRectangle()
    {
        Rectangle rect= new Rectangle();
        rect.setX(X);
        rect.setY(Y);
        rect.setWidth((Width));
        rect.setHeight(Length);
        return rect;
    }
    public void drawBoundingRectangle(GraphicsContext BR)
    { BR.setFill(Main.MyColor.BLACK.getCol());
        //BR.setStroke(Color.GREEN);
        BR.fillRect(Center.getX()+(Width/2), Center.getY(), Length/5,Width);}
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
            if(X>Length)
            {
                System.out.println("This point is not in the shape");
                return false;
            }
            X++;
        }
        while(point.getY()!=Y)
        {
            if(Y>Width)
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
        S.fillArc(Center.getX(), Center.getY(),Width, Length, StartAng, ArcExtent, ArcType.ROUND);

    }
}
