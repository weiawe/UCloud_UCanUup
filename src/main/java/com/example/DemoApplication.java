package com.example;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.io.IOUtils;

public class DemoApplication {

    public static void main(String[] args) {
        String uCanUup = "UCanUup";
        String uri ="http://106.75.28.160/UCloud.txt#rd?n";
        URL url;
        InputStream is = null;
        try {
            url = new URL( uri);
            URLConnection urlcon;
            urlcon = url.openConnection();
            urlcon.connect();
            is = urlcon.getInputStream();
            String text = "~~~" + IOUtils.toString(is, "UTF-8") + "~~~";
            System.out.println("'UCanUup'出现的次数: "+ Integer.toString(text.split(uCanUup).length -1));
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        } finally {
            try {
                if (is != null)
                    is.close();
            } catch (IOException e) {
            }
        }
    }
}
