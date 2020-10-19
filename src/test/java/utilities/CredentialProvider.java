package utilities;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.List;

public class CredentialProvider {

    public static void main(String[] args) {

        CredentialProvider credentialProvider = new CredentialProvider();

    }

    /**
     * @author wboufaden
     * <p>
     * An extension of the JAXB Abstract Interface to read User objects from
     * an XML file
     */

    public static String pwProvider(String username) throws JAXBException {
        //JAXB classes initialisation
        JAXBContext context = JAXBContext.newInstance(Users.class);
        Unmarshaller un = context.createUnmarshaller();
        //Casting type to Users
        Users userData = (Users) un.unmarshal(new File("src/test/resources/userscredentials/users.xml"));
        List<User> users = userData.getuser();
        for (User u : users) {
            if (u.getUsername().equals(username)) {
                return u.getPassword();
            }
        }
        return null;
    }


    @XmlRootElement
    public static class Users {
        private List<User> user;

        @XmlElement
        public List<User> getuser() {
            return user;
        }

        public void setuser(List<User> userList) {
            this.user = userList;
        }
    }


    public static class User {

        private String username;

        private String password;

        @XmlElement
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        @XmlElement
        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }


}



