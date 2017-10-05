package pico.placa.predictor.servicio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import lombok.Getter;
import lombok.Setter;
import pico.placa.predictor.dto.PicoPlacaDto;
import pico.placa.predictor.excepcion.PredictorPicoPlacaExcepcion;

@Singleton
@Startup
public class InicializaServicio {

	@Getter
	@Setter
	private Map<Integer, PicoPlacaDto> datosPicoPlaca;

	@PostConstruct
	public void inicializa() {
		try {
			SimpleDateFormat format = new SimpleDateFormat("HH:mm");
			setDatosPicoPlaca(new HashMap());

			PicoPlacaDto picoPlacaDto = new PicoPlacaDto();
			picoPlacaDto.setDia("LUNES");
			picoPlacaDto.setHoraMananaInicio(format.parse("07:00"));
			picoPlacaDto.setHoraMananaFin(format.parse("09:30"));
			picoPlacaDto.setHoraTardeInicio(format.parse("16:00"));
			picoPlacaDto.setHoraTardeFin(format.parse("19:30"));
			picoPlacaDto.setUltimosNmeroPlaca1("1");
			picoPlacaDto.setUltimosNmeroPlaca2("2");
			picoPlacaDto.setPermitidoTexto("NO TIENE PERMITIDO");
			picoPlacaDto.setPermitido(false);

			getDatosPicoPlaca().put(2, picoPlacaDto);

			picoPlacaDto = new PicoPlacaDto();
			picoPlacaDto.setDia("MARTES");
			picoPlacaDto.setHoraMananaInicio(format.parse("07:00"));
			picoPlacaDto.setHoraMananaFin(format.parse("09:30"));
			picoPlacaDto.setHoraTardeInicio(format.parse("16:00"));
			picoPlacaDto.setHoraTardeFin(format.parse("19:30"));
			picoPlacaDto.setUltimosNmeroPlaca1("3");
			picoPlacaDto.setUltimosNmeroPlaca2("4");
			picoPlacaDto.setPermitidoTexto("NO TIENE PERMITIDO");
			picoPlacaDto.setPermitido(false);

			getDatosPicoPlaca().put(3, picoPlacaDto);

			picoPlacaDto = new PicoPlacaDto();
			picoPlacaDto.setDia("MIERCOLES");
			picoPlacaDto.setHoraMananaInicio(format.parse("07:00"));
			picoPlacaDto.setHoraMananaFin(format.parse("09:30"));
			picoPlacaDto.setHoraTardeInicio(format.parse("16:00"));
			picoPlacaDto.setHoraTardeFin(format.parse("19:30"));
			picoPlacaDto.setUltimosNmeroPlaca1("5");
			picoPlacaDto.setUltimosNmeroPlaca2("6");
			picoPlacaDto.setPermitidoTexto("NO TIENE PERMITIDO");
			picoPlacaDto.setPermitido(false);

			getDatosPicoPlaca().put(4, picoPlacaDto);

			picoPlacaDto = new PicoPlacaDto();
			picoPlacaDto.setDia("JUEVES");
			picoPlacaDto.setHoraMananaInicio(format.parse("07:00"));
			picoPlacaDto.setHoraMananaFin(format.parse("09:30"));
			picoPlacaDto.setHoraTardeInicio(format.parse("16:00"));
			picoPlacaDto.setHoraTardeFin(format.parse("19:30"));
			picoPlacaDto.setUltimosNmeroPlaca1("7");
			picoPlacaDto.setUltimosNmeroPlaca2("8");
			picoPlacaDto.setPermitidoTexto("NO TIENE PERMITIDO");
			picoPlacaDto.setPermitido(false);

			getDatosPicoPlaca().put(5, picoPlacaDto);

			picoPlacaDto = new PicoPlacaDto();
			picoPlacaDto.setDia("VIERNES");
			picoPlacaDto.setHoraMananaInicio(format.parse("07:00"));
			picoPlacaDto.setHoraMananaFin(format.parse("09:30"));
			picoPlacaDto.setHoraTardeInicio(format.parse("16:00"));
			picoPlacaDto.setHoraTardeFin(format.parse("19:30"));
			picoPlacaDto.setUltimosNmeroPlaca1("9");
			picoPlacaDto.setUltimosNmeroPlaca2("0");
			picoPlacaDto.setPermitidoTexto("NO TIENE PERMITIDO");
			picoPlacaDto.setPermitido(false);

			getDatosPicoPlaca().put(6, picoPlacaDto);
		} catch (ParseException e) {
			Logger.getLogger(InicializaServicio.class.getName()).log(Level.SEVERE, "inicializa", e);
		}
	}
}
