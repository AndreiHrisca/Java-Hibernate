package dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import modelo.Marca;
import modelo.Refresco;

public class DaoMarca {
	/**
	 * Inserta en la base de datos.
	 * @param r Objeto que pasamos como parametro.
	 * @throws IOException
	 * @throws SQLException
	 */
	public static void insertar(Marca r)throws IOException, SQLException{

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
	public static void update(Marca r) throws IOException, SQLException {

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
	public static void delete(Marca r) throws IOException, SQLException {

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
	public static Marca obtener(int id) throws IOException, SQLException {


		Session sesion = Conexion.getSession().openSession();
		Transaction tx = sesion.beginTransaction();

		Marca res = sesion.get(Marca.class, id);

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
	public static List<Marca> obtenerListado() throws IOException, SQLException{

		Session sesion = Conexion.getSession().openSession();
		Transaction tx = sesion.beginTransaction();
		//Forma deprecate	
		//List<Refresco> res = (List<Refresco>) sesion.createCriteria(Refresco.class).list();

		//Forma posterior
		CriteriaQuery<Marca> cq = sesion.getCriteriaBuilder().createQuery(Marca.class);
		cq.from(Marca.class);
		List<Marca> res = sesion.createQuery(cq).getResultList();



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
	public static List<Marca> obtenerListadoPorNombreOpcion(String nombre) throws IOException, SQLException{

		Session sesion = Conexion.getSession().openSession();
		Transaction tx = sesion.beginTransaction();

		Query consulta = sesion.createQuery("from Marca where nombre = :nombre");
		consulta.setParameter("nombre", nombre);

		List<Marca> res = consulta.getResultList();

		tx.commit();
		sesion.close();
		return res;

	}


}
