package startup;


/**
 * Grupo 7
 * João Ferreira Nº54600
 * João Ascenso Nº56939
 * Tiago Pereira Nºfc55854
 */

import javafx.application.Application;
import view.MainView;
/**
 * Classe que implementa o caso de uso startup usando uma
 * interface com o utilizador grafica
 * @author fmartins
 *
 */
public class StartUp {

	public static void main(String[] args) {
		// Quando ja' quiserem testar a aplicacao sobre o vosso
		// objeto inicial usam a seguinte instrucao em vez da outra:
		// MainView.setApp(new domain.OCT());
		MainView.setApp(new domain.stubs.OCT());
		Application.launch(MainView.class);
	}

}
