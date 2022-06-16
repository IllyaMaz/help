package Builder;
import Object.User;

public class BuilderUserImpl implements BuilderUser.Build {

    User user = new User();

    @Override
    public BuilderUserImpl clear() {
        user.setId(null);
        user.setFirstName(null);
        user.setUsername(null);
        user.setPassword(null);
        user.setEmail(null);
        user.setPhone(null);
        user.setUserStatus(null);
        return this;
    }

    @Override
    public User reset() {
        return user;
    }

    @Override
    public BuilderUserImpl setPeople(Long id, String firstName, String lastName) {
        user.setId(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return this;
    }

    @Override
    public BuilderUserImpl setLog(String userName, String password, int userStatus) {
        user.setUsername(userName);
        user.setPassword(password);
        user.setUserStatus(userStatus);
        return this;
    }

    @Override
    public BuilderUserImpl setContacts(String email, String phone) {
        user.setEmail(email);
        user.setPhone(phone);
        return this;
    }
}
