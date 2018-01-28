package com.revature.drail.dto;

import java.util.List;

public class DrailChartDTO<X, Y> {
	
	private List<OrderedPair<X, Y>> data;
	private int totalPoints;
	
	private Integer stId; 
	private List<Integer> tileIds;
	
	
	

	public DrailChartDTO() {
	}

	public DrailChartDTO(List<OrderedPair<X, Y>> data, int totalPoints) {
		super();
		this.data = data;
		this.totalPoints = totalPoints;
	}

	public List<OrderedPair<X, Y>> getData() {
		return data;
	}

	public void setData(List<OrderedPair<X, Y>> data) {
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
		return "DrailChartDTO [data=" + data + ", totalPoints=" + totalPoints + "]";
	}
	
}
