package fire.crud.creator;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fire.crud.entity.Article;





public class ArticleCreator extends CreatorBase {
	
	final private Logger logger = LoggerFactory.getLogger(ArticleCreator.class);
	
	@Test
	public void createArticle() {
		logger.info("Creating Article database table ...");
		
		configuration.addAnnotatedClass(Article.class);
		
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();         
	 	SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry); 
	    
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		SchemaExport schemaExport = new SchemaExport(configuration);
		schemaExport.create(true, true);
		session.getTransaction().commit();
		session.close();
		
		////测试数据
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		Article article = new Article(
		"文章题目测试","摘要内容",
			"文章内容"
		,
			"王俊首发"
		,
			new Date()
		,
		new Date(),	new Date());
		
		session.save(article);
		
		session.getTransaction().commit();
		session.close();
		
	}
}
