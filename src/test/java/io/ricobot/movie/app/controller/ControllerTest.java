package io.ricobot.movie.app.controller;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.ricobot.movie.MovieApplication;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { MovieApplication.class }, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public abstract class ControllerTest<T> {

    private T model;
    public Faker faker = new Faker();

    private String endpoint = "http://localhost:8081/api";
    protected String property = "name";

    public void setEndpoint(String value){
        this.endpoint = this.endpoint + value;
    }

    private String createAsUri(T obj) {
        Response response = RestAssured.given().contentType(MediaType.APPLICATION_JSON_VALUE).body(obj).post(endpoint);
        return endpoint + "/" + response.jsonPath().get("id");
    }

    protected T create(){
        return model;
    }

    @Test
    public void shouldGetCreated() throws Exception {
        T obj = create();
        Response response = RestAssured.get(createAsUri(obj));
        Assert.assertEquals(HttpStatus.OK.value(), response.getStatusCode());
        Assert.assertEquals(BeanUtils.getProperty(obj, this.property), response.jsonPath().get(this.property));
    }

    @Test
    public void shouldGetAll() {
        Response response = RestAssured.get(endpoint);
        Assert.assertEquals(HttpStatus.OK.value(), response.getStatusCode());
    }

    @Test
    public void shouldNotExist() {
        Response response = RestAssured.get(endpoint + "/" + randomNumeric(4));
        Assert.assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCode());
    }

    @Test
    public void shouldCreated() {
        T obj = create();
        Response response = RestAssured.given().contentType(MediaType.APPLICATION_JSON_VALUE).body(obj).post(endpoint);
        Assert.assertEquals(HttpStatus.CREATED.value(), response.getStatusCode());
    }

    @Test
    public void shouldNotCreatedWithError() throws Exception {
        T obj = create();
        BeanUtils.setProperty(obj, this.property, null);
        Response response = RestAssured.given().contentType(MediaType.APPLICATION_JSON_VALUE).body(obj).post(endpoint);
        Assert.assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatusCode());
    }

    @Test
    public void shouldDeleteCreatedObj() {
        T obj = create();
        String location = createAsUri(obj);
        Response response = RestAssured.delete(location);
        Assert.assertEquals(HttpStatus.OK.value(), response.getStatusCode());

        response = RestAssured.get(location);
        Assert.assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCode());
    }

    @Test
    public void shouldUpdateCreatedObj() throws Exception {
        T obj = create();

        String location = createAsUri(obj);
        Response response = RestAssured.get(location);
        obj = response.jsonPath().get();

        String name = faker.name().name();
        BeanUtils.setProperty(obj, this.property, name);
        response = RestAssured.given().contentType(MediaType.APPLICATION_JSON_VALUE).body(obj).put(location);
        Assert.assertEquals(HttpStatus.OK.value(), response.getStatusCode());

        response = RestAssured.get(location);
        Assert.assertEquals(HttpStatus.OK.value(), response.getStatusCode());
        Assert.assertEquals(name, response.jsonPath().get(this.property));
    }
}
