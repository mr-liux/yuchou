package com.youzi.yuchou.core.constants;

/**
 * 此常量类设置所有系统的相关数据字典常量
 * @author Yingjie.Wu
 *
 */
public class DataDictConstants {

    /**
     * 物品类别
     */
    public static final String GOODS_TYPE = "Goods_Type";
    /**
     * 物品类别_货样
     */
    public static final String GOODS_TYPE_SAMPLE   = "0001";
    /**
     * 物品类别_非货样
     */
    public static final String GOODS_TYPE_NONSAMPLE = "0002";
    
    /**
	 * 设备类型-PC
	 */
	public static final String DEVICETYPE_PC = "0001";
	
	/**
	 * 设备类型-PDA
	 */
	public static final String DEVICETYPE_PDA = "0002";
	
    /**
     * 运单状态
     */
    public static final String WAYBILL_STATUS ="Waybill_Status";
    /**
     * 运单状态_收件
     */
    public static final String WAYBILL_STATUS_CONSIGNEE="10";
    /**
     * 运单状态_中转
     */
    public static final String WAYBILL_STATUS_TRANSIT="20";
    /**
     * 运单状态_换单
     */
    public static final String WAYBILL_STATUS_SWITCH="30";
    /**
     * 运单状态_签收
     */
    public static final String WAYBILL_STATUS_SIGN="40";
    /**
     * 运单状态_派件失败
     */
    public static final String WAYBILL_STATUS_FAILURE="41";
    /**
     * 快件类型
     */
    public static final String EFFECTIVE_TYPE="Effective_Type";
    /**
     * 快件类型_国内24小时件
     */
    public static final String EFFECTIVE_TYPE_24H="1";
    /**
     * 快件类型_国内普通件
     */
    public static final String EFFECTIVE_TYPE_COMMON="2";
    /**
     * 快件类型_国际件
     */
    public static final String EFFECTIVE_TYPE_INTERNATIONAL="3";
    /**
     * 快件类型_航空件
     */
    public static final String EFFECTIVE_TYPE_AVIATION="4";
    
    /**
	 * 值集类型-订单打回原因
	 */
	public static final String ORDER_RETURN_REASON_CODE="Order_Return_Reason";
	
	/**
	 * 值集类型-班次
	 */
	public static final String FREQUENCY_TYPE_CODE="FREQUENCY";
	

	/**
	 * 班次
	 */
	public static final String FREQUENCY_TYPE="Allocate_Batch";
	
	
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
     * opt_org_type 中心
     */
    public static final String OPT_ORG_TYPE_CENTER="2";
    
    /**
     * opt_org_type 网点
     */
    public static final String OPT_ORG_TYPE_SITE="1";
    
    /**
     * 操作类型
     */
    public static final String OP_TYPE = "Op_type";
    
    /**
     * 业务员收件
     */
    public final static String OP_TYPE_1="0001";
    
    /**
     * 网点收件
     */
    public final static String OP_TYPE_2="0002";
    
    /**
     * 发件
     */
    public final static String OP_TYPE_3="0003";
    
    /**
     * 装袋发件
     */
    public final static String OP_TYPE_4="0004";
    
    /**
     * 装车发件
     */
    public final static String OP_TYPE_5="0005";
    
    /**
     * 到件
     */
    public final static String OP_TYPE_6="0006";
    
    /**
     * 装包发件
     */
    public final static String OP_TYPE_7="0007";
        
    /**
     * 航空发包
     */
    public final static String OP_TYPE_8="0008";
    
    /**
     * 航空到包
     */
    public final static String OP_TYPE_9="0009";
    
    /**
     * 发车
     */
    public final static String OP_TYPE_10="0010";
    
    /**
     * 到车
     */
    public final static String OP_TYPE_11="0011";
    //....
    /**
     * 派件
     */
    public final static String OP_TYPE_12="0012";
    
    /**
     * 签收
     */
    public final static String OP_TYPE_13="0013";
    
    /**
     * 问题件
     */
    public final static String OP_TYPE_14="0014";
    
    /**
     * 留仓件
     */
    public final static String OP_TYPE_15="0015";
    
    /**
     * 交接
     */
    public final static String OP_TYPE_16="0016";
    
    /**
     * 网点
     */
    public final static String OPT_ORG_TYPE_1="1";
    
    /**
     * 中心
     */
    public final static String OPT_ORG_TYPE_2="2";
    
    
    /**
     * 业务员收件
     */
    public final static String OP_TYPE_01="110";
    
    /**
     * 网点收件
     */
    public final static String OP_TYPE_02="120";
    
    /**
     * 发件
     */
    public final static String OP_TYPE_03="210";
    
    /**
     * 装袋发件
     */
    public final static String OP_TYPE_04="221";
    public final static String OP_TYPE_019="220";
    
    /**
     * 装车发件
     */
    public final static String OP_TYPE_05="231";
    public final static String OP_TYPE_018="230";
    
    /**
     * 到件
     */
    public final static String OP_TYPE_06="520";
    
    /**
     * 装包发件
     */
    public final static String OP_TYPE_07="321";
        
    /**
     * 航空发包
     */
    public final static String OP_TYPE_08="310";
    
    /**
     * 航空到包
     */
    public final static String OP_TYPE_09="330";
    
    /**
     * 发车
     */
    public final static String OP_TYPE_010="240";
    
    /**
     * 到车
     */
    public final static String OP_TYPE_011="510";
    //....
    /**
     * 派件
     */
    public final static String OP_TYPE_012="710";
    
    /**
     * 签收
     */
    public final static String OP_TYPE_013="795";
    
    /**
     * 问题件
     */
    public final static String OP_TYPE_014="410";
    
    /**
     * 留仓件
     */
    public final static String OP_TYPE_015="420";
    
    /**
     * 交接
     */
    public final static String OP_TYPE_016="721";
    

    /**
     * 装包发件（航空）
     */
    public final static String OP_TYPE_017="320";
    


    /**
	 * 来源类型-报文
	 */
	public static final String SOURCETYPE_MESSAGE = "1";
	/**
	 * 来源类型-文件
	 */
	public static final String SOURCETYPE_FILE = "2";
	
	/**
	 * 解析错误类型-重复扫描
	 */
	public static final String PARSE_ERROR_MULTISCAN = "0001";
	
	/**
	 * 解析错误类型-缺少信息
	 */
	public static final String PARSE_ERROR_LACKINFO = "0002";
	
	/**
	 * 解析错误类型-格式错误
	 */
	public static final String PARSE_ERROR_FORMATERROR = "0003";
	
	/**
	 * 解析错误类型-程序异常
	 */
	public static final String PARSE_ERROR_PROGRAMERROR = "0004";
	
	/**
	 * 解析错误类型-数据包解析错误
	 */
	public static final String PARSE_ERROR_MESSAGEERROR = "0005";
	
	/**
	 * 接入错误类型-日期格式错误
	 */
	public static final String RECEIVE_ERROR_DATEFORMATEERROR = "0006";
	
	/**
	 * 接入错误类型-不是格林威治时间
	 */
	public static final String RECEIVE_ERROR_DATEERROR = "0007";
	
	
	/**
	 * 接入错误类型-字段非空错误
	 */
	public static final String RECEIVE_ERROR_NULLERROE = "0008";
	
	/**
	 * 单号类型-运单
	 */
	public static final String EXPTYPE_WAYBILL = "10";
	
	/**
	 * 单号类型-大包
	 */
	public static final String EXPTRYPE_PACKAGE = "20";
	
	/**
	 * 单号类型-铅封
	 */
	public static final String EXPTRYPE_SEAL = "40";
	
	/**
	 * 单号类型-RFID
	 */
	public static final String EXPTRYPE_RFID = "60";
	
	/**
	 * 币种类型-RMB
	 */
	public static final String CURRENCY_TYPE_RMB = "RMB";
	
	/**
	 * 扫描码类型 运单规则
	 */
	public static final String PARSE_BAR_CODE_WAYBILL="CODE0001";
	
	/**
	 * 扫描码类型 包规则
	 */
	public static final String PARSE_BAR_CODE_PACKGE="CODE0002";
	
	/**
	 * 扫描码类型 车规则
	 */
	public static final String PARSE_BAR_CODE_TRUCK="CODE0003";
	
	/**
	 * 扫描码类型 运单
	 */
	public static final String PARSE_EXP_TYPE_WAYBILL="10";
	
	/**
	 * 扫描码类型 包
	 */
	public static final String PARSE_EXP_TYPE_PACKGE="20";
	
	/**
	 * 扫描码类型 车
	 */
	public static final String PARSE_EXP_TYPE_TRUCK="40";
	
	/**
	 * 快件类型-24小时件
	 */
	public static final String PARSE_EffectiveType_24="24小时件";
	
	/**
	 * 物品类别-货样
	 */
	public static final String PARSE_GOODTYPE_SAMPLE="货样";
	
	/**
	 * 物品类别-非货样
	 */
	public static final String PARSE_GOODTYPE_NOSAMPLE="非货样";
	
	/**
	 *  辅助操作码-新建(NEW)
	 */
	public static final String AUXOPCODE_NEW="NEW";
	
	/**
	 *  辅助操作码-更新(UPDATE)
	 */

	public static final String AUXOPCODE_UPDATE="UPDATE";
	
	/**
	 * 辅助操作码-删除(DELETE)
	 */
	public static final String AUXOPCODE_DELETE="DELETE";

	/**
	 * 辅助操作码-已删除(DELETED)
	 */
	public static final String AUXOPCODE_DELETED="DELETED";
	
	/**
	 * 状态-有效
	 */
	public static final String STATUS_VALID = "1";
	
	/**
	 * 状态-无效
	 */
	public static final String STATUS_INVALID = "0";
	
	/**
	 * 数据来源-网络订单标识
	 */
	public static final String DATASOURCE_ORDER = "ORD";
	
    /**
     * 数据来源-巴枪
     */
	public static final String DATASOURC_PDA = "10";
	
	
	/**
	 * 数据来源-E3
	 */
	public static final String DATASOURC_E3 = "20";
	
	/**
	 * 数据来源-菜鸟订单
	 */
	public static final String DATASOURCE_CAINIAO = "3";
	
	/**
	 * 数据来源-苏宁订单
	 */
	public static final String DATASOURCE_SUNING = "4";
	
	/**
	 * 颜色
	 */
	public static final String RED = "red";
	
	public static final String GREEN = "green";
	
	/**
	 * 航空标识
	 */
	public static final String AIR="1";
	
	/**
	 *非航空标识 
	 */
	public static final String NOT_AIR="0";
	
	/**
	 * 待补分发
	 */
	public static final int DISTRIBUTE_AGAIN_STATUS_0 = 0;
	
	/**
	 * 正在补分发
	 */
	public static final int DISTRIBUTE_AGAIN_STATUS_1 = 1;
	
	/**
	 * 补分发成功
	 */
	public static final int DISTRIBUTE_AGAIN_STATUS_2 = 2;
	
	/**
	 * 补分发失败
	 */
	public static final int DISTRIBUTE_AGAIN_STATUS_3 = 3;
	
	
	/**
	 * 组织业务规则
	 */
	public static final String QUERY_DATE_RANGE="query_date_range";
	public static final String OPRECORD_QUERY_DATA_RANGE="opRecord_query_data_range";
	
	/**
	 * 问题件：拦截件->退回件 类型编码
	 */
	public static final String ISSUE_LJ_BACK = "58";
}
