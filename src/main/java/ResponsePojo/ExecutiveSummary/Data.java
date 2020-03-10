package ResponsePojo.ExecutiveSummary;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Data {

    private List<responseMetricsInfo> qualityRisk;

    private List<responseMetricsInfo> warehouseSummary;

    private List<responseMetricsInfo> costSummary;

    private List<responseMetricsInfo> demographics;


    @JsonProperty("QUALITY_RISK")
    public List<responseMetricsInfo> getQualityRisk() {
        return qualityRisk;
    }

    public void setQualityRisk(List<responseMetricsInfo> qualityRisk) {
        this.qualityRisk = qualityRisk;
    }

    @JsonProperty("WAREHOUSE_SUMMARY")
    public List<responseMetricsInfo> getWarehouseSummary() {
        return warehouseSummary;
    }

    public void setWarehouseSummary(List<responseMetricsInfo> warehouseSummary) {
        this.warehouseSummary = warehouseSummary;
    }

    @JsonProperty("COST_SUMMARY")
    public List<responseMetricsInfo> getCostSummary() {
        return costSummary;
    }


    public void setCostSummary(List<responseMetricsInfo> costSummary) {
        this.costSummary = costSummary;
    }

    @JsonProperty("DEMOGRAPHICS")
    public List<responseMetricsInfo> getDemographics() {
        return demographics;
    }

    public void setDemographics(List<responseMetricsInfo> demographics) {
        this.demographics = demographics;
    }

//    public static void main(String[] args) throws JsonProcessingException {
//        Data Data = new Data();
//        ObjectMapper objectMapper = new ObjectMapper();
//        String json = objectMapper.writeValueAsString(Data);
//        System.out.println("json = " + json);
//
//    }
}
