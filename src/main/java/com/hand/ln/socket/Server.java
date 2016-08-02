package com.hand.ln.socket;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(32000, 10, InetAddress.getByName("10.211.119.203"));
        server.setReuseAddress(true);
        try {
            while (true) {
                Socket afd = server.accept();
                InetSocketAddress add = (InetSocketAddress) afd.getRemoteSocketAddress();
                System.out.println("Recive connection from " + add.getHostString() + ":" + add.getPort());
                Thread thread = new Thread(new Handler(afd));
                thread.start();
            }
        }
        finally {
            server.close();
        }
    }

}
