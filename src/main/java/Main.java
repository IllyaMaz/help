import Object.UserUtil;
import Object.User;

import java.io.IOException;
import java.net.URI;

public class Main {
    public static final String URI_CREATE_USER = "https://petstore.swagger.io/#/user/createUser";
    public static void main(String[] args) {
        UserUtil userUtil = new UserUtil();
        User user = createUser(2L,"maznichenkoo16@gmail.com","asnils", "VisaGold1234", "Illya",
                "Maznichenko", "+380636593406",1);
        try {
            userUtil.createUser(URI.create(URI_CREATE_USER),user);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
}
