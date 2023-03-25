package TM;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
public class connectURI2 {
public final String USER_AGENT ="Mozilla/5.0";

public static URL builURL(String urlQUery){
    URL url = null;
    try {
        url = new URL(urlQUery.toString());

    }catch (MalformedURLException e) {
        e.printStackTrace();
    }
    return url;

}
 public static String GetResponseFromHttpurl(URL url)throws IOException {
     HttpURLConnection urlConnection =(HttpURLConnection) url.openConnection();
     try{
         InputStream in = urlConnection.getInputStream();
         Scanner scanner = new Scanner(in);
         scanner.useDelimiter("\\A");
         boolean hasInput =scanner.hasNext();
         if (hasInput){
             return scanner.next();
         }else{
             return null;
         }
     } finally {
         urlConnection.disconnect();
     }
 }

}
