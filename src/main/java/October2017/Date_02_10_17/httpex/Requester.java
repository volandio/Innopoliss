package October2017.Date_02_10_17.httpex;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Requester {
    public static void main(String[] args) {
//        sendGet("http://www.ivan1.ru");
        sendPost("http://apple.com/resolve", "sn=asdf432234523");
    }

    public static void sendGet(String addres) {
        try {
            URL url = new URL(addres);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                String tempStr;
                while ((tempStr = reader.readLine()) != null) {
                    stringBuilder.append(tempStr);
                }
                reader.close();
                System.out.println(stringBuilder.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sendPost(String addres, String data) {
        URL url;
        try {
            url = new URL(addres);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");

            connection.setDoOutput(true);
            DataOutputStream dos = new DataOutputStream(connection.getOutputStream());
            dos.writeBytes(data);
            dos.flush();
            dos.close();

            int responseCode = connection.getResponseCode();
//            if (responseCode == 200) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                String tempStr;
                while ((tempStr = reader.readLine()) != null) {
                    stringBuilder.append(tempStr);
                }
                reader.close();
                System.out.println(stringBuilder.toString());
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
