package com.example.proyecto.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.proyecto.models.entities.Usuario;
import com.example.proyecto.models.service.IUsuarioService;

@Controller
@RequestMapping(value="/usuario")
public class UsuarioController {
	@Autowired 
	private  IUsuarioService service;
	
	@GetMapping(value="/create") 
	public String create(Model model) {
		Usuario usu = new Usuario();
		model.addAttribute("usuario", usu); 
		model.addAttribute("title", "Registro de nuevo Usuario ");
		return "usuario/form";
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		Usuario usu= service.findById(id);
		model.addAttribute("usuario", usu);
		model.addAttribute("title", "Detalle de Usuarios ");
		return "usuario/card";
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
		return "redirect:/usuario/list";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		Usuario usu = service.findById(id);
		model.addAttribute("usuario", usu);
		model.addAttribute("title", "Actualizar usuario : " + usu.getNombre());
		return "usuario/form";
	}
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Usuario> list = service.findAll();
		model.addAttribute("tittle", "Listado de usuarios ");
		model.addAttribute("list", list);
		return "usuario/list";
	}
	
	@PostMapping(value="/save")
	public String save(@Valid Usuario usu,BindingResult result, Model model, RedirectAttributes flash) {
		try {
			if(result.hasErrors())
			{
				if(usu.getIdusuario() == null) {
					model.addAttribute("tittle","Registro de un nuevo Usuario");					
				}
				else {
					model.addAttribute("tittle","Actualizando el registro de " 
							+ usu.getNombre());
				}
				
				return"usuario/form";
			}
			service.save(usu); 
			flash.addFlashAttribute("success", "Registro guardado con éxito");
		}catch(Exception ex) {
			flash.addFlashAttribute("error", "No se pudo guardar");
		}
		return "redirect:/usuario/list";
	}

}
