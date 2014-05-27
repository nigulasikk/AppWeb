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
 * 文章
 * 
 */
@Entity
@Table(name="om_article")
public class Article implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * 标题
	 * 
	 */
		@Pattern(regexp = "^[\\S\u4E00-\u9FA5]+$", message="{tip.article.title}")
		@Column(name = "title" )
		private String title;
	/**
	 * 摘要
	 * 
	 */
		@Column(name = "detail" ,columnDefinition="TEXT")
		private String detail;
	/**
	 * 内容
	 * 
	 */
		@Column(name = "content" ,columnDefinition="TEXT")
		private String content;
	/**
	 * 发布人
	 * 
	 */
		@Column(name = "publisher" ,columnDefinition="TEXT")
		private String publisher;
	/**
	 * 发布时间
	 * 
	 */
		@Column(name = "publish_date" )
		private Date publishDate;

	/**
	 * 修改时间
	 * 
	 */
		@Column(name = "modify_time" )
		private Date modifyTime;
		
		/**
	 * 创建时间
	 * 
	 */
		@Column(name = "create_time" , updatable=false)
		private Date createTime;
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 8538631258084019523L;

	//
	public Article() {
		super();
	}

/**
 * 
 * @param title 标题
 * @param detail 摘要
 * @param content 内容
 * @param publisher 发布人
 * @param publishDate 发布时间
		* @param modifyTime
	 *         修改时间
	 * @param createTime
	 *         创建时间
 */
	public Article(
			String title
		,
			String detail
		,
			String content
		,
			String publisher
		,
			Date publishDate
		,
			Date modifyTime,
			Date  createTime) {
			super();
			this.title = title;
			this.detail = detail;
			this.content = content;
			this.publisher = publisher;
			this.publishDate = publishDate;
			this.modifyTime = modifyTime;
			this.createTime = createTime;
	}

/**
 * 
 * @param title 标题
 * @param detail 摘要
 * @param content 内容
 * @param publisher 发布人
 * @param publishDate 发布时间
 */
	public Article(
			String title
		,
				String detail
		,
				String content
		,
				String publisher
		,
				Date publishDate
		
	 ) {
			super();
			this.title = title;
			this.detail = detail;
			this.content = content;
			this.publisher = publisher;
			this.publishDate = publishDate;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

			/**
	 * 标题
	 * 
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 标题
	 * 
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
			/**
	 * 摘要
	 * 
	 */
	public String getDetail() {
		return detail;
	}

	/**
	 * 摘要
	 * 
	 */
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
			/**
	 * 内容
	 * 
	 */
	public String getContent() {
		return content;
	}

	/**
	 * 内容
	 * 
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
			/**
	 * 发布人
	 * 
	 */
	public String getPublisher() {
		return publisher;
	}

	/**
	 * 发布人
	 * 
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
			/**
	 * 发布时间
	 * 
	 */
	public Date getPublishDate() {
		return publishDate;
	}

	/**
	 * 发布时间
	 * 
	 */
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
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