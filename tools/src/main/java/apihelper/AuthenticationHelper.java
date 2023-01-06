package apihelper;

import constants.Url;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import services.bookingApi.request.TokenRequest;
import services.bookingApi.response.BookingCreateResponse;
import services.bookingApi.response.TokenResponse;

import static io.restassured.RestAssured.given;

public class AuthenticationHelper extends GeneralServiceHelper {
    private static final String CONTENT_TYPE = "content-type";
    private static final String APPLICATION_JSON = "application/json; charset=utf-8";

    public AuthenticationHelper() {
        super(Url.BOOKING_TEST_URL);
    }

    public TokenResponse getAdminToken(TokenRequest tokenRequest, ResponseSpecification spec) {
        return given()
                .spec(getReqSpec())
                .header(CONTENT_TYPE, APPLICATION_JSON)
                .body(tokenRequest)
                .log().all()
                .when()
                .post("/auth")
                .then()
                .log().all()
                .assertThat()
                .spec(spec)
                .extract()
                .response()
                .jsonPath()
                .getObject("", TokenResponse.class);
    }

}
