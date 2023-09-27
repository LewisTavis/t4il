package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Producto;
import model.Usuario;

//GUI

public class Demo07 {
	//Listado de todos los productos, mostrando nombre del proveedor y nombre de categoria
	
	public static void main(String[] args) {
		
		// 1. Obtener la conexión -> Llamar a la unidad de persistencia
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		
		// 2. crear un manejador de entidades
		EntityManager em = fabrica.createEntityManager();
		
		// 3. Select * from tb_usuarios --> Lista 
		String jpql = "Select p from Producto p";
		List<Producto> lstProductos = em.createQuery(jpql, Producto.class).getResultList();
		
		// 4. Mostrar el contenido el listado
		for (Producto p : lstProductos) {
			System.out.println("Codigo...:" + p.getId_prod());
			System.out.println("Nombre...:" + p.getDes_prod());
			System.out.println("Categoria...:" + p.getObjCategoria().getDescripcion());
			System.out.println("Proveedor...:" + p.getObjProveedor().getNombre_rs());
			System.out.println("---------------------------");
			
		}
		
		em.close();
	}
}
