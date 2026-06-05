package exercice1;

public class NombreNegatifException extends Exception {
    public NombreNegatifException() {
        super("Nombre negatif");
    }

    public NombreNegatifException(String message) {
        super(message);
    }

    public NombreNegatifException(String message, Throwable cause) {
        super(message, cause);
    }

    public NombreNegatifException(Throwable cause) {
        super(cause);
    }

    public NombreNegatifException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
