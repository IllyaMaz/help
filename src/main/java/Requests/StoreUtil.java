package Requests;

import com.google.gson.Gson;
import Object.StoreOrder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class StoreUtil {

    private static final HttpClient CLIENT = HttpClient.newHttpClient();
    private static final Gson GSON = new Gson();

    //place an order for a pet
    public void placeAnOrderForPet(URI uri, StoreOrder storeOrder) throws IOException, InterruptedException {
        String json = GSON.toJson(storeOrder);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Content-type","application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();
        HttpResponse<String> response = CLIENT.send(request,HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
    }

    //GET purchase by id
    public StoreOrder getPurchaseById(String uri,Integer id) throws IOException, InterruptedException {
        String req = String.format(uri,id);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(req))
                .GET()
                .build();
        HttpResponse<String> response = CLIENT.send(request,HttpResponse.BodyHandlers.ofString());
        StoreOrder storeOrder = GSON.fromJson(response.body(),StoreOrder.class);
        return storeOrder;
    }

    //GET store inventory
    public String getStoreInventory(URI uri) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();
        HttpResponse<String> response = CLIENT.send(request,HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    //DELETE purchase order by id
    public void deletePurchaseOrderById(String uri, int id) throws IOException, InterruptedException {
        String req = String.format(uri,id);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(req))
                .DELETE()
                .build();
        HttpResponse<String> response = CLIENT.send(request,HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
    }
}
