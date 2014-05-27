package fire.crud.controller;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fire.crud.controller.util.ControllerProperty;
import fire.crud.controller.util.Login;
import fire.crud.controller.util.SessionHelper;
import fire.crud.controller.util.ViewPath;
import fire.crud.entity.User;
import fire.crud.service.IUserService;

@Controller("loginController")
@RequestMapping(value = "/login")
public class LoginController {

	final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private IUserService userService;

	@Value("${isValidateCodeOn}")
	private boolean isValidateCodeOn;

	/**
	 * 
	 * @param user
	 * @param validcode
	 * @param request
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/login.spr", method = RequestMethod.POST)
	public String login(@ModelAttribute("user") User user, String validcode, HttpServletRequest request, HttpSession session, HttpServletResponse response,
			Model model) {

		logger.debug("isValidateCodeOn: {}", isValidateCodeOn);

		if (isValidateCodeOn) {
			String code = (String) session.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
			if (StringUtils.isEmpty(validcode) || !validcode.equals(code)) {
				ControllerProperty.setOprst(model, false, "验证码错误!");
				return ViewPath.USER_LOGIN_REDIRECT;
			}
		}

		User tuser = userService.verify(user.getLoginName(), user.getPswd());
		if (null == tuser) {
			model.addAttribute("user", user);
			ControllerProperty.setOprst(model, false, "登录失败,用户名或者密码错误!");
			return ViewPath.USER_LOGIN_REDIRECT;
		}

		// 增加登录统计
		userService.addLoginCount(tuser.getId());

		String ip = request.getRemoteAddr();
		logger.debug("user ip is: {}", ip);
		userService.doLastLoginInfo(tuser.getId(), ip, new Date());

		tuser = userService.findByID(User.class, tuser.getId());

		session.setAttribute(SessionHelper.USER_HANDLER, tuser);

		Cookie cookie = new Cookie("JSESSIONID", request.getSession().getId());
		response.addCookie(cookie);

		// 重定向到用户首页,因为https和http之间的重定向,没有找到spring的支持方法,所以写到jsp里面
		return "redirect_to_userindex";

		// if("http".equals(request.getScheme())){
		// return ViewPath.USER_INDEX_REDIRECT;
		// }else{
		// return "redirect_to_userindex";
		// }

	}

	/**
	 * 
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/logout.spr", method = RequestMethod.GET)
	public String logout(HttpSession session, Model model) {
		session.invalidate();
		return ViewPath.USER_LOGIN_REDIRECT;
	}

	/**
	 * 
	 * @param session
	 * @return
	 */
	@Login
	@RequestMapping(value = "/home.spr", method = RequestMethod.GET)
	public String home(HttpSession session) {
		return ViewPath.USER_INDEX;
	}

}
