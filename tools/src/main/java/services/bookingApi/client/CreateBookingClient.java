package services.bookingApi.client;

import apihelper.GeneralServiceHelper;
import constants.Url;
import io.restassured.specification.ResponseSpecification;
import services.bookingApi.request.BookingCreateRequest;
import services.bookingApi.response.BookingCreateResponse;

import static io.restassured.RestAssured.given;

public class CreateBookingClient extends GeneralServiceHelper {
    public CreateBookingClient() {
        super(Url.BOOKING_TEST_URL);
    }

    private static final String CONTENT_TYPE = "content-type";
    private static final String APPLICATION_JSON = "application/json; charset=utf-8";

    public BookingCreateResponse createBooking(BookingCreateRequest body, ResponseSpecification spec) {

        return given()
                .spec(getReqSpec())
                .header(CONTENT_TYPE, APPLICATION_JSON)
                .body(body)
                .log().all()
                .when()
                .post("/booking")
                .then()
                .log().all()
                .assertThat()
                .spec(spec)
                .extract()
                .response()
                .jsonPath()
                .getObject("", BookingCreateResponse.class);

    }
}
