package controlador;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import modelo.Departamento;
import modelo.Empleado;

public class Insertar {
	private static Logger logger = LogManager.getLogger(Insertar.class);
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
	
	public void guardarEmpleado(Empleado empleado) {
		iniciaOperacion();
		session.save(empleado);
		logger.info("Empleado guardado. ID: "+empleado.getCodigo());
		terminaOperacion();
	}
	
	public void guardarDepartamento(Departamento departamento) {
		iniciaOperacion();
		session.save(departamento);
		logger.info("Departamento guardado. ID: "+departamento.getCodigo());
		terminaOperacion();
	}
}
