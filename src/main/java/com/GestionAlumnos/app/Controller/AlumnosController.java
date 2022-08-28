package com.GestionAlumnos.app.Controller;

 

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.GestionAlumnos.app.Modelo.Alumno;
import com.GestionAlumnos.app.Repository.AlumnoRepository;

@Controller
@RequestMapping("/alumno")
public class AlumnosController {

	@Autowired
	private AlumnoRepository repoAlumno;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("titulo", "Listado de alumnos");
		model.addAttribute("alumnos", repoAlumno.getAlumnos());
		return "alumnos/index";
	}
	@GetMapping("/{nombre}")
	public String editar(Model model, @PathVariable String nombre) {
		Alumno a= repoAlumno.findByNobre(nombre);
		model.addAttribute("alumno",a);
		model.addAttribute("titulo", "Editar alumno "+ nombre +a.getApellido());
		return "alumnos/detalleAlumno";
	}
	
}
