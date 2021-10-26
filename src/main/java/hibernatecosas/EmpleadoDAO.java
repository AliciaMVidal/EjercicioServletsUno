package hibernatecosas;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

public class EmpleadoDAO {
	public static void insertEmpleado(Session s, Empleado e) {
		s.save(e);
	}

	public static Empleado readEmpleado(Session s, int codigo) {
		String hQuery = " from Empleado e " + " where e.codigo = :codigo";
		Empleado em = s.createQuery(hQuery, Empleado.class).setParameter("codigo", codigo).setMaxResults(1)
				.uniqueResult();
		return em;
	}

	public static void updateEmpleado(Session s, Empleado e) {
		s.update(e);
	}

	public static void deleteEmpleado(Session s, Empleado e) {
		// d.getCodigo();
		s.delete(e);
	}

	public static void seleccionarEmpleado(int codigo) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SeleccionarEmpleados");
		EntityManager em = emf.createEntityManager();
		try {

			CriteriaBuilder cb = em.getCriteriaBuilder();

			CriteriaQuery<Empleado> consulta = cb.createQuery(Empleado.class);

			Root<Empleado> empleado = consulta.from(Empleado.class);
			Predicate p1 = null;

			p1 = cb.equal(empleado.get("cod_departamento"), codigo);

			Predicate codigoabuscar = cb.or(p1);

			consulta.select(empleado).where(codigoabuscar);

			List<Empleado> lista = em.createQuery(consulta).getResultList();
			lista.forEach((p) -> {

				System.out.println(p.getNombre());

			});
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			em.close();

		}
	}
}
