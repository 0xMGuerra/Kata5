package software.ulpgc;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Client {


    private static String url = "http://localhost:8080/getFactorial";

    public static void main(String[] args) {
        try (InputStream inputStream = new URL(url).openStream()) {
            System.out.println(new String(inputStream.readAllBytes()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
