package pico.placa.predictor.servicio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import lombok.Getter;
import pico.placa.predictor.dto.PicoPlacaDto;
import pico.placa.predictor.excepcion.PredictorPicoPlacaExcepcion;

@Stateless
public class PredictorPicoPlacaServicio {

	@EJB
	@Getter
	private InicializaServicio inicializaServicio;

	public PicoPlacaDto vaidarPicoPlaca(String placa, String fecha, String hora) throws PredictorPicoPlacaExcepcion, ParseException {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Map<Integer, PicoPlacaDto> lista = getInicializaServicio().getDatosPicoPlaca();

		Date fechaDia = format.parse(fecha);

		Calendar calendario = Calendar.getInstance();
		calendario.setTime(fechaDia);

		int dia = calendario.get(Calendar.DAY_OF_WEEK);

		if (lista.containsKey(dia)) {
			PicoPlacaDto picoPlacaDto = lista.get(dia);
			if (validarUltimoDigitoPlaca(picoPlacaDto, placa)) {
				if (validarHora(picoPlacaDto, hora)) {
					picoPlacaDto.setPermitidoTexto("NO TIENE PERMITIDO");
					picoPlacaDto.setPermitido(false);
				} else {
					picoPlacaDto.setPermitidoTexto("TIENE PERMITIDO");
					picoPlacaDto.setPermitido(true);
				}
			} else {
				picoPlacaDto.setPermitidoTexto("TIENE PERMITIDO");
				picoPlacaDto.setPermitido(true);
			}
			
			return picoPlacaDto;
		} else {
			PicoPlacaDto picoPlacaDto = new PicoPlacaDto();
			picoPlacaDto.setPermitidoTexto("TIENE PERMITIDO");
			picoPlacaDto.setPermitido(true);
			picoPlacaDto.setDia("FIN DE SEMANA");
			
			return picoPlacaDto;
		}

	}

	private boolean validarUltimoDigitoPlaca(PicoPlacaDto picoPlacaDto, String placa) {
		return (placa != null && (placa.endsWith(picoPlacaDto.getUltimosNmeroPlaca1()) || placa.endsWith(picoPlacaDto.getUltimosNmeroPlaca2())));
	}

	private boolean validarHora(PicoPlacaDto picoPlacaDto, String hora) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		Date fechaHora = format.parse(hora);

		return (fechaHora.compareTo(picoPlacaDto.getHoraMananaInicio()) > 0 && fechaHora.compareTo(picoPlacaDto.getHoraMananaFin()) < 0)
				|| (fechaHora.compareTo(picoPlacaDto.getHoraTardeInicio()) > 0 && fechaHora.compareTo(picoPlacaDto.getHoraTardeFin()) < 0);
	}
}
