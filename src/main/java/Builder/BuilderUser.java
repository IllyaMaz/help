package Builder;
import Object.User;

public class BuilderUser {

    public interface Build{
        public Build clear();

        public User reset();

        public Build setPeople(Long id,String firstName, String lastName);

        public Build setLog(String userName, String password, int userStatus);

        public Build setContacts(String email, String phone);
    }


    public static BuilderUser.Build newBuilder(){
        return new BuilderUserImpl();
    }
}
