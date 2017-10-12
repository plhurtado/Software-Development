
public class Main {

	public static void main(String[] args) {
		Simulador simulador = new Simulador();
		Pantalla pantalla = new Pantalla();

		simulador.start();
		pantalla.run();
	}
}
