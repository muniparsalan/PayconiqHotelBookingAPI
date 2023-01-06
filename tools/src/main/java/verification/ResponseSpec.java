package verification;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;

import static org.hamcrest.Matchers.equalTo;


public class ResponseSpec {
    private ResponseSpec() {
    }

    public static ResponseSpecification checkStatusCodeOk() {
        return new ResponseSpecBuilder().expectStatusCode(HttpStatus.SC_OK).build();
    }

    public static ResponseSpecification checkStatusCodeBadRequest() {

        return new ResponseSpecBuilder().expectStatusCode(HttpStatus.SC_BAD_REQUEST).build();
    }

    public static ResponseSpecification checkStatusCodeInternalError() {
        return new ResponseSpecBuilder().expectStatusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR).build();
    }

    public static ResponseSpecification checkStatusCodeNotFound() {
        return new ResponseSpecBuilder().expectStatusCode(HttpStatus.SC_NOT_FOUND).build();
    }

    public static ResponseSpecification checkStatusCodeCreated() {

        return new ResponseSpecBuilder().expectStatusCode(HttpStatus.SC_CREATED).build();
    }
}
