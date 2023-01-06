package services.bookingApi.client;

import apihelper.AuthenticationHelper;
import apihelper.GeneralServiceHelper;
import constants.Url;
import io.restassured.specification.ResponseSpecification;
import services.bookingApi.request.TokenRequest;
import services.bookingApi.response.TokenResponse;

import static io.restassured.RestAssured.given;
import static verification.ResponseSpec.checkStatusCodeOk;

public class DeleteBookingClient extends GeneralServiceHelper {
    public DeleteBookingClient() {
        super(Url.BOOKING_TEST_URL);
    }

    private static final String CONTENT_TYPE = "content-type";
    private static final String APPLICATION_JSON = "application/json; charset=utf-8";
    private static final String APPLICATION_JSON2 = "application/json";


    TokenRequest tokenRequest = new TokenRequest();
    AuthenticationHelper authenticationHelper = new AuthenticationHelper();
    TokenResponse tokenResponse = authenticationHelper.getAdminToken(tokenRequest, checkStatusCodeOk());

    public void deleteBooking(Long id, ResponseSpecification spec) {

        given().spec(getReqSpec())
                .header(CONTENT_TYPE, APPLICATION_JSON)
                .auth()
                .preemptive()
                .basic("admin", "password123")
                .pathParam("id", id)
                .log().all()
                .when()
                .delete("/booking/{id}")
                .then()
                .log()
                .all()
                .assertThat()
                .spec(spec);


    }
}
