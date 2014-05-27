package fire.crud.listener;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fire.crud.controller.util.FileUploadPath;

public class CrudServletContextListener implements ServletContextListener {

	final Logger logger = LoggerFactory.getLogger(getClass());

	public void contextInitialized(ServletContextEvent sce) {
		ServletContext sc = sce.getServletContext();
		TomcatContextConstants.REALPATH = sc.getRealPath("/");

		logger.info("tomcat real path is: {}", TomcatContextConstants.REALPATH);

		logger.info("开始初始化文件上传路径...");
		FileUploadPath.CKEDITOR_FILEUPLOAD_IMAGE= TomcatContextConstants.REALPATH+FileUploadPath.CKEDITOR_IMAGE_SHORT_PATH;
		File f = new File(FileUploadPath.CKEDITOR_FILEUPLOAD_IMAGE);
		f.mkdirs();
		
		logger.info("完成初始化文件上传路径! 路径是:{}",f.getAbsolutePath());
	}

	public void contextDestroyed(ServletContextEvent sce) {

	}

	// static{
	// URL url = FileUploadPath.class.getResource("/");
	// System.out.println(url.toString());
	// REALPATH = url.toString();
	// classespath = file:/D:/apache-tomcat-6.0.20/webapps/yuyang/WEB-INF/classes/
	// REALPATH = REALPATH.substring(5);
	// System.out.println(realPath);
	// REALPATH = REALPATH.substring(0,REALPATH.length()-15);
	// System.out.println(REALPATH);
	// }

}
