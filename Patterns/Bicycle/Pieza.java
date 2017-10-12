
public abstract class Pieza {
	//Atributos
	private TC tipo;
	
	//Constructor
	public Pieza (TC tipo){
		this.tipo = tipo;
	}
	
	//Métodos
	public TC getTipo (){
		return this.tipo;
	}
	
}
