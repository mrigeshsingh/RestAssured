import ResponsePojo.ExecutiveDashboard.EDMetricsResponseDTO;
import ResponsePojo.ExecutiveDashboard.QualityMeasures.EDQualityMeasuresMetricsResponseDTO;
import ResponsePojo.ExecutiveDashboard.Risk.EDRiskMetricsResponseDTO;
import ResponsePojo.Individual301.Indv301ResponseMetricsDTO;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import PayLoadPojo.ExecutiveDashbordPayload;
import utils.EndPointResource;
import utils.ReuseableMethods;

import java.io.FileNotFoundException;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class ExecutiveDashboardTest extends ReuseableMethods {

    ExecutiveDashbordPayload payload;
    String token;
    RequestSpecification request;
    EDMetricsResponseDTO edMetricsResponseDTO;
    EndPointResource resource;


    @BeforeClass
    public void initializeToken() throws IOException {
        payload = new ExecutiveDashbordPayload();
        token = getStaticToken();
        edMetricsResponseDTO = new EDMetricsResponseDTO();
        resource = EndPointResource.valueOf("ExexutiveDashboardKPIAPI");
    }


    @Test(dataProvider = "executiveDashboardData")
    public void getKPIData(String AnalyzeBy, String AnalysisPeriod) throws FileNotFoundException {

        request = given().
                spec(getRequest()).
                body(payload.getExecutiveDashbordPayload("kpi", AnalyzeBy, AnalysisPeriod));

        edMetricsResponseDTO = request.
                when().
                post(resource.getResource()).
                then().spec(getResponse()).
                extract().response().as(EDMetricsResponseDTO.class);

//        RestAssured.baseURI = prop.getProperty("baseURI");
//        EDMetricsResponseDTO kpiResponse = given().
//                queryParam("appId", prop.getProperty("appId")).
//                header("Authorization", "Bearer " + token).
//                header("Content-Type", "application/json").
//                body(payload.getExecutiveDashbordPayload("kpi", AnalyzeBy, AnalysisPeriod)).
//                when().
//                post("/director/kpi").
//                then().assertThat().
//                statusCode(200).
//                extract().response().as(EDMetricsResponseDTO.class);

//        Assert.assertTrue(kpiResponse.getExecutiveSummaryResponseInfo().get("avgRisk_55").getLabel().contains("AVERAGE RISK SCORE (MODEL #55)"));
//        Assert.assertTrue(kpiResponse.getExecutiveSummaryResponseInfo().get("avgRisk_55").getUnit().contains("RRS"));
//
//        Assert.assertTrue(kpiResponse.getExecutiveSummaryResponseInfo().get("avgRisk_18").getLabel().contains("AVERAGE RISK SCORE (MODEL #18)"));
//        Assert.assertTrue(kpiResponse.getExecutiveSummaryResponseInfo().get("avgRisk_18").getUnit().contains("RRS"));
//
//        Assert.assertTrue(kpiResponse.getExecutiveSummaryResponseInfo().get("membership").getLabel().contains("MEMBERSHIP"));
//        Assert.assertTrue(kpiResponse.getExecutiveSummaryResponseInfo().get("membership").getUnit().contains("members"));
//        Assert.assertTrue(kpiResponse.getExecutiveSummaryResponseInfo().get("membership").getDescription().contains("Number of members in the analysis period"));
//
//        Assert.assertTrue(kpiResponse.getExecutiveSummaryResponseInfo().get("avgAge").getLabel().contains("AVERAGE AGE"));
//        Assert.assertTrue(kpiResponse.getExecutiveSummaryResponseInfo().get("avgAge").getUnit().contains("years"));
//        Assert.assertTrue(kpiResponse.getExecutiveSummaryResponseInfo().get("avgAge").getDescription().contains("Average Age of individuals as of the last day of the analysis period"));
    }

    @Test(dataProvider = "executiveDashboardData")
    public void getClinicalOutcomeData(String AnalyzeBy, String AnalysisPeriod) {
        RestAssured.baseURI = prop.getProperty("baseURI");
        EDMetricsResponseDTO response = given().
                queryParam("appId", prop.getProperty("appId")).
                header("Authorization", "Bearer " + token).
                header("Content-Type", "application/json").
                body(payload.getExecutiveDashbordPayload("clinicaloutcome", AnalyzeBy, AnalysisPeriod)).
                when().
                post("/director/clinicalOutcomes").
                then().assertThat().
                statusCode(200).
                extract().response().as(EDMetricsResponseDTO.class);

    }

    @Test(dataProvider = "executiveDashboardData")
    public void getCostAndUtilsData(String AnalyzeBy, String AnalysisPeriod) {
        RestAssured.baseURI = prop.getProperty("baseURI");
        EDMetricsResponseDTO response = given().
                queryParam("appId", prop.getProperty("appId")).
                header("Authorization", "Bearer " + token).
                header("Content-Type", "application/json").
                body(payload.getExecutiveDashbordPayload("costandutils", AnalyzeBy, AnalysisPeriod)).
                when().
                post("/director/costAndUtilization").
                then().assertThat().
                statusCode(200).
                extract().response().as(EDMetricsResponseDTO.class);
    }

    @Test(dataProvider = "executiveDashboardData")
    public void getRiskData(String AnalyzeBy, String AnalysisPeriod) {
        RestAssured.baseURI = prop.getProperty("baseURI");
        EDRiskMetricsResponseDTO response = given().
                queryParam("appId", prop.getProperty("appId")).
                header("Authorization", "Bearer " + token).
                header("Content-Type", "application/json").
                body(payload.getExecutiveDashbordPayload("risk", AnalyzeBy, AnalysisPeriod)).
                when().
                post("/director/risk").
                then().assertThat().
                statusCode(200).
                extract().response().as(EDRiskMetricsResponseDTO.class);

        Assert.assertTrue(response.getData().riskContribution.getLabel().contains("Top contributing conditions"));
        Assert.assertTrue(response.getData().description.contains("Average risk score for DxCG Model"));
    }

    @Test(dataProvider = "executiveDashboardData")
    public void getQualityMeasuresData(String AnalyzeBy, String AnalysisPeriod) {
        RestAssured.baseURI = prop.getProperty("baseURI");
        EDQualityMeasuresMetricsResponseDTO res = given().
                queryParam("appId", prop.getProperty("appId")).
                header("Authorization", "Bearer " + token).
                header("Content-Type", "application/json").
                body(payload.getExecutiveDashbordPayload("qualitymeasures", AnalyzeBy, AnalysisPeriod)).
                when().
                post("/director/qualityMeasures").
                then().assertThat().
                statusCode(200).
                extract().response().as(EDQualityMeasuresMetricsResponseDTO.class);

        Assert.assertTrue(res.getData().get(0).getType().contains("QRM"));
    }



    @DataProvider
    public Object[][] executiveDashboardData() {
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

