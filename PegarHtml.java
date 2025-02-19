import java.io.*;
import java.net.URL;
import java.util.*;

public class PegarHtml {

    public static List<String> fetchHtml(String urlString){
    String line;
    List<String> linhas = new ArrayList<>();

    try {
        URL url = new URL(urlString);
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

        while ((line = reader.readLine()) != null) {
            linhas.add(line.trim());
        }
        reader.close();
    } catch (IOException e) {
        return null;
    }

    return linhas;

    }
}
