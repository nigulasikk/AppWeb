package fire.crud.controller.util;

import javax.servlet.http.HttpSession;

import fire.crud.entity.User;

public class SessionHelper {

	/**
	 * user的键
	 */
	final public static String USER_HANDLER="user";
	
	public static Integer getManagerId(HttpSession session){
		User user = (User)session.getAttribute(SessionHelper.USER_HANDLER);
		if(null == user){
			return null;
		}
		
		return user.getId();
	}
	
	public static User getManager(HttpSession session){
		User user = (User)session.getAttribute(SessionHelper.USER_HANDLER);
		return user;
	}
}
