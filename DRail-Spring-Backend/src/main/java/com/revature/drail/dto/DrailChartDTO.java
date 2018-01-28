package com.revature.drail.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DrailChartDTO {
	
	private List<OrderedPair> data;
	private int totalPoints;
	
	private Integer stId; 
	private List<Integer> tileIds;
	
//	private Map<String,String> chart = new HashMap<>();
	

	public DrailChartDTO() {
		
		
	}

	public DrailChartDTO(List<OrderedPair> data, int totalPoints) {
		super();
		this.data = data;
		this.totalPoints = totalPoints;
//		chart.put("caption", "BurnDown Chart");
//		chart.put("subCaption", "BurnDown Chart");
//		chart.put("xAxisName", "Days");
//		chart.put("yAxisName", "Total Project Points");
//		chart.put("showValues", "0");
//		chart.put("theme", "ocean");
	}

	public List<OrderedPair> getData() {
		return data;
	}

	public void setData(List<OrderedPair> data) {
		this.data = data;
	}

	public int getTotalPoints() {
		return totalPoints;
	}

	public void setTotalPoints(int totalPoints) {
		this.totalPoints = totalPoints;
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
		return "DrailChartDTO [data=" + data + ", totalPoints=" + totalPoints + ", stId=" + stId + ", tileIds="
				+ tileIds + "]";
	}

//	public Map<String, String> getChart() {
//		return chart;
//	}
//
//	public void setChart(Map<String, String> chart) {
//		this.chart = chart;
//	}

	
	
}
