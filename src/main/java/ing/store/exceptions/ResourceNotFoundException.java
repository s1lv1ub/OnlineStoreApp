package ing.store.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    Long fieldId;
    String field;
    String fieldName;
    String resourceName;



    public ResourceNotFoundException(String resourceName, String field, String fieldName) {
        super(String.format("%s not found with %s: %s", resourceName, field, fieldName));
        this.fieldName = fieldName;
        this.field = field;
        this.resourceName = resourceName;
    }

    public ResourceNotFoundException(String resourceName, String field, Long fieldId) {
        super(String.format("%s not found with %s: %d", resourceName, field, fieldId));
        this.fieldId = fieldId;
        this.field = field;
    }


}
