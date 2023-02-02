package com.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.canvas.Canvas;
import javafx.scene.Group;

import java.io.IOException;

public class HelloApplication extends Application {
//private Pane P;
Stage stage;
  @Override
  public void start(Stage stage) throws IOException {
      this.stage=stage;
      FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
      try {
          stage.setTitle("MyShape");
         Pane P=new Pane();
          Canvas CV = addCanvas(1000, 500);
          P.getChildren().add(CV);
          Scene SC = new Scene(P, 1000, 500);
          stage.setScene(SC);
          stage.show();
      }
      catch(Exception e){ System.out.println(e.getMessage()); }
  }
    private Canvas addCanvas(int cWidth, int cHeight) {
        Canvas CV = new Canvas(cWidth, cHeight);
        GraphicsContext GC = CV.getGraphicsContext2D();


        //Prints ovals and bounding rectangles as example of MyShape hierarchy in use
/*
        MyRectangle r1 = new MyRectangle(350, 109, 300, 100, Main.MyColor.CYAN.getCol());
        r1.Draw(GC);
        //r1.drawBoundingRectangle(GC);
        String r=r1.ToString();
        System.out.println(r);
        double ar=r1.Area(350, 109, 40, 20);
        System.out.println("Area: "+ar);
        double pr=r1.Perimeter(350, 109, 40, 20);
        System.out.println("Perimeter: "+pr);
        r1.getTLC(350,109);
        r1.drawBoundingRectangle(GC);


        MyOval o3 = new MyOval(350, 100, 400, 200, Main.MyColor.ORANGE.getCol());
        o3.Draw(GC);
MyArc a1= new MyArc(new MyPoint(300,150),400,200,35,22, Main.MyColor.ORANGE.getCol());
    a1.drawBoundingRectangle(GC);
    a1.Draw(GC);
//double aL=a1.ArcLength(400,200,35,22);
//System.out.println("Arc Length: "+aL);


        MyLine lin1=new MyLine(0,400,0,400,Main.MyColor.PURPLE.getCol());
        lin1.Draw(GC);
        double len=lin1.Length(0,400,0,400);
        System.out.println("Line Length: "+len);
        lin1.getMyBoundingRectangle();
        String lin=lin1.ToString();
        System.out.println(lin);
        lin1.DrawBoundingRectangle(GC);
        lin1.Draw(GC);



        MyCircle circ=new MyCircle(300,150,100,100, Main.MyColor.PURPLE.getCol());
        circ.Draw(GC);
        double ca=circ.Area(300,150,100,100);
        System.out.println("Area: "+ca);
        double pa=circ.Perimeter(300,150,100,100);
        System.out.println("Perimeter: "+pa);
        String c=circ.ToString();
        System.out.println(c);
        circ.drawBoundingRectangle(GC);
        circ.Draw(GC);



        MyArc a2= new MyArc(new MyPoint(300,150),400,200,90,45, Main.MyColor.ORANGE.getCol());

        a2.Draw(GC);
        MyArc a3= new MyArc(new MyPoint(300,150),400,200,35,22, Main.MyColor.BLACK.getCol());

        a3.Draw(GC);
        MyArc a4= new MyArc(new MyPoint(300,150),400,200,90,50, Main.MyColor.GREEN.getCol());

        a4.Draw(GC);
        MyArc a6= new MyArc(new MyPoint(300,150),400,200,36,60, Main.MyColor.PURPLE.getCol());

        a6.Draw(GC);
        MyArc a7= new MyArc(new MyPoint(300,150),400,200,91,45, Main.MyColor.YELLOW.getCol());

        a7.Draw(GC);
        MyArc a8= new MyArc(new MyPoint(300,150),400,200,300,60, Main.MyColor.ORANGE.getCol());

       a8.Draw(GC);
        MyArc a9= new MyArc(new MyPoint(300,150),400,200,360,60, Main.MyColor.BLACK.getCol());

       a9.Draw(GC);
        MyArc aa= new MyArc(new MyPoint(300,150),400,200,136,30, Main.MyColor.VIOLET.getCol());

       aa.Draw(GC);
        MyArc aa1= new MyArc(new MyPoint(300,150),400,200,166,200, Main.MyColor.GREY.getCol());

        aa1.Draw(GC);

        //r1.drawBoundingRectangle(GC);

         o3.drawBoundingRectangle(GC);
        o3.Draw(GC);
        String o=o3.ToString();
        System.out.println(o);
        o3.CenterPoint();
        double area=o3.Area(350, 100, 400, 200);
        System.out.println("Area: "+area);
        double peri=o3.Perimeter(350, 100, 400, 200);
        System.out.println("Perimeter: "+peri);
*/
       // MyCircle circ1=new MyCircle(375,150,100,100, Main.MyColor.PURPLE.getCol());
        //circ1.drawBoundingRectangle(GC);
       //circ1.Draw(GC);
/*
        MyPoint purr=new MyPoint(12,11);
        MyRectangle ruff=new MyRectangle(300,250,100,110, Main.MyColor.YELLOW.getCol());
        MyRectangle ruff1=new MyRectangle(100,100,100,110, Main.MyColor.PURPLE.getCol());
      //  ruff.pointInMyShape(purr);
        ruff.Draw(GC);
        //ruff1.Draw(GC);
        MyPoint p1=new MyPoint(10,20);
        MyCircle circc=new MyCircle(100,50,20,20,Main.MyColor.GREEN.getCol());
      //  circc.pointInMyShape(p1);
       // circc.Draw(GC);
        //Canvas canvas=ruff.drawIntersectMyShapes(ruff,circc);
        Canvas canvas=ruff.drawIntersectMyShapes(ruff,ruff1);

        if(canvas==null)
        {
            System.out.println("No intersection");
        }
        else {
           // Pane P=new Pane();
           // Canvas CV = addCanvas(1000, 500);
         //   P.getChildren().add(canvas);
            Stage stage=new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);

            Group group=new Group(canvas);
            Scene SC = new Scene(group, 1000, 500);
            stage.setScene(SC);
            stage.showAndWait();

        }
*/

        return CV;
    }





    public static void main(String[] args) {


        launch();
    }
}