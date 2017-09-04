/**
 * 
 */
package com.ymt.tcc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ymt.tcc.domain.Point;
import com.ymt.tcc.dto.PointInfo;
import com.ymt.tcc.repository.PointRepository;
import com.ymt.tcc.service.PointService;

/**
 * @author zhailiang
 *
 */
@Service("pointService")
@Transactional
public class PointServiceImpl implements PointService {
	
	@Autowired
	private PointRepository pointRepository;
	
	/* (non-Javadoc)
	 * @see com.ymt.tcc.service.PointService#changePoint(com.ymt.tcc.dto.PointInfo)
	 */
	@Override
	public void changePoint(PointInfo info) {
		Point point = pointRepository.findOne(info.getId());
		point.setAmount(point.getAmount() + info.getAmount());
	}

}
