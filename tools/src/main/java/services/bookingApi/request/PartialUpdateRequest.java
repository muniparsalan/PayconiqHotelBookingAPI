package services.bookingApi.request;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class PartialUpdateRequest {
    private String firstname;
    private String lastname;

    public static PartialUpdateRequest initialize(String firstname, String lastname) {
        return PartialUpdateRequest.builder()
                .firstname(firstname)
                .lastname(lastname)
                .build();
    }
}
