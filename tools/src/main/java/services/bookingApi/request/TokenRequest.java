package services.bookingApi.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class TokenRequest {
    @Builder.Default
    private String username = "admin";
    @Builder.Default
    private String password = "password123";

    public static TokenRequest initialize() {
        return TokenRequest.builder()
                .build();
    }
}
