package org.iesalandalus.programacion.evaluacionsp;

public class Instrumento {

	//Atributos
	private static final float PESO_MINIMO=0f;
	private static final float PESO_MAXIMO=1f;
	private static final float CALIFICACION_MINIMA=0f;
	private static final float CALIFICACION_MAXIMA=10f;
	private String nombre;
	private float peso;
	private float calificacion;
	
	
	//Constructor con par�metros
	public Instrumento (String nombre, float peso) {
		
		setNombre(nombre);
		setPeso(peso);
		calificacion=0;
	}
	
	
	//Getters y setters
	public String getNombre() {
		return nombre;
	} 
	
	private void setNombre(String nombre) {
		
		if (nombre == null)
			throw new NullPointerException ("ERROR: El nombre introducido no puede ser nulo");
		
		this.nombre = nombre;
	}
	
	public float getPeso() {
		return peso;
	}
	
	private void setPeso(float peso) {
		
		if (peso<PESO_MINIMO || peso>PESO_MAXIMO)
			throw new IllegalArgumentException("ERROR: El peso introducido no es v�lido.");
		
		this.peso = peso;
	}
	
	public float getCalificacion() {
		return calificacion;
	}
	
	public void setCalificacion(float calificacion) {
		
		if (calificacion<CALIFICACION_MINIMA || calificacion>CALIFICACION_MAXIMA)
			throw new IllegalArgumentException("ERROR: La calificaci�n debe estar comprendida entre: 0.0 y 10.0 (ambos inclusive). Vuelve a introducirla.");
		
		this.calificacion = calificacion;
	}
	
	//M�todo getCalificacionPonderada
	
	public float getCalificacionPonderada () {
		return calificacion*peso;
	}


	//M�todo toString
	
	@Override
	public String toString() {
		return "Nombre=" + this.nombre + ", peso=" + this.peso + ", calificaci�n=" + this.calificacion
				+ ", calificaci�n ponderada=" + this.getCalificacionPonderada();
	}
	
	
}
