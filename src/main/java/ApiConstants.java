public final class ApiConstants {
    public static final String URI_CREATE_USER = "https://petstore.swagger.io/v2/user";
    public static final String DELETE_USER = "https://petstore.swagger.io/v2/user/";
    public static final String LOGIN_USER = "https://petstore.swagger.io/v2/user/login?username=%s&password=%s";
    public static final String LOGOUT_USER = "https://petstore.swagger.io/v2/user/logout";
    public static final String UPDATE_USER = "https://petstore.swagger.io/v2/user/%s";
    public static final String GET_USER = "https://petstore.swagger.io/v2/user/%s";
    public static final String CREATE_USER_WITH_LIST = "https://petstore.swagger.io/v2/user/createWithList";
    public static final String CREATE_PET = "https://petstore.swagger.io/v2/pet";
    public static final String UPDATE_PET = "https://petstore.swagger.io/v2/pet";
    public static final String GET_BY_STATUS = "https://petstore.swagger.io/v2/pet/findByStatus?status=%s";
    public static final String GET_PET_BY_ID = "https://petstore.swagger.io/v2/pet/%d";
    public static final String UPDATE_PET_BY_ID = "https://petstore.swagger.io/v2/pet/%d";
    public static final String DELETE_PET = "https://petstore.swagger.io/v2/pet/%d";
    public static final String UPLOAD_IMAGE_PET = "https://petstore.swagger.io/v2/pet/%d/uploadImage";
    public static final String PLACE_ORDER = "https://petstore.swagger.io/v2/store/order";
    public static final String GET_PURCHASE_BY_ID = "https://petstore.swagger.io/v2/store/order/%d";
    public static final String GET_STORE_INVENTORY = "https://petstore.swagger.io/v2/store/inventory";
    public static final String DELETE_PURCHASE_ORDER_BY_ID = "https://petstore.swagger.io/v2/store/order/%d";

    public ApiConstants(){

    }
}
