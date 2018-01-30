package com.revature.drail.dto;

import java.time.LocalDate;
import java.util.List;

public class DrailChartOutDTO {

	private List<Integer> data;
	
	private List<Integer> labels;
	
	private int points;
	
	
	public DrailChartOutDTO() {
		
	}



	public DrailChartOutDTO(List<Integer> data, List<Integer> labels) {
		super();
		this.data = data;
		this.labels = labels;
	}



	public List<Integer> getData() {
		return data;
	}



	public void setData(List<Integer> data) {
		this.data = data;
	}



	public List<Integer> getLabels() {
		return labels;
	}



	public void setLabels(List<Integer> labels) {
		this.labels = labels;
	}



	public int getPoints() {
		return points;
	}



	public void setPoints(int points) {
		this.points = points;
	}



	@Override
	public String toString() {
		return "DrailChartOutDTO [data=" + data + ", labels=" + labels + ", points=" + points + "]";
	}





	
	
	
}
