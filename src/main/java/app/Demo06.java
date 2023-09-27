package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

//GUI

public class Demo06 {
	//Listado de todos los usuarios, segun un criterio(filtro)
	
	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager em = fabrica.createEntityManager();
		
		// 3. Select * from tb_usuarios where --> Lista 
		String jpql = "Select u from Usuario u";
		List<Usuario> lstUsuarios = em.createQuery(jpql, Usuario.class).getResultList();
		
		// 4. Mostrar el contenido el listado
		for (Usuario u : lstUsuarios) {
			System.out.println("Codigo...:" + u.getCod_usua());
			System.out.println("Nombre...:" + u.getNom_usua() + " " + u.getApe_usua());
			System.out.println("Tipo...:" + u.getIdtipo() + "-" + u.getObjTipo().getDescripcion());
			System.out.println("---------------------------");
			
		}
		
		em.close();
	}
}
