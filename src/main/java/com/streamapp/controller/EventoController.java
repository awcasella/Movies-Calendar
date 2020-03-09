package com.streamapp.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.streamapp.models.Evento;
import com.streamapp.repository.EventoRepository;
import com.streamapp.repository.EventoRepositoryJpa;

@Controller
public class EventoController {
	
	@Autowired
	private EventoRepository er;
	
	@Autowired
	private EventoRepositoryJpa erjpa;
	
	private HashMap<Integer, String> months = new HashMap<Integer, String>();
	
	public void initMonths() {
		months.put(1, "Jan");
		months.put(2, "Feb");
		months.put(3, "Mar");
		months.put(4, "Apr");
		months.put(5, "May");
		months.put(6, "Jun");
		months.put(7, "Jul");
		months.put(8, "Aug");
		months.put(9, "Sep");
		months.put(10, "Oct");
		months.put(11, "Nov");
		months.put(12, "Dec");
	}
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public ModelAndView formIndex() {
		ModelAndView mv = new ModelAndView("index");
		
		String currentDate = LocalDate.now().toString();
		List<Evento> evento = erjpa.findByDate(currentDate, JpaSort.unsafe("date"));
		
		mv.addObject("dados1", currentDate);
		mv.addObject("dados2", evento.get(0).getTitle());
		
		return mv;

	}
	
	@RequestMapping(value="/registerMovie", method=RequestMethod.GET)
	public String form() {
		return "_events/formEvento";
	}
	
	@RequestMapping("/movies")
	public ModelAndView listaEventos(){
		String year = "2020";
		initMonths();
		List<List<Evento>> coisa = new ArrayList<List<Evento>>();
		List<Evento> eventos = null;
		ModelAndView mv = new ModelAndView("moviesList");
		for (int m : this.months.keySet()) {
			if (m < 10) {
				eventos = erjpa.findByNameAndSort(year+"-0"+m, JpaSort.unsafe("date"));
			} else {
				eventos = erjpa.findByNameAndSort(year+"-"+m, JpaSort.unsafe("date"));
			}
			coisa.add(eventos);
		}
		mv.addObject("movies", coisa);
		mv.addObject("months", this.months);
		
		return mv;
	}
	
	@RequestMapping(value="/registerMovie", method=RequestMethod.POST)
	public String form(Evento evento) {
		er.save(evento);
		return "redirect:/registerMovie";
	}
	
	@RequestMapping(value="/{code}")
	public ModelAndView moviesDetails(@PathVariable("code") long code) {
		Evento evento = er.findByCode(code);
		ModelAndView mv = new ModelAndView("_events/moviesDetails");
		mv.addObject("movieDetails", evento);
		return mv;
	}
}
