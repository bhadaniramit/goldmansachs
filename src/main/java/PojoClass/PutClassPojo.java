package PojoClass;

import com.google.gson.Gson;

import java.util.Map;

public class PutClassPojo {

    public String putBodyBuild(Map<String, String> myPutMap) {
        HeaderPojo headerPojo = new HeaderPojo();
        headerPojo.setFirstName(myPutMap.get("First_Name"));
        Gson gson = new Gson();
        return gson.toJson(headerPojo);
    }

}
