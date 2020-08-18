package com.company;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Timer;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javax.sound.sampled.*;

public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001b[37m";
    public static final String WHITE_BACKGROUND_BRIGHT = "\u001b[0m";
    public static final String name = "saeed";

    static boolean flag=false;


    public static void  main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException, InterruptedException {
        String date="13 May 2020";
        //System.out.println("13 May 2020");
        String str= " Happy Birthday  \uD83C\uDF82\uD83C\uDF88";
        //str.substring(16)
        String newString = str.substring(0, 16)
                + name
                + str.substring(16);
        str=newString;

        String[][] mat = new String[12][28];

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 28; j++) {

                mat[i][j]="\u0000";
            }

        }

        File file = new File("m.wav");
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioIn);
        clip.start();
            try {

                for (int i = 0; i < date.length(); i++) {

                    Thread.sleep(100);
                    char ch= date.charAt(i);
                    System.out.print(ch);
                }
                System.out.println();
                for (int i = 0; i < str.length(); i++) {
                    Thread.sleep(100);
                    char ch= str.charAt(i);
                    System.out.print(ch);
                }
                System.out.println();

            } catch (Exception e) {}

        System.out.println("Play Music !!");
           make_cake();

            cake(mat);
            show_cake(mat);
        System.out.println();
        MyThread t1=new MyThread("One");
        MyThread t2= new MyThread("Two");

        long startTime = System.currentTimeMillis(); //fetch starting time
        while(false||(System.currentTimeMillis()-startTime)<20000) {


            if(flag)
            {
                t2.run();
            }
            else {
                t1.run();

            }
        }

        for (int i = 0; i < 5; i++) {
            System.out.println("");
        }
        System.in.read();
   }

    public static void cake(String[][] mat)
    {
        String happy="HAPPY BIRTHDAY";
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 28; j++) {

                // row 1 *
                if(j==5 | j==14 | j==23)
                {
                    mat[0][j]="*";
                }

                // row 2-4 |-|  ***
                if(i==2 | i==3 | i==4)
                {
                    if(j==4 | j==5 | j==6|
                            j==13|j==14|j==15|
                            j==22|j==23|j==24)
                    {
                        mat[1][j]="*";
                        if (j==5|j==14|j==23)
                        {
                            mat[i][j]="-";
                        }
                        else
                        {
                            mat[i][j]="|";
                        }
                    }
                }

                // row 5 ___|-|____
                if(i==5)
                {
                    if(j==4 | j==5 | j==6| j==13|j==14|j==15| j==22|j==23|j==24)
                    {
                        if (j==5|j==14|j==23)
                        {
                            mat[i][j]="-";
                        }
                        else
                        {
                            mat[i][j]="|";
                        }
                    }
                    else {
                        mat[i][j]="_";
                    }
                }

                if(i>5)
                {

                    if(i==6) mat[i][j]="=";
                    if(i==8) mat[i][j]="~";
                    if(i==10) mat[i][j]="~";
                    if(i==11) mat[i][j]="_";

                    if(j==6 & (i==7|i==9))
                    {
                        for (int k = 0; k < happy.length(); k++) {
                            char ch= happy.charAt(k);
                            mat[i][j+k]= String.valueOf(ch);

                        }
                    }

                    mat[i][0]="|";
                    mat[i][27]="|";
                }

            }
        }
    }

    public static void show_cake(String[][] mat) throws InterruptedException {

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 28; j++) {

                if(i==6)
                {
                    System.out.print( ANSI_PURPLE_BACKGROUND +ANSI_BLACK +mat[i][j] + ANSI_RESET);
                }


                else if(i==7)
                {
                    System.out.print( ANSI_BLUE_BACKGROUND + ANSI_BLACK +mat[i][j] + ANSI_RESET);
                    String happy="HAPPY BIRTHDAY";
                }
                else if(i==9)
                {
                    System.out.print(ANSI_CYAN_BACKGROUND + ANSI_BLACK + mat[i][j] + ANSI_RESET);
                }
                else if(i==11)
                {
                    System.out.print(ANSI_RED_BACKGROUND + ANSI_BLACK + mat[i][j] + ANSI_RESET);
                }
                else {
                    System.out.print(mat[i][j]);
                }


            }
            System.out.print("\n");
        }
    }




    public  static  void setMat() throws InterruptedException {
        flag=true;
        Thread.sleep(150);
        //System.out.print(" Happy ");
        System.out.print( ANSI_RED_BACKGROUND + ANSI_BLUE + " Happy "+ ANSI_RESET);
        Thread.sleep(150);
        unset();
    }

    public  static  void setMat2() throws InterruptedException {
        flag=false;
        Thread.sleep(150);
        //System.out.print(" Birthday ");
        System.out.print( ANSI_BLUE_BACKGROUND + ANSI_RED + " Birthday "+ ANSI_RESET);
        Thread.sleep(150);
        unset();
    }

    public static void unset()
    {
        System.out.print("\r");
    }


    public static void make_cake() throws InterruptedException {
        System.out.print("Make a birthday cake 0% complete");
        int length = 10; // length of % complete
        for (int i = 1; i <= 100; i++)
        {
            Thread.sleep(50);
            for (int j = 0; j < length + 1; j++) // + 1 handles the 1st digit
            {
                System.out.print('\b');
            }
            if (i > 10)
            {
                System.out.print('\b');
            }
            if (i > 100)
            {
                System.out.print('\b');
            }
            System.out.print(i);
            System.out.print("% complete");
        }
        System.out.println();
    }
}

class MyThread implements Runnable {
    String name;
    Thread t;
    MyThread(String threadname){
        name = threadname;
        t = new Thread(this, name);
        //System.out.println("New thread: " + t);
        t.start();
    }
    public void run() {
        try {
            if (t.getName() == "One") {

                Main.setMat();
            }
            if (t.getName() == "Two") {
                Main.setMat2();
            }
            Thread.sleep(10);


        } catch (InterruptedException e) {
            System.out.println(name + "Interrupted");
        }

        // System.out.println(name + " exiting.");
        //System.out.print("1");
    }
}
