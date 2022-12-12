package service;

import entity.User;
import entity.UserInformation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserInformationService {
    public Optional<UserInformation> retriveUserInformationById(int userInformationId) throws Exception {
        try {
            UserInformationDAO userInformationDAO = DAOFactory.getInstance().getUserInformationDAO();
            return userInformationDAO.finndById(userInformationId);
        }catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }
    }

    public List<UserInformation> getUserInformationFromUsers(List<User> users) throws Exception {
        List<UserInformation> result = new ArrayList<>();
        try {
            for (User user : users) {
                Optional<UserInformation> userInformation = retriveUserInformationById(user.getUserInformationId());
                userInformation.ifPresent(result::add);
            }
        }catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }
        return result;
    }
}
