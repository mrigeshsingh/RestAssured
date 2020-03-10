package PayLoadPojo.Indv301Payload.SetValue;

import PayLoadPojo.Indv301Payload.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Indv301PayLoadSetValue {
    Indv301Payload payload = new Indv301Payload();
    Filters filters = new Filters();
    AnalysisPeriod analysisPeriod = new AnalysisPeriod();
    Page page = new Page();
    Sort sort = new Sort();
    Filters filter = new Filters();
    ColumnFilters columnFilters = new ColumnFilters();
    BusinessLevels businessLevels = new BusinessLevels();
    BusinessLevelExclude businessLevelExclude = new BusinessLevelExclude();


    public Indv301Payload setValue(String AnalysisBy, String AnalysisPeriod,String Age, String AdmitCount)
    {
        String emptyFilter[] ={};

        String columnList[] = {"memid","age","gender","mm","curflag","subscriberflag","admitcount","ervisitcount","officevisitcount","pridiagdesc","delri","msrrs2","totallowedamt","totpaidamt"};
        String ageArgs[] = {Age};
        String admitCount[] = {AdmitCount};

        payload.setColumns(columnList);
        payload.setApplyFullCycle("true");
        payload.setFilters(filters);
        payload.setPage(page);
        analysisPeriod.setPeriod(AnalysisBy);
        analysisPeriod.setPeriodOverPeriod("false");
        analysisPeriod.setType(AnalysisPeriod);
        analysisPeriod.setArgs(emptyFilter);


        filters.setAnalysisPeriod(analysisPeriod);
        filters.setColumnFilters(new ColumnFilters[]{columnFilters});
        filters.setBusinessLevels(null);

        Map emptyMap=null;


        page.setSize("50");
        page.setOffset("1");

        sort.setField("totpaidamt");
        sort.setOrder("DESC");

        Sort[] sortFieldsArray = {sort};
        payload.setSort(sortFieldsArray);

        columnFilters.setCol("age");
        columnFilters.setType("OPERAND");
        columnFilters.setOp("GTE");
        columnFilters.setArgs(ageArgs);

        columnFilters.setCol("admitcount");
        columnFilters.setType("OPERAND");
        columnFilters.setOp("GTE");
        columnFilters.setArgs(admitCount);


        payload.setQmEntries(emptyFilter);
        return payload;
    }

}
