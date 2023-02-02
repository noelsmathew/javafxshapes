package com.example.demo1;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

class Slice extends MyArc{
    String n;
    double t;
    Slice(MyPoint Center, double Length, double Width, double StartAng, double ArcExtent, Color colors,String n, double t)
    {

        super(Center,Length,Width,StartAng,ArcExtent, colors);
        this.n=n;
        this.t=t;
    }


   // @Override
    public void Draw(GraphicsContext D)
    {

       super.Draw(D);
       D.fillText(n+":      "+t, 10, getStartAng()+20);

    }

    @Override
    public String toString() {
        return "Slice{" +
                "n='" + n + '\'' +
                ", t=" + t +
                ", StartAng="+getStartAng()+
                ", ArcExtent="+getArcExtent()+
                '}';
    }


}
