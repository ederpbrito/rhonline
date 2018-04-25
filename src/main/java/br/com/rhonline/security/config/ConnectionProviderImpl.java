package br.com.rhonline.security.config;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;

public class ConnectionProviderImpl implements ConnectionProvider {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DataSource ds = null;
	
	public ConnectionProviderImpl(String database) {
		DataSourceBuilder factory = DataSourceBuilder.create()
				.driverClassName("org.h2.Driver")
				.username("sa")
				.password("")
				.url("jdbc:h2:mem:"+ database);
		 ds = factory.build();

	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean isUnwrappableAs(Class unwrapType) {		
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> unwrapType) {		
		return null;
	}

	@Override
	public Connection getConnection() throws SQLException {
		return ds.getConnection();		
	}

	@Override
	public void closeConnection(Connection conn) throws SQLException {
		conn.close();
	}

	@Override
	public boolean supportsAggressiveRelease() {		
		return false;
	}

}
