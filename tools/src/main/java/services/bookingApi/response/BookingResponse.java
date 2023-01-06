package services.bookingApi.response;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import services.bookingApi.request.BookingDateDTO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingResponse {
    private String firstname;
    private String lastname;
    private Long totalprice;
    private Boolean depositpaid;
    private BookingDateDTO bookingdates;
    private String additionalneeds;

    public static BookingResponse initialize(String firstname, String lastname, Long totalprice, Boolean depositpaid, BookingDateDTO bookingdates, String additionalneeds) {
        return BookingResponse.builder()
                .firstname(firstname)
                .lastname(lastname)
                .totalprice(totalprice)
                .depositpaid(depositpaid)
                .bookingdates(bookingdates)
                .additionalneeds(additionalneeds)
                .build();
    }
}
