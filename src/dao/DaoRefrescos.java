package dao;



import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;

import modelo.Refresco;

public class DaoRefrescos {
	
	/**
	 * Inserta en la base de datos.
	 * @param r Objeto que pasamos como parametro.
	 * @throws IOException
	 * @throws SQLException
	 */
	public static void insertar(Refresco r)throws IOException, SQLException{

		Session sesion = Conexion.getSession().openSession();
		Transaction tx = sesion.beginTransaction();

		sesion.save(r);

		tx.commit();
		sesion.close();

	}	

	/**
	 * Actualiza el objeto de la base de datos.
	 * @param r Objeto que le pasamos
	 * @throws IOException
	 * @throws SQLException
	 */
	public static void update(Refresco r) throws IOException, SQLException {

		Session sesion = Conexion.getSession().openSession();
		Transaction tx = sesion.beginTransaction();

		sesion.update(r);

		tx.commit();
		sesion.close();


	}

	/**
	 * Borra el objeto de la base de  datos indicandole el objeto.
	 * @param r Objeto que pasamos como parametro.
	 * @throws IOException
	 * @throws SQLException
	 */
	public static void delete(Refresco r) throws IOException, SQLException {

		Session sesion = Conexion.getSession().openSession();
		Transaction tx = sesion.beginTransaction();

		sesion.delete(r);

		tx.commit();
		sesion.close();


	}

	/**
	 * Obtiene el objeto que necesitamos, pasandole el id de dicho objeto.
	 * @param id que queremos obtener
	 * @return
	 * @throws IOException
	 * @throws SQLException
	 */
	public static Refresco obtener(int id) throws IOException, SQLException {


		Session sesion = Conexion.getSession().openSession();
		Transaction tx = sesion.beginTransaction();

		Refresco res = sesion.get(Refresco.class, id);

		tx.commit();
		sesion.close();
		return res;

	}


	/**
	 * Obtiene todos los objetos de la base de datos.
	 * @return
	 * @throws IOException
	 * @throws SQLException
	 */
	public static List<Refresco> obtenerListado() throws IOException, SQLException{

		Session sesion = Conexion.getSession().openSession();
		Transaction tx = sesion.beginTransaction();
		//Forma deprecate	
		//List<Refresco> res = (List<Refresco>) sesion.createCriteria(Refresco.class).list();

		//Forma posterior
		CriteriaQuery<Refresco> cq = sesion.getCriteriaBuilder().createQuery(Refresco.class);
		cq.from(Refresco.class);
		List<Refresco> res = sesion.createQuery(cq).getResultList();



		tx.commit();
		sesion.close();
		return res;

	}



	
	/**
	 * Obtiene un objeto indicandole el nombre.
	 * @param nombre que le pasas como parametro.
	 * @return
	 * @throws IOException
	 * @throws SQLException
	 */
	public static List<Refresco> obtenerListadoPorNombreOpcion(String nombre) throws IOException, SQLException{

		Session sesion = Conexion.getSession().openSession();
		Transaction tx = sesion.beginTransaction();

		Query consulta = sesion.createQuery("from Refresco where nombre = :nombre");
		consulta.setParameter("nombre", nombre);

		List<Refresco> res = consulta.getResultList();

		tx.commit();
		sesion.close();
		return res;

	}


}