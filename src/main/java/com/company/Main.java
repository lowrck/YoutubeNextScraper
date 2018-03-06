package com.company;

import com.jaunt.*;
import java.io.IOException;
import java.io.*;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {

        try {
            File content = new File("list.txt");
            PrintWriter cout = new PrintWriter(content);
            UserAgent userAgent = new UserAgent();
            Scanner input = new Scanner(System.in);
            int runtime = 0;

            String url = "", startingUrl = "";
            //open HTML from a String.

            System.out.println("How many videos do you want to scrape?");
            runtime = input.nextInt();
            System.out.println("Enter starting url");
            startingUrl = input.next();
            url = startingUrl;
            for (int i = 0; i < runtime; i++) {


                userAgent.visit(url);
                Element body = userAgent.doc.findFirst("<body>");
                String newUrl = body.findFirst("<a class=\" content-link spf-link  yt-uix-sessionlink      spf-link \"").getAtString("href");
                cout.println(newUrl);

              url = newUrl;
                System.out.println("Line number: " + (i+1));
                //
            }
            System.out.println("Output put in list.txt");
            cout.close();
        }
        catch(JauntException e){
                System.err.println(e);
            }



        }





    }

