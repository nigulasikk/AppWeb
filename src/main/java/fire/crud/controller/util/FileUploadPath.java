package fire.crud.controller.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class FileUploadPath {
	
	final Logger logger = LoggerFactory.getLogger(getClass());
	
	public static String CKEDITOR_FILEUPLOAD_IMAGE="";
	
	public static String BASE_URL="";
	
	final public static String CKEDITOR_IMAGE_SHORT_PATH="userdata/ckeditor";
	
	final public static String USER_PORTRAIT = "userdata/user/portrait";

	public static String pathCutter(String path){
		//TODO 处理ueditor上传的图片进行处理。
		if(StringUtils.isEmpty(path))
			return "";
		
		return path.replace(BASE_URL, "");
	}
}
