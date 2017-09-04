/**
 * 
 */
package com.ymt.tcc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ymt.tcc.domain.Inventory;
import com.ymt.tcc.dto.InventoryInfo;
import com.ymt.tcc.repository.InventoryRepository;
import com.ymt.tcc.service.InventoryService;

/**
 * @author zhailiang
 *
 */
@Service("inventoryService")
@Transactional
public class InventoryServiceImpl implements InventoryService {
	
	@Autowired
	private InventoryRepository inventoryRepository;
	
	/* (non-Javadoc)
	 * @see com.ymt.tcc.service.InventoryService#changeInventory(com.ymt.tcc.dto.InventoryInfo)
	 */
	@Override
	public void changeInventory(InventoryInfo info) {
		Inventory inventory = inventoryRepository.findOne(info.getId());
		inventory.setAmount(inventory.getAmount() + info.getAmount());
	}

}
