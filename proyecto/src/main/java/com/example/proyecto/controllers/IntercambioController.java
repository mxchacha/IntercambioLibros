package com.example.proyecto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.proyecto.models.entities.Intercambio;
import com.example.proyecto.models.service.IIntercambioService;

@Controller
@RequestMapping(value="/intercambio")
public class IntercambioController {
	@Autowired 
	private  IIntercambioService service;
	
	@GetMapping(value="/create") 
	public String create(Model model) {
		Intercambio intercambio = new 	Intercambio();
		model.addAttribute("intercambio", intercambio); 
		model.addAttribute("title", "Registro de nuevo paciente");
		return "intercambio/form";
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		Intercambio intercambio = service.findById(id);
		model.addAttribute("intercambio", intercambio);
		model.addAttribute("title", "Detalle de paciente");
		return "intercambio/card";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model, RedirectAttributes flash) {
		try {
			service.delete(id);
			flash.addFlashAttribute("success", "El registro se eliminó exitosamente");
		}catch(Exception ex) {
			flash.addFlashAttribute("error", "El registro no pudo eliminarse"); 
			ex.getStackTrace();
		}
		return "redirect:/intercambio/list";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		Intercambio intercambio = service.findById(id);
		model.addAttribute("intercambio", intercambio);
		model.addAttribute("title", "Actualizar Intercambio: " + intercambio.getEstado());
		return "intercambio/form";
	}
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Intercambio> list = service.findAll();
		model.addAttribute("tittle", "Listado de intercambio");
		model.addAttribute("list", list);
		return "intercambio/list";
	}
	
	@PostMapping(value="/save")
	public String save(Intercambio intercambio, Model model, RedirectAttributes flash) {
		try {
			service.save(intercambio); //El service ya sabe si es nuevo o un antiguo y lo actualiza
			flash.addFlashAttribute("success", "Registro guardado con éxito");
		}catch(Exception ex) {
			flash.addFlashAttribute("error", "No se pudo guardar");
		}
		return "redirect:/intercambio/list";
	}

}
