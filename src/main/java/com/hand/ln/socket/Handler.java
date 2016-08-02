package com.hand.ln.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.regex.Pattern;

public class Handler implements Runnable {
    private Socket afd;

    public Handler(Socket afd) {
        if (afd.isClosed()) {
            throw new IllegalStateException("Connection is closed");
        }
        this.afd = afd;
    }

    public void run() {
        BufferedReader reader = null;
        PrintWriter writer = null;
        try {
            reader = new BufferedReader(new InputStreamReader(afd.getInputStream()));
            writer = new PrintWriter(afd.getOutputStream());
            String message = null;
            while (true) {
                message = reader.readLine();
                if ((message == null) && ((message = reader.readLine()) == null)) {
                    try {
                        afd.sendUrgentData(0);
                    }
                    catch (Exception e) {
                        reader.close();
                        writer.close();
                        afd.close();
                        break;
                    }
                }
                else {
                    System.out.println("recive : " + message + " from " + afd.getInetAddress().getHostAddress() + ":"
                            + afd.getPort());
                    if (Pattern.matches("hello|你好|hi", message)) {
                        writer.println("你好 " + afd.getInetAddress().getHostAddress() + ":" + afd.getPort());
                        writer.flush();
                    }
                    else {
                        writer.println(message + " " + afd.getInetAddress().getHostAddress() + ":" + afd.getPort());
                        writer.flush();
                    }
                }
            }
            System.out.println("处理结束");
        }
        catch (IOException e) {
        }
        finally {
            try {
                reader.close();
                writer.close();
                afd.close();
                afd = null;
            }
            catch (IOException e) {
            }
        }
    }

}
