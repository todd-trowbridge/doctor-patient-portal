package com.todd.trowbridge.ibex.interview.backend;

import com.todd.trowbridge.ibex.interview.backend.entities.Authority;
import com.todd.trowbridge.ibex.interview.backend.entities.User;
import com.todd.trowbridge.ibex.interview.backend.repos.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BackendApplication {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserDetailsRepository userDetailsRepository;

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@PostConstruct
	protected void init(){
		List<Authority> authorityList = new ArrayList<>();
		authorityList.add(createAuthority("USER", "User role"));

//		User user = new User();
//		user.setUserName("user");
//		user.setFirstName("Test");
//		user.setLastName("User");
//		user.setPassword(passwordEncoder.encode("1234"));
//		user.setEnabled(true);
//		user.setAuthorities(authorityList);
//		userDetailsRepository.save(user);
//
//		authorityList.add(createAuthority("ADMIN", "Admin role"));
//
//		User admin = new User();
//		admin.setUserName("admin");
//		admin.setFirstName("Test");
//		admin.setLastName("Admin");
//		admin.setPassword(passwordEncoder.encode("1234"));
//		admin.setEnabled(true);
//		admin.setAuthorities(authorityList);
//		userDetailsRepository.save(admin);
	}

	private Authority createAuthority(String roleCode, String roleDescription){
		Authority authority = new Authority();
		authority.setRoleCode(roleCode);
		authority.setRoleDescription(roleDescription);
		return authority;
	}

}
