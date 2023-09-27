package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

//GUI

public class Demo01 {
	//Realizar el registro de un nuevo Usuario usando valores fijos
	
	public static void main(String[] args) {
		
		// 1. Obtener la conexión -> Llamar a la unidad de persistencia
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		
		// 2. crear un manejador de entidades
		EntityManager em = fabrica.createEntityManager();
		
		// Procesos
		Usuario u = new Usuario();
		u.setNom_usua("Juan"); 
		u.setApe_usua("Perez");
		u.setUsr_usua("jPerez");
		u.setCla_usua("7854");
		u.setFna_usua("2000/01/15");
		u.setIdtipo(1);
		u.setEst_usua(1);
		
		// Si el proceso es: reg/act/elim -> necesitan : transaccion
		em.getTransaction().begin();
		em.persist(u);
		// Update tb_xxx set campo=?.... where ...
		em.merge(u);
		// Delete from tb_xxx where
		em.remove(u);
		// Select * from tb_xxx where id=?
		Usuario x = em.find(Usuario.class, 1);
		em.getTransaction().commit();
		System.out.println("Registro OK");
		System.out.println("Registro OK");
		
		em.close();
	}
}
