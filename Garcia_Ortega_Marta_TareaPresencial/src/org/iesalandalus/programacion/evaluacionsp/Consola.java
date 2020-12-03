package org.iesalandalus.programacion.evaluacionsp;

import utilidades.Entrada;

public class Consola {

	//Constructor para evitar instanciar objetos de esta clase
	private Consola () {
		
	}
	
	//M�todo leerCalificacionInstrumento
	private static void leerCalificacionInstrumento (Instrumento instrumento) throws IllegalArgumentException {
		
		float nota;
		
		do {
			System.out.print("Introduce la calificaci�n para " + instrumento.getNombre() + ": ");
			nota=Entrada.real();
			
			try {
				instrumento.setCalificacion(nota);
			}
			catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
			
		}while (nota<0 || nota>10);
		
		
			
	}
	
	
	//M�todo leerCalificacionesEvaluacionSP
	public static void leerCalificacionesEvaluacionSP (EvaluacionSP evaluacion) {
		
		leerCalificacionInstrumento(evaluacion.getParticipacion());
		leerCalificacionInstrumento(evaluacion.getCuestionarios());
		leerCalificacionInstrumento(evaluacion.getTareasOnline());
		leerCalificacionInstrumento(evaluacion.getTareasPresenciales());
		leerCalificacionInstrumento(evaluacion.getExamen());
		
	}
	
}
