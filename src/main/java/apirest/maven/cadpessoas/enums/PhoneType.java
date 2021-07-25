package apirest.maven.cadpessoas.enums;
import lombok.*;

@Getter
@AllArgsConstructor
public enum PhoneType {
    HOME("Home"),
    MOBILE("Mobile"),
    COMMERCIAL("Comercial");

    private final String description;
}
