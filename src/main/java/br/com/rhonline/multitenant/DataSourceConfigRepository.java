package br.com.rhonline.multitenant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataSourceConfigRepository extends JpaRepository<DataSourceConfig, Long> {

	DataSourceConfig findByName(String name);
}
