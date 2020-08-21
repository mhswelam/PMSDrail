package com.revature.drail.service;

import com.revature.drail.dto.DrailChartDTO;
import com.revature.drail.dto.DrailChartOutDTO;


/**
 * @author Mohamed
 *Service interface to handle the burn chart
 */
public interface GetBChartService {
	
	
	
	/**
	 * return DrailChartDto to send out to front end.
	 * 
	 * @param chartDto from front end 
	 * @return chartDto with charts values 
	 */
	public DrailChartOutDTO getChartDto(DrailChartDTO chartDto);

}
