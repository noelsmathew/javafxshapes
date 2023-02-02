
package com.example.demo1;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Line;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

class MyLine extends MyShape{
    private double x1;
    private double y1;
    private double x2;
    private double y2;

    MyColor color;
    public MyLine(double x1, double x2, double y1, double y2,Color colors)
    {   super(x1,y1,colors);
        this.x2=x2;
        this.y2=y2;
    }
    public String ToString(){
        String lin="The points on the line: "+x1+","+y1+",  "+x2+","+y2;
        return lin;

    }
    public double Length(double x1,double x2,double y1,double y2)
    {return Math.sqrt(Math.pow((x2-x1),2)+Math.pow((y2-y1),2));}
    public double Perimeter(double x1,double x2,double y1,double y2)
    {
        return 0;
    }
    public double Area(double x1,double x2,double y1,double y2)
    {
        return 0;
    }
    @Override
    public boolean pointInMyShape(MyPoint point) {
        return false;
    }

    public void DrawLine(double x1, double y1, double x2, double y2)
    {
        Line line1= new Line();
        line1.setStartX(x1);
        line1.setStartY(y1);
        line1.setEndX(x2);
        line1.setEndY(y2);
    }
    public Rectangle getMyBoundingRectangle()
    {
        Rectangle rect= new Rectangle();
        rect.setX(1);
        rect.setY(1);
        rect.setWidth((1));
        rect.setHeight(1);
        return rect;
    }
    public void DrawBoundingRectangle(GraphicsContext S)
    {
        S.setFill(Main.MyColor.GREY.getCol());
        S.fillRect(x1,y1,x1+x2,y1+y2);
    }
    public void Draw(GraphicsContext S)
    {
        S.setFill(super.getColor());
        S.strokeLine(x1,y1,x2,y2);
    }
}
