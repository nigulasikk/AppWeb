package fire.crud.interceptor;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import fire.crud.controller.util.AuthorityHelper;
import fire.crud.controller.util.AuthorityType;
import fire.crud.controller.util.FireAuthority;
import fire.crud.controller.util.ResultTypeEnum;
import fire.crud.controller.util.SessionHelper;
import fire.crud.entity.User;

public class AuthorityAnnotationInterceptor extends HandlerInterceptorAdapter {

	final Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		HandlerMethod handler2=(HandlerMethod) handler;
		FireAuthority fireAuthority = handler2.getMethodAnnotation(FireAuthority.class);
	
		if(null == fireAuthority){
			//没有声明权限,放行
			return true;
		}
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(SessionHelper.USER_HANDLER);
		boolean aflag = false;
		
		for(AuthorityType at:fireAuthority.authorityTypes()){
			if(AuthorityHelper.hasAuthority(at.name(), user.getRightContent())==true){
				aflag = true;
				break;
			}
		}
		
		if(false == aflag){// 没有权限
			if (fireAuthority.resultType() == ResultTypeEnum.page) {
				//传统页面的提示
				request.getRequestDispatcher("/oprst.jsp?oprst=false&opmsg=您没有权限执行该操作!").forward(request, response);
			} else if (fireAuthority.resultType() == ResultTypeEnum.json) {
				//ajax页面的提示
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=UTF-8");
				OutputStream out = response.getOutputStream();
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(out,"utf-8"));
				pw.println("{\"result\":false,\"code\":11,\"errorMessage\":\"您没有权限执行该操作!\"}");
				pw.flush();
				pw.close();
			}
			return false;
		
		}
		
		return true;

	}
	
}
