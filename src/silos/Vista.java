
package silos;

import javax.swing.JOptionPane;


public class Vista {
    
    public static void menuPrincipal () { 
		
		String opcion;
		boolean uso = true;
		while (uso) {
			opcion = JOptionPane.showInputDialog( "1) Agregar silo\n"
												 +"2) Agregar celda/galpon\n"
												 +"3) Agregar silo bolsa\n"
												 +"4) Eliminar silo\n"
												 +"5) Eliminar celda\n"
												 +"6) Eliminar silo bolsa\n"
												 +"7) Listar silos\n"
												 +"8) Listar celdas\n"
												 +"9) Listar silo bolsa\n"
												 +"10) Total cubicaje\n"
												 +"11) Salir\n");
		
		switch (opcion) {
			
			case "1": 	Gestion.agregarSilo();
						break;						
						 
			case "2": 	Gestion.agregarCelda();
						break;						
			
			case "3": 	Gestion.agregarSiloBolsa();
						break;
			
			case "4":	Gestion.eliminarSilo();
						break;
						
			case "5": 	Gestion.eliminarCelda();
						break;
						
			case "6": 	Gestion.eliminarSiloBolsa();
						break;
			
			case "7":	Gestion.listarSilos();
						break;
						
			case "8":  	Gestion.listarCeldas();
						break;
						
			case "9": 	Gestion.listarSilosBolsa();
						break;
		
			case "10": 	Gestion.totalCubicaje();
						break;
						
			case "11":  JOptionPane.showMessageDialog(null, "Hasta luego", "Mensaje de informaci�n", JOptionPane.INFORMATION_MESSAGE);
						uso = false;
						break;
									
			default: 	JOptionPane.showMessageDialog(null, "Opcion Incorrecta", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
						break;
			}
		}
    }
}
