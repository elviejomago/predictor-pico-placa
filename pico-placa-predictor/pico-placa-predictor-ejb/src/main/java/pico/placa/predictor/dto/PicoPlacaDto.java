package pico.placa.predictor.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

public class PicoPlacaDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1562800541617575995L;

	@Getter
	@Setter
	private String dia;
	@Getter
	@Setter
	private Date horaMananaInicio;
	@Getter
	@Setter
	private Date horaMananaFin;
	@Getter
	@Setter
	private Date horaTardeInicio;
	@Getter
	@Setter
	private Date horaTardeFin;
	@Getter
	@Setter
	private String ultimosNmeroPlaca1;
	@Getter
	@Setter
	private String ultimosNmeroPlaca2;
	@Getter
	@Setter
	private String permitidoTexto;
	@Getter
	@Setter
	private Boolean permitido;
	
	public PicoPlacaDto() {
		super();
	}
}
