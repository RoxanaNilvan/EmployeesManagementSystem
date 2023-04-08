public class Exceptie extends Exception{
    public Exceptie() {
    }

    public Exceptie(String message) {
        super(message);
    }

    public Exceptie(String message, Throwable cause) {
        super(message, cause);
    }

    public Exceptie(Throwable cause) {
        super(cause);
    }

    public Exceptie(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
