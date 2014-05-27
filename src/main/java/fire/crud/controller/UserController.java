package fire.crud.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import fire.crud.controller.util.AjaxHelper;
import fire.crud.controller.util.AjaxResult;
import fire.crud.controller.util.AuthorityType;
import fire.crud.controller.util.ControllerProperty;
import fire.crud.controller.util.DateHelper;
import fire.crud.controller.util.FileUploadPath;
import fire.crud.controller.util.FireAuthority;
import fire.crud.controller.util.FireDateConvertor;
import fire.crud.controller.util.Login;
import fire.crud.controller.util.ResultTypeEnum;
import fire.crud.controller.util.SearchKeyHelper;
import fire.crud.controller.util.ViewPath;
import fire.crud.dao.IBaseDao;
import fire.crud.entity.User;
import fire.crud.listener.TomcatContextConstants;
import fire.crud.service.IUserService;
//import fire.authority.annotation.Login;
//import fire.authority.annotation.ResultTypeEnum;
//import fire.util.DateHelper;
//import fire.util.FireDateConvertor;
@Controller("userController")
@RequestMapping(value="/user")
public class UserController {

	final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private IUserService userService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new FireDateConvertor());
	}
	
	private void saveOrUpdate(User user
		, MultipartFile portraitFile
		) {
		
		Date nowTime = new Date();
		user.setModifyTime(nowTime);
		
		if(user.getId()==null){//属于创建
			user.setCreateTime(nowTime);
			userService.save(user);
		}else{
			userService.update(user);
		}
	
		// 处理上传的图片
		if (portraitFile!=null && !portraitFile.isEmpty()) {
			//删除原有图片
			File oldFile = new File(TomcatContextConstants.REALPATH + FileUploadPath.USER_PORTRAIT, user.getPortrait());
			
			if(oldFile.exists()){
				try {
					logger.debug("原有图片文件: {}",oldFile.getAbsolutePath());
					oldFile.delete();
				} catch (Exception e) {
					logger.warn("删除原图像遇到错误{}", e);
				}
			}
			
			String extenstion = FilenameUtils.getExtension(portraitFile.getOriginalFilename());
			logger.debug("extenstion is {}", extenstion);

			String distName = user.getId() + "." + extenstion;
			
			
			File distFile = new File(TomcatContextConstants.REALPATH + FileUploadPath.USER_PORTRAIT, distName);
			logger.debug("file name is {}", distName);

			try {
				FileUtils.copyInputStreamToFile(portraitFile.getInputStream(), distFile);
				user.setPortrait(distName);
			} catch (IOException e) {
				logger.warn("图像上传出错了{}", e);
			}
			
		}
		
		userService.update(user);
	}

	/**
	 * 添加
	 * @param user
	 * @param model
	 * @return
	 */
	@Login()
	@FireAuthority(authorityTypes = AuthorityType.增删改查用户)
	@RequestMapping(value="/save.spr", method=RequestMethod.POST)
	public String save(@Valid @ModelAttribute("user") User user,
		BindingResult result, Model model
		, MultipartFile portraitFile
		) {
		if (result.hasErrors()) {
			StringBuilder sb = new StringBuilder();
			for(FieldError fe:result.getFieldErrors()){
				logger.debug("fe.getDefaultMessage(): {}",fe.getDefaultMessage());
				sb.append(fe.getDefaultMessage()).append("<br>");
			}
			logger.debug("result.toString(): {}",result.toString());
			logger.debug("error message: {}", sb.toString());
			
			ControllerProperty.setOprst(model, false, sb.toString());
			
			return ViewPath.USER_CREATE;
		}
		
		saveOrUpdate(user
		, portraitFile
			);
		
		ControllerProperty.setOprst(model, true, ControllerProperty.SAVE_SUCCESS_MSG);
		
		return String.format(ViewPath.USER_DETAIL_REDIRECT, user.getId());
	}

	/**
	 * ajax添加
	 * @param user
	 * @return
	 */
	@Login(ResultTypeEnum.json)
	@FireAuthority(authorityTypes = AuthorityType.增删改查用户, resultType = ResultTypeEnum.json)
	@RequestMapping(value="/save.spr", params="_ajax_submit_type=ajax", method=RequestMethod.POST)
	public @ResponseBody ResponseEntity<AjaxResult> ajaxSave(@Valid User user, BindingResult result
		, MultipartFile portraitFile
	) {
		
		AjaxResult ar = new AjaxResult();
		
			if (result.hasErrors()) {
			StringBuilder sb = new StringBuilder();
			for(FieldError fe:result.getFieldErrors()){
				logger.debug("fe.getDefaultMessage(): {}",fe.getDefaultMessage());
				sb.append(fe.getDefaultMessage()).append("\n");
			}
			logger.debug("result.toString(): {}",result.toString());
			logger.debug("error message: {}", sb.toString());
			
			ar.setResult(false);
			ar.setErrorMessage(sb.toString());
			return AjaxHelper.makeResult(ar);
		}
		
		
		try {
			saveOrUpdate(user
		, portraitFile
			);
		} catch (RuntimeException e) {
			logger.warn("保存失败", e);
			ar.fail("保存失败!");
			return AjaxHelper.makeResult(ar);
		}
		
		ar.setId(user.getId());
		ar.setResult(true);
		String tourl = String.format(ViewPath.USER_DETAIL_REDIRECT.substring(9), user.getId());
		logger.debug("tourl is {}",tourl);
		ar.setToURL(tourl);
		
		return AjaxHelper.makeResult(ar);
	}

	/**
	 * 修改
	 * @param user
	 * @param model
	 * @return
	 */
	@Login()
	@FireAuthority(authorityTypes = AuthorityType.增删改查用户)
	@RequestMapping(value="/modify.spr", method=RequestMethod.POST)
	public String modify(@Valid @ModelAttribute("user") User user,
		BindingResult result, Model model
		, MultipartFile portraitFile
		) {
		
		if (result.hasErrors()) {
			StringBuilder sb = new StringBuilder();
			for(FieldError fe:result.getFieldErrors()){
				logger.debug("fe.getDefaultMessage(): {}",fe.getDefaultMessage());
				sb.append(fe.getDefaultMessage()).append("<br>");
			}
			logger.debug("result.toString(): {}",result.toString());
			logger.debug("error message: {}", sb.toString());
			
			ControllerProperty.setOprst(model, false, sb.toString());
			
			return ViewPath.USER_MODIFY;
		}
		
		saveOrUpdate(user
		, portraitFile
			);
		
		ControllerProperty.setOprst(model, true, ControllerProperty.MODIFY_SUCCESS_MSG);
		return String.format(ViewPath.USER_DETAIL_REDIRECT, user.getId());
	}

	/**
	 * ajax修改
	 * @param user
	 * @return
	 */
	@Login(ResultTypeEnum.json)
	@FireAuthority(authorityTypes = AuthorityType.增删改查用户, resultType = ResultTypeEnum.json)
	@RequestMapping(value="/modify.spr", params = "_ajax_submit_type=ajax", method=RequestMethod.POST)
	public @ResponseBody ResponseEntity<AjaxResult> ajaxModify(@Valid User user, BindingResult result
		, MultipartFile portraitFile
	) {
		
		AjaxResult ar = new AjaxResult();
		
			if (result.hasErrors()) {
			StringBuilder sb = new StringBuilder();
			for(FieldError fe:result.getFieldErrors()){
				logger.debug("fe.getDefaultMessage(): {}",fe.getDefaultMessage());
				sb.append(fe.getDefaultMessage()).append("\n");
			}
			logger.debug("result.toString(): {}",result.toString());
			logger.debug("error message: {}", sb.toString());
			
			ar.setResult(false);
			ar.setErrorMessage(sb.toString());
			return AjaxHelper.makeResult(ar);
		}
		
		try {
			saveOrUpdate(user
		, portraitFile
			);
		} catch (RuntimeException e) {
			logger.warn("保存失败", e);
			ar.fail("保存失败!");
			return AjaxHelper.makeResult(ar);
		}
		
		ar.setId(user.getId());
		ar.setResult(true);
		String tourl = String.format(ViewPath.USER_DETAIL_REDIRECT.substring(9), user.getId());
		logger.debug("tourl is {}",tourl);
		ar.setToURL(tourl);
		
		return AjaxHelper.makeResult(ar);
	}

	/**
	 * 删除
	 * @param id
	 * @param model
	 * @return
	 */
	@Login()
	@FireAuthority(authorityTypes = AuthorityType.增删改查用户)
	@RequestMapping(value="/{id}/delete.spr", method=RequestMethod.GET)
	public String delete(@PathVariable("id") Integer id, Model model) {
		logger.debug("id is {}", id);
		//为了页面显示
		User user = userService.findByID(User.class, id);
		
		userService.deleteByID(User.class, id);
		
		model.addAttribute("user",user);
		
		ControllerProperty.setOprst(model, true, ControllerProperty.DELETE_SUCCESS_MSG);
		
		return ViewPath.OPRST_REDIRECT;
	}
	
	/**
	 * ajax删除
	 * @param id
	 * @return
	 */
	@Login(ResultTypeEnum.json)
	@FireAuthority(authorityTypes = AuthorityType.增删改查用户, resultType = ResultTypeEnum.json)
	@RequestMapping(value = "/{id}/delete.spr", params = "_ajax_submit_type=ajax", method = RequestMethod.GET)
	public @ResponseBody AjaxResult ajaxDelete(@PathVariable("id") Integer id) {
		logger.debug("id is {}", id);
		
		AjaxResult ar = new AjaxResult();
		
		try {
			userService.deleteByID(User.class, id);
			ar.setResult(true);
			return ar;
		} catch (RuntimeException e) {
			logger.warn("删除出错!",e);
			ar.setResult(false);
			ar.setErrorMessage("删除出错!");
			return ar;
		}
		
	}

	/**
	 * 转到修改页面
	 * 
	 * @param id
	 * @return
	 */
	@Login()
	@FireAuthority(authorityTypes = AuthorityType.增删改查用户)
	@RequestMapping(value="/{id}/tomodify.spr", method=RequestMethod.GET)
	public String tomodify(@PathVariable("id") Integer id, Model model) throws Exception {
		logger.debug("id is {}", id);
		User user = userService.findByID(User.class, id);
		
		if(null == user){
			ControllerProperty.setOprst(model, false, ControllerProperty.FIND_FAILED_MSG);
			return ViewPath.OPRST;
		}
		
		model.addAttribute("user",user);
		return ViewPath.USER_MODIFY;
	}
	
	/**
	 * 根据id号找到对象
	 * @param id
	 * @param model
	 * @return
	 */
	@Login()
	@FireAuthority(authorityTypes = AuthorityType.增删改查用户)
	@RequestMapping(value="/{id}/find.spr", method=RequestMethod.GET)
	public String find(@PathVariable("id") Integer id, Model model) throws Exception {
		logger.debug("id is {}", id);
		User user = userService.findByID(User.class, id);
		
		if(null == user){
			ControllerProperty.setOprst(model, false, ControllerProperty.FIND_FAILED_MSG);
			return ViewPath.OPRST;
		}
		
		model.addAttribute("user",user);
		return ViewPath.USER_DETAIL;
	}

	/**
	 * 搜索
	 * @param user
	 * @param startDate
	 * @param endDate
	 * @param start
	 * @param pageSize
	 * @param model
	 * @return
	 */
	@Login()
	@FireAuthority(authorityTypes = AuthorityType.增删改查用户)
	@RequestMapping(value="/search.spr", method={RequestMethod.POST,RequestMethod.GET})
	public String search(
			@ModelAttribute("user") User user, 
			@ModelAttribute("startDate") String startDate, 
			@ModelAttribute("endDate") String endDate, 
			@RequestParam(value="start",required=false,defaultValue="0") int start, 
			@RequestParam(value="pageSize",required=false,defaultValue="10") int pageSize,
			Model model){
		Map<String, Object> keys = new HashMap<String, Object>();
		
		Date t_startDate = DateHelper.getDate(startDate);
		if(t_startDate !=null){
			keys.put("createTime >= ", t_startDate);
		}
		
		Date t_endDate = DateHelper.getDate(endDate);
		if(t_endDate !=null){
			keys.put("createTime <= ", t_endDate);
		}
		
		if(user != null){
			SearchKeyHelper.setIntegerKey(keys, "id", user.getId());
		}
		
		Map<String, String> orderKeys = new LinkedHashMap<String, String>();
		orderKeys.put("createTime", IBaseDao.DESC);
		
		List<User> users = userService.findByMultiKeys(User.class, keys, orderKeys, start, pageSize);
		
		int total = userService.countByMultiKeys(User.class, keys);
		
		model.addAttribute("users",users);
		model.addAttribute("total", total);
		model.addAttribute("start", start);
		model.addAttribute("pageSize", pageSize);
		return ViewPath.USER_SEARCH;
	}
	
	
}
