package utils;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.util.Properties;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.restassured.builder.RequestSpecBuilder;



public class ReuseableMethods {

    //public WebDriver driver;
    public Properties prop;
    RequestSpecification req;
    ResponseSpecification res;


    public ReuseableMethods(){
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream("src\\main\\resources\\Data.properties");
            prop.load(fis);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

//    public String getToken() throws IOException {
//
//        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.get("https://mi-scmqa.verscend.com/");
//        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(prop.getProperty("username"));
//        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(prop.getProperty("password"));
//        driver.findElement(By.xpath("//input[@name='submit']")).click();
//
//        driver.get("https://cas-scmqa.verscend.com/login?view=401LoginView&service=https%3A%2F%2Fpophealthauth-scmqa.verscend.com%2Foauth%2Fauthorize%3Fredirect_uri%3Dhttps%3A%2F%2Fpophealthauth-scmqa.verscend.com%2Ftokenextract.html%26client_id%3Dmx-memberservice%26response_type%3Dtoken%26appId%3D"+prop.getProperty("appId"));
//
//        String url = driver.getCurrentUrl();
//        System.out.println(driver.getCurrentUrl());
//
//        String[] parts = url.split("access_token=");
//        String part2 = parts[1];
//
//        String[] partss = part2.split("&token_type=");
//        String token = partss[0];
//
//        driver.close();
//
//        return token;
//        //RestAssured.baseURI = "http://216.10.245.166";
//    }

    public RequestSpecification getRequest() throws FileNotFoundException {
       if (req == null) {
            PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
            req = new RequestSpecBuilder()
                    .setBaseUri(prop.getProperty("baseURI"))
                    .addQueryParam("appId", prop.getProperty("appId"))
                    .addHeader("Authorization", "Bearer " + getStaticToken())
                    .addHeader("Content-Type", "application/json")
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .build();

            return req;
        }
        return req;
    }

    public ResponseSpecification getResponse()
    {
        res = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        return res;
    }

    protected String getStaticToken(){
        return "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJvYXV0aC52ZXJzY2VuZC5jb20iLCJpYXQiOjE1ODI4NzQ0MzgsImV4cCI6MTU4NDM0NTY2NywiYXVkIjoibXgtbWVtYmVyc2VydmljZS52ZXJzY2VuZC5jb20iLCJzdWIiOiI1MzQzMyIsImp0aSI6IjU5NmFhZmY5LWVjYjQtNGM2YS04NmNmLTgyNjQxMzRkYzFkYyIsImxvZ2luTmFtZSI6Im5pbWFuYW5kaGFyIiwibmFtZSI6Im5pcm1hbG1hbmFuZGhhciIsImVtYWlsIjoiYXNoaXNoLmJpc3RhQGNvdGl2aXRpLmNvbSIsImxvZ2luVHlwZSI6IjEiLCJhdXRoIjp7InJpZ2h0cyI6WzAsMSwyLDMsNCw1LDYsNyw4LDksMTAsMTEsMTIsMTMsMTQsMTUsMTYsMTcsMTgsMTksMjAsMjEsMjIsMjMsMjQsMjUsMjYsMjcsMjgsMjksMzAsMzEsMzIsMzMsMzQsMzUsMzYsMzcsMzgsMzksNDAsNDEsNDIsNDMsNDQsNDUsNDYsNDcsNDgsNDksNTAsNTEsNTIsNTMsNTQsNTUsNTYsNTcsNTgsNTksNjAsNjEsNjIsNjMsNjQsNjUsNjYsNjcsNjgsNjksNzAsNzEsNzIsNzMsNzQsNzUsNzYsNzcsNzgsNzksODAsODEsODIsODMsODQsODUsODYsODcsODgsODksOTAsOTEsOTIsOTMsOTQsOTUsOTYsOTcsOTgsOTksMTAwLDEwMSwxMDIsMTAzLDEwNCwxMDUsMTA2LDEwNywxMDgsMTA5LDExMCwxMTEsMTEyLDExMywxMTQsMTE1LDExNiwxMTcsMTE4LDExOSwxMjAsMTIxLDEyMiwxMjMsMTI0LDEyNV0sInBlcm1zIjpbMTEsMjddLCJhcHBJZCI6WyI5ODItMDAzIiwiMDA0LTEwMSIsIjAwOC0wMDQiLCIwMDgtMTAxIiwiMDEzLTAwMSIsIjA5MC0wMDMiLCI2NTgtMDAxIiwiNjU4LTEwMSIsIjY1OS0wMDIiLCI2NTktMDAzIiwiNjU5LTAwNiIsIjY1OS00NTYiLCI2OTEtMDAxIiwiNzM5LTAwMSIsIjczOS0wMDIiLCI3NDAtMDAyIiwiODU3LTAwMSIsIjg1Ny0wMDIiLCI4NTctMDAzIiwiODg1LTAwMSIsIjkwMS0wMDEiLCI5MDItMDE0IiwiOTAyLTEwMSIsIjk0MC0wMDEiLCI5NDAtMDAyIiwiOTQxLTAwMSIsIjk0MS0wMDIiLCI5NDItMDAxIiwiOTQzLTAwMSIsIjk0NC0wMDEiLCI5NDUtMDAxIiwiOTQ1LTAwMiIsIjk0Ni0wMDEiLCI5NDctMDAxIiwiOTU1LTAwMSIsIjk1NS0wMDIiLCI5NTYtMDAxIiwiOTU2LTAwMiIsIjk1OS0wMDEiLCI5NTktMDAyIiwiOTY1LTAwMSIsIjk2NS0wMDIiLCI5NjctMDAxIiwiOTY3LTAwMiIsIjk3MS0wMDEiLCI5NzEtMDAyIiwiOTcxLTAwMyIsIjk3MS0wMDUiLCI5NzEtMDA2IiwiOTcxLTAwNyIsIjk3MS0wMTAiLCI5NzItMDAxIiwiOTcyLTIwMSIsIjk3Mi0yMDIiLCI5NzItMjAzIiwiOTcyLTIwNCIsIjk3NC0wMDIiLCI5NzQtMDA1IiwiOTc0LTA3NyIsIjk3NC0xMTEiLCI5NzQtNjU5IiwiOTc0LTc3NyIsIjk3NC03NzgiLCI5NzQtODg4IiwiOTc0LTkwMCIsIjk3NC05OTkiLCI5NzUtMDAxIiwiOTc1LTAwMiIsIjk3NS0wMDMiLCI5NzUtMDA5IiwiOTc1LTIwMCIsIjk3Ny0wMDEiLCI5NzctMDAyIiwiOTc3LTAwOSIsIjk3Ny0wMzYiLCI5NzctMTAyIiwiOTc4LTAwMSIsIjk3OS0wMDEiLCI5NzktMDAyIiwiOTgxLTAwMSIsIjk4Mi0wMDEiLCI5ODItMDAyIiwiOTgyLTAwNCIsIjk4Mi0wMDUiLCI5ODItMDA2IiwiOTgyLTAwNyIsIjk4Mi0wMDgiLCI5ODItMDEzIiwiOTgzLTAwMSIsIjAwNC0xMTEiLCI5NzQtMTIxIl0sImxvYSI6eyIxIjpbIkFOVEhFTSJdLCIyIjpbIjIiXSwiMyI6WyJGUCJdfX0sImNsaWVudF9pZCI6Im14LW1lbWJlcnNlcnZpY2UifQ.McL8Uae_LZZaxkL23-EplSbbTAuRywwMcdRcxkTnXZ4";
    }


}
