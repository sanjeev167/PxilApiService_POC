/**
 * 
 */
package com.pxil.db.config;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * @author sanjeevkumar 
 * 29-Nov-2023 
 * 11:43:00 am 
 * Objective:
 */

@Configuration
@EnableTransactionManagement
@PropertySource({ "classpath:application.properties" })
@EnableJpaRepositories(basePackages = {
		                               ApiJpaConstants.PKG_PVT_REGUL_REPO,
		                               ApiJpaConstants.PKG_SEC_REPO,  
		                               ApiJpaConstants.PKG_PVT_SLDC_REPO}, 
                                       entityManagerFactoryRef = "apiServiceEntityManager", 
                                       transactionManagerRef = "apiServiceTransactionManager")

public class ApiServicePersistenceConfig {


	@Autowired
	private Environment env;// Contains Properties loaded by @PropertySources		
	
	/**
	 * Author: sanjeevkumar<p>
	 * Date 29-Nov-2023<p>
	 * Objective : This bean has been configure for creating a data-source for apiService.<p>
	 * Using a datasource, we could get a connection for doing database related operation.
	 *
	 */
	@Bean(name = "apiServiceDataSource")
	public DataSource apiServiceDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
		dataSource.setUrl(env.getProperty("spring.datasource.url"));
		dataSource.setUsername(env.getProperty("spring.datasource.username"));
		dataSource.setPassword(env.getProperty("spring.datasource.password"));
		return dataSource;
	}//End of apiServiceDataSource

	/**
	 * Author: sanjeevkumar<p>
	 * Date 29-Nov-2023<p>
	 * Objective This bean has been configured for creating a apiServiceEntityManager for the
	 *            apiService. This will manage all those entities which have
	 *            been defined in API_SERVICE_PKG_ENTITIES_ARRAY under API_SERVICE_JPA_UNIT. 
	 *            An entity manager is used for doing operation through entities.
	 *
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean apiServiceEntityManager() {
		final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(apiServiceDataSource());
		// Scan Entities in Package:
		em.setPackagesToScan(ApiJpaConstants.API_SERVICE_PKG_ENTITIES_ARRAY); 
		em.setPersistenceUnitName(ApiJpaConstants.API_SERVICE_JPA_UNIT);// Important !!

		final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);

		// JPA & Hibernate
		final HashMap<String, Object> jpaProperties = new HashMap<String, Object>();

		// Configures the used database dialect. This allows Hibernate to create SQL
		// that is optimized for the used database.
		jpaProperties.put("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect"));

		// If the value of this property is true, Hibernate writes all SQL
		// statements to the console.
		jpaProperties.put("hibernate.show-sql", env.getProperty("spring.jpa.show-sql"));

		// If the value of this property is true, Hibernate will format the SQL
		// that is written to the console.
		jpaProperties.put("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));

		// Solved Error: PostGres createClob() is not yet implemented.
		// PostGres Only:
		jpaProperties.put("hibernate.temp.use_jdbc_metadata_defaults", false);

		// jpaProperties.put("hibernate.hbm2ddl.auto",
		// env.getRequiredProperty("hibernate.hbm2ddl.auto"));
		em.setJpaPropertyMap(jpaProperties);
		em.afterPropertiesSet();

		return em;
	}//End of apiServiceEntityManager

	/**
	 * Author: sanjeevkumar<p>
	 * Date 29-Nov-2023<p>
	 * Objective : This method will be used for creating an apiServiceTransactionManager for apiServiceEntityManager. 
	 *             It is used for managing a transaction.<p>
	 *
	 */
	
	@Bean(name = "apiServiceTransactionManager")
	public PlatformTransactionManager apiServiceTransactionManager() {
		final JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(apiServiceEntityManager().getObject());
		return transactionManager;
	}//End of apiServiceTransactionManager

}// End of ApiServicePersistenceConfig
