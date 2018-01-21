package com.revature.drail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.revature.drail.repo.DRailURSRepo;
import com.revature.drail.service.AddRailService;

@RestController
public class AddRailCtrl {
	
	
	@Autowired
	AddRailService railser;
	@Autowired
	DRailURSRepo urs;

}
