package com.revature.drail.dto;

public class OrderedPair {
		
	private Long label;
	private Integer value;
		
    public OrderedPair() {
		// TODO Auto-generated constructor stub
	}

	public OrderedPair(Long label, Integer value) {
		super();
		this.label = label;
		this.value = value;
	}

	public Long getLabel() {
		return label;
	}

	public void setLabel(Long label) {
		this.label = label;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "OrderedPair [label=" + label + ", value=" + value + "]";
	}
    
    
    
}
