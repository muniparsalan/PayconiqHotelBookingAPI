package booking;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import services.bookingApi.client.CreateBookingClient;
import services.bookingApi.client.DeleteBookingClient;
import services.bookingApi.client.GetBookingClient;
import services.bookingApi.request.BookingCreateRequest;
import services.bookingApi.request.BookingDateDTO;
import services.bookingApi.response.BookingCreateResponse;

import static verification.ResponseSpec.checkStatusCodeCreated;
import static verification.ResponseSpec.checkStatusCodeOk;


public class deleteBookingTests {
    @Test
    void deleteTheCreatedBookingSuccesfully() throws JsonProcessingException {

        CreateBookingClient createBookingClient = new CreateBookingClient();
        GetBookingClient getBookingClient = new GetBookingClient();
        DeleteBookingClient deleteBookingClient = new DeleteBookingClient();

        BookingCreateResponse bookingCreateResponse =
                createBookingClient.createBooking(BookingCreateRequest
                        .initialize("Senol", "Mert", 40L, true, BookingDateDTO.initialize(), "Dinner"), checkStatusCodeOk());

        Assert.assertEquals(getBookingClient.retrieveBooking(bookingCreateResponse.getBookingid(), checkStatusCodeOk()).getFirstname(), "Senol");
        Assert.assertEquals(getBookingClient.retrieveBooking(bookingCreateResponse.getBookingid(), checkStatusCodeOk()).getLastname(), "Mert");
        Assert.assertEquals(getBookingClient.retrieveBooking(bookingCreateResponse.getBookingid(), checkStatusCodeOk()).getAdditionalneeds(), "Dinner");

        deleteBookingClient.deleteBooking(bookingCreateResponse.getBookingid(), checkStatusCodeCreated());

    }
}
