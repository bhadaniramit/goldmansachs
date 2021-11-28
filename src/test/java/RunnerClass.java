import PojoClass.HeaderPojo;
import PojoClass.PostCallPojo;
import PojoClass.PutClassPojo;
import io.cucumber.java.en.Given;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;

public class RunnerClass extends PostCallPojo {
    private int Id;
    private String FirstName;
    private String LastName;
    private String Username;
    private String Avatar;
    private String Email;
    ArrayList<Integer> myIdList;
    RestUtils restUtils;
    String myGetResponsewithoutParam;

    @Given("user make a get call without any parameter")
    public void user_make_a_get_call_without_any_parameter() {
        baseURI = "http://fakeapi.jsonparseronline.com/users/1";
        restUtils = new RestUtils();
        myIdList = new ArrayList<Integer>();
//        Map<String, String> itrMap = new HashMap<>();
//        myGetResponsewithoutParam = restUtils.getrequest(baseURI).getBody().asPrettyString();
         PostCallPojo postCallPojo =  restUtils.getrequest(baseURI).as(PostCallPojo.class);
        System.out.println(myGetResponsewithoutParam);
        Id = JsonPath.from(myGetResponsewithoutParam).get("id");
        FirstName = JsonPath.from(myGetResponsewithoutParam).get("firstName");
        LastName = JsonPath.from(myGetResponsewithoutParam).get("lastName");
        Username = JsonPath.from(myGetResponsewithoutParam).get("username");
        Avatar = JsonPath.from(myGetResponsewithoutParam).get("avatar");
        Email = JsonPath.from(myGetResponsewithoutParam).get("email");
 /*       HeaderPojo headerPojo = new HeaderPojo();
/      for (Integer myIdItr : myIdList) {
            headerPojo.setId(myIdItr);
            Assert.assertEquals("My response for Id", 1, headerPojo.getId());
        }*/
    }

    @Given("user make a get call by using a query parameter")
    public void user_make_a_get_call_by_using_a_query_parameter() {
        baseURI = "http://fakeapi.jsonparseronline.com/";
        myIdList = new ArrayList<Integer>();
        String pathParameter = "users";
        HashMap<String, Integer> pageMap = new HashMap<>();
        HashMap<String, Integer> limitMap = new HashMap<>();
        pageMap.put("_page", 2);
        limitMap.put("_limit", 5);
        restUtils = new RestUtils();
        String myGetResponsewithParam = restUtils.getrequestwithParam(baseURI, pathParameter, pageMap, limitMap).getBody().asPrettyString();
        System.out.println(myGetResponsewithParam);
    }

    @Given("I will make a post call using the get data")
    public void i_will_make_a_post_call_using_the_get_data() {
        HeaderPojo headerPojo1 = new HeaderPojo();
        restUtils = new RestUtils();

        String url = "http://fakeapi.jsonparseronline.com/users";
        PostCallPojo postCallPojo = new PostCallPojo();
        HashMap<String, String> mypostBodyMap = new HashMap<>();
        mypostBodyMap.put("Id", String.valueOf(Id));
        mypostBodyMap.put("FirstName", FirstName);
        mypostBodyMap.put("LastName", LastName);
        mypostBodyMap.put("Username", Username);
        mypostBodyMap.put("Avatar", Avatar);
        mypostBodyMap.put("email", Email);

        String myPostBody = postCallPojo.orginialPostCall(mypostBodyMap);
        headerPojo1.getLastName();

        Response postResponse = restUtils.postrequestwithParam(url, myPostBody);

        String contentType = postResponse.getHeaders().get("Content-Type").toString();
    }

    @Given("user will trigger the Put Call")
    public void user_will_trigger_the_put_call() {
        PutClassPojo putClassPojo = new PutClassPojo();
        RestUtils restUtils = new RestUtils();
        String URL = "http://fakeapi.jsonparseronline.com/users/{user}";
        HashMap<String, String> myPutMap = new HashMap<>();
        myPutMap.put("First_Name", FirstName);
        String myPutBody = putClassPojo.putBodyBuild(myPutMap);
        Response response = restUtils.putrequestwithParam(URL, myPutBody);
        System.out.println(response.asPrettyString());
    }
}
