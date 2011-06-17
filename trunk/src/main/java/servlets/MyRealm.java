package servlets;

import DAO.UserDAO;
import model.User;
import org.securityfilter.realm.SimpleSecurityRealmBase;

public class MyRealm extends SimpleSecurityRealmBase {

    public boolean booleanAuthenticate(String username, String password) {
        User user = null;
        try{
            user = UserDAO.retrieveUserbyNickName(username);
        }catch(IndexOutOfBoundsException e){
            return false;
        }
        if(user!=null){
            if(user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    public boolean isUserInRole(String username, String role) {
        return true;
    }



}