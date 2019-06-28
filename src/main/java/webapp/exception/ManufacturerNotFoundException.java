package webapp.exception;

public class ManufacturerNotFoundException extends RuntimeException {
    public ManufacturerNotFoundException() {
        super("Manufacturer not found!");
    }
}
