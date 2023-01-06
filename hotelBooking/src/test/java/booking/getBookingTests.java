package booking;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import services.bookingApi.client.CreateBookingClient;
import services.bookingApi.client.DeleteBookingClient;
import services.bookingApi.client.GetBookingClient;
import services.bookingApi.request.BookingCreateRequest;
import services.bookingApi.request.BookingDateDTO;
import services.bookingApi.response.BookingCreateResponse;
import services.bookingApi.response.BookingId;

import java.util.HashMap;
import java.util.List;

import static verification.ResponseSpec.checkStatusCodeCreated;
import static verification.ResponseSpec.checkStatusCodeOk;

public class getBookingTests {
    @Test
    void retrieveTheCreatedBookingSuccesfully() {

        CreateBookingClient createBookingClient = new CreateBookingClient();
        GetBookingClient getBookingClient = new GetBookingClient();

        BookingCreateResponse bookingCreateResponse =
                createBookingClient.createBooking(BookingCreateRequest
                        .initialize("Meriç", "Merve", 30L, false, BookingDateDTO.initialize(), "Breakfast"), checkStatusCodeOk());

        Assert.assertEquals(getBookingClient.retrieveBooking(bookingCreateResponse.getBookingid(), checkStatusCodeOk()).getFirstname(), "Meriç");
        Assert.assertEquals(getBookingClient.retrieveBooking(bookingCreateResponse.getBookingid(), checkStatusCodeOk()).getLastname(), "Merve");
        // Assert.assertEquals(getBookingClient.retrieveBooking(bookingCreateResponse.getBookingid(), checkStatusCodeOk()).getAdditionalneeds(), "Breakfast");

    }

    @Test
    void getAllBookingIds() {

        CreateBookingClient createBookingClient = new CreateBookingClient();
        GetBookingClient getBookingClient = new GetBookingClient();
        DeleteBookingClient deleteBookingClient = new DeleteBookingClient();
        // assume that there is no data in this list and want to add smt.
        BookingCreateResponse resp1 = createBookingClient.createBooking(BookingCreateRequest
                .initialize("Melinda", "Munip", 30L, false, BookingDateDTO.initialize(), "Breakfast"), checkStatusCodeOk());
        BookingCreateResponse resp2 = createBookingClient.createBooking(BookingCreateRequest
                .initialize("Berk", "Bulent", 50L, true, BookingDateDTO.initialize(), "Breakfast"), checkStatusCodeOk());

        //   List<BookingCreateResponse> resps = getBookingClient.getAllBookingIds2(checkStatusCodeOk());

        List<BookingId> resps2 = getBookingClient.getAllBookingIds(checkStatusCodeOk());
        for (BookingId resp : resps2) {

            Assert.assertNotNull(getBookingClient.retrieveBooking(resp.getBookingId(), checkStatusCodeOk()).getFirstname());

        }

        // In order for assertions to work correctly, only my datas are required. There is a lot of datas

       /*
        for (BookingCreateResponse resp : resps) {

            Assert.assertNotNull(getBookingClient.retrieveBooking(resp.getBookingid(), checkStatusCodeOk()).getFirstname());

        }
*/
        deleteBookingClient.deleteBooking(resp1.getBookingid(), checkStatusCodeCreated());
        deleteBookingClient.deleteBooking(resp2.getBookingid(), checkStatusCodeCreated());
    }

    @Test
    void getBookingIdsByFirstname() {

        CreateBookingClient createBookingClient = new CreateBookingClient();
        GetBookingClient getBookingClient = new GetBookingClient();
        DeleteBookingClient deleteBookingClient = new DeleteBookingClient();
        // assume that there is no data in this list and want to add smt.

        BookingCreateResponse resp1 = createBookingClient.createBooking(BookingCreateRequest
                .initialize("Meriç", "Yavuz", 30L, false, BookingDateDTO.initialize(), "Dinner"), checkStatusCodeOk());
        BookingCreateResponse resp2 = createBookingClient.createBooking(BookingCreateRequest
                .initialize("Mehmet", "Guner", 50L, true, BookingDateDTO.initialize(), "Breakfast"), checkStatusCodeOk());
        BookingCreateResponse resp3 = createBookingClient.createBooking(BookingCreateRequest
                .initialize("Munip", "Mert", 60L, false, BookingDateDTO.initialize(), "Lunch"), checkStatusCodeOk());

        HashMap<String, Object> params = new HashMap<>();
        params.put("firstname", "Munip");

        List<BookingCreateResponse> resps = getBookingClient.getBookingIdsWithParam2(params, checkStatusCodeOk());

        for (BookingCreateResponse resp : resps) {

            Assert.assertEquals(getBookingClient.retrieveBooking(resp.getBookingid(), checkStatusCodeOk()).getFirstname(), "Munip");

        }

        deleteBookingClient.deleteBooking(resp1.getBookingid(), checkStatusCodeCreated());
        deleteBookingClient.deleteBooking(resp2.getBookingid(), checkStatusCodeCreated());
        deleteBookingClient.deleteBooking(resp3.getBookingid(), checkStatusCodeCreated());

    }

    @Test
    void getBookingIdsByLastname() {

        CreateBookingClient createBookingClient = new CreateBookingClient();
        GetBookingClient getBookingClient = new GetBookingClient();
        DeleteBookingClient deleteBookingClient = new DeleteBookingClient();
        // assume that there is no data in this list and want to add smt.
        BookingCreateResponse resp1 = createBookingClient.createBooking(BookingCreateRequest
                .initialize("Merve", "Meriç", 30L, false, BookingDateDTO.initialize(), "Dinner"), checkStatusCodeOk());
        BookingCreateResponse resp2 = createBookingClient.createBooking(BookingCreateRequest
                .initialize("Ulku", "Mehmet", 50L, true, BookingDateDTO.initialize(), "Lunch"), checkStatusCodeOk());
        BookingCreateResponse resp3 = createBookingClient.createBooking(BookingCreateRequest
                .initialize("Senol", "Munip", 70L, false, BookingDateDTO.initialize(), "Cleaning twice in a day"), checkStatusCodeOk());

        HashMap<String, Object> params = new HashMap<>();
        params.put("lastname", "Munip");

        List<BookingCreateResponse> resps = getBookingClient.getBookingIdsWithParam2(params, checkStatusCodeOk());

        for (BookingCreateResponse resp : resps) {

            Assert.assertEquals(getBookingClient.retrieveBooking(resp.getBookingid(), checkStatusCodeOk()).getLastname(), "Munip");

        }

        deleteBookingClient.deleteBooking(resp1.getBookingid(), checkStatusCodeCreated());
        deleteBookingClient.deleteBooking(resp2.getBookingid(), checkStatusCodeCreated());
        deleteBookingClient.deleteBooking(resp3.getBookingid(), checkStatusCodeCreated());

    }
}
