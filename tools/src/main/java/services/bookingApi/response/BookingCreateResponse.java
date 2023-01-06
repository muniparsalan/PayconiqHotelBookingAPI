package services.bookingApi.response;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingCreateResponse {
    private Long bookingid;
    private BookingDTO booking;
    private String additionalneeds;
}
