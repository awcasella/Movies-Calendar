package com.streamapp.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.streamapp.models.Evento;
import com.streamapp.repository.EventoRepositoryJpa;

@Controller
public class IndexController {
	
	@Autowired
	private EventoRepositoryJpa erjpa;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView formIndex() {
		ModelAndView mv = new ModelAndView("index");
		
		String currentDate = LocalDate.now().toString();
		List<Evento> evento = erjpa.findByDate(currentDate, JpaSort.unsafe("date"));
		
		String imgUrl = "/imgs/" + evento.get(0).getCode() + ".jpg";
		System.out.println(imgUrl);
		mv.addObject("dados1", imgUrl);
		mv.addObject("movie", evento.get(0));
		
		return mv;
	
	}

}