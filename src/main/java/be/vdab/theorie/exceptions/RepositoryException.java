package be.vdab.theorie.exceptions;

public class RepositoryException extends RuntimeException {
    private final static long serialVersionUID = 1L;
    public RepositoryException(Exception oorzaak) {
        super(oorzaak);
    }
}
