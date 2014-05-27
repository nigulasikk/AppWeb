package fire.crud.controller.util;

public class AjaxResult {

	/**
	 * 操作是否成功
	 */
	private boolean result;
	
	/**
	 * id号,在数据添加成功的时候用到
	 */
	private Integer id;
	
	/**
	 * 错误信息
	 */
	private String errorMessage;
	
	/**
	 * 操作成功后,要访问的url,比如数据详情页面
	 */
	private String toURL;

	/**
	 * 实体类数据,主要为了显示信息
	 */
	private Object entityData;
	
	/**
	 * 写入成功信息,并且标记成功
	 * @param toURL
	 */
	public void success(String toURL) {
		this.result = true;
		this.toURL = toURL;
	}

	/**
	 * 写入错误信息,并且标记错误
	 * @param errorMessage
	 */
	public void fail(String errorMessage) {
		this.result = false;
		this.errorMessage = errorMessage;
	}

	final public static String ERROR_MESSAGE_ITEM_NOT_FOUND="没有该项";
	
	//==============
	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public String getToURL() {
		return toURL;
	}

	public void setToURL(String toURL) {
		this.toURL = toURL;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Object getEntityData() {
		return entityData;
	}

	public void setEntityData(Object entityData) {
		this.entityData = entityData;
	}
	
}
