package rca.rw.vanessa.demo.models;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import jdk.jfr.Enabled;
import rca.rw.vanessa.demo.enums.ERole;

@Entity

@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public ERole getRoleName() {
        return roleName;
    }

    public void setRoleName(ERole roleName) {
        this.roleName = roleName;
    }

    @Enumerated(EnumType.STRING)
    private ERole roleName;

    public Role() {
    }

    public Role(ERole roleName) {
        this.roleName = roleName;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
