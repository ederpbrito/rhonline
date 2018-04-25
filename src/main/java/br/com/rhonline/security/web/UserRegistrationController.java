package br.com.rhonline.security.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.rhonline.multitenant.DataSourceConfigService;
import br.com.rhonline.security.model.User;
import br.com.rhonline.security.service.UserService;
import br.com.rhonline.security.web.dto.UserRegistrationDto;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private DataSourceConfigService dataSourceService;

	@ModelAttribute("user")
	public UserRegistrationDto userRegistrationDto() {
		return new UserRegistrationDto();
	}

	@GetMapping
	public String showRegistrationForm(Model model) {
		return "registration";
	}

	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto userDto,
			BindingResult result) {

		User existing = userService.findByEmail(userDto.getEmail());
		if (existing != null) {
			result.rejectValue("email", null, "Já existe uma conta registrada com esse email");
		}
		
		if (result.hasErrors()) {
			return "registration";
		}
		
		//Cria usuário e schema do cliente
		userService.save(userDto);		
		dataSourceService.save(userDto);
		
		return "redirect:/registration?success";
	}
}
