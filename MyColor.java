package com.example.demo1;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;


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

