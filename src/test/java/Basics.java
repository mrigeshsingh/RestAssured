import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class Basics {

    @Test
    public void Test() {
        RestAssured.baseURI = "https://maps.googleapis.com";
        given().
                param("input", "[{\"key\":\"input\",\"value\":\"Museum%20of%20Contemporary%20Art%20Australia\",\"equals\":true,\"description\":\"\",\"enabled\":true}]").
                param("inputtype", "textquery").
                param("fields", "photos,formatted_address,name,rating,opening_hours,geometry").
                param("key", "AIzaSyAywdX7xjBXN0_Kqf3jYREys0PUXGZF9BM").

                when().
                get("/maps/api/place/findplacefromtext/json").

                then().assertThat().
                statusCode(200).and().contentType(ContentType.JSON);
        //and().
        //body("results[0].geometry.location.lat",equalTo(""));
    }

    @Test
    public void addDeletePlace() {
        RestAssured.baseURI = "http://216.10.245.166";
        Response res = given().
                //param("input","[{\"key\":\"input\",\"value\":\"Museum%20of%20Contemporary%20Art%20Australia\",\"equals\":true,\"description\":\"\",\"enabled\":true}]").
                //param("inputtype","textquery").
                //param("fields","photos,formatted_address,name,rating,opening_hours,geometry").
                        queryParam("key", "qaclick123").
                        body("{\n" +
                                "\n" +
                                "    \"location\":{\n" +
                                "\n" +
                                "        \"lat\" : -38.383494,\n" +
                                "\n" +
                                "        \"lng\" : 33.427362\n" +
                                "\n" +
                                "    },\n" +
                                "\n" +
                                "    \"accuracy\":50,\n" +
                                "\n" +
                                "    \"name\":\"Frontline house\",\n" +
                                "\n" +
                                "    \"phone_number\":\"(+91) 983 893 3937\",\n" +
                                "\n" +
                                "    \"address\" : \"29, side layout, cohen 09\",\n" +
                                "\n" +
                                "    \"types\": [\"shoe park\",\"shop\"],\n" +
                                "\n" +
                                "    \"website\" : \"http://google.com\",\n" +
                                "\n" +
                                "    \"language\" : \"French-IN\"\n" +
                                "\n" +
                                "}").
                        when().
                        post("/maps/api/place/add/json").

                        then().assertThat().
                        statusCode(200).and().contentType(ContentType.JSON).
                        and().
                //body("status", equalTo("OK"));

                        extract().response();

        String responseString = res.asString();
        //System.out.println(responseString);
        JsonPath js = new JsonPath(responseString);
        //System.out.println(js.get("place_id"));
        String placeID = js.get("place_id");
        //js.get("","")


        //delete the selected place ID
        given().

                queryParam("key", "qaclick123").
                body("{\n" +
                        "    \"place_id\": \"" + placeID + "\"" +
                        "}").
                when().
                post("/maps/api/place/add/json").

                then().assertThat().
                statusCode(200).and().contentType(ContentType.JSON).

                and().
                body("status",equalTo("OK"));
    }

//    @Test
//    public void deletePlace() {
//        RestAssured.baseURI = "http://216.10.245.166";
//        given().
//
//                queryParam("key", "qaclick123").
//                body("{\n" +
//                        "    \"place_id\":\"6ce69fa0fd85944cfada5476ea786577\"\n" +
//                        "}").
//                when().
//                post("/maps/api/place/add/json").
//
//                then().assertThat().
//                statusCode(200).and().contentType(ContentType.JSON).
//
//                and().
//                body("status", equalTo("OK"));
//    }
}
