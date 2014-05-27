package fire.crud.controller.util;

import java.io.IOException;

import ognl.Ognl;
import ognl.OgnlException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fire.crud.util.JsonHelper;


public class WebBeanHelper {
	
	final Logger logger = LoggerFactory.getLogger(getClass());
	
	public Object express(String ognlExpress){
		logger.debug("ognlExpress is {}",ognlExpress);
		try {
			return Ognl.getValue(ognlExpress, null);
		} catch (OgnlException e) {
			logger.warn("ognl paser failed, {}",e);
			return null;
		}
	}
	
	public Object eqs(String ognlExpress,Object o){
		logger.debug("ognlExpress is {}",ognlExpress);
		try {
			Object _ognl_result=Ognl.getValue(ognlExpress, null);
			return o.equals(_ognl_result);
		} catch (OgnlException e) {
			logger.warn("ognl paser failed, {}",e);
			return null;
		}
	}
	
	public String toJson(Object object){
		logger.debug("object is {}",object.toString());
		try {
			return JsonHelper.toJson(object);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
			return "";
		} catch (JsonMappingException e) {
			e.printStackTrace();
			return "";
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}

}
