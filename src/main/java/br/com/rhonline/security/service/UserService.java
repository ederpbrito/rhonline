package br.com.rhonline.security.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import br.com.rhonline.security.model.User;
import br.com.rhonline.security.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {

	User findByEmail(String email);
    User save(UserRegistrationDto registration);
}
