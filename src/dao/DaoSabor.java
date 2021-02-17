package dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import modelo.Refresco;
import modelo.Sabor;

public class DaoSabor {
	
	/**
	 * Inserta en la base de datos.
	 * @param r Objeto que pasamos como parametro.
	 * @throws IOException
	 * @throws SQLException
	 */
	public static void insertar(Sabor r)throws IOException, SQLException{

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
	public static void update(Sabor r) throws IOException, SQLException {

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
	public static void delete(Sabor r) throws IOException, SQLException {

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
	public static Sabor obtener(int id) throws IOException, SQLException {


		Session sesion = Conexion.getSession().openSession();
		Transaction tx = sesion.beginTransaction();

		Sabor res = sesion.get(Sabor.class, id);

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
	public static List<Sabor> obtenerListado() throws IOException, SQLException{

		Session sesion = Conexion.getSession().openSession();
		Transaction tx = sesion.beginTransaction();
		//Forma deprecate	
		//List<Refresco> res = (List<Refresco>) sesion.createCriteria(Refresco.class).list();

		//Forma posterior
		CriteriaQuery<Sabor> cq = sesion.getCriteriaBuilder().createQuery(Sabor.class);
		cq.from(Sabor.class);
		List<Sabor> res = sesion.createQuery(cq).getResultList();



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
	public static List<Sabor> obtenerListadoPorNombreOpcion(String nombre) throws IOException, SQLException{

		Session sesion = Conexion.getSession().openSession();
		Transaction tx = sesion.beginTransaction();

		Query consulta = sesion.createQuery("from Sabor where nombre = :nombre");
		consulta.setParameter("nombre", nombre);

		List<Sabor> res = consulta.getResultList();

		tx.commit();
		sesion.close();
		return res;

	}

}
