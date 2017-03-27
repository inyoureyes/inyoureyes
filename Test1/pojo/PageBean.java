package pojo;

import java.util.List;

/**
 * 分页信息
 * @author Administrator
 *
 */
public class PageBean<T> {
    private int currenPage = 1;   //当前页
    private int pageCount = 5;    //每页显示的行数
    private int totalCount;   //总信息数
    private int totalPage;    //总页数
    private List<T> dataList;
	public int getCurrenPage() {
		return currenPage;
	}
	public void setCurrenPage(int currenPage) {
		this.currenPage = currenPage;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		if(totalCount % pageCount ==0){
			totalPage = totalCount/pageCount;
		}else{
		   totalPage = totalCount/pageCount+1;
		}
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getDataList() {
		return dataList;
	}
	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}
	@Override
	public String toString() {
		return "PageBean [currenPage=" + currenPage + ", pageCount="
				+ pageCount + ", totalCount=" + totalCount + ", totalPage="
				+ totalPage + ", dataList=" + dataList + "]";
	}
    
}
