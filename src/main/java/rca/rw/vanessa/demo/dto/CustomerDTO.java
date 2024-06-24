package rca.rw.vanessa.demo.dto;

import rca.rw.vanessa.demo.enums.ERole;

public class CustomerDTO {
    private Long id;
    private String firstname;
    private String email;
    private String phone;
    private String password;
    private String roles;

    public CustomerDTO() {
    }

    public CustomerDTO(Long id, String firstname, String email, String phone, String password, String role) {
        this.id = id;
        this.firstname = firstname;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.roles = role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.roles = role;
    }

    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }


    public String getPassword() {
        return password;
    }

    public String getRoles() {
        return roles;
    }
}
