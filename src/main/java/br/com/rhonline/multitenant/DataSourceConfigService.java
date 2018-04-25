package br.com.rhonline.multitenant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import br.com.rhonline.security.web.dto.UserRegistrationDto;

@Service
public class DataSourceConfigService {

	//@Autowired
	//private DataSourceConfigRepository repository;	
	
	@Autowired
	ApplicationContext context;
	
	public void save(UserRegistrationDto user) {
		DataSourceConfig dataSource = new DataSourceConfig();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setName(user.getFirstName());
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		dataSource.setUrl("jdbc:h2:mem:" + user.getFirstName());
		dataSource.setInitialize(true);
		
		DataSourceConfigRepository repository = context.getBean(DataSourceConfigRepository.class);		
		TenantDataSource tenantSource = context.getBean(TenantDataSource.class);		
		repository.save(dataSource);		
		tenantSource.getDataSource(user.getFirstName());
	}
}
