package com.believexin.wage.common.model;

/**
 * <p>Title: PageInfo</p>
 * <p>Description: 分页信息</p>
 * <p>Company: thunisoft </p> 
 * @author zhangxin
 * @date 2018年4月8日 下午2:46:59
 */
public class PageInfo {
	private Integer pageStart;
	private Integer pageCount;
	private Integer dataCount;
	private Integer thisPage;
	public Integer getPageStart() {
		return pageStart;
	}
	public void setPageStart(Integer pageStart) {
		this.pageStart = pageStart;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public Integer getDataCount() {
		return dataCount;
	}
	public void setDataCount(Integer dataCount) {
		this.dataCount = dataCount;
	}
	public Integer getThisPage() {
		return thisPage;
	}
	public void setThisPage(Integer thisPage) {
		this.thisPage = thisPage;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PageInfo [pageStart=");
		builder.append(pageStart);
		builder.append(", pageCount=");
		builder.append(pageCount);
		builder.append(", dataCount=");
		builder.append(dataCount);
		builder.append(", thisPage=");
		builder.append(thisPage);
		builder.append("]");
		return builder.toString();
	}
	
}
