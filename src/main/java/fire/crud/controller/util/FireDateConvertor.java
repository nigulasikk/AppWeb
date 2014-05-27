package fire.crud.controller.util;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FireDateConvertor extends PropertyEditorSupport implements PropertyEditor {

	final Logger logger = LoggerFactory.getLogger(getClass());
	
	String[] pattern = new String[]{"yyyy-MM","yyyyMM","yyyy/MM",   
            "yyyyMMdd","yyyy-MM-dd","yyyy/MM/dd",   
            "yyyyMMddHHmmss",   
                        "yyyy-MM-dd HH:mm:ss",   
                        "yyyy/MM/dd HH:mm:ss"};
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		logger.debug("text is {}",text);
		
		if(null == text|| "".equals(text)){
			setValue(null);
			return;
		}
		
		try {
			Date date =  DateUtils.parseDate(text, pattern);
			setValue(date);
		} catch (Exception e) {
			logger.error("{}",e);
			setValue(null);
		}
		
	}
}
