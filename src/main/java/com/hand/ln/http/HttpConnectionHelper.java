package com.hand.ln.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;

public class HttpConnectionHelper {

    public static void main(String[] args) {
        // String baidu = Get("http://www.baidu.com");
        // System.out.print(baidu);
        // String qq = Post("http://127.0.0.1:80", "post数据");
        // System.out.println(qq);
        HttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost("https://passport.baidu.com/v2/api/?login");
        EntityBuilder entityBuilder = EntityBuilder.create();
        entityBuilder.setText("mdzz");
        post.setEntity(entityBuilder.build());
        try {
            HttpResponse response = client.execute(post);
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent(), "utf-8"));
            StringBuilder builder = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            System.out.println(builder.toString());
            reader.close();
        }
        catch (ClientProtocolException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String Get(String url) {
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = null;
        try {
            URL requestUrl = new URL(url);
            URLConnection urlConnection = requestUrl.openConnection();
            urlConnection.connect();
            reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line = null;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (reader != null) {
                try {
                    reader.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return builder.toString();
    }

    public static String Post(String url, String param) {
        OutputStreamWriter writer = null;
        BufferedReader reader = null;
        StringBuilder builder = new StringBuilder();
        try {
            URL requestUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) requestUrl.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("encoding", "UTF-8");
            writer = new OutputStreamWriter(conn.getOutputStream(), "utf-8");
            // reader = new BufferedReader(new
            // InputStreamReader(conn.getInputStream()));
            writer.write(param);
            writer.flush();
            // String line = null;
            // while ((line = reader.readLine()) != null) {
            // builder.append(line);
            // }
            writer.close();
            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            reader.close();
            conn.disconnect();
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {

        }
        return builder.toString();
    }
}
