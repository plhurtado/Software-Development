
public class Main {
	
	public static void main(String[] args) {
		Interfaz objetivo = new Interfaz();
		GestorFiltros gestorFiltros = new GestorFiltros(objetivo);
		gestorFiltros.setFiltro(new CalcularVelocidad());
		gestorFiltros.setFiltro(new CalcularDistancia());
		Cliente cliente = new Cliente(gestorFiltros);
		
		double sizePeticion = 500.0;
		cliente.enviarPeticion(sizePeticion);
		//if(!pruebaBasica){
			while(true){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(objetivo.getEstado() == EstadoInterfaz.ACELERANDO){
					if(sizePeticion < 1000.0){
						sizePeticion+=50.0;
						cliente.enviarPeticion(sizePeticion);	
					}
				}
				else{
					sizePeticion = 500.0;
				}
			}	
	}
}
