package dao;

public class DAOfactory {

    private static final DAOfactory instance = new DAOfactory();

    private DAOfactory() {}

    public static DAOfactory getInstance() {
        return instance;
    }

    private final UserDAOImpl userDao = new UserDAOImpl();
    private final RoleDAOImpl roleDao = new RoleDAOImpl();
    private final UserInfoDAOImpl userInfoDao = new UserInfoDAOImpl();
    private final UserOrderDAOImpl userOrderDao=new UserOrderDAOImpl();
    private final ApartmentDAOImp apartmentDao=new ApartmentDAOImp();

    public UserDAOImpl getUserDAO() {
        return userDao;
    }

    public RoleDAOImpl getRoleDAO() {
        return roleDao;
    }

    public UserInfoDAOImpl getUserInformationDAO() {
        return userInfoDao;
    }

    public UserOrderDAOImpl getUserOrderDAO() {
        return userOrderDao;
    }

    public ApartmentDAOImp getApartmentDAO() {
        return apartmentDao;
    }
}
