
public class BicicletaMontana extends Bicicleta{

	//Constructor
	public BicicletaMontana(){
		super(TC.MONTANA);
		
		setCuadro(new CuadroMontana());
		setManillar(new ManillarMontana());
		setRuedas(new RuedaMontana(), new RuedaMontana());
	}
	
}
