
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class RestUtils {


    public Response getrequest(String url) {
        return  given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .log().all()
                .get(url);
    }

    public Response getrequestwithParam(String url, String pathParam, Map<String, Integer> page, Map<String, Integer> limit) {
        return given()
                .param(pathParam)
                .queryParams(page)
                .queryParams(limit)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .log().all()
                .get(url);
    }


    public Response postrequestwithParam(String url, String myPostBody) {
        baseURI = "http://fakeapi.jsonparseronline.com/users";
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(myPostBody)
                .log().all()
                .post(url);
    }


    public Response putrequestwithParam(String url, String myPutBody) {
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("user", 1)
                .body(myPutBody)
                .log().all()
                .put(url);
    }
}
