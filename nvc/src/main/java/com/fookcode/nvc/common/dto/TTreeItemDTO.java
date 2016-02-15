//************************************************************//
//File Name : TTreeItemDTO.java
//Author    : kinee
//Mailto    : kinee@163.com
//Comment   : 
//Date      : Jul 22, 2014
//************************************************************//

package com.fookcode.nvc.common.dto;

import java.util.List;
import java.util.Map;

public class TTreeItemDTO {
	
	private int id;
	
	private String text;
	
	private String iconCls;
	
	private boolean checked;
	
	private String state;
	
	private Map<String, String> attributes;
	
	List<TTreeItemDTO> children;
	
	public List<TTreeItemDTO> getChildren() {
		return children;
	}

	public void setChildren(List<TTreeItemDTO> children) {
		this.children = children;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Map<String, String> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}

}

