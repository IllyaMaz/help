package Builder;
import Object.User;

public class BuilderUser {

    User user = new User();

    public void setPeople(Long id,String firstName, String lastName) {
        user.setId(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
    }

    public void setContacts(String email, String phone) {
        user.setEmail(email);
        user.setPhone(phone);
    }

    public void setLog(String userName, String password, int userStatus){
        user.setUsername(userName);
        user.setPassword(password);
        user.setUserStatus(userStatus);
    }

    public User reset(){
        return user;
    }

    public void clear(){
        user.setId(null);
        user.setFirstName(null);
        user.setUsername(null);
        user.setPassword(null);
        user.setEmail(null);
        user.setPhone(null);
        user.setUserStatus(null);
    }
}
