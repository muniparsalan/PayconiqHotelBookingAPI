package services.bookingApi.request;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingCreateRequest {
    private String firstname;
    private String lastname;
    private Long totalprice;
    private Boolean depositpaid;
    private BookingDateDTO bookingdates;
    private String additionalneeds;

    public static BookingCreateRequest initialize(String firstname, String lastname, Long totalprice, Boolean depositpaid, BookingDateDTO bookingdates, String additionalneeds) {
        return BookingCreateRequest.builder()
                .firstname(firstname)
                .lastname(lastname)
                .totalprice(totalprice)
                .depositpaid(depositpaid)
                .bookingdates(bookingdates)
                .additionalneeds(additionalneeds)
                .build();
    }
}
