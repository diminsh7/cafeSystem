package com.caffeesys.cafesystem.menu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.caffeesys.cafesystem.menu.service.MenuPriceService;

@Controller
public class MenuPriceController {
	
	@Autowired
	MenuPriceService menuPriceService;
}
