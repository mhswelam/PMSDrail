package com.revature.drail.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.revature.drail.beans.DrailRail;
import com.revature.drail.dto.DrailRailDTO;

@RunWith(MockitoJUnitRunner.class)
public class AddRailServiceTest {
	
	@InjectMocks
	DrailRail railOut = new DrailRail(4);
	@InjectMocks
	DrailRailDTO railIn = new DrailRailDTO(railOut);
	
	@Mock
	AddRailServiceImp tileSer;
	
	@Test
	public void addRailTest() {
		
		when(tileSer.addRail(railIn)).thenReturn(railOut);
		
		assertEquals(tileSer.addRail(railIn).getRailId(),railOut.getRailId());
	}
	
	
	

}
