package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import model.Usuario;

//GUI

public class Demo09 {
	//Listado de todos los listados, mostrando además el tipo de usuario
	
	public static void main(String[] args) {
		String usuario = JOptionPane.showInputDialog("Ingrese usuario: ");
		String clave = JOptionPane.showInputDialog("Ingrese clave: ");
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager em = fabrica.createEntityManager();
		
		// 3. Select * from tb_usuarios where usr_usua = ? and cla_usua = ? --> Lista 
		String jpql = "Select u from Usuario u where u.usr_usua = :xusr and u.cla_usua = :xcla";
		try {
			Usuario u = em.createQuery(jpql, Usuario.class).
			//getSingleResult devuelve la primera ocurrencia
					setParameter("xusr", usuario).setParameter("xcla", clave).getSingleResult();
	
			// Mostrar el contenido del Usuario
			JOptionPane.showMessageDialog(null, "Bienvenido " + u.getNom_usua());
			// Abrir la ventana principal
			FrmManteProd v = new FrmManteProd();
			v.setVisible(true);
			// dispose();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: Usuario o clave incorrecto");
		}
		
		em.close();
	}
}
