package michlam.genshin_simulator_backend.exception;

import lombok.Getter;
public class ErrorResponse {
    @Getter
    private int status;

    @Getter
    private String message;

    public ErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
