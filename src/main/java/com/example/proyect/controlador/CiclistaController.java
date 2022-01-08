package com.example.proyect.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.proyect.modelo.Estadistica;
import com.example.proyect.service.EstadisticaService;

@Controller
@RequestMapping("/ciclista") 
public class CiclistaController {

	@Autowired
	private EstadisticaService estadisticaService;

	@GetMapping("")
	public String home(Model model) throws Exception {
		model.addAttribute("listEstadistica", estadisticaService.findAll());
		return "index";
	}

	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("estadistica", new Estadistica());
		return "form";
	}

	@GetMapping("/select")
	public String top(Model model) throws Exception {
		model.addAttribute("listEstadistica", estadisticaService.findByTop());
		return "select"; 
	}

	@PostMapping("/save")
	public String save(Estadistica estadistica) throws Exception {
		estadisticaService.save(estadistica);
		return "redirect:/ciclista";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) throws Exception {
		Estadistica estadistica = estadisticaService.findByIdEstadistica(id);
		model.addAttribute("estadistica", estadistica);
		return "edit";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) throws Exception {
		Estadistica estadistica = estadisticaService.findByIdEstadistica(id);
		if (estadistica != null) {
			estadisticaService.delete(estadistica);
		}
		return "redirect:/ciclista";
	}

}