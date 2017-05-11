package com.youzi.yuchou.core.constants;

public class MDMConstants {
	//
    /**
     * 正常数据
     */
    public static final String STATUS_NORMAL = "1";

    /**
     * 已删除数据
     */
    public static final String STATUS_DELETE = "0";

    /**
     * 有效数据
     */
    public static final String STATUS_VALID = "1";

    /**
     * 无效数据
     */
    public static final String STATUS_INVALID = "0";

    /**
     * 启用
     */
    public static final String STATUS_ENABLED = "1";

    /**
     * 禁用
     */
    public static final String STATUS_DISABLED = "0";
    
    /**
     * 已注册未启用
     */
    public static final String STATUS_REGISTER_DISABLED= "9";

    /**
     * 注销
     */
    public static final String STATUS_CANCEL = "0";
    
    /**
     * 注册
     */
    public static final String STATUS_REGISTER= "1";
    
  
    
    /**
	 * 组织级别1级001
	 */
	public final static String ORG_TYPE_LEVEL_1="0001";
	/**
	 * 组织级别2级002
	 */
	public final static String ORG_TYPE_LEVEL_2="0002";
	/**
	 * 组织级别3级003
	 */
	public final static String ORG_TYPE_LEVEL_3="0003";
	/**
	 * 组织级别4级004
	 */
	public final static String ORG_TYPE_LEVEL_4="0004";
	/**
	 * 组织级别5级005
	 */
	public final static String ORG_TYPE_LEVEL_5="0005";
	/**
	 * 组织级别6级006
	 */
	public final static String ORG_TYPE_LEVEL_6="0006";
	/**
	 * 组织级别7级007
	 */
	public final static String ORG_TYPE_LEVEL_7="0007";
	
	
	/**
     * 组织类型
     */
    public final static String ORG_TYPE="Org_Type";
	/**
	 * 总公司
	 */
	public static final String ORG_TYPE_1="0001"; 
	/**
	 * 管理区
	 */
	public static final String ORG_TYPE_2="0002"; 
	/**
	 * 转运中心
	 */
	public static final String ORG_TYPE_3="0003"; 
	/**
	 * 独立网点
	 */
	public static final String ORG_TYPE_4="0004"; 
	/**
	 * 承包区
	 */
	public static final String ORG_TYPE_5="0005"; 
	/**
	 * 部门
	 */
	public static final String ORG_TYPE_6="0006"; 
	/**
	 * 资源类型
	 */
	public final static String RESOURCE_TYPE="Resource_Type";
	/**
	 * 导出记录数
	 */
	public final static long RECORD=10000;
	
 	/**
 	 * 查询所有
 	 */
	public static final String QUERY_MODEL_ALL="1"; 
	
	/**
 	 * 查询所属及子孙
 	 */
	public static final String QUERY_MODEL_CHILD="2"; 
	
	/**
 	 * 查询所属
 	 */
	public static final String QUERY_MODEL_SELF="3"; 

	
	/**
	 * 已领用
	 */
	public static final String STATUS_RECEIVE="0001"; 
	
	/**
	 * 未领用
	 */
	public static final String STATUS_REVERT="0002"; 

	/**
	 * 网点
	 */
	public final static String Opt_Org_Type_NETWORK="1";
	/**
	 * 中心
	 */
	public final static String Opt_Org_Type_CENTRE="2";
	
	/**
	 *总公司系统管理员 
	 */
	public final static String R_SYSADMIN_HD = "R_SYSADMIN_HD";
	
	/**
	 * 管理区系统管理员
	 */
	public final static String R_SYSADMIN_MA = "R_SYSADMIN_MA";
	
	/**
	 * 转运中心系统管理员
	 */
	public final static String R_SYSADMIN_TC = "R_SYSADMIN_TC";
	
	/**
	 * 独立网点系统管理员
	 */
	public final static String R_SYSADMIN_BR = "R_SYSADMIN_BR";
	
	/**
	 * 承包区系统管理员
	 */
	public final static String R_SYSADMIN_CA = "R_SYSADMIN_CA";
	
	/**
	 * 总公司主数据管理员
	 */
	public final static String R_MDMADMIN_HD = "R_MDMADMIN_HD";
	
	/**
	 * 管理区主数据管理员
	 */
	public final static String R_MDMADMIN_MA = "R_MDMADMIN_MA";
	
	/**
	 * 转运中心主数据管理员
	 */
	public final static String R_MDMADMIN_TC = "R_MDMADMIN_TC";
	
	/**
	 * 网点主数据管理员
	 */
	public final static String R_MDMADMIN_BR = "R_MDMADMIN_BR";
	
	/**
	 * 承包区主数据管理员
	 */
	public final static String R_MDMADMIN_CA = "R_MDMADMIN_CA";
	
	/**
	 * 网点业务员
	 */
	public final static String R_SALESMAN_BR = "R_SALESMAN_BR";
	
	/**
	 * 承包区业务员
	 */
	public final static String R_SALESMAN_CA = "R_SALESMAN_CA";
	
	/**
	 * 转运中心提货员
	 */
	public final static String R_DELIVERY_TC = "R_DELIVERY_TC";
	
	/**
	 * 总公司扫描员
	 */
	public final static String R_OPERATOR_HD = "R_OPERATOR_HD";
	
	/**
	 * 转运中心扫描员
	 */
	public final static String R_OPERATOR_TC = "R_OPERATOR_TC";
	
	/**
	 * 网点扫描员
	 */
	public final static String R_OPERATOR_BR = "R_OPERATOR_BR";
	
	/**
	 * 承包区扫描员
	 */
	public final static String R_OPERATOR_CA = "R_OPERATOR_CA";
	
	/**
	 * 总公司_管理员
	 */
	public final static String R_OPADMIN_HD = "R_OPADMIN_HD";
	
	/**
	 * 总公司_客服
	 */
	public final static String R_OPSERVICE_HD = "R_OPSERVICE_HD";
	
	/**
	 * 管理区_管理员
	 */
	public final static String R_OPADMIN_MA = "R_OPADMIN_MA";
	
	/**
	 * 转运中心_管理员
	 */
	public final static String R_OPADMIN_TC = "R_OPADMIN_TC";
	
	/**
	 * 独立网点_管理员
	 */
	public final static String R_OPADMIN_BR = "R_OPADMIN_BR";
	
	/**
	 * 独立网点_客服
	 */
	public final static String R_OPSERVICE_BR = "R_OPSERVICE_BR";
	
	/**
	 * 承包区_管理员
	 */
	public final static String R_OPADMIN_SD = "R_OPADMIN_SD";
	
	/**
	 * 承包区_客服
	 */
	public final static String R_OPSERVICE_SD = "R_OPSERVICE_SD";

	/***
	 * 管理员代码
	 */
	public final static String S_ADMIN="ADMIN";
	/**
	 * 系统管理员代码
	 */
	public final static String SYS_ADMIN="SYSADMIN";
	/***************
	 * 业务员代码
	 */
	public final static String S_SALESMAN="SALESMAN";
	/*****
	 * 扫描员代码
	 */
	public final static String S_OPERATOR="OPERATOR";
	/****
	 * 提货员代码
	 */
	public final static String S_DELIVERY="DELIVERY";
	/****
	 * 管理员简码
	 */
	public final static String P_ADMIN="10";
	/*****
	 * 业务员简码
	 */
	public final static String P_SALESMAN="20";
	/***
	 * 扫描员简码
	 */
	public final static String P_OPERATOR="30";
	/*********
	 * 提货员简码
	 */
	public final static String P_DELIVERY="40";
	/**
	 * 包含子组织
	 */
	public final static String CONTAINCHILD="1";
	/**
	 * 总公司编码
	 */
	public final static String CORPORATION_ORGCODE="888880";
	/**
	 * 到签，派签，收签-1:签收,（航空发包）有到
	 */
	public final static String SIGNATURE = "1";
	/**
	 * 到签，派签，收签0:未到，未派，未收,未签
	 */
	public final static String NO_SIGNATURE = "0";
	
	/**
	 * 条码规则验证位
	 */
	public final static String BARCODE_CHECK = "Barcode_Check";
	
	/**
	 * 管理员岗位
	 */
	public final static String POST_MANAGER="0003";
	/**
	 * 管理员岗位
	 */
	public final static String ROLE_MANAGER="5,10,16";
	/**
	 * 默认密码
	 */
	public final static String DEFAULT_PASSWORD="1234";
	
	/**
	 * 运单条码
	 */
	public final static Long CODE0001 = 1l;
	/**
	 * 包/袋签号条码
	 */
	public final static Long CODE0002 = 2l;
	/**
	 * 车签号条码
	 */
	public final static Long CODE0003 = 3l;
	/**
	 * 铅封号条码
	 */
	public final static Long CODE0004 = 4l;
	/**
	 * 网点条码
	 */
	public final static Long CODE0005 = 5l;
	/**
	 * 职员条码
	 */
	public final static Long CODE0006 = 6l;
	
}
