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
public class BookingDTO {

private String firstname;
private String lastname;
private Long totalprice;
private Boolean depositpaid;
private BookingDateDTO bookingdates;

public static BookingDTO initialize(String firstname, String lastname, Long totalprice, Boolean depositpaid, BookingDateDTO bookingdates){
        return BookingDTO.builder()
        .firstname(firstname)
        .lastname(lastname)
        .totalprice(totalprice)
        .depositpaid(depositpaid)
        .bookingdates(bookingdates)
        .build();
        }
}
