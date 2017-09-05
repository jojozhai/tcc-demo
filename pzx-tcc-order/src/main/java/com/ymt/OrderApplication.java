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
@ImportResource({ "classpath:tcc-transaction.xml", 
				  "classpath:tcc-transaction-dubbo.xml", 
				  "classpath:dubbo.xml", 
				  "classpath*:com/ymt/*/*/dubbo/consumer.xml" })
public class OrderApplication {

	public static void main(String[] args) {
		SpringBoot.start(OrderApplication.class, args);
	}

}
