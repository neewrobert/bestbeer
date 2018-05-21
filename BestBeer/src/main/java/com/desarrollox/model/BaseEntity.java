package com.desarrollox.model;

import java.io.Serializable;

public abstract class BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2908969733145126254L;
	
	
	private Long id;

	public abstract Long getId();

	public abstract void setId(Long id);
	
	

}
