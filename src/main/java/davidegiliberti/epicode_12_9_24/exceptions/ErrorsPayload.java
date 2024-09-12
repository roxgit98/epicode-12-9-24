package davidegiliberti.epicode_12_9_24.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorsPayload {
    private String message;
    private String details;
}
