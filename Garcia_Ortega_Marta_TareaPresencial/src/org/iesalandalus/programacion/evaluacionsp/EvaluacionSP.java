package org.iesalandalus.programacion.evaluacionsp;

public class EvaluacionSP {

	//Atributos
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
	
	
	//Constructor con parámetros
	
	public EvaluacionSP (String nombre) throws NullPointerException, IllegalArgumentException {
		
		setNombre(nombre);
		participacion = new Instrumento("Participacion", PESO_PARTICIPACION);
		cuestionarios = new Instrumento("Cuestionarios", PESO_CUESTIONARIOS);
		tareasOnline = new Instrumento("Tareas online", PESO_TAREAS_ONLINE);
		tareasPresenciales = new Instrumento("Tareas presenciales", PESO_TAREAS_PRESENCIALES);
		examen = new Instrumento("Examen", PESO_EXAMEN);
	
	}
	
	
	//Métodos getters y setters
	
	public String getNombre() {
		return nombre;
	}
	
	private void setNombre(String nombre) {
		
		if (nombre == null)
			throw new NullPointerException ("ERROR: El nombre introducido no puede ser nulo");
			
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
	
	
	//Método getCalificacion
	public float getCalificacion() {
		
		float notaParticipacion, notaTareaOnline, notaTareaPresencial, notaCuestionarios, notaExamen, notaFinal;
		
		notaParticipacion=participacion.getCalificacionPonderada();
		notaCuestionarios=cuestionarios.getCalificacionPonderada();
		notaTareaOnline=tareasOnline.getCalificacionPonderada();
		notaTareaPresencial=tareasPresenciales.getCalificacionPonderada();
		notaExamen=examen.getCalificacionPonderada();
		
		notaFinal=notaParticipacion+notaCuestionarios+notaTareaOnline+notaTareaPresencial+notaExamen;
		
		if (superaInstrumentosObligatorios()==true)
			return notaFinal;
		else if (superaCalificacionCorte(notaFinal)==true)	
			return CALIFICACION_ALGUN_INSTRUMENTO_OBLIGATORIO_NO_SUPERADO;
		else 
			return notaFinal;
		
	}
	
	
	//Método getResultado
	public Resultado getResultado() {
		
		if(getCalificacion()>=5)
			return Resultado.APROBADO;
		else
			return Resultado.SUSPENSO;
	}
	
	
	//Método superaCalificacionCorte
	
	private boolean superaCalificacionCorte(float calificacion) {
	
		if(calificacion>=CALIFICACION_CORTE)
			return true;
		else 
			return false;
	}
	
	
	//Método superaInstrumentosObligatorios
	//Revisar 
	
	private boolean superaInstrumentosObligatorios() {
	
		float notaExamen, notaTareaOnline, notaTareaPresencial;
		
		notaExamen=examen.getCalificacion();
		notaTareaOnline=tareasOnline.getCalificacion();
		notaTareaPresencial=tareasPresenciales.getCalificacion();
		
		if(notaExamen>=5 && notaTareaOnline>=5 && notaTareaPresencial>=5)
			return true;
		else
			return false;
		
	}


	//Método toString
	
	@Override
	public String toString() {
		return "Resultado Primera Evaluación: [Calificación=" + this.getCalificacion() + ", Resultado=" + this.getResultado() + "]";
	}
	
	
	

	
	
	
}
