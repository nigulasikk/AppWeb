package fire.crud.util;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonHelper {

	final static private Logger LOGGER=LoggerFactory.getLogger(JsonHelper.class);
	
	/**
	 * 
	 * @param o
	 * @return
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static String toJson(Object o) throws JsonGenerationException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(o);
		LOGGER.debug(json);
		return html(json);
	}
	
	/**
	 * html转义
	 * @param content
	 * @return
	 */
	public static String html(String content) {
	 if(content==null) return "";        
	     String html = content;
	     
	 //    html = html.replace( "'", "&apos;");
	     html = html.replaceAll( "&", "&amp;");
	     html = html.replace( "\"", "&quot;");  //"
	     html = html.replace( "\t", "&nbsp;&nbsp;");// 替换跳格
	     html = html.replace( " ", "&nbsp;");// 替换空格
	     html = html.replace("<", "&lt;");
	 
	     html = html.replaceAll( ">", "&gt;");
	   
	     return html;
	 }
}
