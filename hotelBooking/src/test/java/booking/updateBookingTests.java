package booking;

import org.junit.jupiter.api.Test;
import org.junit.Assert;
import services.bookingApi.client.CreateBookingClient;
import services.bookingApi.client.GetBookingClient;
import services.bookingApi.client.PatchBookingClient;
import services.bookingApi.request.BookingCreateRequest;
import services.bookingApi.request.BookingDateDTO;
import services.bookingApi.request.PartialUpdateRequest;
import services.bookingApi.response.BookingCreateResponse;

import static verification.ResponseSpec.checkStatusCodeOk;

public class updateBookingTests {

    @Test
    void checkTheBookingIsUpdatedSuccessfully() {
        CreateBookingClient createBookingClient = new CreateBookingClient();
        GetBookingClient getBookingClient = new GetBookingClient();
        PatchBookingClient patchBookingClient = new PatchBookingClient();

        BookingCreateResponse bookingCreateResponse =
                createBookingClient.createBooking(BookingCreateRequest
                        .initialize("Meriç", "Merve", 30L, false, BookingDateDTO.initialize(), "Breakfast"), checkStatusCodeOk());

        patchBookingClient.updateBookingByPartially(PartialUpdateRequest.initialize("x", "y"), bookingCreateResponse.getBookingid(), checkStatusCodeOk());

        Assert.assertEquals(getBookingClient.retrieveBooking(bookingCreateResponse.getBookingid(), checkStatusCodeOk()).getFirstname(), "x");
        Assert.assertEquals(getBookingClient.retrieveBooking(bookingCreateResponse.getBookingid(), checkStatusCodeOk()).getLastname(), "y");
        Assert.assertEquals(getBookingClient.retrieveBooking(bookingCreateResponse.getBookingid(), checkStatusCodeOk()).getAdditionalneeds(), "Breakfast");

    }
    }
