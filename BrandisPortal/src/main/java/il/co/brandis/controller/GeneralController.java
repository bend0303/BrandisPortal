/*
 * @(#)GeneralController.java        22/02/2013
 *
 * Copyright 2013 OB Software Company, Inc. All Rights Reserved.
 *
 * This software is the proprietary information of OB Software Company, Inc. 
 * Use is subject to license terms.
 *
 */
package il.co.brandis.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The GeneralController class represents the controller which will handle all general actions.
*/
@Controller
public class GeneralController {

	static Logger logger = Logger.getLogger(CartController.class.getName());
	
	/**
	 * Redirecting any inner unmapped request to error page
	*/
	@RequestMapping(value="/?*/?*")
	public String innerErrorPage() {
		return "redirect:/error";
	}
	
	/**
	 * Redirecting any unmapped request to error page
	*/
	@RequestMapping(value="/?*")
	public String errorPage() {
		logger.info("Unmapped request has received directing to error page");
		return "generalerror";
	}
}
