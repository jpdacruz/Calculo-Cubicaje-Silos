package silos;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class Gestion {

	static ArrayList<Silo> silos = new ArrayList<Silo>(); //ARRAYLIST DE SILOS,
	static ArrayList<Celda> celdas = new ArrayList<Celda>(); //CELDAS Y SILOBOLSAS. SE USA ARRAY LIST DEBIDO A QUE NO SE SABEN LA CANTIDAD DE SILO QUE VAN A HABER
	static ArrayList<SiloBolsa> silosB = new ArrayList<SiloBolsa>();
	
	static double totalCubicajeTrigo; //VARIABLES GLOBALES PARA LOS TOTALES DEL CUBICAJE
	static double totalCubicajeMaiz;
	static double totalCubicajeSoja;
	static double totalCubicaje;
	
	public static void agregarSilo() {
                    
        //declaracion de las variables que se van a usar en las funciones
		double radioC; double radio2; double alturaGrano; double volumenCilindro; double cono; double largoChapa;
                double altGranoChapas; double diametro; int cantChapasAncho; double altoChapas;
                double copete; double pesoHecto; double metrosCubicos = 0; double totalSilo = 0; double ph = 0; double altuCono = 0; double altuCopete = 0;
			
                String [] tiposGranos = {"Trigo","Maiz","Soja"};
		String [] tiposConos = {"Recto", "Sin Cono"};
		String [] tipoSiloMaterial = {"Chapa","Chapa Aereo","Hormigon"};
                String [] tiposCopetes = {"Positivo","Negativo","Raso"};
		
		
                String nombreSilo = JOptionPane.showInputDialog("Ingrese numero/nombre del silo: ");
		String tipoSilo = (String) JOptionPane.showInputDialog(null, "Tipo de silo? (Material)", "Material", JOptionPane.DEFAULT_OPTION, null, tipoSiloMaterial, tipoSiloMaterial[0]);
		String tipoGrano = (String) JOptionPane.showInputDialog(null, "Selecciones tipo de grano", "Grano", JOptionPane.DEFAULT_OPTION, null, tiposGranos, tiposGranos[0]);
		
		if ("Trigo".equals(tipoGrano))  {ph = 0.80;} //VALORES POR DEFECTO DEL PESO HECTOLITRICO DEL GRANO SELECCIONADO
		if ("Maiz".equals(tipoGrano))   {ph = 0.75;}
		if ("Soja".equals(tipoGrano))   {ph = 0.65;}
		
                pesoHecto = ingresarDatosDouble(null, "Ingrese PH grano: ", ph);
                largoChapa = ingresarDatosDouble(null, "Largo de las chapas: (0 si conoce el diametro)", 0);
		cantChapasAncho = ingresarDatosEnteros(null, "Cantidad de chapas en ancho: (0 si conoce el diametro)", 0);
                altoChapas = ingresarDatosDouble(null, "Alto de chapas: ", 0);
                altGranoChapas = ingresarDatosDouble(null, "Altura del grano en chapas: ", 0);
                diametro = ingresarDatosDouble(null, "Diametro, (0 si ingreso datos del perimetro: ", 0);
                
                if (diametro==0){diametro = (largoChapa*cantChapasAncho)/Math.PI;} //CALCULO VOLUMEN DEL CILINDRO
                    radioC = diametro/2;
                    radio2 = radioC * radioC;
                    alturaGrano = altoChapas * altGranoChapas;
                    volumenCilindro = (Math.PI * radio2 * alturaGrano);
                
                //CALCULO DEL CONO DEL SILO    
                String tipoCono = (String) JOptionPane.showInputDialog(null, "Seleccione tipo de cono: ", "Cono", JOptionPane.DEFAULT_OPTION, null, tiposConos, tiposConos[0]);
			
		if ("Recto".equals(tipoCono)){ 
			
                    altuCono = ingresarDatosDouble(null, "Altura Cono: 0 para que lo calcule el sistema", 0);
                                               
                    if (altuCono == 0) { // SI SE PONE EL VALOR 0 POR DEFECTO LO CALCULA EN BASE A FORMULA
			altuCono = (diametro/2)*0.7;
                        }
                    }
			
                    if ("Sin Cono".equals(tipoCono)) {
			altuCono = 0;
                    }
                        
                    cono = (Math.PI * radio2 * altuCono)/3;
                    
                //CALCULO DEL COPETE DEL SILO 3 TIPOS DE COPETE POSITIVO, NEGATIVO, RASO    
                
                String tipoCopete = (String) JOptionPane.showInputDialog(null,"Seleccion tipo de copete: ", "Copete", JOptionPane.DEFAULT_OPTION, null, tiposCopetes, tiposCopetes[0]);
                        
                if("Positivo".equals(tipoCopete)){ 
                            
                    altuCopete = ingresarDatosDouble(null, "Altura Copete: 0 para que lo calcule el sistema",0 );
                    
                    if (altuCopete == 0) { //SI SE INGRESO EL VALOR 0 POR DEFECTO LO CALCULA EN BASE A FORMULA
                        
                        altuCopete = (diametro/2) *0.5; 
                    }
                            
                    copete = (Math.PI* radio2 * altuCopete) /3;
                    metrosCubicos = (volumenCilindro+cono+copete); //SELECCIONADO POSITIVO, SUMA COPETE
                    totalSilo = metrosCubicos*pesoHecto;
                }
                        
                if("Negativo".equals(tipoCopete)){
                            
                    altuCopete = ingresarDatosDouble(null, "Altura Copete: 0 para que lo calcule el sistema",0 );
                            
                    if (altuCopete == 0) { 
                    	altuCopete = (diametro/2) *0.5;
                    }
                            
                    copete = (Math.PI* radio2 * altuCopete) /3;
                    metrosCubicos = (volumenCilindro+cono-copete);//SELECCIONADO NEGATIVO RESTA EL COPETE
                            totalSilo = metrosCubicos*pesoHecto;
                            
                        }
                        
		if("Raso".equals(tipoCopete)){
                            
                    metrosCubicos = (volumenCilindro+cono); ////SELECCIONADO RASO NO TOMA EN CUENTA EL COPETE
                    totalSilo = metrosCubicos*pesoHecto;
                            
                }
			
		Silo s = new Silo(nombreSilo, tipoSilo, tipoGrano, pesoHecto, diametro, alturaGrano, tipoCono, altuCono, altuCopete, metrosCubicos, totalSilo);
                String datos = s.imprimeSilo(); //FINCION IMPRIME SILO EN CLASE SILO PARA MOSTRAR DATOS DEL SILO
                JOptionPane.showMessageDialog(null, datos);
		silos.add(s); //AGREGA EL SILO AL ARRAYLIST
                        
	}

	public static void agregarCelda() { //MISMAS ANOTACIONES QUE AGREGARSILO()
		
		double totalCelda = 0; double ph = 0; double metrosCubicos = 0;double altuConoInf =0;double altuConoSup= 0; double pesoHecto;double anchoCelda;
		double largoCelda;double alturaGranoCelda;
		String [] tiposGranos = {"Trigo","Maiz","Soja"};
		String [] tiposCeldas = {"Galpon","Celda piso conico","Celda piso traposiodal"};
		String [] tipoCeldaMat = {"Hormigon", "Chapa", "Otros materiales"};
		String nombreCelda = JOptionPane.showInputDialog("Ingrese numero/nombre de la Celda: ");
		String tipoCelda = (String) JOptionPane.showInputDialog(null, "Tipo de Celda?", "Tipo", JOptionPane.DEFAULT_OPTION, null, tiposCeldas, tiposCeldas[0]);
		String tipoCeldaMaterial = (String) JOptionPane.showInputDialog(null, "Tipo de Celda? (Material)", "Material", JOptionPane.DEFAULT_OPTION, null, tipoCeldaMat, tipoCeldaMat[0]);
		String tipoGrano = (String) JOptionPane.showInputDialog(null, "Selecciones tipo de grano", "Grano",JOptionPane.DEFAULT_OPTION, null, tiposGranos, tiposGranos[0]);
		
		if ("Trigo".equals(tipoGrano)){ ph = 0.80;}
		if ("Maiz".equals(tipoGrano)) {	ph = 0.75;}
		if ("Soja".equals(tipoGrano)) {	ph = 0.65;}
                
                pesoHecto = ingresarDatosDouble(null, "Ingrese PH Grano: ", ph);
                anchoCelda = ingresarDatosDouble(null, "Ancho de la celda: ", 0);
                largoCelda = ingresarDatosDouble(null, "Largo de la celda: ", 0);
                alturaGranoCelda = ingresarDatosDouble(null, "Altura del grano: ", 0);
                		
		if ("Celda piso conico".equals(tipoCelda)) {
			
                    altuConoInf = ingresarDatosDouble(null, "Altura cono inferior: ", 0);
                    altuConoSup = ingresarDatosDouble(null, "Altura cono superior: 0 si esta al ras", 0); 
                    
                    metrosCubicos = (anchoCelda*largoCelda*alturaGranoCelda) + ((anchoCelda*largoCelda*altuConoInf)/2) + ((anchoCelda*largoCelda*altuConoSup)/2);
                    totalCelda= metrosCubicos * pesoHecto;
                
                }
		
		if ("Celda piso traposiodal".equals(tipoCelda)) {
			
                    altuConoInf = ingresarDatosDouble(null, "Altura cono inferior: ", 0);
                    altuConoSup = ingresarDatosDouble(null, "Altura cono superior: 0 si esta al ras", 0);
			
                    metrosCubicos = (largoCelda*anchoCelda*alturaGranoCelda) + ((largoCelda*anchoCelda*altuConoSup/2) + (largoCelda-(altuConoInf*0.577*2))*(anchoCelda-(altuConoInf*0.577*2))*altuConoInf);
                    totalCelda= metrosCubicos * pesoHecto;
			
		}
		
		if ("Galpon".equals(tipoCelda)) {
			
                    altuConoSup = ingresarDatosDouble(null, "Altura cono superior: 0 si esta al ras", 0);
                        
                    metrosCubicos = (anchoCelda*anchoCelda*alturaGranoCelda)+(largoCelda*anchoCelda*altuConoSup/2) ;
                    totalCelda= metrosCubicos * pesoHecto;
			
		}
				
		Celda c = new Celda(nombreCelda, tipoCelda, tipoCeldaMaterial, tipoGrano,  pesoHecto, anchoCelda, largoCelda, alturaGranoCelda, altuConoInf, altuConoSup, metrosCubicos, totalCelda);
		String datos = c.imprimeCelda();
                JOptionPane.showMessageDialog(null, datos);
                celdas.add(c);
					
	}

	public static void agregarSiloBolsa() { // MISMAS ANOTACIONES QUE AGREGARSILO
	
		double ph = 0; double rectangulo; double parabola; double metrosCubicosSB; double toneladasSB;double pesoHecto;double anchoSB;
                double largoSB;double alturaBase;double alturaParabola;
		String [] tiposGranos = {"Trigo","Maiz","Soja"};
		
		String nombreSiloB = JOptionPane.showInputDialog("Ingrese numero/nombre del silo bolsa: ");
		
		String tipoGrano = (String) JOptionPane.showInputDialog(null, "Selecciones tipo de grano", "Grano",JOptionPane.DEFAULT_OPTION, null, tiposGranos, tiposGranos[0]);
		if ("Trigo".equals(tipoGrano)){	ph = 0.80;}
		if ("Maiz".equals(tipoGrano)) {	ph = 0.75;}
		if ("Soja".equals(tipoGrano)) {	ph = 0.65;}
		
                pesoHecto = ingresarDatosDouble(null, "Ingrese PH Grano: ", ph);
                anchoSB = ingresarDatosDouble(null, "Ancho del silo bolsa: ", 0);
                largoSB = ingresarDatosDouble(null, "Largo del silo bolsa: ", 0);
		alturaBase = ingresarDatosDouble(null, "Altura de la base del silo bolsa: ", 0);
                alturaParabola = ingresarDatosDouble(null, "Altura de la parabola del silo bolsa: ", 0);

		rectangulo = (anchoSB * largoSB * alturaBase);
		parabola = (((anchoSB * largoSB * alturaParabola)*2)/3);
		metrosCubicosSB = rectangulo + parabola;
		toneladasSB = metrosCubicosSB * pesoHecto;
		
		SiloBolsa sb = new SiloBolsa(nombreSiloB, tipoGrano, pesoHecto, largoSB, anchoSB, alturaBase, alturaParabola, metrosCubicosSB, toneladasSB);
		String datos = sb.imprimeSiloBolsa();
                JOptionPane.showMessageDialog(null, datos);
                silosB.add(sb);
			
	}

	public static void eliminarSilo() {
		
		listarSilos(); //PRIMERO LISTA LOS SILOS
		
		String nombreaBorrar = JOptionPane.showInputDialog("Escribe el nombre del silo a borrar: ");
		
		boolean encontrado = false;
	
		Iterator<Silo> it2 = silos.iterator(); //APLICA UN ITERADOR DE ARRALIST PARA BUSCAR SI EXISTE EL SILO INGRESADO, SI NO VUELVE AL MENU PRINCIPAL
			while ((it2.hasNext())&& (encontrado == false)) { //MIENTRAS EL ITERADOR TENGO UN SIGUIENTE Y NO SE HAYA ENCONTRADO (FALSE)
			Silo s = it2.next();                               // S VA A TENER EL VALOR DEL SIGUIENTE REGISTRO EN EL ARRAY LIST
				if (s.getNombreSilo().compareTo(nombreaBorrar)==0) { //COMPARE TO FUNCION CREADA EN LA CLASE SILO, 
				it2.remove();                                       //SE ENVIA POR PARAMETRO EL NOMBREABORRAR Y LO COMPARA CON EL SILO QUE SE ESTA RECORRIENDO EN ESE MOMENTO
				encontrado = true;                                  // LO BORRA Y DEVUELVE ENCONTRADO TRUE
			}
		}
	}

	public static void eliminarCelda() { //IDEM DE ELIMINAR SILOS
		
		listarCeldas();
		
		String nombreaBorrar = JOptionPane.showInputDialog("Escribe el nombre de la celda a borrar: ");
		
		boolean encontrado = false;
			
		Iterator<Celda> ic2 = celdas.iterator();
			while ((ic2.hasNext())&& (encontrado == false)) {
			Celda c = ic2.next();
				if (c.getNombreCelda().compareTo(nombreaBorrar)==0) {
				ic2.remove();
				encontrado = true;
			}
		}	
	}

	public static void eliminarSiloBolsa() { //IDEM DE ELIMINAR SILOS
		
		listarSilosBolsa();
		
		String nombreaBorrar = JOptionPane.showInputDialog("Escribe el nombre del silo bolsa a borrar: ");
		
		boolean encontrado = false;
	
		Iterator<SiloBolsa> isb2 = silosB.iterator();
			while ((isb2.hasNext())&& (encontrado == false)) {
			SiloBolsa sb2 = isb2.next();
				if (sb2.getNombreSiloB().compareTo(nombreaBorrar)==0) {
				isb2.remove();
				encontrado = true;
			}
		}
	}


	public static void listarSilos() {
            
		String datosSilos = "";
		Collections.sort(silos); //ARMA UNA COLECCIONES DE SILOS
		Iterator<Silo> it = silos.iterator(); //ITERADOR PARA RECORRER LA COLECCION DE SILOS
		while (it.hasNext()) { //MIENTRAS TENGAMOS UN SIGUIENTE HAGA
			Silo s =it.next(); //ASIGNA EL VALOR A S DEL OBJETO ACTUAL DEL ARRAYLIST
			datosSilos += s.imprimeSilo(); //RELLENA DATOSILOS CON EN DATO DE ESE OBJETO
		}
                if ("".equals(datosSilos)){ //CICLO IF PARA MOSTRAR MSJ DE QUE NO HAY SILOS SI NO SE AGREGO NINGUNO TODAVIA
                    
                    JOptionPane.showMessageDialog(null, "No hay silos a mostrar");
                    }else { JOptionPane.showMessageDialog(null, datosSilos);
                }
        }   

	public static void listarCeldas() { //IDEM LISTARSILOS()
		
            String datosCeldas = "";
                Collections.sort(celdas);
		Iterator<Celda> ic = celdas.iterator();
		while (ic.hasNext()) {
			Celda c =ic.next();
			datosCeldas += c.imprimeCelda();
		}
                
                if ("".equals(datosCeldas)){
                    
                    JOptionPane.showMessageDialog(null, "No hay celdas a mostrar");
                    }else { JOptionPane.showMessageDialog(null, datosCeldas);
                }
        }   
	
	public static void listarSilosBolsa() { //IDEM LISTASILOS()
		
		String datosSiloBolsas = "";
                Collections.sort(silosB);
		Iterator<SiloBolsa> isb = silosB.iterator();
		while (isb.hasNext()) {
			SiloBolsa sb = isb.next();
			datosSiloBolsas += sb.imprimeSiloBolsa();
		}
                
                if ("".equals(datosSiloBolsas)){
                    
                    JOptionPane.showMessageDialog(null, "No hay silo Bolsas a mostrar");
                    }else { JOptionPane.showMessageDialog(null, datosSiloBolsas);
                }
	}

	public static void totalCubicaje() {
		
		totalCubicajeTrigo = 0; //VARIABLES STATICAS
		totalCubicajeMaiz = 0;
		totalCubicajeSoja = 0;
		double totalCubicajeTrigoSilo = 0;
		double totalCubicajeMaizSilo = 0;
		double totalCubicajeSojaSilo = 0;
		double totalCubicajeTrigoCelda = 0;
		double totalCubicajeMaizCelda = 0;
		double totalCubicajeSojaCelda = 0;
		double totalCubicajeTrigoSB = 0;
		double totalCubicajeMaizSB = 0;
		double totalCubicajeSojaSB = 0;
		
		Iterator<Silo> it = silos.iterator(); //RECORRE EL ARRAYLIST
		while (it.hasNext()) { // MIENTRAS HAY SIGUIENTE
			Silo s =it.next(); // ASIGNE AL OBJETO S EL VALOR ACTUAL DEL ARRAYLIST DE OBJETOS
			if ("Trigo".equals(s.getTipoGrano())) {
				totalCubicajeTrigo = totalCubicajeTrigo + s.getTotalSilo();
				totalCubicajeTrigoSilo = totalCubicajeTrigoSilo + s.getTotalSilo();
			}
			if ("Maiz".equals(s.getTipoGrano())) {
				totalCubicajeMaiz = totalCubicajeMaiz + s.getTotalSilo();
				totalCubicajeMaizSilo = totalCubicajeMaizSilo + s.getTotalSilo();
			}
			if ("Soja".equals(s.getTipoGrano())) {
				totalCubicajeSoja = totalCubicajeSoja + s.getTotalSilo();
				totalCubicajeSojaSilo = totalCubicajeSojaSilo + s.getTotalSilo();
			}
				
		}
		
		Iterator<Celda> it2 = celdas.iterator();// IDEN TOTALSILOS
		while (it2.hasNext()) {//SE CREA ITERADOR NUEVO PARA EVITAR COLISIONES DE VARIABLES
			
			Celda c =it2.next();
			
			if ("Trigo".equals(c.getTipoGrano())) {
				totalCubicajeTrigo = totalCubicajeTrigo + c.getTotalCelda();
				totalCubicajeTrigoCelda = totalCubicajeTrigoCelda + c.getTotalCelda();
			}
			if ("Maiz".equals(c.getTipoGrano())) {
				totalCubicajeMaiz = totalCubicajeMaiz + c.getTotalCelda();
				totalCubicajeMaizCelda = totalCubicajeMaizCelda + c.getTotalCelda();
			}
			if ("Soja".equals(c.getTipoGrano())) {
				totalCubicajeSoja = totalCubicajeSoja + c.getTotalCelda();
				totalCubicajeSojaCelda = totalCubicajeSojaCelda + c.getTotalCelda();
			}
		}
		
		Iterator<SiloBolsa> it3 = silosB.iterator(); // IDEM TOTALSILOS
		while (it3.hasNext()) {//SE CREA ITERADOR NUEVO PARA EVITAR COLISIONES DE VARIABLES
			
			SiloBolsa sb =it3.next();
			
			if ("Trigo".equals(sb.getTipoGrano())) {
				totalCubicajeTrigo = totalCubicajeTrigo + sb.getToneladasSB();
				totalCubicajeTrigoSB = totalCubicajeTrigoSB + sb.getToneladasSB();
			}
			if ("Maiz".equals(sb.getTipoGrano())) {
				totalCubicajeMaiz = totalCubicajeMaiz + sb.getToneladasSB();
				totalCubicajeMaizSB = totalCubicajeMaizSB + sb.getToneladasSB();
			}
			if ("Soja".equals(sb.getTipoGrano())) {
				totalCubicajeSoja = totalCubicajeSoja + sb.getToneladasSB();
				totalCubicajeSojaSB = totalCubicajeSojaSB + sb.getToneladasSB();
			}
		}
		
		JOptionPane.showMessageDialog(null, "------TOTALES------"
										+ 	"\nToneladas Trigo en silos: " + totalCubicajeTrigoSilo
										+	"\nToneladas Trigo en celdas: " + totalCubicajeTrigoCelda
										+	"\nToneladas Trigo en silo bolsa: " + totalCubicajeTrigoSB
										+	"\nToneladas Maiz en silos: " + totalCubicajeMaizSilo
										+	"\nToneladas Maiz en celdas: " + totalCubicajeMaizCelda
										+	"\nToneladas Maiz en silo bolsa: " + totalCubicajeMaizSB
										+	"\nToneladas Soja en silos: " + totalCubicajeSojaSilo
										+	"\nToneladas Soja en celdas: " + totalCubicajeSojaCelda
										+	"\nToneladas Soja en silo bolsa: " + totalCubicajeSojaSB
										+	"\n"
										+	"\n----EXISTENCIAS----"
										+ 	"\nExistencia de Trigo en toneladas: " +  totalCubicajeTrigo
										+	"\nExistencia de Maiz en toneladas: " + totalCubicajeMaiz
										+	"\nExistencia de Soja en toneladas: " + totalCubicajeSoja);
		}

    private static double validarNumeros(String num) { //FUNCION PARA VALIDAR SOLO NUMEROS, INCLUYE DECIMALES CON PUNTO (.)
        
        double valor;
        
        try {
            valor = Double.parseDouble(num); //SI PUEDE REALIZAR LA CONVERSION ASIGNE A VALOR EL VALOR DE ESTA
            
        } catch (NumberFormatException e) {
            
            JOptionPane.showMessageDialog(null,"Ingrese un valor numerico");
            valor = 10000; //SI NO PUDO MUESTRA EL ERROR Y ASIGNA VALOR = 10000
        }
        
        return valor; //SI DEVUELVE EL VALOR 10000 VA A REPETIR EL CICLO DO

    }

    private static int validarNumerosEnteros(String num) { // FUNCION PARA VALIDAR SOLO NUMEROS ENTEROS
        int valor;
        
        try {
            valor = Integer.parseInt(num);
            
        } catch (NumberFormatException e) {
            
            JOptionPane.showMessageDialog(null,"Ingrese solo Numeros Enteros");
            valor = 10000;
        }
        
        return valor;
    }

    private static double ingresarDatosDouble(Object object, String datos, double datos2) {//funcion para agregar datos decimales por teclado
        
        double datoCalcular;
        
        do { 
            String datosString = JOptionPane.showInputDialog(null, datos, datos2); // SELECCION DEL VALOR DE PH, CON VALOR DEFAULT PH EN CASO DE NO PONER NADA
            datoCalcular = validarNumeros(datosString);           // FUNCION validarNumeros VA A VALIDAR A LO LARGO DE PROGRAMA LA ENTRADA NUMEROCA DE DATOS         
        } while (datoCalcular==10000);
        
        return datoCalcular;
    }

    private static int ingresarDatosEnteros(Object object, String datos, int datos2) { //funcion para agregar datos enteros por teclado
        
        int datoCalcular;
        do {
            String datosString = JOptionPane.showInputDialog(null, datos, datos2);
            datoCalcular = validarNumerosEnteros(datosString); //llamado a funcion para validar los datos
        } while (datoCalcular==10000);
        
        return datoCalcular;
    }
}