package rca.rw.vanessa.demo.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import rca.rw.vanessa.demo.models.Customer;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerDataDetails implements UserDetails {
    private static final long serialVersionUID = 1L;
    //private String name;
    private String username;
    private String password;
    private List<GrantedAuthority> authorities;
    public CustomerDataDetails(Customer customerData) {
        username=customerData.getEmail();
        password = customerData.getPassword();
        authorities = Arrays.stream(customerData.getRoles().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
//        System.out.println("Here: "+customerData.getRoles());
//        authorities= customerData.getRoles().stream()
//                .map(role -> new SimpleGrantedAuthority(role.getRoleName().toString()))
//                .collect(Collectors.toList());
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public String getUsername() {
        return username;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
}
