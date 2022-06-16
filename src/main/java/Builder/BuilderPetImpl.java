package Builder;
import Object.Pet;
import Object.Category;
import Object.Tag;
import Object.Status;

public class BuilderPetImpl implements BuilderPet.Build {

    Pet pet = new Pet();

    @Override
    public BuilderPetImpl clear() {
        pet.setId(null);
        pet.setName(null);
        pet.setStatus(null);
        pet.setCategory(null);
        pet.setTag(null);
        pet.setPhotoUrls(null);
        return this;
    }

    @Override
    public BuilderPetImpl setPhoto(String photoUrl) {
        String[] photo = new String[1];
        photo[0] = photoUrl;
        pet.setPhotoUrls(photo);
        return this;
    }

    @Override
    public BuilderPetImpl setCategory(Long id, String name) {
        Category category = new Category();
        category.setId(id);
        category.setName(name);
        pet.setCategory(category);
        return this;
    }

    @Override
    public BuilderPetImpl setTag(Long id, String name) {
        Tag[] tag = new Tag[1];
        tag[0].setId(id);
        tag[0].setName(name);
        pet.setTag(tag);
        return this;
    }

    @Override
    public BuilderPetImpl setPet(Long id,String name,Status status) {
        pet.setId(id);
        pet.setName(name);
        pet.setStatus(status);
        return this;
    }

    @Override
    public Pet reset() {
        return pet;
    }
}
