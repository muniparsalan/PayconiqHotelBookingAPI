package services.bookingApi.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingDateDTO {

    @Builder.Default
    private LocalDate checkin = LocalDate.now();
    @Builder.Default
    private LocalDate checkout = LocalDate.now().plusDays(7);

    public static BookingDateDTO initialize() {
        return BookingDateDTO.builder()
                .build();
    }

    public static BookingDateDTO initialize(LocalDate checkin, LocalDate checkout) {
        return BookingDateDTO.builder()
                .checkin(checkin)
                .checkout(checkout)
                .build();
    }
}
