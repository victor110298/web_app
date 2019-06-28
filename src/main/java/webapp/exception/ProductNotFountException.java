package webapp.exception;

public class ProductNotFountException extends RuntimeException {
    public ProductNotFountException() {
        super("Product not found!");
    }
}
