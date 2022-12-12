package service;

import entity.Apartment;
import entity.UserOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ApartmentService {

    public List<Apartment> retriveApartmentByStatus(String status) throws Exception {
        try {
            ApartmentDAO apartmentDAO = DAOFactory.getInstance().getApartamentDAO();
            return apartmentDAO.findByStatus(status);
        }catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }
    }

    public boolean addNewApartment(String status, String number, String price) throws Exception {
        if (status == null || number == null || price == null) {
            return false;
        }

        double dblPrice;
        int intNumber;
        try {
            dblPrice = Double.parseDouble(price);
            intNumber = Integer.parseInt(number);
        }catch(NumberFormatException e) {
            throw new Exception(e.getMessage(), e);
        }

        ApartmentDAO apartmentDAO = DAOFactory.getInstance().getApartamentDAO();
        Apartment apartment = buildApartment(status, intNumber, dblPrice);
        try {
            apartmentDAO.save(apartment);
            return true;
        }catch(Exception e) {
            throw new Exception(e.getMessage(), e);
        }
    }

    public List<Apartment> retrieveApartmentsByUserOrders(List<UserOrder> userOrders) throws Exception {
        try {
            ApartmentDAO apartmentDAO = DAOFactory.getInstance().getApartamentDAO();
            List<Apartment> result = new ArrayList<>();
            for (UserOrder userOrder : userOrders) {
                result.add(apartmentDAO.finndById(userOrder.getApartmentId()).get());
            }
            return result;
        }catch(Exception e) {
            throw new Exception(e.getMessage(), e);
        }
    }

    public List<Apartment> retrieveApartamentsByUserId(int userId) throws Exception {
        try {
            UserOrderDAO userOrderDao=DAOFactory.getInstance().getUserOrderDAO();
            List<UserOrder> userOrders=userOrderDao.findByUserId(userId);
            List<Apartment> result=new ArrayList<>();
            ApartmentDAO apartmentDao= DAOFactory.getInstance().getApartamentDAO();
            for (UserOrder userOrder : userOrders) {
                result.add(apartamentDao.finndById(userOrder.getApartmentId()).get());
            }
            return result;
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }
    }

    public Optional<Apartment> retriveApartmentById(int apartmentId) throws Exception {
        try {
            ApartmentDAO apartmentDAO = DAOFactory.getInstance().getApartamentDAO();
            return apartmentDAO.finndById(apartmentId);
        }catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }
    }

    public void removeApartmentById(int apartmentId) throws Exception {
        try {
            ApartmentDAO apartamentDAO= DAOFactory.getInstance().getApartamentDAO();
            UserOrderDAO userOrderDAO=DAOFactory.getInstance().getUserOrderDAO();

            List<UserOrder> userOrders=userOrderDAO.findByApartmentId(apartmentId);
            for (UserOrder userOrder : userOrders) {
                userOrderDAO.removeById(userOrder.getId());
            }
            apartamentDAO.removeById(apartmentId);
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }
    }

    public List<Apartment> retrieveAllApartments() throws Exception {
        try {
            ApartmentDAO apartmentDAO = DAOFactory.getInstance().getApartamentDAO();
            return apartamentDAO.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }
    }

    public boolean updateApartmentInformation(String id, String status, String number, String price) throws Exception {
        if(status == null || price == null){
            return false;
        }

        double dblPrice;
        int intId;
        int intNumber;
        try{
            dblPrice = Double.parseDouble(price);
            intId = Integer.parseInt(id);
            intNumber = Integer.parseInt(number);
        }catch (NumberFormatException e) {
            throw new Exception(e.getMessage(), e);
        }

        ApartmentDAO apartmentDAO = DAOFactory.getInstance().getApartamentDAO();
        Apartment apartment = buildApartment(status, intNumber, dblPrice);
        try {
            apartmentDAO.updateApartmentById(intId, apartment);
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }
    }

    public void updateApartmentStatusById(int id, String status) throws Exception {
        ApartmentDAO apartmentDAO = DAOFactory.getInstance().getApartamentDAO();
        try {
            apartmentDAO.updateApartmentStatusById(id,status);
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }
    }

    private Apartment buildApartment(String status, int number, double price) {
        Apartment apartment = new Apartment();
        apartment.setStatus(status);
        apartment.setNumber(number);
        apartment.setPrice(price);
        return apartment;
    }
}
