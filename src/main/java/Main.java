import Requests.PetUtil;
import Requests.UserUtil;
import Object.User;
import Object.Pet;
import Object.Category;
import Object.Status;
import Object.Tag;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String URI_CREATE_USER = "https://petstore.swagger.io/v2/user";
    private static final String DELETE_USER = "https://petstore.swagger.io/v2/user/";
    private static final String LOGIN_USER = "https://petstore.swagger.io/v2/user/login?username=%s&password=%s";
    private static final String LOGOUT_USER = "https://petstore.swagger.io/v2/user/logout";
    private static final String UPDATE_USER = "https://petstore.swagger.io/v2/user/%s";
    private static final String GET_USER = "https://petstore.swagger.io/v2/user/%s";
    private static final String CREATE_USER_WITH_LIST = "https://petstore.swagger.io/v2/user/createWithList";
    private static final String CREATE_PET = "https://petstore.swagger.io/v2/pet";

    public static void main(String[] args) throws IOException, InterruptedException {
        UserUtil userUtil = new UserUtil();
        User user = createUser(2L,"maznichenkoo16@gmail.com","asnils", "VisaGold1234", "Illya",
                "Maznichenko", "+380636593406",1);
        User user1 = createUser(3L,"e@gmail.com","savitar","qwerty","Egor","Bonduk",
                "675754",2);
        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user1);
        PetUtil petUtil = new PetUtil();
        Pet pet = createPet(1,"Barsyc",1,"string",1,"cat","available","url");

            //userUtil.createUser(URI.create(URI_CREATE_USER),user);
            //userUtil.deleteUser(DELETE_USER,user);
            //userUtil.loginUser(LOGIN_USER,user);
            //userUtil.logoutUser(URI.create(LOGOUT_USER));
            //userUtil.updateUser(UPDATE_USER,user);
            //System.out.println(userUtil.getUser(GET_USER, user));
            //userUtil.createListUser(list,URI.create(CREATE_USER_WITH_LIST));
            petUtil.addPetToStore(URI.create(CREATE_PET),pet);

    }






    private static User createUser(Long id, String email, String userName, String password, String firstName, String lastName,
                                   String phone, int status){
        User user = new User();
        user.setId(id);
        user.setEmail(email);
        user.setUserStatus(status);
        user.setUsername(userName);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPhone(phone);
        return user;
    }

    private static Pet createPet(int id, String name,int idTag, String nameTag, int idCategory, String nameCategory, String status, String photoUrl){
        Pet pet = new Pet();
        Category category = new Category();
        Tag tag = new Tag();
        tag.setId(idTag);
        tag.setName(nameTag);
        category.setId(idCategory);
        category.setName(nameCategory);
        pet.setId(id);
        pet.setName(name);
        pet.setCategory(category);
        pet.setStatus(Status.valueOf(status));
        pet.setTag(tag);
        pet.setPhotoUrls(photoUrl);
        return pet;
    }
}
