package utils;

public enum EndPointResource {
    Indv301MembersAPI("/members"),
    ExexutiveDashboardKPIAPI("/director/kpi"),
    ExexutiveSummaryAPI("/mi/es");

    private String resource;

    EndPointResource(String resource) {
        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }
}
