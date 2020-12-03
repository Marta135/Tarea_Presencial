package org.iesalandalus.programacion.evaluacionsp;

import utilidades.Entrada;

public class Consola {

	/**
	 * Constructor para evitar instanciar objetos de esta clase.
	 */
	private Consola () {
		
	}
	
	
	/**
	 * Método leerCalificacionInstrumento
	 * Recibirá un instrumento y le asignará la calificación leída por teclado.
	 */
	private static void leerCalificacionInstrumento (Instrumento instrumento) throws IllegalArgumentException {
		
		float notaInstrumento;
		
		do {
			System.out.print("Introduce la calificación para " + instrumento.getNombre() + ": ");
			notaInstrumento=Entrada.real();
			
			try {
				instrumento.setCalificacion(notaInstrumento);
			}
			catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
			
		}while (notaInstrumento<0 || notaInstrumento>10);
		
	}
	
	
	/**
	 * Método leerCalificacionesEvaluacionSP
	 * Leerá las calificaciones de los distintos instrumentos de la evaluación.
	 */
	public static void leerCalificacionesEvaluacionSP (EvaluacionSP evaluacion) {
		
		leerCalificacionInstrumento(evaluacion.getParticipacion());
		leerCalificacionInstrumento(evaluacion.getCuestionarios());
		leerCalificacionInstrumento(evaluacion.getTareasOnline());
		leerCalificacionInstrumento(evaluacion.getTareasPresenciales());
		leerCalificacionInstrumento(evaluacion.getExamen());
		
	}
	
}
