package fire.crud.controller.util;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;


public class ControllerProperty {
	
	/**
	 * 操作结果提示信息字段名称
	 */
	final public static String OPMSG = "opmsg";

	/**
	 * 操作结果信息字段名称
	 * 操作结果指是否成功
	 */
	final public static String OPRST = "oprst";
	
	public static void setOprst(Model model, boolean oprst, String opmsg){
		model.addAttribute(OPRST, oprst);
		model.addAttribute(OPMSG, opmsg);
	}

	/**
	 * 创建一个结果页面
	 * @param mav
	 * @param oprst
	 * @param opmsg
	 * @return
	 */
	public static ModelAndView makeOprst(ModelAndView mav, boolean oprst, String opmsg){
		mav.addObject(OPRST, oprst);
		mav.addObject(OPMSG, opmsg);
		mav.setViewName(ViewPath.OPRST);
		return mav;
	}
	
	/**
	 * 创建一个结果页面
	 * @param oprst
	 * @param opmsg
	 * @return
	 */
	public static ModelAndView createMavOprst(boolean oprst, String opmsg){
		ModelAndView mav = new ModelAndView();
		mav.addObject(OPRST, oprst);
		mav.addObject(OPMSG, opmsg);
		mav.setViewName(ViewPath.OPRST);
		return mav;
	}
	
	/**
	 * 删除成功提示
	 */
	final public static String DELETE_SUCCESS_MSG="删除成功!";
	
	/**
	 * 删除禁止
	 */
	final public static String DELETE_PROHIBIT_MSG_EMPTY="删除失败!没有该项目!";
	
	/**
	 * 删除禁止
	 */
	final public static String DELETE_PROHIBIT_MSG_OWN="删除失败!不能删除别人的项目!";
	
	/**
	 * 删除禁止
	 */
	final public static String DELETE_PROHIBIT_MSG_STATE="删除失败!该项目前的状态不允许删除!";
	
	/**
	 * 保存成功提示
	 */
	final public static String SAVE_SUCCESS_MSG="保存成功!";
	
	/**
	 * 修改成功提示
	 */
	final public static String MODIFY_SUCCESS_MSG="修改成功!";
	
	/**
	 * 禁止修改
	 */
	final public static String MODIFY_PROHIBIT_MSG="该项禁止修改!";
	
	/**
	 * 禁止修改
	 */
	final public static String MODIFY_PROHIBIT_MSG_OWN="该项目禁止修改!不能修改别人的项目!";
	
	/**
	 * 禁止修改
	 */
	final public static String MODIFY_PROHIBIT_MSG_STATE="该项目禁止修改!该项目前的状态不允许修改!";
	
	/**
	 * 查询单条数据失败
	 */
	final public static String FIND_FAILED_MSG="没有该项数据! 可能已经被删除";
	
	/**
	 * 禁止查看
	 */
	final public static String FIND_FAILED_MSG_OWN="该项目禁止查看!不能查看别人的项目!";
	
	/**
	 * 没有该权限
	 */
	final public static String NOT_HAVE_AUTHORITY="没有该功能的权限";
	
	/**
	 * 请输入要求的信息!
	 */
	final public static String NOT_INPUT="请输入要求的信息!";
	
}
