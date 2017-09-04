/**
 * 
 */
package com.ymt.tcc.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ymt.tcc.service.OrderService;

/**
 * @author zhailiang
 *
 */
@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	@GetMapping("/order")
	public void create(){
		orderService.create();
	}

}
