package fire.crud.interceptor;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import fire.crud.controller.util.Login;
import fire.crud.controller.util.ResultTypeEnum;
import fire.crud.controller.util.SessionHelper;
import fire.crud.entity.User;
/**
 * 检查是否已经登录
 * @author jf
 *
 */
public class LoginAnnotationInterceptor extends HandlerInterceptorAdapter {

	final Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		HandlerMethod handler2 = (HandlerMethod) handler;
		Login login = handler2.getMethodAnnotation(Login.class);

		if (null == login) {
			// 没有声明权限,放行
			return true;
		}

		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(SessionHelper.USER_HANDLER);

		if (null == user) {
			// 需要登录
			if (login.value() == ResultTypeEnum.page) {
				//传统页面的登录
				String rurl = request.getContextPath()+"/login.jsp?oprst=false&opmsg="+URLEncoder.encode("请登录!","utf-8");
				logger.debug(rurl);
				response.sendRedirect(rurl);
			} else if (login.value() == ResultTypeEnum.json) {
				//ajax页面的登录
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=UTF-8");
				OutputStream out = response.getOutputStream();
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(out,"utf-8"));
				pw.println("{\"result\":false,\"code\":11,\"errorMessage\":\"您未登录,请先登录\"}");
				pw.flush();
				pw.close();
			}
			return false;

		}

		return true;

	}

}
