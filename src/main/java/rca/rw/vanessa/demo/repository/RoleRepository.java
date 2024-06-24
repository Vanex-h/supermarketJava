package rca.rw.vanessa.demo.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rca.rw.vanessa.demo.enums.ERole;
import rca.rw.vanessa.demo.models.Role;


@Repository

public interface RoleRepository extends JpaRepository<Role, Long>{

    boolean existsByRoleName(ERole roleName);
    Role findByRoleName(ERole roleName);
}
