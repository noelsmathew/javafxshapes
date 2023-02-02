package com.example.demo1;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



import static javafx.application.Application.launch;


public class HistogramAlphaBet extends Application {

    public void histoLaunch(int n, Map<Character, Integer> freq, double sum)
    {
        System.out.println("Launch called");
        MPC = new MyPieChart(n,freq,sum);
        launch();
    }


private static MyPieChart MPC;
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HistogramAlphaBet.class.getResource("hello-view.fxml"));
        try {
            stage.setTitle("MyGrades");
            Pane P=new Pane();
            Canvas CV = addCanvas(1000, 700);
            MPC.draw(CV.getGraphicsContext2D());
            P.getChildren().add(CV);
            Scene SC = new Scene(P, 1000, 700);
            stage.setScene(SC);
            stage.show();
        }
        catch(Exception e){ System.out.println(e.getMessage()); }
    }

    private Canvas addCanvas(int cWidth, int cHeight) {
        Canvas CV = new Canvas(cWidth, cHeight);
        GraphicsContext GC = CV.getGraphicsContext2D();
        return CV;
    }

    public static void main(String[] args) throws IOException {


        HashMap<Character, Integer> hash = new HashMap<>();

        // Load this text file.
        BufferedReader reader = new BufferedReader(new FileReader(
                "/Users/noelmathew/IdeaProjects/proj3/src/main/java/com/example/proj3/WarAndPeace.txt"));

        while (true) {
            String line = reader.readLine();
            if (line == null) {
                break;
            }
            for (int i = 0; i < line.length(); i++) {
                char c = Character.toLowerCase(line.charAt(i));
                if (c >= 'a' && c <= 'z') {
                    // Increment existing value in HashMap.
                    // ... Start with zero if no key exists.
                    //int value = hash.getOrDefault((int) c, 0);
                    int value = hash.getOrDefault(c, 0);
                    //hash.put((int) c, value + 1);
                    hash.put(c, value + 1);
                }

            }
        }

        // Close object.
        reader.close();

        double val = 0;
        // Display values of all keys.
        for (Character key : hash.keySet()) {
            //val += hash.get(key);
            val += hash.get(key);
        }
        float lol = 0;
        for (Character key : hash.keySet()) {
            // System.out.println((char) key + ": " + (hash.get(key) / val));
            System.out.println(key + ": " + (hash.get(key) / val) * 100 + " % freqeuncy");
            lol += (hash.get(key) / val) * 100;

        }
        System.out.println(lol);
        MPC = new MyPieChart(2, hash, val);

        launch();
    }

    public static class MyPieChart {
        private Map<Character, Slice> slices;
        private int n; //number of freq to see on piechart
        private double val; //value of all freq summation

        public MyPieChart(int n, Map<Character, Integer> freq, double val) {

            ArrayList<Character> chars = new ArrayList<>();

            slices = new HashMap<>();
            this.val = val;
            this.n = n;
            for (Character key : freq.keySet()) {
                if (chars.size() == 0) {
                    chars.add(key);
                } else {
                    for (int i = chars.size() - 1; i >= 0; i--) {
                        if (freq.get(key) > freq.get(chars.get(i)) && i == 0) { //freq is greater than whats in array
                            chars.add(0, key); //pushes everything else down
                            if (chars.size() > n) {
                                chars.remove(chars.size() - 1); //removing the last element of the list, lowest freq
                            }

                        } else if (freq.get(key) <= freq.get(chars.get(i))) {
                            chars.add(i + 1, key); //pushes everything else down
                            if (chars.size() > n) {
                                chars.remove(chars.size() - 1); //removing the last element of the list, lowest freq
                            }
                            break;
                        }
                    }

                }

            }
            System.out.println("Top " + n + " Chars");
            double remain = 1.0;
            double starta=0.0;
            MyPoint cent=new MyPoint(200,40);
            MyColor [] colors=new MyColor[]{MyColor.BLACK,MyColor.CYAN,MyColor.GREEN,MyColor.GREY,MyColor.ORANGE,
                    MyColor.PURPLE,MyColor.VIOLET,MyColor.YELLOW};
            int color=0;
            for (Character c : chars) {
                double freqPercent=(freq.get(c)/val) ;
                System.out.println(c + " " + freq.get(c));
                double t = freqPercent*360; //arcExtent
                double arce=(starta*360); //startAngle
                int count=freq.get(c);


                Slice s = new Slice( cent,550.0,550.0,arce,t,colors[color++].getCol(),c+ "",count); //pass in array of colors
                starta+= freqPercent;
                remain -= freqPercent;
                slices.put(c, s);   //hash map doesn't preserve order
            }
         //   Slice remainder = new Slice(cent,550.0,550.0,starta*360,remain*360,colors[color++].getCol(),"All Other Events", remain);
         //   slices.put(' ', remainder);
        }


        public void draw(GraphicsContext s) { //create window
            //pass graphic to myslice->myarc
            for (Character c : slices.keySet()) {
               // slice.Draw(s);
                slices.get(c).Draw(s);

                System.out.println("Drawing slice "+slices.get(c).toString());
            }
        }
    }

}