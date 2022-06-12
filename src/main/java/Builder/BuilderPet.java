package Builder;
import Object.Pet;
import Object.Status;
import Object.Tag;
import Object.Category;
public class BuilderPet {

    Pet pet = new Pet();

    public void setPet(Long id,String name,Status status){
        pet.setId(id);
        pet.setName(name);
        pet.setStatus(status);
    }

    public void setTag(Long id, String name){
        Tag[] tag = new Tag[1];
        tag[0].setId(id);
        tag[0].setName(name);
        pet.setTag(tag);
    }

    public void setCategory(Long id, String name){
        Category category = new Category();
        category.setId(id);
        category.setName(name);
        pet.setCategory(category);
    }

    public void setPhoto(String photoUrl){
        String[] photo = new String[1];
        photo[0] = photoUrl;
        pet.setPhotoUrls(photo);
    }

    public void clear(){
        pet.setId(null);
        pet.setName(null);
        pet.setStatus(null);
        pet.setCategory(null);
        pet.setTag(null);
        pet.setPhotoUrls(null);
    }

    public Pet reset(){
        return pet;
    }
}
