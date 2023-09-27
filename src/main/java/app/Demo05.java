package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

//GUI

public class Demo05 {
	//Listado de todos los listados	1
	
	public static void main(String[] args) {
		
		// 1. Obtener la conexión -> Llamar a la unidad de persistencia
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		
		// 2. crear un manejador de entidades
		EntityManager em = fabrica.createEntityManager();
		
		// 3. Select * from tb_usuarios --> Lista 
		String jpql = "Select u from Usuario u";
		List<Usuario> lstUsuarios = em.createQuery(jpql, Usuario.class).getResultList();
		
		// 4. Mostrar el contenido el listado
		for (Usuario u : lstUsuarios) {
			System.out.println("Codigo...:" + u.getCod_usua());
			System.out.println("Nombre...:" + u.getNom_usua() + " " + u.getApe_usua());
			System.out.println("Tipo...:" + u.getIdtipo());
			System.out.println("---------------------------");
			
		}
		
		em.close();
	}
}
