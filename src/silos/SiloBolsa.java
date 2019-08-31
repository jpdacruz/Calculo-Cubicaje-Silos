package silos;

import javax.swing.JOptionPane;

public class SiloBolsa implements Comparable<SiloBolsa>{
	
	private String nombreSiloB;
	private String tipoGrano;
	private double pesoHecto;
	private double largoSB;
	private double anchoSB;
	private double alturaBase;
	private double alturaParabola;
	private double metrosCubicosSB;
	private double toneladasSB;
	
	public SiloBolsa(String nombreSiloB, String tipoGrano, double pesoHecto, double largoSB, double anchoSB,
			double alturaBase, double alturaParabola, double metrosCubicosSB, double toneladasSB) {
		super();
		this.nombreSiloB = nombreSiloB;
		this.tipoGrano = tipoGrano;
		this.pesoHecto = pesoHecto;
		this.largoSB = largoSB;
		this.anchoSB = anchoSB;
		this.alturaBase = alturaBase;
		this.alturaParabola = alturaParabola;
		this.metrosCubicosSB = metrosCubicosSB;
		this.toneladasSB = toneladasSB;
	}

	public String getNombreSiloB() {
		return nombreSiloB;
	}

	public void setNombreSiloB(String nombreSiloB) {
		this.nombreSiloB = nombreSiloB;
	}

	public String getTipoGrano() {
		return tipoGrano;
	}

	public void setTipoGrano(String tipoGrano) {
		this.tipoGrano = tipoGrano;
	}

	public double getPesoHecto() {
		return pesoHecto;
	}

	public void setPesoHecto(double pesoHecto) {
		this.pesoHecto = pesoHecto;
	}

	public double getLargoSB() {
		return largoSB;
	}

	public void setLargoSB(double largoSB) {
		this.largoSB = largoSB;
	}

	public double getAnchoSB() {
		return anchoSB;
	}

	public void setAnchoSB(double anchoSB) {
		this.anchoSB = anchoSB;
	}

	public double getAlturaBase() {
		return alturaBase;
	}

	public void setAlturaBase(double alturaBase) {
		this.alturaBase = alturaBase;
	}

	public double getAlturaParabola() {
		return alturaParabola;
	}

	public void setAlturaParabola(double alturaParabola) {
		this.alturaParabola = alturaParabola;
	}

	public double getMetrosCubicosSB() {
		return metrosCubicosSB;
	}

	public void setMetrosCubicosSB(double metrosCubicosSB) {
		this.metrosCubicosSB = metrosCubicosSB;
	}

	public double getToneladasSB() {
		return toneladasSB;
	}

	public void setToneladasSB(double toneladasSB) {
		this.toneladasSB = toneladasSB;
	}

        public String imprimeSiloBolsa() {
		
            String datosSilos = "";
            datosSilos+="Numero/Nombre: " + this.getNombreSiloB()
			+"\nTipo grano: " + this.getTipoGrano()
			+"\nPH grano: " + this.getPesoHecto()
			+"\nAncho silo bolsa: " + this.getAnchoSB()
			+"\nLargo silo bolsa: " + this.getLargoSB()
			+"\nAltura de la base: " + this.getAlturaBase()
			+"\nAltura de la parabola: " + this.getAlturaParabola()
			+"\nMetros cubicos silo bolsa (m3): " + this.getMetrosCubicosSB()
			+"\nToneladas silo bolsa (tn):  " + this.getToneladasSB()
                        +"\n--------------------------------------------\n";
                                
            return datosSilos;
	}
	
	@Override
	public int compareTo(SiloBolsa o) {
            
                String a=String.valueOf(this.getNombreSiloB());
                String b=String.valueOf(o.getNombreSiloB());
       
            return a.compareTo(b);
   }
}


