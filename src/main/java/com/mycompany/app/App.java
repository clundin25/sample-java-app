package com.mycompany.app;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.javanet.NetHttpTransport;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
         HttpTransport http_transport = new NetHttpTransport();
         HttpRequestFactory factory = http_transport.createRequestFactory();

         GenericUrl url = new GenericUrl("https://www.google.com");
         try {
             HttpRequest request = factory.buildGetRequest(url);
             HttpResponse response = request.execute();

             System.out.println(response);
         } catch (IOException ex) {
             System.out.println(ex);
         }
    }
}
