package org.iesalandalus.programacion.evaluacionsp;

public class MainApp {

	/**
	 * Atributo
	 */
	private static EvaluacionSP primeraEvaluacion;
	
	
	/**
	 * M�todo main
	 * Crea una instancia de EvaluacionSP y la asigna al atributo.
	 * Lee las calificaciones de los distintos instrumentos (m�todo de la clase Consola).
	 * Y muestra la calificaci�n y el resultado de la evaluaci�n. 
	 */
	public static void main(String[] args) {
		
		try {
			primeraEvaluacion=new EvaluacionSP("Primera evaluaci�n");
			Consola.leerCalificacionesEvaluacionSP(primeraEvaluacion);
			System.out.println(primeraEvaluacion);
		}
		catch (NullPointerException | IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
