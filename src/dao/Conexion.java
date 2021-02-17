package dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Conexion {

	private static SessionFactory sesion;

	static {
		sesion = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();	
	}

	public static SessionFactory getSession() {
		return sesion;
	}
}