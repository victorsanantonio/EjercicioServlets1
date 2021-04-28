package controlador;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import modelo.Departamento;
import modelo.Empleado;

public class Borrar {
	private static Logger logger = LogManager.getLogger(Borrar.class);
	private Session session;

	private void iniciaOperacion() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		session.getTransaction().begin();
		logger.info("Borrado iniciado");
	}

	private void terminaOperacion() {
		session.getTransaction().commit();
		session.close();
		logger.info("Borrado finalizado");
	}
	
	public void borrarEmpleado(Empleado empleado) {
		iniciaOperacion();
		session.delete(empleado);
		logger.info("Empleado borrado. ID: "+empleado.getCodigo());
		terminaOperacion();
	}
	
	public void borrarDepartamento(Departamento departamento) {
		iniciaOperacion();
		session.delete(departamento);
		logger.info("Departamento borrado. ID: "+departamento.getCodigo());
		terminaOperacion();
	}
}
