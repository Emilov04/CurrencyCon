package org.example;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Main {
    public static String  main(String from, String to, int amount) throws IOException {

        String link = "https://www.amdoren.com/api/currency.php?api_key=MyApi="+from+"&to="+to+"&amount="+amount;
        URL url = new URL(link);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        int response = conn.getResponseCode();

        Scanner scanner = new Scanner(conn.getInputStream());
        StringBuilder str = new StringBuilder();

        while(scanner.hasNext()){
            str.append(scanner.nextLine());

        }
        System.out.println(str);
        System.out.println(response);
        return String.valueOf(str);

    }
}