/**
 * 
 */
package com.ymt.tcc.service;

import org.mengyun.tcctransaction.api.Compensable;

import com.ymt.tcc.dto.InventoryInfo;

/**
 * @author zhailiang
 *
 */
public interface InventoryService {
	
	@Compensable
	void changeInventory(InventoryInfo info);

}
