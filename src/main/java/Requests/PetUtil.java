package Requests;
import Object.Pet;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import Object.Status;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.util.List;

public class PetUtil {

    private static final HttpClient CLIENT = HttpClient.newHttpClient();
    private static final Gson GSON = new Gson();

    //Add Pet to store
    public void addPetToStore(URI uri, Pet pet) throws IOException, InterruptedException {
        String json = GSON.toJson(pet);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Content-type","application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();
        HttpResponse<String> response = CLIENT.send(request,HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
    }

    //Update Pet
    public void updatePet(URI uri, Pet pet) throws IOException, InterruptedException {
        String req = GSON.toJson(pet);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Content-type","application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(req))
                .build();
        HttpResponse<String> response = CLIENT.send(request,HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
    }

    //Get by status
    public List<Pet> getByStatus(String uri, String status) throws IOException, InterruptedException {
        String req = String.format(uri,status);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(req))
                .GET()
                .build();
        HttpResponse<String> response = CLIENT.send(request,HttpResponse.BodyHandlers.ofString());
        return GSON.fromJson(response.body(),new TypeToken<List<Pet>>(){}.getType());
    }

    //Get pet by id
    public Pet getById(String uri,Long id) throws IOException, InterruptedException {
        String req = String.format(uri,id);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(req))
                .GET()
                .build();
        HttpResponse<String> response = CLIENT.send(request,HttpResponse.BodyHandlers.ofString());
        return GSON.fromJson(response.body(),new TypeToken<Pet>(){}.getType());
    }

    //Update pet by id
    public void updatePetById(String uri, Pet pet) throws IOException, InterruptedException {
        String req = String.format(uri,pet.getId());
        String petJson = GSON.toJson(pet);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(req))
                .POST(HttpRequest.BodyPublishers.ofString(petJson))
                .build();
        HttpResponse<String> response = CLIENT.send(request,HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
    }

    //Delete pet
    public void deletePet(String uri, Long id) throws IOException, InterruptedException {
        String req = String.format(uri,id);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(req))
                .DELETE()
                .build();
        HttpResponse<String> response = CLIENT.send(request,HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
    }

    //Uploads to image
    public void uploadToImage(String uri, Long id, Path path) throws IOException, InterruptedException {
        String req = String.format(uri,id);
        //String petJson = GSON.toJson(pet);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(req))
                //.header("Content-type","application/json")
                .POST(HttpRequest.BodyPublishers.ofFile(path))
                .build();
        HttpResponse<String> response = CLIENT.send(request,HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
    }

}
