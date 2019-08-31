package silos;

import javax.swing.JOptionPane;

public class Silo implements Comparable<Silo>{ // SE IMPLEMENTA PARA LA FUNCION public int compareTo(Silo o)
	
	private String nombreSilo;
	private String tipoGrano;
	private double diametro;
	private double alturaGrano;
	private String tipoCono;
	private double altuCono;
	private double altuCopete;
	private double totalSilo;
	private double metrosCubicos;
	private double pesoHecto;
	private String tipoSilo;
	
	public Silo() {
		super();
	}

	public Silo(String nombreSilo, String tipoSilo, String tipoGrano, double pesoHecto, double diametro, double alturaGrano, String tipoCono,
			double altuCono, double altuCopete, double metrosCubicos, double totalSilo) {
		super();
                //SE PODRIAN HACER LOS CALCULOS EN EL CONSTRUCTOR, PERO SE OPTA POR HACERLOS EN LA CLASE GESTION PARA DEJAR ELCODIGO DEL CONSTRUCTOR MAS LIMPIO
		this.nombreSilo = nombreSilo;
		this.tipoGrano = tipoGrano;
		this.diametro = diametro;
		this.alturaGrano = alturaGrano;
		this.tipoCono = tipoCono;
		this.altuCono = altuCono;
		this.altuCopete = altuCopete;
		this.metrosCubicos = metrosCubicos;
		this.totalSilo = totalSilo;
		this.pesoHecto = pesoHecto;
		this.tipoSilo = tipoSilo;
	}

	public String getNombreSilo() {
		return nombreSilo;
	}

	public void setNombreSilo(String nombreSilo) {
		this.nombreSilo = nombreSilo;
	}

	public String getTipoGrano() {
		return tipoGrano;
	}

	public void setTipoGrano(String tipoGrano) {
		this.tipoGrano = tipoGrano;
	}

	public double getDiametro() {
		return diametro;
	}

	public void setDiametro(double diametro) {
		this.diametro = diametro;
	}

	public double getAlturaGrano() {
		return alturaGrano;
	}

	public void setAlturaGrano(double alturaGrano) {
		this.alturaGrano = alturaGrano;
	}

	public String getTipoCono() {
		return tipoCono;
	}

	public void setTipoCono(String tipoCono) {
		this.tipoCono = tipoCono;
	}

	public double getAltuCono() {
		return altuCono;
	}

	public void setAltuCono(double altuCono) {
		this.altuCono = altuCono;
	}

	public double getAltuCopete() {
		return altuCopete;
	}

	public void setAltuCopete(double altuCopete) {
		this.altuCopete = altuCopete;
	}

	public double getTotalSilo() {
		return totalSilo;
	}

	public void setTotalSilo(double totalSilo) {
		this.totalSilo = totalSilo;
	}
	
	
	public double getMetrosCubicos() {
		return metrosCubicos;
	}

	public void setMetrosCubicos(double metrosCubicos) {
		this.metrosCubicos = metrosCubicos;
	}

	public double getPesoHecto() {
		return pesoHecto;
	}

	public void setPesoHecto(double pesoHecto) {
		this.pesoHecto = pesoHecto;
	}
	
	public String getTipoSilo() {
		return tipoSilo;
	}

	public void setTipoSilo(String tipoSilo) {
		this.tipoSilo = tipoSilo;
	}

	public String imprimeSilo() { //SE PODRIA UTILIZAR FUNCION TOSTRING, PERO SE OPTA POR LA VIEJA ESCUELA PARA TENER MEJOR LEGILIBIDAD EN LA VISTA DEL USUARIO
		
            String datosSilos = "";
            datosSilos+="Numero/Nombre Silo : " + this.getNombreSilo()
			+"\nTipo de Silo: " + this.getTipoSilo()
			+"\nTipo Grano: " + this.getTipoGrano()
			+"\nPeso Hectolitrico: " + this.getPesoHecto()
			+"\nDiametro: " + this.getDiametro()
			+"\nAltura Grano: " + this.getAlturaGrano()
			+"\nTipo Cono: " + this.getTipoCono()
			+"\nAltura Cono: " + this.getAltuCono()
			+"\nAltura Copete: " + this.getAltuCopete()
			+"\nMetros Cubicos (m3): " + this.getMetrosCubicos()
			+"\nToneladas silo (tn): " + this.getTotalSilo()
                        +"\n--------------------------------------------\n";
            
            return datosSilos;
	}
		
	@Override
	public int compareTo(Silo o) { // FUNCION  APLICADA EN ELIMINAR SILOS
            
            String a=String.valueOf(this.getNombreSilo());
            String b=String.valueOf(o.getNombreSilo());
            
            return a.compareTo(b);
   }
}
