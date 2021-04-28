package controlador;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import modelo.Departamento;
import modelo.Empleado;

public class Consultar {
	//Logger
	private static Logger logger = LogManager.getLogger(Consultar.class);
	private Session session;

	private void iniciaOperacion() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		session.getTransaction().begin();
		logger.info("Inserción iniciada");
	}

	private void terminaOperacion() {
		session.getTransaction().commit();
		session.close();
		logger.info("Inserción finalizada");
	}
	
	public List<Empleado> listarEmpleadosPorDepartamento(int codDepartamento) {
		iniciaOperacion();
		List<Empleado> empleados = null;
		empleados = session.createQuery("from Empleado where codDepartamento=" + codDepartamento).list();
		terminaOperacion();
		logger.info("Empleados del departamento " + codDepartamento + " listados correctamente");
		return empleados;
	}

	public Empleado obtenerEmpleado(int idEmpleado) {
		iniciaOperacion();
		Empleado empleado = null;
		empleado = (Empleado) session.get(Empleado.class, idEmpleado);
		terminaOperacion();
		logger.info("Empleado obtenido a partir del id: " + idEmpleado);
		return empleado;
	}

	public List<Empleado> listarEmpleados() {
		iniciaOperacion();
		List<Empleado> empleados = null;
		empleados = session.createQuery("from Empleado").list();
		terminaOperacion();
		logger.info("Empleados listados correctamente");
		return empleados;
	}

	public Departamento obtenerDepartamento(int idDepartamento) {
		iniciaOperacion();
		Departamento departamento = null;
		departamento = (Departamento) session.get(Departamento.class, idDepartamento);
		terminaOperacion();
		logger.info("Departamento obtenido a partir del id: " + idDepartamento);
		return departamento;
	}

	public List<Departamento> listarDepartamentos() {
		iniciaOperacion();
		List<Departamento> departamentos = null;
		departamentos = session.createQuery("from Departamento").list();
		terminaOperacion();
		logger.info("Departamentos listados correctamente");
		return departamentos;
	}
}
