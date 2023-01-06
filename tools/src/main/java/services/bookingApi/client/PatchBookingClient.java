package services.bookingApi.client;

import apihelper.AuthenticationHelper;
import apihelper.GeneralServiceHelper;
import constants.Url;
import io.restassured.specification.ResponseSpecification;
import services.bookingApi.request.PartialUpdateRequest;
import services.bookingApi.request.TokenRequest;
import services.bookingApi.response.BookingResponse;
import services.bookingApi.response.TokenResponse;

import static io.restassured.RestAssured.given;

public class PatchBookingClient extends GeneralServiceHelper {
    public PatchBookingClient() {
        super(Url.BOOKING_TEST_URL);
    }

    private static final String CONTENT_TYPE = "content-type";
    private static final String APPLICATION_JSON = "application/json; charset=utf-8";

    public BookingResponse updateBookingByPartially(PartialUpdateRequest body, Long id, ResponseSpecification spec) {

        TokenResponse token;
        TokenRequest tokenRequest = new TokenRequest();
        AuthenticationHelper authenticationHelper = new AuthenticationHelper();
        token = authenticationHelper.getAdminToken(tokenRequest, spec);

        return given()
                .spec(getReqSpec())
                .header(CONTENT_TYPE, APPLICATION_JSON)
                .auth()
                .preemptive()
                .basic("admin", "password123")
                .pathParam("id", id)
                .body(body)
                .log().all()
                .when()
                .patch("/booking/{id}")
                .then()
                .log().all()
                .assertThat()
                .spec(spec)
                .extract()
                .response()
                .jsonPath()
                .getObject("", BookingResponse.class);

    }
}
