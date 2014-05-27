package fire.crud;
import java.net.URL;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
 //使用@RunWith(SpringJUnit4ClassRunner.class),才能使测试运行于Spring测试环境  
@RunWith(SpringJUnit4ClassRunner.class)  
//@ContextConfiguration 注解有以下两个常用的属性：  
//locations：可以通过该属性手工指定 Spring 配置文件所在的位置,可以指定一个或多个 Spring 配置文件  
//inheritLocations：是否要继承父测试类的 Spring 配置文件，默认为 true  
@ContextConfiguration(locations={"classpath:/springcontext.xml"
//							,"classpath:/spring-mvc.xml"
							})  //如果只有一个配置文件就直接写locations=“配置文件路径+名”
public class SpringContext {  
	@Before
	public void setUp() throws Exception {
		//配置log4j
		String resource = "/log4j.properties"; 
		URL configFileResource = SpringContext.class.getResource(resource);
		PropertyConfigurator.configure(configFileResource); 
	}
	
//	@Test
	public void test(){
//		System.out.println(ConstanHelper.getKey(Product.PRODUCT_SIZE, "14寸"));
	}
}  