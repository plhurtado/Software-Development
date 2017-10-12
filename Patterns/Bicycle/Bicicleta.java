
public class Bicicleta {

	//Atributos
	TC tipo;
	Manillar manillar;
	Cuadro cuadro;
	Rueda ruedaA;
	Rueda ruedaB;
	
	//Constructor
	public Bicicleta (TC tipo){
		this.tipo = tipo;
	}
	
	//Métodos
	public TC getTipo(){
		return this.tipo;
	}
	
	protected void setCuadro (Cuadro cuadro){
		this.cuadro = cuadro;
	}
	
	protected void setManillar (Manillar manillar){
		this.manillar = manillar;
	}
	
	protected void setRuedas (Rueda ruedaa, Rueda ruedab){
		this.ruedaA = ruedaa;
		this.ruedaB = ruedab;
	}
}
