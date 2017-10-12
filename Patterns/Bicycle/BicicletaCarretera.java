
public class BicicletaCarretera extends Bicicleta{
	
	//Constructor
	public BicicletaCarretera(){
		super(TC.CARRETERA);
		
		setCuadro(new CuadroCarretera());
		setManillar(new ManillarCarretera());
		setRuedas(new RuedaCarretera(), new RuedaCarretera());
	}

}
