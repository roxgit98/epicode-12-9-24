package davidegiliberti.epicode_12_9_24.exceptions;

public class NotFoundExceptions extends RuntimeException {
    public NotFoundExceptions(int id) {
        super("elemento con ID " + id + " non trovato");
    }
}
