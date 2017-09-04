/**
 * 
 */
package com.ymt.tcc.repository;

import org.springframework.stereotype.Repository;

import com.ymt.pz365.data.jpa.repository.PzRepository;
import com.ymt.tcc.domain.Point;

/**
 * @author zhailiang
 *
 */
@Repository
public interface PointRepository extends PzRepository<Point> {

}
