package service;

import javax.management.relation.Role;
import java.util.Optional;

public class RoleService {
    public Optional<Role> retriveRoleById(int roleId) throws Exception {
        try {
            RoleDAO roleDAO = DAOFactory.getInstance().getRoleDAO();
            return roleDAO.finndById(roleId);
        }catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }
    }

    public Optional<Role> retriveRoleByRoleName(String roleName) throws Exception {
        try {
            RoleDAO roleDAO = DAOFactory.getInstance().getRoleDAO();
            return roleDAO.findByRole(roleName);
        }catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }
    }
}
