package com.baidu.ueditor.define;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.youzi.yuchou.module.mvc.img.UplAppInfo;

public class BaseUpdState implements State {

	private boolean state = false;
	private String info = null;
	
	private Map<String, String> infoMap = new HashMap<String, String>();
	
	public BaseUpdState () {
		this.state = true;
	}
	
	public BaseUpdState ( boolean state ) {
		this.setState( state );
	}
	
	public BaseUpdState ( boolean state, String info ) {
		this.setState( state );
		this.info = info;
	}
	
	public BaseUpdState ( boolean state, int infoCode ) {
		this.setState( state );
		this.info = UplAppInfo.getStateInfo( infoCode );
	}
	
	public boolean isSuccess () {
		return this.state;
	}
	
	public void setState ( boolean state ) {
		this.state = state;
	}
	
	public void setInfo ( String info ) {
		this.info = info;
	}
	
	public void setInfo ( int infoCode ) {
		this.info = UplAppInfo.getStateInfo( infoCode );
	}
	
	@Override
	public String toJSONString() {
		return this.toString();
	}
	
	public String toString () {
		
		String key = null;
//		String stateVal = this.isSuccess() ? UplAppInfo.getStateInfo( UplAppInfo.SUCCESS ) : this.info;
		String stateVal = this.isSuccess() ? UplAppInfo.getStateInfo( UplAppInfo.SUCCESS ) : UplAppInfo.getStateInfo( UplAppInfo.ERROR );
		if(!this.isSuccess()){
			String messgae = this.info ;
			stateVal+="\",\"messgae\": \"" + messgae ;
		}
		
		StringBuilder builder = new StringBuilder();
		
		builder.append( "{\"state\": \"" + stateVal + "\"" );
		
		Iterator<String> iterator = this.infoMap.keySet().iterator();
		
		while ( iterator.hasNext() ) {
			
			key = iterator.next();
			
			builder.append( ",\"" + key + "\": \"" + this.infoMap.get(key) + "\"" );
			
		}
		
		builder.append( "}" );

		return builder.toString();
//		return Encoder.toUnicode( builder.toString() );

	}

	@Override
	public void putInfo(String name, String val) {
		this.infoMap.put(name, val);
	}

	@Override
	public void putInfo(String name, long val) {
		this.putInfo(name, val+"");
	}

}
