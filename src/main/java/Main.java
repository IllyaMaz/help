import Requests.PetUtil;
import Requests.StoreUtil;
import Requests.UserUtil;
import Object.User;
import Object.Pet;
import Object.Category;
import Object.Status;
import Object.Tag;
import Object.StoreOrder;
import Object.StatusStoreOrder;


import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) throws IOException, InterruptedException {
        ApiConstants apiConstants = new ApiConstants();
        UserUtil userUtil = new UserUtil();
        User user = createUser(2L,"maznichenkoo16@gmail.com","asnils", "VisaGold1234", "Illya",
                "Maznichenko", "+380636593406",1);
                User user1 = createUser(3L,"e@gmail.com","savitar","qwerty","Egor","Bonduk",
                "675754",2);
        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user1);
        PetUtil petUtil = new PetUtil();
        Pet pet = createPet(1L,"Barsyc",1,"string",1,"cat","available","url");
        StoreOrder storeOrder = createStoreOrder(1L,1L, LocalDateTime.now(),StatusStoreOrder.approved,1,true);
        StoreUtil storeUtil = new StoreUtil();
        File file = new File("D:\\hw-HTTP-developer\\image.jpg");
//            userUtil.createUser(URI.create(apiConstants.URI_CREATE_USER),user);
//            userUtil.deleteUser(apiConstants.DELETE_USER,user);
//            userUtil.loginUser(apiConstants.LOGIN_USER,user);
//            userUtil.logoutUser(URI.create(apiConstants.LOGOUT_USER));
//            userUtil.updateUser(apiConstants.UPDATE_USER,user);
//            System.out.println(userUtil.getUser(apiConstants.GET_USER, user));
//            userUtil.createListUser(list,URI.create(apiConstants.CREATE_USER_WITH_LIST));
//            petUtil.addPetToStore(URI.create(apiConstants.CREATE_PET),pet);
//            petUtil.updatePet(URI.create(apiConstants.UPDATE_PET),pet);
//            System.out.println(petUtil.getByStatus(apiConstants.GET_BY_STATUS, String.valueOf(Status.available)));
//            System.out.println(petUtil.getById(apiConstants.GET_PET_BY_ID, 1L));
//            petUtil.updatePetById(apiConstants.UPDATE_PET_BY_ID,pet);
//            petUtil.deletePet(apiConstants.DELETE_PET,1L);
//            petUtil.uploadToImage(apiConstants.UPLOAD_IMAGE_PET,1L, file);
//            storeUtil.placeAnOrderForPet(URI.create(apiConstants.PLACE_ORDER),storeOrder);
//            System.out.println(storeUtil.getPurchaseById(apiConstants.GET_PURCHASE_BY_ID, 1));
//            System.out.println(storeUtil.getStoreInventory(URI.create(apiConstants.GET_STORE_INVENTORY)));
//            storeUtil.deletePurchaseOrderById(apiConstants.DELETE_PURCHASE_ORDER_BY_ID,1);
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

    private static Pet createPet(Long id, String name,int idTag, String nameTag, int idCategory, String nameCategory, String status, String photoUrl){
        Pet pet = new Pet();
        Category category = new Category();
        String[] photoUrls = new String[1];
        photoUrls[0] = photoUrl;
        Tag[] tag = new Tag[1];
        tag[0]=new Tag();
        tag[0].setId(idTag);
        tag[0].setName(nameTag);
        category.setId(idCategory);
        category.setName(nameCategory);
        pet.setId(id);
        pet.setName(name);
        pet.setCategory(category);
        pet.setStatus(Status.valueOf(status));
        pet.setTag(tag);
        pet.setPhotoUrls(photoUrls);
        return pet;
    }

    private static StoreOrder createStoreOrder(Long id, Long petID, LocalDateTime shipDate, StatusStoreOrder statusStoreOrder,Integer quantity, Boolean copmlete){
        StoreOrder storeOrder = new StoreOrder();
        storeOrder.setId(id);
        storeOrder.setPetId(petID);
        storeOrder.setShipDate(String.valueOf(shipDate));
        storeOrder.setStatus(statusStoreOrder);
        storeOrder.setQuantity(quantity);
        storeOrder.setComplete(copmlete);
        return storeOrder;
    }
}
