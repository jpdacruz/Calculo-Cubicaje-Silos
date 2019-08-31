package silos;

public class Celda implements Comparable<Celda> {

	private String nombreCelda;
	private String tipoGrano;
	private double anchoCelda;
	private double largoCelda;
	private double alturaGranoCelda;
	private double totalCelda;
	private double pesoHecto;
	private double metrosCubicos;
	private String tipoCelda;
	private String tipoCeldaMaterial;
	private double altuConoInf;
	private double altuConoSup;
 
	public Celda() {
		super();
	}

	public Celda(String nombreCelda, String tipoCelda, String tipoCeldaMaterial,String tipoGrano, double pesoHecto, double anchoCelda, double largoCelda, double alturaGranoCelda, double altuConoInf, double altuConoSup, double metrosCubicos, double totalCelda) {
		
		super();
		this.nombreCelda = nombreCelda;
		this.tipoGrano = tipoGrano;
		this.anchoCelda = anchoCelda;
		this.largoCelda = largoCelda;
		this.alturaGranoCelda = alturaGranoCelda;
		this.totalCelda = totalCelda;
		this.pesoHecto = pesoHecto;
		this.metrosCubicos = metrosCubicos;
		this.tipoCelda = tipoCelda;
		this.tipoCeldaMaterial = tipoCeldaMaterial;
		this.altuConoInf = altuConoInf;
		this.altuConoSup = altuConoSup;
	}

	public String getNombreCelda() {
		return nombreCelda;
	}

	public void setNombreCelda(String nombreCelda) {
		this.nombreCelda = nombreCelda;
	}

	public String getTipoGrano() {
		return tipoGrano;
	}

	public void setTipoGrano(String tipoGrano) {
		this.tipoGrano = tipoGrano;
	}

	public double getAnchoCelda() {
		return anchoCelda;
	}

	public void setAnchoCelda(double anchoCelda) {
		this.anchoCelda = anchoCelda;
	}

	public double getLargoCelda() {
		return largoCelda;
	}

	public void setLargoCelda(double largoCelda) {
		this.largoCelda = largoCelda;
	}

	public double getAlturaGranoCelda() {
		return alturaGranoCelda;
	}

	public void setAlturaGranoCelda(double alturaGranoCelda) {
		this.alturaGranoCelda = alturaGranoCelda;
	}

	public double getTotalCelda() {
		return totalCelda;
	}

	public void setTotalCelda(double totalCelda) {
		this.totalCelda = totalCelda;
	}
	
	public double getPesoHecto() {
		return pesoHecto;
	}

	public void setPesoHecto(double pesoHecto) {
		this.pesoHecto = pesoHecto;
	}

	public double getMetrosCubicos() {
		return metrosCubicos;
	}

	public void setMetrosCubicos(double metrosCubicos) {
		this.metrosCubicos = metrosCubicos;
	}
	
	public String getTipoCelda() {
		return tipoCelda;
	}

	public void setTipoCelda(String tipoCelda) {
		this.tipoCelda = tipoCelda;
	}

	public String getTipoCeldaMaterial() {
		return tipoCeldaMaterial;
	}

	public void setTipoCeldaMaterial(String tipoCeldaMaterial) {
		this.tipoCeldaMaterial = tipoCeldaMaterial;
	}

	public double getAltuConoInf() {
		return altuConoInf;
	}

	public void setAltuConoInf(double altuConoInf) {
		this.altuConoInf = altuConoInf;
	}

	public double getAltuConoSup() {
		return altuConoSup;
	}

	public void setAltuConoSup(double altuConoSup) {
		this.altuConoSup = altuConoSup;
	}
	
        public String imprimeCelda() {
		
            String datosSilos = "";
            datosSilos+="Numero/Nombre: " + this.getNombreCelda()
			+"\nTipo de celda: " + this.getTipoCelda()
			+"\nMaterial de la celda: " + this.getTipoCeldaMaterial()
			+"\nTipo grano: " + this.getTipoGrano()
			+"\nPH grano: " + this.getPesoHecto()
			+"\nAncho celda: " + this.getAnchoCelda()
			+"\nLargo celda: " + this.getLargoCelda()
			+"\nAltura grano en celda: " + this.getAlturaGranoCelda()
			+"\nCono inferior celda: " + this.getAltuConoInf()
			+"\nCono superior celda: " + this.getAltuConoSup()
			+"\nMetros cubicos celda (m3): " + this.getMetrosCubicos()
			+"\nToneladas celda (tn) : " + this.getTotalCelda()
                        +"\n--------------------------------------------\n";
                                
            return datosSilos;
	}
	
	@Override
	public int compareTo(Celda o) {
            
                String a=String.valueOf(this.getNombreCelda());
                String b=String.valueOf(o.getNombreCelda());
                
            return a.compareTo(b);
   }
	
	
}
