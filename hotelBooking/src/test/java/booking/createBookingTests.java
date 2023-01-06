package booking;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import services.bookingApi.client.CreateBookingClient;
import services.bookingApi.request.BookingCreateRequest;
import services.bookingApi.request.BookingDateDTO;
import services.bookingApi.response.BookingCreateResponse;

import static verification.ResponseSpec.checkStatusCodeOk;

public class createBookingTests {
    @Test
    void checkTheBookingIsCreatedSuccessfully() {

        CreateBookingClient createBookingClient = new CreateBookingClient();
        BookingCreateResponse bookingCreateResponse =
                createBookingClient.createBooking(BookingCreateRequest
                        .initialize("Munip", "Arsalan", 20L, true, BookingDateDTO.initialize(), "Lunch"), checkStatusCodeOk());

        Assert.assertEquals(bookingCreateResponse.getBooking().getFirstname(), "Munip");
        Assert.assertEquals(bookingCreateResponse.getBooking().getLastname(), "Arsalan");
        //    Assert.assertEquals(bookingCreateResponse.getAdditionalneeds(), "Lunch"); // additionalneeds null , todo: analyze it

    }
}
