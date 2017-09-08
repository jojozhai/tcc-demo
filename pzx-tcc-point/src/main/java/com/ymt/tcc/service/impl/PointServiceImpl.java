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
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	/* (non-Javadoc)
	 * @see com.ymt.tcc.service.PointService#changePoint(com.ymt.tcc.dto.PointInfo)
	 */
	@Override
	@Compensable(confirmMethod = "confirmChange", cancelMethod = "cancelChange", transactionContextEditor = DubboTransactionContextEditor.class)
	public void changePoint(PointInfo info) {
		logger.info("point try");
		Point point = pointRepository.findOne(info.getId());
		point.setAmount(point.getAmount() - info.getAmount());
		point.setFreeze(point.getFreeze() + info.getAmount());
	}
	
	public void confirmChange(PointInfo info) {
		logger.info("point confirm");
		Point point = pointRepository.findOne(info.getId());
		point.setFreeze(point.getFreeze() - info.getAmount());
	}
	
	public void cancelChange(PointInfo info) {
		logger.info("point cancel");
		Point point = pointRepository.findOne(info.getId());
		point.setAmount(point.getAmount() + info.getAmount());
		point.setFreeze(point.getFreeze() - info.getAmount());
		
//		throw new RuntimeException("test cancel error");
	}

}
