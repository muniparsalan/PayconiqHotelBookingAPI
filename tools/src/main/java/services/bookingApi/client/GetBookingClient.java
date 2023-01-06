package services.bookingApi.client;

import apihelper.GeneralServiceHelper;
import constants.Url;
import io.restassured.specification.ResponseSpecification;
import services.bookingApi.response.BookingCreateResponse;
import services.bookingApi.response.BookingId;
import services.bookingApi.response.BookingResponse;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GetBookingClient extends GeneralServiceHelper {
    public GetBookingClient() {
        super(Url.BOOKING_TEST_URL);
    }

    private static final String CONTENT_TYPE = "content-type";
    private static final String APPLICATION_JSON = "application/json; charset=utf-8";

    public BookingResponse retrieveBooking(Long id, ResponseSpecification spec) {

        return given()
                .spec(getReqSpec())
                .header(CONTENT_TYPE, APPLICATION_JSON)
                .pathParam("id", id)
                .log().all()
                .when()
                .get("/booking/{id}")
                .then()
                .log().all()
                .assertThat()
                .spec(spec)
                .extract()
                .response()
                .jsonPath()
                .getObject("", BookingResponse.class);

    }

    public List<BookingId> getAllBookingIds(ResponseSpecification spec) {

        return given()
                .spec(getReqSpec())
                .header(CONTENT_TYPE, APPLICATION_JSON)
                .log().all()
                .when()
                .get("/booking")
                .then()
                .log().all()
                .assertThat()
                .spec(spec)
                .extract()
                .response()
                .jsonPath()
                .getList("", BookingId.class);

    }

    public List<BookingCreateResponse> getBookingIdsWithParam2(HashMap<String, Object> params, ResponseSpecification spec) {

        return given()
                .spec(getReqSpec())
                .header(CONTENT_TYPE, APPLICATION_JSON)
                .queryParams(params)
                .log().all()
                .when()
                .get("/booking")
                .then()
                .log().all()
                .assertThat()
                .spec(spec)
                .extract()
                .response()
                .jsonPath()
                .getList("", BookingCreateResponse.class);

    }
}
