package com.hand.ln.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import com.google.gson.Gson;

public class Client {
    public static void main(String[] args) {
        Socket sfd;
        Gson gson = new Gson();
        try {
            sfd = new Socket("10.211.119.221", 12345);
            PrintWriter writer = new PrintWriter(sfd.getOutputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(sfd.getInputStream()));
            Scanner sc = new Scanner(System.in);
            while (sc.hasNextLine()) {
                String message = sc.nextLine();
                if (message.contains("exit")) {
                    break;
                }
                writer.println(message);
                writer.flush();
                System.out.println(reader.readLine());
            }
            sc.close();
            // for (int i = 0; i < 15; i++) {
            // writer.println(gson.toJson(new Date()));
            // writer.flush();
            // System.out.println(reader.readLine());
            // Thread.sleep(1000);
            // }
            reader.close();
            writer.close();
            sfd.close();
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
