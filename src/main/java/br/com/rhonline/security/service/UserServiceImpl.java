package br.com.rhonline.security.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.rhonline.security.model.Role;
import br.com.rhonline.security.model.User;
import br.com.rhonline.security.repository.UserRepository;
import br.com.rhonline.security.web.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		 User user = userRepository.findByEmail(email);
	        if (user == null){
	            throw new UsernameNotFoundException("Nome de usuário ou senha inválidos.");
	        }
	        return new org.springframework.security.core.userdetails.User(user.getFirstName(),
	                user.getPassword(),
	                mapRolesToAuthorities(user.getRoles()));
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public User save(UserRegistrationDto registration) {
		 User user = new User();
	        user.setFirstName(registration.getFirstName());
	        user.setLastName(registration.getLastName());
	        user.setEmail(registration.getEmail());
	        user.setPassword(passwordEncoder.encode(registration.getPassword()));
	        user.setRoles(Arrays.asList(new Role("ROLE_USER")));
	        return userRepository.save(user);
	}
	
	 private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
	        return roles.stream()
	                .map(role -> new SimpleGrantedAuthority(role.getName()))
	                .collect(Collectors.toList());
	    }

}
