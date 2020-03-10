import PayLoadPojo.Indv301Payload.SetValue.Indv301PayLoadSetValue;
import ResponsePojo.Individual301.Indv301ResponseMetricsDTO;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.EndPointResource;
import utils.ReuseableMethods;

import java.io.FileNotFoundException;

import static io.restassured.RestAssured.given;

public class Individual301Test extends ReuseableMethods {
    RequestSpecification request;
    Indv301ResponseMetricsDTO indv301ResponseMetricsDTO;
    EndPointResource resource;
    Indv301PayLoadSetValue indv301PayLoadSetValue;

    @BeforeClass
    public void initializeToken() {
        indv301ResponseMetricsDTO = new Indv301ResponseMetricsDTO();
        resource = EndPointResource.valueOf("Indv301MembersAPI");
        indv301PayLoadSetValue = new Indv301PayLoadSetValue();
    }

    @Test(dataProvider = "individualDashboardData")
    public void getMembersData(String AnalyzeBy, String AnalysisPeriod, String Age, String AdmitCount) throws FileNotFoundException {

        request = given().
                spec(getRequest()).
                body(indv301PayLoadSetValue.setValue(AnalyzeBy,AnalysisPeriod,Age,AdmitCount));

        indv301ResponseMetricsDTO = request.
                when().
                post(resource.getResource()).
                then().spec(getResponse()).
                extract().response().as(Indv301ResponseMetricsDTO.class);
    }

    @Test(dependsOnMethods = "getMembersData")
    public void defaultSortTest() {
        int indvCount = indv301ResponseMetricsDTO.getData().size();
        //Test for Data is sorted by total paid by default
        for (int k = 0; k < indvCount - 1; k++) {
            System.out.println(indv301ResponseMetricsDTO.getData().get(k).getTotpaidamt());
            if (indv301ResponseMetricsDTO.getData().get(k).getTotpaidamt() < indv301ResponseMetricsDTO.getData().get(k + 1).getTotpaidamt()) {
                Assert.assertTrue(false);
            }
        }

    }

    @Test(dependsOnMethods = "getMembersData")
    public void genderTest() {
        int indvCount = indv301ResponseMetricsDTO.getData().size();
        //Test for Data is sorted by total paid by default
        for (int k = 0; k < indvCount - 1; k++) {
            System.out.println(indv301ResponseMetricsDTO.getData().get(k).getGender());
            if (!(indv301ResponseMetricsDTO.getData().get(k).getGender().contains("M") || indv301ResponseMetricsDTO.getData().get(k).getGender().contains("F"))) {
                Assert.assertTrue(false);
            }
        }

    }

    @DataProvider
    public Object[][] individualDashboardData() {


        return new Object[][]{
                {"FULL_CYCLE", "INCURRED_DATE","70","2"},
//                {"FULL_CYCLE", "PAID_DATE","3"},
//                {"CONTRACT_YEAR", "INCURRED_DATE","4"},
//                {"CONTRACT_YEAR", "PAID_DATE","5"},
//                {"ROLLING_YEAR", "INCURRED_DATE","2"},
//                {"ROLLING_YEAR", "PAID_DATE","6"}
        };
    }
}
