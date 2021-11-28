package PojoClass;

import com.google.gson.Gson;

import java.util.Map;

public class PostCallPojo {
    HeaderPojo headerPojo;

    public String addUserPojo(Map<String, String> myData) {
        GeoPojo geoPojo = new GeoPojo();
        AddressPojo addressPojo = new AddressPojo();
        geoPojo.setLat(myData.get("LatitudeValue"));
        geoPojo.setLng(myData.get("LongitudeValue"));

        addressPojo.setHouse(myData.get("HouseAddress"));
        addressPojo.setStreet(myData.get("StreetAddress"));
        addressPojo.setZipcode(Integer.parseInt(myData.get("ZipCode")));
        addressPojo.setCountry(myData.get("Country"));
        addressPojo.setGeoPojo(geoPojo);

        headerPojo.setId(Integer.parseInt(myData.get("Id")));
        headerPojo.setFirstName(myData.get("FirstName"));
        headerPojo.setLastName(myData.get("LastName"));
        headerPojo.setUsername(myData.get("UserName"));
        headerPojo.setAvatar(myData.get("Avatar"));
        headerPojo.setEmail(myData.get("Email"));
        headerPojo.setAge(Integer.parseInt(myData.get("Age")));
        headerPojo.setGender(myData.get("Gender"));
        headerPojo.setMaritalStatus(myData.get("MaritalStatus"));
        headerPojo.setAddressPojo(addressPojo);
        headerPojo.getId();
        Gson gson = new Gson();
        return gson.toJson(headerPojo);
    }

    public String orginialPostCall(Map<String, String> oriMap) {
        headerPojo = new HeaderPojo();
        headerPojo.setFirstName(oriMap.get("FirstName"));
        headerPojo.setLastName(oriMap.get("LastName"));
        headerPojo.setUsername(oriMap.get("Username"));
        headerPojo.setAvatar(oriMap.get("Avatar"));
        headerPojo.setEmail(oriMap.get("email"));
        validateTheResponse();
        Gson gson = new Gson();
        return gson.toJson(headerPojo);
    }

    public void validateTheResponse() {
        System.out.println("Email ------ " +headerPojo.getEmail());
        System.out.println("First_Name ------ " +headerPojo.getFirstName());
        System.out.println("Last_Name ------ " +headerPojo.getLastName());
    }

}
