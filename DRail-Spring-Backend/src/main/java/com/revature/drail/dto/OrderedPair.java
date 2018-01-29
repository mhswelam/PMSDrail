package com.revature.drail.dto;

public class OrderedPair {
		
	private long label;
	private int value;
		
    public OrderedPair() {
		// TODO Auto-generated constructor stub
	}

	public OrderedPair(long label, int value) {
		super();
		this.label = label;
		this.value = value;
	}

	public long getLabel() {
		return label;
	}

	public void setLabel(long label) {
		this.label = label;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "OrderedPair [label=" + label + ", value=" + value + "]";
	}
    
    
    
}
