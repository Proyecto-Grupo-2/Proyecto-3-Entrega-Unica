
package parqueDeAtracciones;

import java.util.ArrayList;

import Empleados.Empelado;
import Empleados.LugarServicio;
import Empleados.Turno;

public class Parque {

		ArrayList<Empelado> listaEmpleado = new ArrayList<Empelado>();
		
		ArrayList<Atraccion> listaAtracciones= new ArrayList<Atraccion>();
		
		ArrayList<Espectaculo> listaEspectaculos= new ArrayList<Espectaculo>();
		
		ArrayList<LugarServicio> listaLugaresServicio= new ArrayList<LugarServicio>();
		
		ArrayList<Usuario> usersList= new ArrayList<Usuario>();
		
		ArrayList<Turno> listaTurnos= new ArrayList<Turno>();

		public Parque(ArrayList<Empelado> listaEmpleado, ArrayList<Atraccion> listaAtracciones,
				ArrayList<Espectaculo> listaEspectaculos, ArrayList<LugarServicio> listaLugaresServicio,
				ArrayList<Usuario> usersList, ArrayList<Turno> listaTurnos) {
			super();
			this.listaEmpleado = listaEmpleado;
			this.listaAtracciones = listaAtracciones;
			this.listaEspectaculos = listaEspectaculos;
			this.listaLugaresServicio = listaLugaresServicio;
			this.usersList = usersList;
			this.listaTurnos = listaTurnos;
		}

		public ArrayList<Empelado> getListaEmpleado() {
			return listaEmpleado;
		}

		public void setListaEmpleado(ArrayList<Empelado> listaEmpleado) {
			this.listaEmpleado = listaEmpleado;
		}

		public ArrayList<Atraccion> getListaAtracciones() {
			return listaAtracciones;
		}

		public void setListaAtracciones(ArrayList<Atraccion> listaAtracciones) {
			this.listaAtracciones = listaAtracciones;
		}

		public ArrayList<Espectaculo> getListaEspectaculos() {
			return listaEspectaculos;
		}

		public void setListaEspectaculos(ArrayList<Espectaculo> listaEspectaculos) {
			this.listaEspectaculos = listaEspectaculos;
		}

		public ArrayList<LugarServicio> getListaLugaresServicio() {
			return listaLugaresServicio;
		}

		public void setListaLugaresServicio(ArrayList<LugarServicio> listaLugaresServicio) {
			this.listaLugaresServicio = listaLugaresServicio;
		}

		public ArrayList<Usuario> getUsersList() {
			return usersList;
		}

		public void setUsersList(ArrayList<Usuario> usersList) {
			this.usersList = usersList;
		}

		public ArrayList<Turno> getListaTurnos() {
			return listaTurnos;
		}

		public void setListaTurnos(ArrayList<Turno> listaTurnos) {
			this.listaTurnos = listaTurnos;
		}
		
		
		public void añadirEmpleado(Empelado empelado) {
			this.listaEmpleado.add(empelado);
		}
		
		public void añadirAtraccion(Atraccion atraccion) {
			this.listaAtracciones.add(atraccion);
		}
		
		public void añadirEspectaculo(Espectaculo espectaculo) {
			this.listaEspectaculos.add(espectaculo);
		}
		
		public void añadirLugarServicio(LugarServicio lugarServicio) {
			this.listaLugaresServicio.add(lugarServicio);
		}
		
		public void añadirUsuario(Usuario usuario) {
			this.usersList.add(usuario);
		}

		public void añadirTurno(Turno turno) {
			this.listaTurnos.add(turno);
		}
		
		
		public Empelado buscarEmpeladoPorId(String id) {
		    for (Empelado emp : listaEmpleado) {
		        if (emp.getIdUnicoEmp().equalsIgnoreCase(id)) {
		            return emp;
		        }
		    }
		    return null;
		}

		public Atraccion buscarAtraccionPorNombre(String nombre) {
		    for (Atraccion a : listaAtracciones) {
		        if (a.getNomAtraccion().equalsIgnoreCase(nombre)) {
		            return a;
		        }
		    }
		    return null;
		}

		public LugarServicio buscarLugarServicioPorNombre(String nombre) {
		    for (LugarServicio l : listaLugaresServicio) {
		        if (l.getNomUnicoLugar().equalsIgnoreCase(nombre)) {
		            return l;
		        }
		    }
		    return null;
		}


}