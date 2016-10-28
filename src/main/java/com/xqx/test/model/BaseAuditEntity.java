//package com.xqx.test.model;
//
//import org.apache.ibatis.type.JdbcType;
//import org.apache.ibatis.type.MappedJdbcTypes;
//
//import java.io.Serializable;
//import java.util.Date;
//
//import static javax.swing.text.StyleConstants.Size;
//
//
///**
// *
// * @author yyhua
// *
// * @since 2015-07-15
// *
// * @Description 用审计实体的父类
// */
//public class BaseAuditEntity extends BaseEntity implements Serializable {
//
//	/**
//	 *
//	 */
//	private static final long serialVersionUID = 1L;
//
//	/**
//	 * 区县代码
//	 */
//	@Size(max = 100)
//	private String QXDM;
//
//	/**
//	 * 区县名称
//	 */
//	@Size(max = 200)
//	private String QXMC;
//
//	/**
//	 * 登记机构
//	 */
//	@Size(max = 500)
//	private String DJJG;
//
//	/**
//	 * 创建人Id
//	 */
//	private Long creatorId;
//
//	/**
//	 * 创建时间
//	 */
//	private Date createTime;
//
//	/**
//	 * 创建人登录名
//	 */
//	@Size(max = 100)
//	private String creatorLoginName;
//
//	/**
//	 * 创建人姓名
//	 */
//	@Size(max = 100)
//	private String creatorName;
//
//	/**
//	 * 创建ip
//	 */
//	@Size(max = 100)
//	private String creatorIp;
//
//	/**
//	 * 更新人id
//	 */
//	private Long lastUpdaterId;
//
//	/**
//	 * 更新时间
//	 */
//	private Date lastUpdateTime;
//
//	/**
//	 * 更新人登录名
//	 */
//	@Size(max = 100)
//	private String lastUpdaterLoginName;
//
//	/**
//	 * 更新人姓名
//	 */
//	@Size(max = 100)
//	private String lastUpdaterName;
//
//	/**
//	 * 更新ip
//	 */
//	@Size(max = 100)
//	private String lastUpdaterIp;
//
//
//	public String getQXDM() {
//		return QXDM;
//	}
//
//	public void setQXDM(String QXDM) {
//		this.QXDM = QXDM;
//	}
//
//	public String getQXMC() {
//		return QXMC;
//	}
//
//	public void setQXMC(String QXMC) {
//		this.QXMC = QXMC;
//	}
//
//	public String getDJJG() {
//		return DJJG;
//	}
//
//	public void setDJJG(String DJJG) {
//		this.DJJG = DJJG;
//	}
//
//	public Long getCreatorId() {
//		return creatorId;
//	}
//
//	public void setCreatorId(Long creatorId) {
//		this.creatorId = creatorId;
//	}
//
//	public Date getCreateTime() {
//		return createTime;
//	}
//
//	public void setCreateTime(Date createTime) {
//		this.createTime = createTime;
//	}
//
//	public String getCreatorLoginName() {
//		return creatorLoginName;
//	}
//
//	public void setCreatorLoginName(String creatorLoginName) {
//		this.creatorLoginName = creatorLoginName;
//	}
//
//	public String getCreatorName() {
//		return creatorName;
//	}
//
//	public void setCreatorName(String creatorName) {
//		this.creatorName = creatorName;
//	}
//
//	public String getCreatorIp() {
//		return creatorIp;
//	}
//
//	public void setCreatorIp(String creatorIp) {
//		this.creatorIp = creatorIp;
//	}
//
//	public Long getLastUpdaterId() {
//		return lastUpdaterId;
//	}
//
//	public void setLastUpdaterId(Long lastUpdaterId) {
//		this.lastUpdaterId = lastUpdaterId;
//	}
//
//	public Date getLastUpdateTime() {
//		return lastUpdateTime;
//	}
//
//	public void setLastUpdateTime(Date lastUpdateTime) {
//		this.lastUpdateTime = lastUpdateTime;
//	}
//
//	public String getLastUpdaterLoginName() {
//		return lastUpdaterLoginName;
//	}
//
//	public void setLastUpdaterLoginName(String lastUpdaterLoginName) {
//		this.lastUpdaterLoginName = lastUpdaterLoginName;
//	}
//
//	public String getLastUpdaterName() {
//		return lastUpdaterName;
//	}
//
//	public void setLastUpdaterName(String lastUpdaterName) {
//		this.lastUpdaterName = lastUpdaterName;
//	}
//
//	public String getLastUpdaterIp() {
//		return lastUpdaterIp;
//	}
//
//	public void setLastUpdaterIp(String lastUpdaterIp) {
//		this.lastUpdaterIp = lastUpdaterIp;
//	}
//}
