package fire.crud.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;


import org.springframework.http.ResponseEntity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.FieldError;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
import fire.crud.entity.Article;
import fire.crud.service.IArticleService;

import fire.crud.listener.TomcatContextConstants;
//import fire.authority.annotation.Login;
//import fire.authority.annotation.ResultTypeEnum;
//import fire.util.DateHelper;
//import fire.util.FireDateConvertor;
@Controller("articleController")
@RequestMapping(value="/article")
public class ArticleController {

		
	final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private IArticleService articleService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new FireDateConvertor());
	}
	
	private void saveOrUpdate(Article article
		) {
		
		Date nowTime = new Date();
		article.setModifyTime(nowTime);
		
		if(article.getId()==null){//属于创建
			article.setCreateTime(nowTime);
			articleService.save(article);
		}else{
			articleService.update(article);
		}
	
		
	}

	/**
	 * 添加
	 * @param article
	 * @param model
	 * @return
	 */
	@Login()
	@FireAuthority(authorityTypes = AuthorityType.增删改查文章)
	@RequestMapping(value="/save.spr", method=RequestMethod.POST)
	public String save(@Valid @ModelAttribute("article") Article article,
		BindingResult result, Model model
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
			
			return ViewPath.ARTICLE_CREATE;
		}
		
		saveOrUpdate(article
			);
		
		ControllerProperty.setOprst(model, true, ControllerProperty.SAVE_SUCCESS_MSG);
		
		return String.format(ViewPath.ARTICLE_DETAIL_REDIRECT, article.getId());
	}

	/**
	 * ajax添加
	 * @param article
	 * @return
	 */
	@Login(ResultTypeEnum.json)
	@FireAuthority(authorityTypes = AuthorityType.增删改查文章, resultType = ResultTypeEnum.json)
	@RequestMapping(value="/save.spr", params="_ajax_submit_type=ajax", method=RequestMethod.POST)
	public @ResponseBody ResponseEntity<AjaxResult> ajaxSave(@Valid Article article, BindingResult result
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
			saveOrUpdate(article
			);
		} catch (RuntimeException e) {
			logger.warn("保存失败", e);
			ar.fail("保存失败!");
			return AjaxHelper.makeResult(ar);
		}
		
		ar.setId(article.getId());
		ar.setResult(true);
		String tourl = String.format(ViewPath.ARTICLE_DETAIL_REDIRECT.substring(9), article.getId());
		logger.debug("tourl is {}",tourl);
		ar.setToURL(tourl);
		
		return AjaxHelper.makeResult(ar);
	}

	/**
	 * 修改
	 * @param article
	 * @param model
	 * @return
	 */
	@Login()
	@FireAuthority(authorityTypes = AuthorityType.增删改查文章)
	@RequestMapping(value="/modify.spr", method=RequestMethod.POST)
	public String modify(@Valid @ModelAttribute("article") Article article,
		BindingResult result, Model model
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
			
			return ViewPath.ARTICLE_MODIFY;
		}
		
		saveOrUpdate(article
			);
		
		ControllerProperty.setOprst(model, true, ControllerProperty.MODIFY_SUCCESS_MSG);
		return String.format(ViewPath.ARTICLE_DETAIL_REDIRECT, article.getId());
	}

	/**
	 * ajax修改
	 * @param article
	 * @return
	 */
	@Login(ResultTypeEnum.json)
	@FireAuthority(authorityTypes = AuthorityType.增删改查文章, resultType = ResultTypeEnum.json)
	@RequestMapping(value="/modify.spr", params = "_ajax_submit_type=ajax", method=RequestMethod.POST)
	public @ResponseBody ResponseEntity<AjaxResult> ajaxModify(@Valid Article article, BindingResult result
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
			saveOrUpdate(article
			);
		} catch (RuntimeException e) {
			logger.warn("保存失败", e);
			ar.fail("保存失败!");
			return AjaxHelper.makeResult(ar);
		}
		
		ar.setId(article.getId());
		ar.setResult(true);
		String tourl = String.format(ViewPath.ARTICLE_DETAIL_REDIRECT.substring(9), article.getId());
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
	@FireAuthority(authorityTypes = AuthorityType.增删改查文章)
	@RequestMapping(value="/{id}/delete.spr", method=RequestMethod.GET)
	public String delete(@PathVariable("id") Integer id, Model model) {
		logger.debug("id is {}", id);
		//为了页面显示
		Article article = articleService.findByID(Article.class, id);
		
		articleService.deleteByID(Article.class, id);
		
		model.addAttribute("article",article);
		
		ControllerProperty.setOprst(model, true, ControllerProperty.DELETE_SUCCESS_MSG);
		
		return ViewPath.OPRST_REDIRECT;
	}
	
	/**
	 * ajax删除
	 * @param id
	 * @return
	 */
	@Login(ResultTypeEnum.json)
	@FireAuthority(authorityTypes = AuthorityType.增删改查文章, resultType = ResultTypeEnum.json)
	@RequestMapping(value = "/{id}/delete.spr", params = "_ajax_submit_type=ajax", method = RequestMethod.GET)
	public @ResponseBody AjaxResult ajaxDelete(@PathVariable("id") Integer id) {
		logger.debug("id is {}", id);
		
		AjaxResult ar = new AjaxResult();
		
		try {
			articleService.deleteByID(Article.class, id);
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
	@FireAuthority(authorityTypes = AuthorityType.增删改查文章)
	@RequestMapping(value="/{id}/tomodify.spr", method=RequestMethod.GET)
	public String tomodify(@PathVariable("id") Integer id, Model model) throws Exception {
		logger.debug("id is {}", id);
		Article article = articleService.findByID(Article.class, id);
		
		if(null == article){
			ControllerProperty.setOprst(model, false, ControllerProperty.FIND_FAILED_MSG);
			return ViewPath.OPRST;
		}
		
		model.addAttribute("article",article);
		return ViewPath.ARTICLE_MODIFY;
	}
	
	/**
	 * 根据id号找到对象
	 * @param id
	 * @param model
	 * @return
	 */
	@Login()
	@FireAuthority(authorityTypes = AuthorityType.增删改查文章)
	@RequestMapping(value="/{id}/find.spr", method=RequestMethod.GET)
	public String find(@PathVariable("id") Integer id, Model model) throws Exception {
		logger.debug("id is {}", id);
		Article article = articleService.findByID(Article.class, id);
		
		if(null == article){
			ControllerProperty.setOprst(model, false, ControllerProperty.FIND_FAILED_MSG);
			return ViewPath.OPRST;
		}
		
		model.addAttribute("article",article);
		return ViewPath.ARTICLE_DETAIL;
	}
	
	/**
	 * 根据id号找到对象
	 * @param id
	 * @param model
	 * @return
	 */


	@RequestMapping(value="/{id}/findInGaofen.spr", method=RequestMethod.GET)
	public String findInGaofen(@PathVariable("id") Integer id, Model model) throws Exception {
		logger.debug("id is {}", id);
		Article article = articleService.findByID(Article.class, id);
		
		if(null == article){
			ControllerProperty.setOprst(model, false, ControllerProperty.FIND_FAILED_MSG);
			return ViewPath.OPRST;
		}
		
		model.addAttribute("article",article);
		return ViewPath.ARTICLE_DETAIL_IN_GAOFEN;
	}

	/**
	 * 搜索
	 * @param article
	 * @param startDate
	 * @param endDate
	 * @param start
	 * @param pageSize
	 * @param model
	 * @return
	 */
	@Login()
	@FireAuthority(authorityTypes = AuthorityType.增删改查文章)
	@RequestMapping(value="/search.spr", method={RequestMethod.POST,RequestMethod.GET})
	public String search(
			@ModelAttribute("article") Article article, 
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
		
		if(article != null){
			SearchKeyHelper.setIntegerKey(keys, "id", article.getId());
		}
		
		Map<String, String> orderKeys = new LinkedHashMap<String, String>();
		orderKeys.put("createTime", IBaseDao.DESC);
		
		List<Article> articles = articleService.findByMultiKeys(Article.class, keys, orderKeys, start, pageSize);
		
		int total = articleService.countByMultiKeys(Article.class, keys);
		
		model.addAttribute("articles",articles);
		model.addAttribute("total", total);
		model.addAttribute("start", start);
		model.addAttribute("pageSize", pageSize);
		return ViewPath.ARTICLE_SEARCH;
	}
	
	
	
	/**
	 * 搜索
	 * @param article
	 * @param startDate
	 * @param endDate
	 * @param start
	 * @param pageSize
	 * @param model
	 * @return
	 */


	@RequestMapping(value="/searchInGaofen.spr", method={RequestMethod.POST,RequestMethod.GET})
	public String searchInGaofen(
			@ModelAttribute("article") Article article, 
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
		
		if(article != null){
			SearchKeyHelper.setIntegerKey(keys, "id", article.getId());
		}
		
		Map<String, String> orderKeys = new LinkedHashMap<String, String>();
		orderKeys.put("createTime", IBaseDao.DESC);
		
		List<Article> articles = articleService.findByMultiKeys(Article.class, keys, orderKeys, start, pageSize);
		
		int total = articleService.countByMultiKeys(Article.class, keys);
		
		model.addAttribute("articles",articles);
		model.addAttribute("total", total);
		model.addAttribute("start", start);
		model.addAttribute("pageSize", pageSize);
		return ViewPath.ARTICLE_SEARCH_IN_GAOFEN;
	}
	
}
