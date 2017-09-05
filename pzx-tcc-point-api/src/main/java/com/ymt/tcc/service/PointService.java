/**
 * 
 */
package com.ymt.tcc.service;

import org.mengyun.tcctransaction.api.Compensable;

import com.ymt.tcc.dto.PointInfo;

/**
 * @author zhailiang
 *
 */
public interface PointService {
	
	@Compensable
	void changePoint(PointInfo info);

}
