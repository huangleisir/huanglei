package com.bao.news.utils;

import java.util.List;

public class SharedNaviPage {
	
	private int size = NewsUtil.NEWS_NEWS_LEFT_PAGESIZE;//每页显示的新闻条数
	private int index = 1;//当前页号
	private int totalPageCount = 1 ;//总页数
	private int totalCount = 0; //总记录数
	private int[] numbers ;//展示页数的集合
	protected List<Object> list;  //要显示到页面的数据集合
	/**
	 * 
	 * 这种分页方式是这样，将记录从零开始重新编号，然后第一个参数为首条记录的编号，第二个
	 * 参数为将记录从1开始编号的该页面最好一条记录的编号
	 * 
	 * @return
	 */
	public int getStartRow(){
		return (index-1)*size;//It seems a little difficult to understand here
	}
	/**
	 * 获取将记录从1开始编号的该页面最好一条记录的编号
	 * @return
	 */
	public int getEndRow(){
		return index*size;
	}
	
	public int getSize(){
		return size;
	}
	
	public void setSize(){
		size = this.size;
	}
	public int getTotalPageCount() {
		return totalPageCount;
	}
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		setTotalCountPageByRs();//
	}
	
	public void setTotalCountPageByRs(){
			
			if(this.totalCount>0&&this.totalCount%this.size==0){  // 很有可能某个分类下面记录数为零
				this.totalPageCount = this.totalCount/this.size;
			}else if(this.totalCount>0 && this.totalCount % this.size>0){
				this.totalPageCount = this.totalCount/this.size+1;
			}else{
				this.totalPageCount = 0;
			}
			
			setNumbers(totalPageCount) ;	
			
	}
	public int[] getNumbers() {
		return numbers;
	}
	public void setNumbers(int totalPageCount) {
		if(totalPageCount>0){
			int[] numbers = new int[this.totalPageCount>10?10:this.totalPageCount];
			int k=0;
			for(int i=0;i<this.totalPageCount;i++){
				//保证当前页为集合的中间
				if(i>=index-(numbers.length/2+1 )|| i>=this.totalPageCount-numbers.length){
					numbers[k]=i+1;
					k++;
					
					
					
					
				}else if(k>=numbers.length){
					break;
				}
				
			}
			
			this.numbers=numbers;
		}
			
	}
	public List<Object> getList() {
		return list;
	}
	public void setList(List<Object> list) {
		this.list = list;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}		
			
	
	
	
	

}
