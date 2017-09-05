/**
 * 
 */
package com.ymt;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.ymt.pz365.framework.core.utils.SpringBoot;

/**
 * @author zhailiang
 *
 */
@SpringBootApplication
@EnableScheduling
@ImportResource({ "classpath:tcc-transaction.xml", 
				  "classpath:tcc-transaction-dubbo.xml", 
				  "classpath:provider.xml" })
public class PointApplication {

	public static void main(String[] args) {
		SpringBoot.start(PointApplication.class, args);
	}

}
