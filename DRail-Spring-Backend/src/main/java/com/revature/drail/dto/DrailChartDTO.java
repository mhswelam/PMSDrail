package com.revature.drail.dto;

import java.util.List;

public class DrailChartDTO {
	
	

	private Integer stId; 
	private List<Integer> tileIds;
	
	

	public DrailChartDTO() {
		
		
	}

	public DrailChartDTO(List<Integer> tileIds, Integer stId ) {
		super();
		this.stId = stId;
		this.tileIds = tileIds;
		
		
	}


	
	public List<Integer> getTileIds() {
		return tileIds;
	}

	public void setTileIds(List<Integer> tileIds) {
		this.tileIds = tileIds;
	}
	
	
	public Integer getStId() {
		return stId;
	}

	public void setStId(Integer stId) {
		this.stId = stId;
	}

	@Override
	public String toString() {
		return "DrailChartDTO [stId=" + stId + ", tileIds=" + tileIds + "]";
	}




	
	
	
	
}
