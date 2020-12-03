package org.iesalandalus.programacion.evaluacionsp;

public class MainApp {

	private static EvaluacionSP primeraEvaluacion;
	
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
