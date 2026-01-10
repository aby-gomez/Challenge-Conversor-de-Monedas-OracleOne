import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorService {
    private String apiKey = System.getenv("API_KEY");
    Gson gson = new Gson();


    public double calculateExchange(String base, String target, double amount){
        double rate = obtainExchangeRates(base,target);
        return amount*rate;
    }

    public double obtainExchangeRates(String base, String target) {
        String url_str = "https://v6.exchangerate-api.com/v6/"+apiKey+"/latest/"+base;
        //conversion_rates is a key containing a jsonObject, to obtain its value I use the method get which returns a JsonElement
        JsonObject rates = requestWithHttpURLConnection(url_str).getAsJsonObject("conversion_rates");
        JsonElement a = rates.get(target);
        return a.getAsDouble();

    }

    public JsonObject requestWithHttpURLConnection(String url_str){
        JsonObject json = new JsonObject();
        try {
            URL url = new URL(url_str);
            //returns an object of the superclass urlconnection ( represents a communications link between the application and a URL)
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //The actual connection to the remote object is made
            connection.connect();
            //The remote object becomes available. The header fields and the contents of the remote object can be accessed

            //parse Json into a parse tree of JsonElements
            JsonParser jsonParser = new JsonParser();
            //getContent , method of urlconeection, returns an object which is cast to a byte stream, then converted to characters
            //by inputstreamreader, parse takes that reader and returns a jsonelement
            JsonElement jsonElement = jsonParser.parse(new InputStreamReader((InputStream)connection.getContent()));
            json = jsonElement.getAsJsonObject();

        }catch (IOException e ){
            System.out.println(e.getMessage());
        }
        return json;
    }

    public Exchange conversionPar(String base, String target, double amount){
        String url = "https://v6.exchangerate-api.com/v6/"+apiKey+"/pair/"+base+"/"+target+"/"+amount;

        return gson.fromJson( requestWithHttpClient(url), Exchange.class);
    }

    public String requestWithHttpClient(String url){
         String json = "";
        try{
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            json = response.body();

        }catch(IOException | InterruptedException e ){
            System.out.println(e.getMessage());
        }
        return json;
    }
}
