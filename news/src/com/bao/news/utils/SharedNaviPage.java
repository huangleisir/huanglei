package com.bao.news.utils;

import java.util.List;

public class SharedNaviPage {
	
	private int size = NewsUtil.NEWS_NEWS_LEFT_PAGESIZE;//ÿҳ��ʾ����������
	private int index = 1;//��ǰҳ��
	private int totalPageCount = 1 ;//��ҳ��
	private int totalCount = 0; //�ܼ�¼��
	private int[] numbers ;//չʾҳ���ļ���
	protected List<Object> list;  //Ҫ��ʾ��ҳ������ݼ���
	/**
	 * 
	 * ���ַ�ҳ��ʽ������������¼���㿪ʼ���±�ţ�Ȼ���һ������Ϊ������¼�ı�ţ��ڶ���
	 * ����Ϊ����¼��1��ʼ��ŵĸ�ҳ�����һ����¼�ı��
	 * 
	 * @return
	 */
	public int getStartRow(){
		return (index-1)*size;//It seems a little difficult to understand here
	}
	/**
	 * ��ȡ����¼��1��ʼ��ŵĸ�ҳ�����һ����¼�ı��
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
			
			if(this.totalCount>0&&this.totalCount%this.size==0){  // ���п���ĳ�����������¼��Ϊ��
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
				//��֤��ǰҳΪ���ϵ��м�
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
