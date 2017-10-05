package pico.placa.predictor.bb;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.Dependent;

import lombok.Getter;
import lombok.Setter;
import pico.placa.predictor.excepcion.PredictorPicoPlacaExcepcion;
import pico.placa.predictor.servicio.PredictorPicoPlacaServicio;

@Dependent
public class PredictorPicoPlacaBb implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4092963234610555700L;
	
	@Getter
	@Setter
	private String placa;
	@Getter
	@Setter
	private String fecha;
	@Getter
	@Setter
	private String hora;
	
	@EJB
	@Getter
	private PredictorPicoPlacaServicio predictorPicoPlacaServicio;
	
	public void init() throws PredictorPicoPlacaExcepcion{
	}
	
}