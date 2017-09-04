/**
 * 
 */
package com.ymt.tcc.dto;

import java.io.Serializable;

/**
 * @author zhailiang
 *
 */
public class PointInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8837433579139850090L;
	
	public PointInfo(Long id, Integer amount){
		this.id = id;
		this.amount = amount;
	}
	
	private Long id;
	
	private Integer amount;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the amount
	 */
	public Integer getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
}
