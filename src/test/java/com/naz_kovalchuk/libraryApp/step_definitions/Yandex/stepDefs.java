package com.naz_kovalchuk.libraryApp.step_definitions.Yandex;

import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class stepDefs {



    @When("I use yandex api I should see translation working as expected")
    public void i_use_yandex_api_i_should_see_translation_working_as_expected() {
        String text = "hey";
        String key = "trnsl.1.1.20220829T080551Z.283a59d4e4025aa7.89a479dd22ac2e957fbc1f427fe00496a6f78e00";

        //trnsl.1.1.20220829T080551Z.283a59d4e4025aa7.89a479dd22ac2e957fbc1f427fe00496a6f78e00

        //https://translate.yandex.net/api/v1.5/tr.json/translate
        Response response = given().log().all()
                .accept(ContentType.JSON)
                .queryParam("key", key)
                .queryParam("text", text)
                .queryParam("lang", "en-ru")
                .contentType(ContentType.JSON)
                .header("Content-Length", "15")
                .post("https://translate.yandex.net/api/v1.5/tr.json/translate");

        System.out.println(response.body().asString());

    }



}
