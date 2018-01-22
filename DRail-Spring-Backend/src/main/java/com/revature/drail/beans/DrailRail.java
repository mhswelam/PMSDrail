package com.revature.drail.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="DRAIL_RAIL")
public class DrailRail {
	
	@Id
	@SequenceGenerator(name="RAIL_SEQ", sequenceName="RAIL_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RAIL_SEQ")
	@Column(name="RAIL_ID")
	private int railId;
	
	@Column(name="RAIL_NAME")
	private String name;
	
	@Column(name="RAIL_ORDER")
	private int order;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="RAIL_S_ID")
	private DrailStation station;
	
	@OneToMany(mappedBy="rail", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	private List<DrailTile> tiles = new ArrayList<>();
	
	public DrailRail() {
	}

	public DrailRail(int railId, String name, int order, DrailStation station, List<DrailTile> tiles) {
		super();
		this.railId = railId;
		this.name = name;
		this.order = order;
		this.station = station;
		this.tiles = tiles;
	}

	public int getRailId() {
		return railId;
	}

	public void setRailId(int railId) {
		this.railId = railId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public DrailStation getStation() {
		return station;
	}

	public void setStation(DrailStation station) {
		this.station = station;
	}

	public List<DrailTile> getTiles() {
		return tiles;
	}

	public void setTiles(List<DrailTile> tiles) {
		this.tiles = tiles;
	}

	@Override
	public String toString() {
		return "DrailRail [railId=" + railId + ", name=" + name + ", order=" + order + ", station=" + station
				+ ", tiles=" + tiles + "]";
	}

}
