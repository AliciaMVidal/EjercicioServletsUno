package hibernatecosas;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Principal {
	
	
	private static Logger logger = LogManager.getLogger(Principal.class);
	

	
	public static void main(String[] args) {

		logger.info(String.format("Cargar Menu"));
		MenuOpciones.menuMostrar();
		
		


	}

}
