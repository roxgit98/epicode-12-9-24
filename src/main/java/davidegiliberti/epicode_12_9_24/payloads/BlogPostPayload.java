package davidegiliberti.epicode_12_9_24.payloads;

import lombok.Data;

@Data
public class BlogPostPayload {
    private String titolo;
    private String contenuto;
    private int tempoDiLettura;
    private int autoreId;
    private String categoria;
}
