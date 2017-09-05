/**
 * 
 */
package com.ymt.tcc.service.impl;

import org.mengyun.tcctransaction.api.Compensable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ymt.tcc.domain.Order;
import com.ymt.tcc.dto.InventoryInfo;
import com.ymt.tcc.dto.PointInfo;
import com.ymt.tcc.repository.OrderRepository;
import com.ymt.tcc.service.InventoryService;
import com.ymt.tcc.service.OrderService;
import com.ymt.tcc.service.PointService;

/**
 * @author zhailiang
 *
 */
@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private InventoryService inventoryService;

	@Autowired
	private PointService pointService;

	@Autowired
	private OrderRepository orderRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ymt.tcc.service.OrderService#create()
	 */
	@Override
	@Compensable(confirmMethod = "confirmCreate", cancelMethod = "cancelCreate")
	public void create() {

		pointService.changePoint(new PointInfo(1L, 1));
		
		inventoryService.changeInventory(new InventoryInfo(1L, 1));

		orderRepository.save(new Order("ok"));

	}

	public void confirmCreate() {
		System.out.println("confirm");
	}

	public void cancelCreate() {
		System.out.println("cancel");
	}

}
