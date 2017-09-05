/**
 * 
 */
package com.ymt.tcc.service;

import org.mengyun.tcctransaction.api.Compensable;

/**
 * @author zhailiang
 *
 */
public interface OrderService {
	
	@Compensable
	void create();

}
