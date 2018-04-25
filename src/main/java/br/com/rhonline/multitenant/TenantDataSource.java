package br.com.rhonline.multitenant;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Component;

@Component
public class TenantDataSource implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private HashMap<String, DataSource> datasources = new HashMap<>();
	
	@Autowired
	private DataSourceConfigRepository configRepo;	
	
	public DataSource getDataSource(String name) {
		
		if(datasources.get(name) != null) {
			return datasources.get(name);
		}
		
		DataSource dataSource = createDataSource(name);
		
		if(dataSource != null) {
			datasources.put(name,dataSource);
		}
		
		return dataSource;
	}
	
	public Map<String, DataSource> getAll(){
		List<DataSourceConfig> configList = configRepo.findAll();
		Map<String,DataSource> result =  new HashMap<>();
		
		for(DataSourceConfig config: configList) {
			DataSource dataSource = getDataSource(config.getName());
			result.put(config.getName(), dataSource);
		}
		
		return result;
	}
	
	private DataSource createDataSource(String name) {
		DataSourceConfig config = configRepo.findByName(name);
		if(config != null) {			
			DataSource ds = factoryDS(config);			
			
			if(config.getInitialize() && !name.equals(MultiTenantConstants.DEFAULT_TENANT_ID)) {
				initialize(ds);
			}
			return ds;
		}
		return null;
	}

	private DataSource factoryDS(DataSourceConfig config) {
		DataSourceBuilder factory = DataSourceBuilder
										.create()
										.driverClassName(config.getDriverClassName())
										.username(config.getUsername())
										.password(config.getPassword())
										.url(config.getUrl());
		DataSource ds = factory.build();
		return ds;
	}
	
	private void initialize(DataSource dataSource) {
		ClassPathResource schemaResource = new ClassPathResource("schemauser.sql");
		ClassPathResource dataResource = new ClassPathResource("datauser.sql");
		
		ResourceDatabasePopulator populator = new ResourceDatabasePopulator(schemaResource,dataResource);
		
		populator.execute(dataSource);
	}	
	
}
