/**
 * 
 */
package com.ymt;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import com.ymt.pz365.framework.core.utils.SpringBoot;

/**
 * @author zhailiang
 *
 */
@SpringBootApplication
@ImportResource("classpath:provider.xml")
public class PointApplication {

	public static void main(String[] args) {
		SpringBoot.start(PointApplication.class, args);
	}

}
