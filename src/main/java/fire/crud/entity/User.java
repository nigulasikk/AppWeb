package fire.crud.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

/**
 * 用户
 * 
 */
@Entity
@Table(name = "om_user")
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * 登录名
	 * 
	 */
	@Pattern(regexp = "^[\\w\u4E00-\u9FA5]+$", message = "{tip.user.loginName}")
	@Column(name = "login_name", nullable = false, updatable = false, unique = true)
	private String loginName;
	/**
	 * 密码
	 * 
	 */
	@Pattern(regexp = "^.{6,}$", message = "{tip.user.pswd}")
	@Column(name = "pswd", nullable = false, updatable = false)
	private String pswd;
	/**
	 * 头像
	 * 
	 */
	@Column(name = "portrait")
	private String portrait;
	/**
	 * 姓名
	 * 
	 */
	@Pattern(regexp = "^[\\w\u4E00-\u9FA5]*$", message = "{tip.user.name}")
	@Column(name = "name")
	private String name;
	/**
	 * 手机
	 * 
	 */
	@Pattern(regexp = "(?:^(0|86|17951)?(13\\d|15[012356789]|18[0236789]|14[57])\\d{8}$)|(?:^$)", message = "{tip.user.mobile}")
	@Column(name = "mobile")
	private String mobile;
	/**
	 * QQ
	 * 
	 */
	@Pattern(regexp = "^\\d*$", message = "{tip.user.qq}")
	@Column(name = "qq")
	private String qq;
	/**
	 * Email
	 * 
	 */
	@Pattern(regexp = "(?:^[\\w\\-\\.\u4E00-\u9FA5]+@\\w+\\.\\w+$)|(?:^$)", message = "{tip.user.email}")
	@Column(name = "email")
	private String email;
	/**
	 * 登陆次数
	 * 
	 */
	@Column(name = "login_count", columnDefinition = "integer default 0", nullable = false, updatable = false, insertable = false)
	private Integer loginCount;
	/**
	 * 最近登陆时间
	 * 
	 */
	@Column(name = "last_login_time", updatable = false)
	private Date lastLoginTime;
	/**
	 * 最近登陆IP
	 * 
	 */
	@Column(name = "last_login_ip", updatable = false)
	private String lastLoginIp;
	/**
	 * 备注
	 * 
	 */
	@Column(name = "memo", columnDefinition="LONGTEXT")
	private String memo;
	/**
	 * 是否启用
	 * 
	 */
	@Column(name = "enable")
	@Enumerated(EnumType.STRING)
	private EnableEnum enable;

	public static enum EnableEnum {
		启用, 停用
	}

	/**
	 * 权限
	 * 
	 */
	@Column(name = "right_content", length = 1024)
	private String rightContent;

	/**
	 * 修改时间
	 * 
	 */
	@Column(name = "modify_time")
	private Date modifyTime;

	/**
	 * 创建时间
	 * 
	 */
	@Column(name = "create_time", updatable = false)
	private Date createTime;

	/**
	 * 
	 */
	private static final long serialVersionUID = 8538631258084019523L;

	//
	public User() {
		super();
	}

	/**
	 * 
	 * @param loginName
	 *         登录名
	 * @param pswd
	 *         密码
	 * @param portrait
	 *         头像
	 * @param name
	 *         姓名
	 * @param mobile
	 *         手机
	 * @param qq
	 *         QQ
	 * @param email
	 *         Email
	 * @param loginCount
	 *         登陆次数
	 * @param lastLoginTime
	 *         最近登陆时间
	 * @param lastLoginIp
	 *         最近登陆IP
	 * @param memo
	 *         备注
	 * @param enable
	 *         是否启用
	 * @param rightContent
	 *         权限
	 * @param modifyTime
	 *         修改时间
	 * @param createTime
	 *         创建时间
	 */
	public User(String loginName, String pswd, String portrait, String name, String mobile, String qq, String email, Integer loginCount, Date lastLoginTime,
			String lastLoginIp, String memo, EnableEnum enable, String rightContent, Date modifyTime, Date createTime) {
		super();
		this.loginName = loginName;
		this.pswd = pswd;
		this.portrait = portrait;
		this.name = name;
		this.mobile = mobile;
		this.qq = qq;
		this.email = email;
		this.loginCount = loginCount;
		this.lastLoginTime = lastLoginTime;
		this.lastLoginIp = lastLoginIp;
		this.memo = memo;
		this.enable = enable;
		this.rightContent = rightContent;
		this.modifyTime = modifyTime;
		this.createTime = createTime;
	}

	/**
	 * 
	 * @param loginName
	 *         登录名
	 * @param pswd
	 *         密码
	 * @param portrait
	 *         头像
	 * @param name
	 *         姓名
	 * @param mobile
	 *         手机
	 * @param qq
	 *         QQ
	 * @param email
	 *         Email
	 * @param loginCount
	 *         登陆次数
	 * @param lastLoginTime
	 *         最近登陆时间
	 * @param lastLoginIp
	 *         最近登陆IP
	 * @param memo
	 *         备注
	 * @param enable
	 *         是否启用
	 * @param rightContent
	 *         权限
	 */
	public User(String loginName, String pswd, String portrait, String name, String mobile, String qq, String email, Integer loginCount, Date lastLoginTime,
			String lastLoginIp, String memo, EnableEnum enable, String rightContent) {
		super();
		this.loginName = loginName;
		this.pswd = pswd;
		this.portrait = portrait;
		this.name = name;
		this.mobile = mobile;
		this.qq = qq;
		this.email = email;
		this.loginCount = loginCount;
		this.lastLoginTime = lastLoginTime;
		this.lastLoginIp = lastLoginIp;
		this.memo = memo;
		this.enable = enable;
		this.rightContent = rightContent;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 登录名
	 * 
	 */
	public String getLoginName() {
		return loginName;
	}

	/**
	 * 登录名
	 * 
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	/**
	 * 密码
	 * 
	 */
	public String getPswd() {
		return pswd;
	}

	/**
	 * 密码
	 * 
	 */
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	/**
	 * 头像
	 * 
	 */
	public String getPortrait() {
		return portrait;
	}

	/**
	 * 头像
	 * 
	 */
	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}

	/**
	 * 姓名
	 * 
	 */
	public String getName() {
		return name;
	}

	/**
	 * 姓名
	 * 
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 手机
	 * 
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * 手机
	 * 
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * QQ
	 * 
	 */
	public String getQq() {
		return qq;
	}

	/**
	 * QQ
	 * 
	 */
	public void setQq(String qq) {
		this.qq = qq;
	}

	/**
	 * Email
	 * 
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Email
	 * 
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 登陆次数
	 * 
	 */
	public Integer getLoginCount() {
		return loginCount;
	}

	/**
	 * 登陆次数
	 * 
	 */
	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}

	/**
	 * 最近登陆时间
	 * 
	 */
	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	/**
	 * 最近登陆时间
	 * 
	 */
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	/**
	 * 最近登陆IP
	 * 
	 */
	public String getLastLoginIp() {
		return lastLoginIp;
	}

	/**
	 * 最近登陆IP
	 * 
	 */
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	/**
	 * 备注
	 * 
	 */
	public String getMemo() {
		return memo;
	}

	/**
	 * 备注
	 * 
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}

	/**
	 * 是否启用
	 * 
	 */
	public EnableEnum getEnable() {
		return enable;
	}

	/**
	 * 是否启用
	 * 
	 */
	public void setEnable(EnableEnum enable) {
		this.enable = enable;
	}

	/**
	 * 权限
	 * 
	 */
	public String getRightContent() {
		return rightContent;
	}

	/**
	 * 权限
	 * 
	 */
	public void setRightContent(String rightContent) {
		this.rightContent = rightContent;
	}

	/**
	 * 修改时间
	 * 
	 */
	public Date getModifyTime() {
		return modifyTime;
	}

	/**
	 * 修改时间
	 * 
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	/**
	 * 创建时间
	 * 
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 创建时间
	 * 
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}