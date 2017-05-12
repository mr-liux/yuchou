package com.youzi.yuchou.core.constants;

public class InteractionConstants {

	/**
	 * 巴枪未注册
	 */
	public final static Integer NO_REGIST = 0;

	/**
	 * 巴枪已注册，未启用
	 */
	public final static Integer IS_REGIST_NO_USE = 1;
	/**
	 * 巴枪已注册，同一网点
	 */
	public final static Integer SAME_ORGCODE = 2;

	/**
	 * 巴枪已注册，不同网点，但同级
	 */
	public final static Integer DIFF_ORGCODE_SAME_LEVEL = 3;

	/**
	 * 巴枪禁用
	 */
	public final static Integer IS_FORBIDDED = 4;

	/**
	 * 巴枪已注册，不同网点，但不同级，不予放过
	 */
	public final static Integer DIFF_ORGCODE_DIFF_LEVEL = 5;
	/**
	 * 巴枪已注册，不同网点，不同组
	 */
	public final static Integer DIFF_ORGCODE_GROUPS = 6;
	/**
	 * 巴枪已注册，不同网点，同组
	 */
	public final static Integer SAME_ORGCODE_GROUPS = 7;

	/***********************************************************
	 * redis,exists：存在1，不存在0，异常-1
	 */
	public final static Integer IS_EXISTS = 1;
	public final static Integer IS_NOT_EXISTES = 0;
	public final static Integer REDIS_EXCEPTION = -1;

	/************************************************************
	 * 组织业务开关：1开，0关
	 */
	public final static String PDA_SWITCH_OPEN = "1";
	public final static String PDA_SWITCH_CLOSE = "0";

	/************************************************************
	 * 报文 应答码：000成功，001未登录，002PDA禁用，003报文格式错误，009其他原因造成失败,010 24小时内不能重复登录
	 */
	public final static String RESPCODE_SUCCESS = "000";
	public final static String RESPCODE_NO_LOGIN = "001";
	public final static String RESPCODE_FAIL_PDA_FORBIDDED = "002";
	public final static String RESPCODE_FAIL_FORMAT_WRONG = "003";
	public final static String RESPCODE_FAIL_OTHER = "009";
	public final static String RESPCODE_HAS_LOGIN = "010";

	/************************************************************
	 * 软件更新：无新版本00，系统更新01，软件更新10，系统软件都要更新11
	 */
	public final static String NO_UPDATE = "00";
	public final static String OS_UPDATE = "01";
	public final static String SOFT_UPDATE = "10";
	public final static String OS_SOFT_UPDATE = "11";

	/*************************************************************
	 * 报文操作码
	 */
	public final static String MTY_RESP_LOGIN = "1851";
	public final static String MTY_RESP_LOGOUT = "1852";

	public final static String MTY_RESP_SYNCTIME = "1853";// 同步时钟

	public final static String MTY_RESP_ORDER_DOWNLOAD = "1810";// 订单下载
	public final static String MTY_RESP_ORDER_PICKUP = "1811";// 订单提取
	public final static String MTY_RESP_ORDER_REBACK = "1812";// 订单打回

	public final static String MTY_RESP_DELIVERY_SIGN = "1820";// 有派无签
	public final static String MTY_RESP_DELIVERY_SCOPE = "1822";// 超派查询

	public final static String MTY_RESP_HARDWARE = "1854";// 硬件信息
	public final static String MTY_RESP_MODIFYTIME = "1855";// pda时间修改
	public final static String MTY_RESP_SYSSYN = "1856";// 系统同步

	public final static String MTY_RESP_BASICDOWN = "1857";// 基础资料下载
	public final static String MTY_RESP_SYSUPDATE = "1858";// 系统更新

	/**********************************************************
	 * 订单状态order_status： 新增10, 已打回20，已处理30，已取消40
	 */
	public final static String ORDER_STATUS_NEWADDLY = "10";
	public final static String ORDER_STATUS_REBACKED = "20";
	public final static String ORDER_STATUS_DONE = "30";
	public final static String ORDER_STATUS_CANCEL = "40";

	/**********************************************************
	 * 下载状态down_status： 已下载10，未下载20, 不下载30
	 */
	public final static String DOWN_STATUS_DONE = "10";
	public final static String DOWN_STATUS_NOTT = "20";
	public final static String DOWN_STATUS_NO = "30";

	/****
	 * 分发标识DistributionTag：已打回未分发1，已打回已分发2
	 */
	public final static String DISTRIBUT_REBACKED_YET = "1";
	public final static String DISTRIBUT_REBACKED_DONE = "2";

	/****
	 * 订单提取分发标识OrderDealDistributionTag 未处理0,已处理未分发1,已处理已分发2
	 */
	public final static String ORDER_DEAL_DONE_DIS_YET = "1";
	public final static String ORDER_DEAL_DONE_DIS_DONE = "2";

}
