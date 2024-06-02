package data;

public class Account {

    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String phoneNumber;
    private String email;

    //constructor
    public Account(String username, String firstName, String lastName,
            String password, String phoneNumber, String email) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    //getter và setter
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //hàm in
    public void showInfor() {
        String str = String.format("|%-15s|%-10s|%-10s|%-10s|%-10s|%20s|",
                username, firstName, lastName, password, phoneNumber, email);
        System.out.println(str);
    }

    @Override
    public String toString() {
        String str = String.format("|%-15s|%-10s|%-10s|%-20s|%-10s|%20s|",
                username, firstName, lastName, password, phoneNumber, email);
        return str;
    }

}
