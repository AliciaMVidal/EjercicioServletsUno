package hibernatecosas;

import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;



public class MenuOpciones {

	private static Logger logger = LogManager.getLogger(Principal.class);

	static SessionFactory sessionFactory;

	static Scanner teclado = new Scanner(System.in);
	static Session session = HibernateUtil.getSessionFactory().openSession();
	static Transaction tx = null;

	public static void menuMostrar() {
		System.out.println("Menu Principal");
		System.out.println("1 - Menu  departamento");
		System.out.println("2 - Menu  empleado");
		System.out.println("3 - Menu ejercicio2");
		System.out.println("4 - Salir");

		logger.info(String.format("Cargar Menu Principal"));
		int opcion = teclado.nextInt();
		if (opcion == 1) {
			MenuOpciones.menuDepartamento();
		}
		if (opcion == 2) {
			MenuOpciones.menuEmpleado();
		}
		if (opcion == 3) {
			MenuOpciones.menuEjercicioDos();
		}
		if (opcion == 4) {
			System.exit(0);
		}

	}

	public static void menuDepartamento() {
		logger.info(String.format("Cargar Menu Departamento"));
		System.out.println("Menu Departamento");
		System.out.println("1 - Añadir departamento");
		System.out.println("2 - Editar departamento");
		System.out.println("3 - Ver departamento");
		System.out.println("4 - Borrar departamento");
		System.out.println("5 - Menu principal");

		int opcion = teclado.nextInt();
		DepartamentoDAO departDao = new DepartamentoDAO();
		if (opcion == 1) {
			System.out.println("Añadir departamento");
			Departamento departamento = new Departamento();
			System.out.println("Codigo");
			departamento.setCodigo(teclado.nextInt());
			System.out.println("Nombre");
			departamento.setNombre(teclado.next());
			System.out.println("Codigo responsable");
			departamento.setCodResponsable(teclado.nextInt());
			tx = session.beginTransaction();
			departDao.insertDepartamento(session, departamento);
			tx.commit();
		}
		if (opcion == 2) {
			System.out.println("Editar departamento");
			Departamento departamento = new Departamento();
			System.out.println("Departamento a editar");
			departamento.setCodigo(teclado.nextInt());
			System.out.println("Nombre");
			departamento.setNombre(teclado.next());
			System.out.println("Codigo responsable");
			departamento.setCodResponsable(teclado.nextInt());
			tx = session.beginTransaction();
			departDao.updateDepartamento(session, departamento);
			tx.commit();
		}
		if (opcion == 3) {
			System.out.println("Ver departamento");
			Departamento departamento = new Departamento();
			System.out.println("Codigo departamento a buscar");
			tx = session.beginTransaction();
			departamento = departDao.readDepartamento(session, teclado.nextInt());
			System.out.println(departamento.toString());
			tx.commit();
		}
		if (opcion == 4) {
			System.out.println("Borrar departamento");
			Departamento departamento = new Departamento();
			System.out.println("Codigo departamento a borrar");
			// departamento.setCodigo(teclado.nextInt());
			tx = session.beginTransaction();
			departamento = departDao.readDepartamento(session, teclado.nextInt());
			departDao.deleteDepartamento(session, departamento);
			tx.commit();

		}
	}

	public static void menuEmpleado() {
		logger.info(String.format("Cargar Menu Principal"));
		System.out.println("Menu Empleado");
		System.out.println("1 - Añadir empleado");
		System.out.println("2 - Editar empleado");
		System.out.println("3 - Ver empleado");
		System.out.println("4 - Borrar empleado");
		System.out.println("5 - Menu principal");
		int opcion = teclado.nextInt();
		EmpleadoDAO empleadoDao = new EmpleadoDAO();
		if (opcion == 1) {
			System.out.println("Añadir Empleado");
			Empleado empleado = new Empleado();
			System.out.println("Codigo");
			empleado.setCodigo(teclado.nextInt());
			System.out.println("Nombre");
			empleado.setNombre(teclado.next());
			System.out.println("Apellido 1");
			empleado.setApellido1(teclado.next());
			System.out.println("Apellido 2");
			empleado.setApellido2(teclado.next());
			System.out.println("Lugar nacimiento");
			empleado.setLugarNacimiento(teclado.next());
			System.out.println("Fecha Nacimiento formato: xx-xx-xx");
			empleado.setFechaNacimiento(teclado.next());
			System.out.println("Direccion");
			empleado.setDireccion(teclado.next());
			System.out.println("Telefono");
			empleado.setTelefono(teclado.next());
			System.out.println("Puesto");
			empleado.setPuesto(teclado.next());
			System.out.println("Codigo departamento");
			empleado.setCodDepartamento(teclado.nextInt());
			tx = session.beginTransaction();
			empleadoDao.insertEmpleado(session, empleado);
			tx.commit();
		}
		if (opcion == 2) {
			System.out.println("Editar empleado");
			Empleado empleado = new Empleado();
			System.out.println("Empleado a editar");
			empleado.setCodigo(teclado.nextInt());
			System.out.println("Nombre");
			empleado.setNombre(teclado.next());
			System.out.println("Apellido 1");
			empleado.setApellido1(teclado.next());
			System.out.println("Apellido 2");
			empleado.setApellido2(teclado.next());
			System.out.println("Lugar nacimiento");
			empleado.setLugarNacimiento(teclado.next());
			System.out.println("Fecha Nacimiento formato: xx-xx-xx");
			empleado.setFechaNacimiento(teclado.next());
			System.out.println("Direccion");
			empleado.setDireccion(teclado.next());
			System.out.println("Telefono");
			empleado.setTelefono(teclado.next());
			System.out.println("Puesto");
			empleado.setPuesto(teclado.next());
			System.out.println("Codigo departamento");
			empleado.setCodDepartamento(teclado.nextInt());
			tx = session.beginTransaction();
			empleadoDao.updateEmpleado(session, empleado);
			tx.commit();
		}
		if (opcion == 3) {
			System.out.println("Ver empleado");
			Empleado empleado = new Empleado();
			System.out.println("Codigo empleado a buscar");
			tx = session.beginTransaction();
			empleado = empleadoDao.readEmpleado(session, teclado.nextInt());
			System.out.println(empleado.toString());
			tx.commit();
		}
		if (opcion == 4) {
			System.out.println("Borrar empleado");
			Empleado empleado = new Empleado();
			System.out.println("Codigo empleado a borrar");
			tx = session.beginTransaction();
			empleado = empleadoDao.readEmpleado(session, teclado.nextInt());
			empleadoDao.deleteEmpleado(session, empleado);
			tx.commit();
		}

	}

	public static void menuEjercicioDos() {
		System.out.println("1 - Devolver trabajadores de un departamento");
		EmpleadoDAO.seleccionarEmpleado(2);
	}
}
