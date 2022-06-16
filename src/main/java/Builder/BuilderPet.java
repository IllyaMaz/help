package Builder;
import Object.Pet;
import Object.Status;
public class BuilderPet {

    public interface Build{
        public Build clear();

        public Build setPhoto(String photoUrl);

        public Build setCategory(Long id, String name);

        public Build setTag(Long id, String name);

        public Build setPet(Long id,String name,Status status);

        public Pet reset();
    }

    public static BuilderPet.Build newBuilder(){
        return  new BuilderPetImpl();
    }
}
