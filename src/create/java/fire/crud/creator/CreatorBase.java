package fire.crud.creator;

import java.net.URL;
import java.util.Properties;

import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class CreatorBase{
	
	final private Logger logger = LoggerFactory.getLogger(CreatorBase.class);
	
	Configuration configuration;
	
	@Before
	public void setUp() throws Exception {
		//配置log4j
		String resource = "/mysqldb.properties"; 
		URL configFileResource = CreatorBase.class.getResource(resource);
		Properties mysqldb = new Properties();
		mysqldb.load(configFileResource.openStream());
		
		logger.info("mysqldb {}", mysqldb);
		
		configuration = new Configuration();
		Properties extraProperties = new Properties();
		extraProperties.setProperty("hibernate.connection.url", mysqldb.getProperty("connection.url"));
		extraProperties.setProperty("hibernate.connection.username", mysqldb.getProperty("connection.username"));
		extraProperties.setProperty("hibernate.connection.password", mysqldb.getProperty("connection.password"));
		extraProperties.setProperty("hibernate.dialect", mysqldb.getProperty("hibernate.dialect"));
		extraProperties.setProperty("hibernate.show_sql", mysqldb.getProperty("hibernate.show_sql"));
		extraProperties.setProperty("hibernate.connection.driver_class", mysqldb.getProperty("connection.driver_class"));
		configuration.addProperties(extraProperties);
		
	}
	
}
