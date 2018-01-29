package com.revature.drail.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DrailChartOutDTO {

	private List<OrderedPair> data;
	
	private Map<String,String> chart = new HashMap<>();
	
	
	
	public DrailChartOutDTO() {
		chart.put("caption", "BurnDown Chart");
		chart.put("subCaption", "BurnDown Chart");
		chart.put("xAxisName", "Days");
		chart.put("yAxisName", "Total Project Points");
		chart.put("showValues", "0");
		chart.put("theme", "ocean");
	}



	public DrailChartOutDTO(List<OrderedPair> data, Map<String, String> chart) {
		super();
		this.data = data;
		this.chart = chart;
	}



	public List<OrderedPair> getData() {
		return data;
	}



	public void setData(List<OrderedPair> data) {
		this.data = data;
	}



	public Map<String, String> getChart() {
		return chart;
	}



	public void setChart(Map<String, String> chart) {
		this.chart = chart;
	}



	@Override
	public String toString() {
		return "DrailChartOutDTO [data=" + data + ", chart=" + chart + "]";
	}
	
	
	
}
