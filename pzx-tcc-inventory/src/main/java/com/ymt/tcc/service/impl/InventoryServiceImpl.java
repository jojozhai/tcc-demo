/**
 * 
 */
package com.ymt.tcc.service.impl;

import org.mengyun.tcctransaction.api.Compensable;
import org.mengyun.tcctransaction.dubbo.context.DubboTransactionContextEditor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	/* (non-Javadoc)
	 * @see com.ymt.tcc.service.InventoryService#changeInventory(com.ymt.tcc.dto.InventoryInfo)
	 */
	@Override
	@Compensable(confirmMethod = "confirmChange", cancelMethod = "cancelChange", transactionContextEditor = DubboTransactionContextEditor.class)
	public void changeInventory(InventoryInfo info) {
		
		logger.info("inventory try");
		Inventory inventory = inventoryRepository.findOne(info.getId());
		inventory.setAmount(inventory.getAmount() - info.getAmount());
		inventory.setFreeze(inventory.getFreeze() + info.getAmount());
		
//		throw new RuntimeException("test try error");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("go on");
		
	} 
	
	public void confirmChange(InventoryInfo info) {
		
		logger.info("inventory confirm");
		Inventory inventory = inventoryRepository.findOne(info.getId());
		inventory.setFreeze(inventory.getFreeze() - info.getAmount());
		
//		throw new RuntimeException("test confirm error");
		
	}
	
	public void cancelChange(InventoryInfo info) {
		
		logger.info("inventory cancel");
		Inventory inventory = inventoryRepository.findOne(info.getId());
		inventory.setFreeze(inventory.getFreeze() - info.getAmount());
		inventory.setAmount(inventory.getAmount() + info.getAmount());
		
//		throw new RuntimeException("test cancel error");
		
	}

}
