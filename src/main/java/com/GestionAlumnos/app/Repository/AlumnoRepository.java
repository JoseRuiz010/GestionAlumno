package com.GestionAlumnos.app.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;
import com.GestionAlumnos.app.Modelo.Alumno;

@Repository
public class AlumnoRepository {

	private  ArrayList<Alumno> alumnos;

 
	public AlumnoRepository() {
		this.CargarDatos();
	}
	
	public void CargarDatos() {
		alumnos= new ArrayList<Alumno>();
		Alumno alumno= new Alumno();
		alumno.setNombre("Jose");
		alumno.setApellido("Ruiz");
		alumno.setTelefono("Jose");
		alumno.setFechaNacimiento(new Date("10/11/1997"));
		alumno.setLegajo("Joruiz765@gmail.com");
		
		Alumno alumno2= new Alumno();
		alumno2.setNombre("Carlos");
		alumno2.setApellido("Ruiz");
		alumno2.setTelefono("3814463721");
		alumno2.setFechaNacimiento(new Date("22/06/2001"));
		alumno2.setLegajo("carruiz765@gmail.com");
		alumnos.add(alumno2);
		alumnos.add(alumno);
		
	}

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = (ArrayList<Alumno>) alumnos;
	}
	public Alumno findByNobre(String nombre) {
		return alumnos.stream().filter(a->a.getNombre().equals(nombre)).collect(Collectors.toList()).get(0);
	}

	 
}
