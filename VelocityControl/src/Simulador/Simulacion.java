/**************
 Implementado por:
 Pedro Hurtado Gozález
 **************/

package Simulador;
public class Simulacion extends ListaObservadoresObservables implements Runnable {
	private final int INTERVALO = 100;
	private PanelEtiquetas p_etiquetas;
	private PanelBotones p_botones; 
	public boolean funcionando;
	int tiempo;
	
	public Simulacion(PanelEtiquetas panelE, PanelBotones panelB){
		p_etiquetas = panelE;
		p_botones = panelB;
		aniadirObservador(panelE);
		aniadirObservador(panelB);
		this.funcionando = true;
		tiempo = 0;
	}
	public PanelEtiquetas getPanelEtiquetas(){
		return p_etiquetas;
	}
	public PanelBotones getPanelBotones(){
		return p_botones;
	}
	public void terminarSimulacion(){
		this.funcionando = false;
	}
	public int getTiempo(){
		return tiempo;
	}
	
	public void run() {
		while(funcionando){
			try{ 
				Thread.sleep(INTERVALO);
				tiempo += INTERVALO;
			}catch(java.lang.InterruptedException e){
				funcionando = false;
				e.printStackTrace();
			}
			notificarObservadores();
		}
	}
}