package org.iesalandalus.programacion.evaluacionsp;

public class MainApp {

	/**
	 * Atributo
	 */
	private static EvaluacionSP primeraEvaluacion;
	
	
	/**
	 * Método main
	 * Crea una instancia de EvaluacionSP y la asigna al atributo.
	 * Lee las calificaciones de los distintos instrumentos (método de la clase Consola).
	 * Y muestra la calificación y el resultado de la evaluación. 
	 */
	public static void main(String[] args) {
		
		try {
			primeraEvaluacion=new EvaluacionSP("Primera evaluación");
			Consola.leerCalificacionesEvaluacionSP(primeraEvaluacion);
			System.out.println(primeraEvaluacion);
		}
		catch (NullPointerException | IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
