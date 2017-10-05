package pico.placa.predictor.excepcion;

public class PredictorPicoPlacaExcepcion extends Exception {

    private static final long serialVersionUID = -5401498301486094378L;

    public PredictorPicoPlacaExcepcion() {
    }

    public PredictorPicoPlacaExcepcion(String message) {
        super(message);
    }

    public PredictorPicoPlacaExcepcion(Throwable cause) {
        super(cause);
    }

    public PredictorPicoPlacaExcepcion(String message, Throwable cause) {
        super(message, cause);
    }

}
