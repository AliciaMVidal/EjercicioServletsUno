package hibernatecosas;
import org.hibernate.Session;


public class DepartamentoDAO {
	
	public static void insertDepartamento(Session s, Departamento d) {
		s.save(d);
	}

	public static Departamento readDepartamento(Session s, int codigo) {
		String hQuery = " from Departamento d " + " where d.codigo = :codigo";
		Departamento depart = s.createQuery(hQuery, Departamento.class).setParameter("codigo", codigo)
				.setMaxResults(1).uniqueResult();
		return depart;
	}
	
	public static void updateDepartamento(Session s, Departamento d) {
		s.update(d);
	}
	
	public static void deleteDepartamento(Session s, Departamento d) {
		//d.getCodigo();
		s.delete(d);
	}

}
