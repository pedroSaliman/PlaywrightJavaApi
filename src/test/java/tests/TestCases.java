package tests;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;
import org.Constants;
import org.PayLoad;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCases {


    private  Playwright play;
    private APIRequestContext request;
    @BeforeClass
    public void setup(){
        play=Playwright.create();
        request=play.request().newContext(new APIRequest.NewContextOptions().setBaseURL(Constants.BaseUrl));
    }

    @Test
    public void getUsers(){
        APIResponse response=request.get("/api/users?page=2");
        System.out.println(response.ok());
        System.out.println(response.statusText());
        System.out.println(response.status());
        System.out.println(response.text());
        Assert.assertEquals(response.ok(),true);
    }
    @Test
    public void getsingleUsers(){
        APIResponse response=request.get("/api/users/2");
        System.out.println(response.ok());
        System.out.println(response.statusText());
        System.out.println(response.status());
        System.out.println(response.text());
        Assert.assertEquals(response.ok(),true);
    }
    @Test
    public void getsingleUsersnotfound(){
        APIResponse response=request.get("/api/users/23");
        System.out.println(response.ok());
        System.out.println(response.statusText());
        System.out.println(response.status());
        System.out.println(response.text());
        Assert.assertEquals(response.ok(),false);
    }


    @Test
    public void postUser(){
        APIResponse response=request.post("/api/users", RequestOptions.create().setData(PayLoad.map()));
        System.out.println(response.ok());
        System.out.println(response.statusText());
        System.out.println(response.status());
        System.out.println(response.text());

        Assert.assertEquals(response.ok(),true);
    }
    @Test
    public void putUser(){
        APIResponse response=request.put("/api/users/2", RequestOptions.create().setData(PayLoad.mapput()));
        System.out.println(response.ok());
        System.out.println(response.statusText());
        System.out.println(response.status());
        System.out.println(response.text());

        Assert.assertEquals(response.ok(),true);
    }
    @Test
    public void Delete(){
        APIResponse response=request.delete("/api/users/2");
        System.out.println(response.ok());
        System.out.println(response.statusText());
        System.out.println(response.status());
        System.out.println(response.text());

        Assert.assertEquals(response.ok(),true);
        Assert.assertEquals(response.status(),204);
    }
    @Test
    public void registerpost(){
        APIResponse response=request.post("/api/register", RequestOptions.create().setData(PayLoad.Register()));
        System.out.println(response.ok());
        System.out.println(response.statusText());
        System.out.println(response.status());
        System.out.println(response.text());

        Assert.assertEquals(response.ok(),true);
        Assert.assertEquals(response.status(),200);
    }
    @Test
    public void Loginpost(){
        APIResponse response=request.post("/api/login", RequestOptions.create().setData(PayLoad.Login()));
        System.out.println(response.ok()); ///return true or false
        System.out.println(response.statusText()); ///return ok
        System.out.println(response.status()); //return status
        System.out.println(response.text());

        Assert.assertEquals(response.ok(),true);
        Assert.assertEquals(response.status(),200);
    }

    @AfterClass
    public void  TearDown()
    {

        request.dispose();
    }
}
