package rca.rw.vanessa.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import rca.rw.vanessa.demo.dto.CustomerDTO;
import rca.rw.vanessa.demo.models.Customer;
import rca.rw.vanessa.demo.models.Role;
import rca.rw.vanessa.demo.repository.CustomerRepository;
import rca.rw.vanessa.demo.repository.RoleRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, RoleRepository roleRepository) {
        this.customerRepository = customerRepository;
        this.roleRepository= roleRepository;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    public Customer saveCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
//        Role role= this.roleRepository.findByRoleName(customerDTO.getRole());
        customer.setFirstname(customerDTO.getFirstname());
        customer.setEmail(customerDTO.getEmail());
        customer.setPassword(encoder.encode(customerDTO.getPassword()));
        customer.setPhone(customerDTO.getPhone());
        customer.setRoles(customerDTO.getRoles());
        return customerRepository.save(customer);
    }

//    public void deleteCustomer(Long id) {
//        customerRepository.deleteById(id);
//    }
//    public Customer updateCustomer(Long id, Customer newCustomerData) {
//        return customerRepository.findById(id)
//                .map(existingCustomer -> {
//                    existingCustomer.setFirstname();Name(newCustomerData.getName());
//                    existingCustomer.setEmail(newCustomerData.getEmail());
//                    return customerRepository.save(existingCustomer);
//                })
//                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id " + id));
//    }
}