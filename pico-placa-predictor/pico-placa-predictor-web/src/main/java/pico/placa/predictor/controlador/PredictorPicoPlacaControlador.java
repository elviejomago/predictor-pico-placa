package pico.placa.predictor.controlador;

import java.io.Serializable;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;
import pico.placa.predictor.bb.PredictorPicoPlacaBb;
import pico.placa.predictor.dto.PicoPlacaDto;
import pico.placa.predictor.excepcion.PredictorPicoPlacaExcepcion;

@Named
@ViewScoped
public class PredictorPicoPlacaControlador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3091967956374729249L;

	@Inject
	@Getter
	@Setter
	PredictorPicoPlacaBb predictorPicoPlacaBb;

	@PostConstruct
	public void init() {
		try {
			getPredictorPicoPlacaBb().init();
		} catch (PredictorPicoPlacaExcepcion e) {
			Logger.getLogger(PredictorPicoPlacaControlador.class.getName()).log(Level.SEVERE, "init", e);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Se ha producido un Error", null));
		}
	}

	public void validar() {
		try {
			PicoPlacaDto picoPlacaDto = getPredictorPicoPlacaBb().getPredictorPicoPlacaServicio()
					.vaidarPicoPlaca(getPredictorPicoPlacaBb().getPlaca(), getPredictorPicoPlacaBb().getFecha(), getPredictorPicoPlacaBb().getHora());
			FacesContext facesContext = FacesContext.getCurrentInstance();
			if (picoPlacaDto.getPermitido()) {
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
						"LA PLACA " + getPredictorPicoPlacaBb().getPlaca().toUpperCase() + " " + picoPlacaDto.getPermitidoTexto() + " TRANSITAR.", null));
			} else {
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"LA PLACA " + getPredictorPicoPlacaBb().getPlaca().toUpperCase() + " " + picoPlacaDto.getPermitidoTexto() + " TRANSITAR.", null));
			}
		} catch (RuntimeException | ParseException | PredictorPicoPlacaExcepcion e) {
			Logger.getLogger(PredictorPicoPlacaControlador.class.getName()).log(Level.SEVERE, "validar", e);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage("Se ha producido un Error", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Se ha producido un Error", null));
		}
	}

}
