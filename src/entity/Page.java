package entity;

import java.util.List;

public class Page {
	private int indexpage;
	private int sizepage;
	private int datacount;
	private int totalpage;
	private List list;
	public int getIndexpage() {
		return indexpage;
	}
	public void setIndexpage(int indexpage) {
		if(indexpage<1)
		{
			this.indexpage=1;
		}else if(indexpage>this.totalpage)
		{
		    this.indexpage=this.totalpage==0?1:this.totalpage;	
		}else{
		this.indexpage = indexpage;
		}
	}
	public int getSizepage() {
		return sizepage;
	}
	public void setSizepage(int sizepage) {
		this.sizepage = sizepage;
	}
	public int getDatacount() {
		return datacount;
	}
	public void setDatacount(int datacount) {
		this.datacount = datacount;
		this.totalpage=datacount%sizepage==0?(datacount/sizepage):(datacount/sizepage+1);
	}
	public int getTotalpage() {
		return totalpage;
	}
	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
}
