package models;

/**
 *
 * @author ahmetsahin
 */
public class User {

    private String name, password, userType, tckn;

    public User() {
    }

    public User(String name, String password, String userType, String tckn) {
	this.name = name;
	this.password = password;
	this.userType = userType;
	this.tckn = tckn;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public String getUserType() {
	return userType;
    }

    public void setUserType(String userType) {
	this.userType = userType;
    }

    public String getTckn() {
	return tckn;
    }

    public void setTckn(String tckn) {
	this.tckn = tckn;
    }
    
}
