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
public class InventoryApplication {

	public static void main(String[] args) {
		SpringBoot.start(InventoryApplication.class, args);
	}

}
