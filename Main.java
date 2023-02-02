package com.example.demo1;

import javafx.scene.paint.Color;
public class Main
{
    public enum MyColor {
        BLACK(0, 0, 0, 255),
        CYAN(0, 255,255, 255),
        GREEN(0, 128, 0, 255),
        PURPLE(128, 0, 128, 255),
        YELLOW(255, 255, 0, 255),
        VIOLET(148,0,211,255),
        GREY(128,128,128,255),

        ORANGE(255,165,0,255);


        private int r;
        private int g;
        private int b;
        private int a;

        MyColor(int r, int g, int b, int a)
        {
            this.r=r;
            this.g=g;
            this.b=b;
            this.a=a;

        }

        public Color getCol(){
            return Color.rgb(r,g,b,(double)(a/255));
        }


    }


    public static void main(String[] args) {

/*
        System.out.print("The color of the shape is: ");
        MyColor color_1=MyColor.BLUE;
        System.out.println(color_1);

        MyOval shapez=new MyOval();
        System.out.println(shapez.ToString());

        MyRectangle shape=new MyRectangle();
        double val= shape.Perimeter(3,7,2,4);
        double H=shape.getHeight(3,7,2,4);
        System.out.print("The perimeter of the rectangle is: ");
        System.out.println(val);
        System.out.print("The height of the rectangle is: ");
        System.out.println(H);

        double area=shape.Area(3,7,2,4);
        System.out.print("The area of the rectangle is: ");
        System.out.println(area);



        MyPoint point1=new MyPoint(2.3,2.5);
        System.out.println("The first point is ("+point1.getX()+", "+point1.getY()+")");
        MyPoint point2=new MyPoint(3.0,7.5);
        MyLine line1= new MyLine(point1.getX(),point1.getY(),point2.getX(),point2.getY());
        line1.toString1();
        System.out.print("The length of the line is: ");
        double len=line1.Length(2.3,2.5,3.0,7.5);
        System.out.println(len);
        line1.toString1();

        MyOval shape1=new MyOval();
        shape1.CenterPoint(4.5,6.7,1.2,2.5);

*/
        MyPoint purr=new MyPoint(2,1);
        MyRectangle ruff=new MyRectangle(30,50,10,11,MyColor.BLACK.getCol());
        ruff.pointInMyShape(purr);

    }
}




