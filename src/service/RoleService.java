package service;

import dao.DAOfactory;
import dao.interfaces.RoleDAO;

import javax.management.relation.Role;
import java.util.Optional;

public class RoleService {
    public Optional<Role> retrieveRoleById(int roleId) throws Exception {
        try {
            RoleDAO roleDAO = DAOfactory.getInstance().getRoleDAO();
            return roleDAO.findById(roleId);
        }catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }
    }

    public Optional<Role> retrieveRoleByRoleName(String roleName) throws Exception {
        try {
            RoleDAO roleDAO = DAOfactory.getInstance().getRoleDAO();
            return roleDAO.findByRole(roleName);
        }catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }
    }
}
