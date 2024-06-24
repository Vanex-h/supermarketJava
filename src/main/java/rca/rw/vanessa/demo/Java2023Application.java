package rca.rw.vanessa.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import rca.rw.vanessa.demo.enums.ERole;
import rca.rw.vanessa.demo.models.Role;
import rca.rw.vanessa.demo.repository.RoleRepository;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class Java2023Application {
	private final RoleRepository roleRepository;


	public static void main(String[] args) {
		SpringApplication.run(Java2023Application.class, args);

	}

	@Bean
	public int initializeRoles() {
		List<ERole> roles = new ArrayList<>();
		roles.add(ERole.ROLE_ADMIN);
		roles.add(ERole.ROLE_MODERATOR);
		roles.add(ERole.ROLE_CUSTOMER);
//        roles.add(ERole.TRADER);

		for (ERole roleName : roles) {
			if (!roleRepository.existsByRoleName(roleName)) {
				Role role = new Role();
				role.setRoleName(roleName);
				roleRepository.save(role);
			}
		}
		return 0;

	}
}
