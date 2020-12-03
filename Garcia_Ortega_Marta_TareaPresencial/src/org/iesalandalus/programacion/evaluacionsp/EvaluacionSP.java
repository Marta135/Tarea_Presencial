package org.iesalandalus.programacion.evaluacionsp;

public class EvaluacionSP {

	/**
	 * Atributos
	 */
	private static final float PESO_PARTICIPACION=0.1f;
	private static final float PESO_CUESTIONARIOS=0.05f;
	private static final float PESO_TAREAS_ONLINE=0.25f;
	private static final float PESO_TAREAS_PRESENCIALES=0.25f;
	private static final float PESO_EXAMEN=0.35f;
	private static final float CALIFICACION_ALGUN_INSTRUMENTO_OBLIGATORIO_NO_SUPERADO=4f;
	private static final float CALIFICACION_CORTE=5f;
	private String nombre;
	private Instrumento participacion;
	private Instrumento cuestionarios;
	private Instrumento tareasOnline;
	private Instrumento tareasPresenciales;
	private Instrumento examen;
	
	
	/**
	 * Constructor con parámetros
	 * Asigna valor a los atributos.
	 */
	public EvaluacionSP (String nombre) throws NullPointerException, IllegalArgumentException {
		
		setNombre(nombre);
		participacion = new Instrumento("Participacion", PESO_PARTICIPACION);
		cuestionarios = new Instrumento("Cuestionarios", PESO_CUESTIONARIOS);
		tareasOnline = new Instrumento("Tareas online", PESO_TAREAS_ONLINE);
		tareasPresenciales = new Instrumento("Tareas presenciales", PESO_TAREAS_PRESENCIALES);
		examen = new Instrumento("Examen", PESO_EXAMEN);
	
	}
	
	
	/**
	 * Métodos getters y setters
	 */
	public String getNombre() {
		return nombre;
	}
	
	private void setNombre(String nombre) {
		
		if (nombre == null)
			throw new NullPointerException ("ERROR: El nombre introducido no puede ser nulo. ");
			
		this.nombre = nombre;
	}
	
	public Instrumento getParticipacion() {
		return participacion;
	}
	
	public Instrumento getCuestionarios() {
		return cuestionarios;
	}
	
	public Instrumento getTareasOnline() {
		return tareasOnline;
	}
	
	public Instrumento getTareasPresenciales() {
		return tareasPresenciales;
	}
	
	public Instrumento getExamen() {
		return examen;
	}
	
	
	/**
	 * Método getCalificacion
	 * Calcula la calificación de la evaluación.
	 */
	public float getCalificacion() {
		
		float notaEvaluacion;
	
		notaEvaluacion=(participacion.getCalificacionPonderada())
						+ (cuestionarios.getCalificacionPonderada())
						+ (tareasOnline.getCalificacionPonderada())
						+ (tareasPresenciales.getCalificacionPonderada())
						+ (examen.getCalificacionPonderada());
		
		if (superaInstrumentosObligatorios()==true)
			return notaEvaluacion;
		else if (superaCalificacionCorte(notaEvaluacion)==true)	
			return CALIFICACION_ALGUN_INSTRUMENTO_OBLIGATORIO_NO_SUPERADO;
		else 
			return notaEvaluacion;
		
	}
	
	
	/**
	 * Método getResultado
	 * Indica si la calificación supera la nota de corte o no.
	 */
	public Resultado getResultado() {
		
		if(getCalificacion()>=5)
			return Resultado.APROBADO;
		else
			return Resultado.SUSPENSO;
	}
	
	
	/**
	 * Método superaCalificacionCorte
	 * Indica si el parámetro pasado supera la calificación de corte.
	 */
	private boolean superaCalificacionCorte(float calificacion) {
	
		if(calificacion>=CALIFICACION_CORTE)
			return true;
		else 
			return false;
	}
	
	
	/**
	 * Método superaInstrumentosObligatorios
	 * Devuelve un valor lógico si tareasOnline, tareasPresenciales y examen superan la calificación de corte. 
	 */
	private boolean superaInstrumentosObligatorios() {
	
		if (superaCalificacionCorte(examen.getCalificacion())==true 
			&& superaCalificacionCorte(tareasOnline.getCalificacion())==true 
			&& superaCalificacionCorte(tareasPresenciales.getCalificacion())==true)
			
			return true;
		else
			return false;
	}


	/**
	 * Método toString
	 * Imprimirá la calificación y el resultado de la misma.
	 */
	@Override
	public String toString() {
		return "Resultado Primera Evaluación: [Calificación=" + this.getCalificacion() + ", Resultado=" + this.getResultado() + "]";
	}
	
	
	

	
	
	
}
