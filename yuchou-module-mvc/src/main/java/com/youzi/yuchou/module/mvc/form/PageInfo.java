package com.youzi.yuchou.module.mvc.form;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.youzi.yuchou.core.exception.ExceptionStaticEnum;
import com.youzi.yuchou.core.exception.ServiceException;
import com.youzi.yuchou.core.text.StringUtil;


public class PageInfo implements Serializable {
	private static final long serialVersionUID = 7832219375451289658L;
	public static final int DEFAULT_PAGE_SIZE = 20;
	public static final String CURRENT_PAGE_KEY="cpage";
	public static final String PAGE_SIZE_KEY="pagesize";
	
    // 当前页
    private int currentPage = 1;
    // 每页数量
    private int pageSize = DEFAULT_PAGE_SIZE;
    // 总记录数
    private int totalCount = 0;
    // 总页数
    private int totalPage = 0;
    
    //请求参数封装回给页面
	private Map<String, Object> paramsMap;
    
	
    public PageInfo() {
		super();
	}

    /**
     * 计算分页及入参
     * @param requestMap
     * @throws Exception
     */
	public PageInfo(Map<String, String[]> requestMap)throws Exception {
		super();
		if(requestMap!=null){
			try {
				this.paramsMap = new HashMap<String, Object>(); 
				Iterator<Entry<String, String[]>> entries = requestMap.entrySet().iterator(); 
				Map.Entry<String, String[]> entry = null ; 
				String name = null;  
				String value = null;  
				Object valueObj = null ;
				while (entries.hasNext()) {
					entry = (Map.Entry<String, String[]>) entries.next(); 
					name = (String) entry.getKey(); 
					valueObj = entry.getValue(); 
					value = null;
					if(valueObj == null){ 
						value = ""; 
					}else{ 
						String[] values = (String[])valueObj;
						if(values!=null){
							for(int i=0;i<values.length;i++){
								if(values[i] == null)
									value ="";
								else
									value = values[i].toString();
							}
						}
					}
					this.paramsMap.put(name, value); 
				}
				this.pageSize=StringUtil.stringToInt(this.paramsMap.get(PageInfo.PAGE_SIZE_KEY).toString(),DEFAULT_PAGE_SIZE);
				this.currentPage=StringUtil.stringToInt(this.paramsMap.get(PageInfo.CURRENT_PAGE_KEY).toString(),this.currentPage);
				this.paramsMap.put("currentPage", currentPage);
				this.paramsMap.put("startRow", getStartRow());
				this.paramsMap.put("endRow", getEndRow());
				this.paramsMap.put("offset", getStartRow()-1);
				this.paramsMap.put("pageSize", getPageSize());
			} catch (Exception e) {
				throw new ServiceException(ExceptionStaticEnum.ERRORPARAMS.getCode(),ExceptionStaticEnum.ERRORPARAMS.getMessage());
			}
		}
	}

	/**
     * 从0开始，用户mysql分页
     * @return 起始记录位置
     */
	private int getStartIndex() {
        int index = getStartRow() - 1;
        if (index < 0) {
            index = 0;
        }
        return index;
    }

    /**
     * 从1开始(currentPage - 1) * pageSize + 1
     *
     * @return 开始序号，从1开始
     */
    private int getStartRow() {
        return (this.currentPage - 1) * this.pageSize + 1;
    }

    /**
     * currentPage * pageSize
     *
     * @return 结束序号
     */
    private int getEndRow() {
        int last = this.currentPage * this.pageSize;
        return this.totalCount > 0 && last > this.totalCount ? this.totalCount : last;
    }

    /**
     * 最小为1
     *
     * @return the currentPage
     */
    public int getCurrentPage() {
        return currentPage;
    }

    /**
     * 当前页只能大于1的值，默认为1
     *
     * @param currentPage the currentPage to set
     */
    public void setCurrentPage(int currentPage) {
        if (currentPage < 1) {
            currentPage = 1;
        }
        this.currentPage = currentPage;
    }

    /**
     * @return the pageSize
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * pageSize只能为大于0的值，默认20
     *
     * @param pageSize the pageSize to set
     */
    public void setPageSize(int pageSize) {
        if (pageSize < 0 || pageSize > 100) {
            pageSize = DEFAULT_PAGE_SIZE;
        }
        this.pageSize = pageSize;
    }

    /**
     * 最小为0
     *
     * @return 总记录数
     */
    public int getTotalCount() {
        return totalCount;
    }

    /**
     * 设置总量，并计算总页数
     *
     * @param totalCount
     */
    public void setTotalCount(int totalCount) {
        if (totalCount < 0) {
            totalCount = 0;
        }
        this.totalCount = totalCount;
        if (totalCount % pageSize == 0) {
            totalPage = totalCount / pageSize;
        } else {
            totalPage = totalCount / pageSize + 1;
        }
        if (currentPage > totalPage) {
            currentPage = totalPage;
        }
        if (currentPage < 1) {
            currentPage = 1;
        }
    }

    /**
     * 最小为1
     *
     * @return 总页数
     */
    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
    



	public Map<String, Object> getParamsMap() {
		return paramsMap;
	}

	public void setParamsMap(Map<String, Object> paramsMap) {
		this.paramsMap = paramsMap;
	}


}
