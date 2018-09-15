package com.flatmate.expanse.enums;

import java.util.HashMap;
import java.util.Map;

public enum ExpenseType {
	
	SABJI(10001,"SABJI","SABJI"),
	KIRANA(10002,"KIRANA","KIRANA"),
	WATER(10003,"WATER","WATER"),
	MAIDFOOD(10004,"MAIDFOOD","Paid to maid for food"),
	MAIDCLEANING(10005,"MAIDCLEANING","Paid to maid for cleaning"),
	CLEANING(10006,"CLEANING","Paid to maid for cleaning"),
	GAS(10007,"GAS","GAS"),
	MOVIE(10008,"MOVIE","MOVIE"),
	ROOMRENT(10009,"ROOMRENT","ROOMRENT"),
	OTHER(10010,"OTHER","OTHER");
	
	
	private static final Map<Integer, ExpenseType> byId = new HashMap<Integer, ExpenseType>();
	private static final Map<String, ExpenseType> byValue = new HashMap<String, ExpenseType>();
	
	
	static {
	     for (ExpenseType e : ExpenseType.values() ) {
	            if (byId.put(e.getId(), e) != null) {
	                throw new IllegalArgumentException("duplicate id: " + e.getId());
	            }
	            
	            if (byValue.put(e.getValue(), e) != null) {
	                throw new IllegalArgumentException("duplicate value: " + e.getValue());
	            }
	    }
	 }
	
	
	public static ExpenseType getById(int id) {
	    return byId.get(id);
	 }
	 
	public static ExpenseType getByValue(String value) {
		    return byValue.get(value);
	}
	
	
	private Integer id;
	
	private String value;
	
	private String desc;

	/**
	 * @param id
	 * @param name
	 * @param desc
	 */
	private ExpenseType(Integer id, String value, String desc) {
		this.id = id;
		this.value = value;
		this.desc = desc;
	}

	public static Map<Integer, ExpenseType> getByid() {
		return byId;
	}

	public static Map<String, ExpenseType> getByvalue() {
		return byValue;
	}

	public Integer getId() {
		return id;
	}

	public String getValue() {
		return value;
	}

	public String getDesc() {
		return desc;
	}
	
	
}
