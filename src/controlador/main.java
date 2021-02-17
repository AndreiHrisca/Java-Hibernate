package controlador;
 
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
import dao.DaoRefrescos;
import modelo.Refresco;
 
public class main {
 
	public static void main(String[] args) throws IOException, SQLException  {
		// TODO Auto-generated method stub
 
		
		//Ejecución insertar
		/*
		Refresco r1 = new Refresco();
		
		
		r1.setNombre("Refresco2");
		r1.setTamano(20);
		r1.setSabor("Vainilla");
		r1.setMarca("Monster");
		r1.setPropiedades("Barata");
		System.out.println(r1.toString());
		r1.insertar();
		*/
		
		//Ejecución Update
		/*
		Refresco r2 = new Refresco();
		r2.setId(9);
		r2.setMarca("RedBull");
		r2.setNombre("DawFresas 2");
		r2.setPropiedades("Salado, saludable");
		r2.setSabor("Chocolate");
		r2.setTamano(3);
		System.out.println(r2.toString());
		r2.update();
		*/
		
		
		//obtener por ID
		/*
		Refresco r3 = new Refresco();
		r3.obtenerPorId(1);
		*/
		
		
		//Delete (recibir primero)
		/*
		r1.delete();
		*/
		
		
		//Ver todos
		/*
		List<Refresco> lista = DaoRefrescos.obtenerListado();
		for (Refresco r : lista) {
			System.out.println(r.toString());
		}
		*/
		
	
		//Buscar por nombre
		/*
		List<Refresco> lista = DaoRefrescos.obtenerListadoPorNombreOpcion("Refresco1");
		for (Refresco r : lista) {
			System.out.println(r.toString());
		}
		*/
		
	}
 
}