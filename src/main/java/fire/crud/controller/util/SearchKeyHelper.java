package fire.crud.controller.util;

import java.util.Map;

public class SearchKeyHelper {

	/**
	 * 两边模糊搜索
	 * @param keys
	 * @param keyname
	 * @param value
	 */
	public static boolean setStringKey(Map<String, Object> keys, String keyname, String value){
		if(null == value)
			return false;
		
		value=value.trim();
		
		if("".equals(value))
			return false;
		
		keys.put(keyname+" like ", '%'+value+'%');
		return true;
	}
	
	/**
	 * 严格对等
	 * @param keys
	 * @param keyname
	 * @param value
	 */
	public static boolean setStringKeyStrict(Map<String, Object> keys, String keyname, String value){
		if(null == value)
			return false;
		
		value=value.trim();
		
		if("".equals(value))
			return false;
		
		keys.put(keyname+" = ", value);
		return true;
	}
	
	/**
	 * 忽略-1和null
	 * @param keys
	 * @param keyname
	 * @param value
	 */
	public static void setIntegerKey(Map<String, Object> keys, String keyname, Integer value){
		if(null == value)
			return;
		
		if(value == -1)
			return;
		
		keys.put(keyname+" = ", value);
		
	}
	
	/**
	 * 忽略null
	 * @param keys
	 * @param keyname
	 * @param value
	 */
	public static void setEnumKey(Map<String, Object> keys, String keyname, Enum value){
		if(null == value)
			return;
		
		keys.put(keyname+" = ", value);
		
	}
}
