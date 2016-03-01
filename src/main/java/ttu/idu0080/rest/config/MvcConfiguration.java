package ttu.idu0080.rest.config;


import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.ejb.HibernatePersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@ComponentScan(basePackages="ttu.idu0080.rest")
@EnableWebMvc
@EnableTransactionManagement


public class MvcConfiguration extends WebMvcConfigurerAdapter{


	private static final String PROPERTY_NAME_DATABASE_DRIVER = "org.postgresql.Driver";
    private static final String PROPERTY_NAME_DATABASE_PASSWORD = "Laantee1994";
    private static final String PROPERTY_NAME_DATABASE_URL = "jdbc:postgresql://localhost:5432/Kassid";
    private static final String PROPERTY_NAME_DATABASE_USERNAME = "postgres";
         
    private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "org.hibernate.dialect.PostgreSQLDialect";
    private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "ttu";
	
    
	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	 @Bean
     public DataSource dataSource() {
             DriverManagerDataSource dataSource = new DriverManagerDataSource();
              
             dataSource.setDriverClassName(PROPERTY_NAME_DATABASE_DRIVER);
             dataSource.setUrl(PROPERTY_NAME_DATABASE_URL);
             dataSource.setUsername(PROPERTY_NAME_DATABASE_USERNAME);
             dataSource.setPassword(PROPERTY_NAME_DATABASE_PASSWORD);
              
             return dataSource;
     }
	
	@Bean
     public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
             LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
             entityManagerFactoryBean.setDataSource(dataSource());
             entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistence.class);
             entityManagerFactoryBean.setPackagesToScan(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN);
                              
             entityManagerFactoryBean.setJpaProperties(hibProperties());
              
             return entityManagerFactoryBean;
     }
	
	private Properties hibProperties() {
		Properties properties = new Properties();
		properties.put(PROPERTY_NAME_HIBERNATE_DIALECT,	PROPERTY_NAME_HIBERNATE_DIALECT);
		properties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, PROPERTY_NAME_HIBERNATE_SHOW_SQL);
		return properties;
	}
	
  @Bean
  public PlatformTransactionManager txManager() {
      // return new DataSourceTransactionManager(dataSource());
 	    JpaTransactionManager transactionManager = new JpaTransactionManager();
 	    transactionManager.setEntityManagerFactory(entityManagerFactory()
 	            .getObject());

 	    return transactionManager;
  }
  
}
