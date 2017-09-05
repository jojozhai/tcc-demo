/**
 * 
 */
package com.ymt.tcc.domain;

import javax.persistence.Entity;

import com.ymt.pz365.data.jpa.domain.DomainImpl;

/**
 * @author zhailiang
 *
 */
@Entity
public class Inventory extends DomainImpl {
	
	private int amount;
	
	private int freeze;

	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	/**
	 * @return the freeze
	 */
	public int getFreeze() {
		return freeze;
	}

	/**
	 * @param freeze the freeze to set
	 */
	public void setFreeze(int freeze) {
		this.freeze = freeze;
	}
	
}
