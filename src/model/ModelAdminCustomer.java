package model;

public class ModelAdminCustomer {
    private String id_pelanggan, username,email,password; 

    public ModelAdminCustomer(String id_pelanggan, String username,String email, String password) {
        this.id_pelanggan = id_pelanggan;
        this.username = username;
        this.email = email;
        this.password =password;
    }

    public String getId_pelanggan() {
        return id_pelanggan;
    }

    public void setId_pelanggan(String id_pelanggan) {
        this.id_pelanggan = id_pelanggan;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    

    
    
    
}