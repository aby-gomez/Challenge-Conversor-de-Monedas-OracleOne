import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorService {
    private String apiKey = System.getenv("API_KEY");
    Gson gson = new Gson();


    public Exchange conversionPar(String base, String target, double monto){
        String url = "https://v6.exchangerate-api.com/v6/"+apiKey+"/pair/"+base+"/"+target+"/"+monto;

        return gson.fromJson( solicitudAPI(url), Exchange.class);
    }

    public String solicitudAPI(String url){
         String json = "";
        try{
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            json = response.body();

        }catch(IOException | InterruptedException e ){
            System.out.println(e.getMessage());
        }
        return json;
    }
}
