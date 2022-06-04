package Requests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import Object.User;

public class UserUtil {

    private static final HttpClient CLIENT = HttpClient.newHttpClient();
    private static final Gson GSON = new Gson();

    //Create User
    public  void createUser(URI uri, User user) throws IOException, InterruptedException {
        String create = GSON.toJson(user);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .POST(HttpRequest.BodyPublishers.ofString(create))
                .header("Content-type","application/json")
                .build();
        HttpResponse<String> response = CLIENT.send(request,HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
    }

    //Delete user
    public void deleteUser(String uri, User user) throws IOException, InterruptedException {
        URI delete = URI.create(uri+user.getUsername());
        HttpRequest request = HttpRequest.newBuilder()
                .uri(delete)
                .DELETE()
                .build();
        HttpResponse<String> response = CLIENT.send(request,HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
    }

    //Login User
    public void loginUser(String uri, User user) throws IOException, InterruptedException {
        String req = String.format(uri,user.getUsername(),user.getPassword());
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(req))
                .GET()
                .build();
        HttpResponse<String> response = CLIENT.send(request,HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
    }

    //Logout User
    public void logoutUser(URI uri) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();
        HttpResponse<String> response = CLIENT.send(request,HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
    }

    //Update User
    public void updateUser(String uri, User user) throws IOException, InterruptedException {
        String req = String.format(uri,user.getUsername());
        String gson = GSON.toJson(user);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(req))
                .header("Content-type","application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(gson))
                .build();
        HttpResponse<String> response = CLIENT.send(request,HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
    }

    //Get User
    public User getUser(String uri, User user) throws IOException, InterruptedException {
        String req = String.format(uri,user.getUsername());
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(req))
                .GET()
                .build();
        HttpResponse<String> response = CLIENT.send(request,HttpResponse.BodyHandlers.ofString());
        return  GSON.fromJson(response.body(), new TypeToken<User>(){}.getType());
    }

    //Create List User
    public void createListUser(List<User> list, URI uri) throws IOException, InterruptedException {
        String req = GSON.toJson(list);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Content-type","application/json")
                .POST(HttpRequest.BodyPublishers.ofString(req))
                .build();
        HttpResponse<String> response = CLIENT.send(request,HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
    }

    //


}
