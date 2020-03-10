import PayLoadPojo.ExecutiveSummaryPayLoad.SetValue.ExecutiveSummaryPayLoadSetValue;
import ResponsePojo.ExecutiveSummary.ExecutiveSummaryResponseMetricsDTO;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.EndPointResource;
import utils.ReuseableMethods;

import java.io.FileNotFoundException;

import static io.restassured.RestAssured.given;

public class ExecutiveSummaryTest extends ReuseableMethods {
    RequestSpecification request;
    EndPointResource resource;
    ExecutiveSummaryPayLoadSetValue executiveSummaryPayLoadSetValue;
    ExecutiveSummaryResponseMetricsDTO executiveSummaryResponseMetricsDTO;

    @BeforeClass
    public void initializeToken() {
        resource = EndPointResource.valueOf("ExexutiveSummaryAPI");
        executiveSummaryPayLoadSetValue = new ExecutiveSummaryPayLoadSetValue();
        executiveSummaryResponseMetricsDTO = new ExecutiveSummaryResponseMetricsDTO();
    }

    @Test(dataProvider = "executiveSummaryData")
    public void getExectuiveSummaryTableData(String AnalyzeBy, String AnalysisPeriod) throws FileNotFoundException {

        request = given().
                spec(getRequest()).
                body(executiveSummaryPayLoadSetValue.setValue(AnalyzeBy,AnalysisPeriod));

        executiveSummaryResponseMetricsDTO = request.
                when().
                post(resource.getResource()).
                then().spec(getResponse()).
                extract().response().as(ExecutiveSummaryResponseMetricsDTO.class);
    }


    @DataProvider
    public Object[][] executiveSummaryData() {
        return new Object[][]{
                {"FULL_CYCLE", "INCURRED_DATE"},
                {"FULL_CYCLE", "PAID_DATE"},
                {"CONTRACT_YEAR", "INCURRED_DATE"},
                {"CONTRACT_YEAR", "PAID_DATE"},
                {"ROLLING_YEAR", "INCURRED_DATE"},
                {"ROLLING_YEAR", "PAID_DATE"}

        };
    }
}
