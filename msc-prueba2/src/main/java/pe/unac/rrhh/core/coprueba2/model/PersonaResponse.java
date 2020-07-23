package pe.unac.rrhh.core.coprueba2.model;

public class PersonaResponse {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public PersonaResponse(String message) {
        super();
        this.message = message;
    }

    public PersonaResponse() {
        super();
    }
}