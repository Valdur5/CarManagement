package de.pandigo.cars.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.json.JSONArray;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import de.pandigo.cars.MainApplication;


// Enables the Spring context for this test.
@RunWith(SpringRunner.class)
// SpringBootTest is used to run Spring Boot Applications.
@SpringBootTest(classes = MainApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// TODO: Load the spring test config file to replace some beans with Mockup data.
// @ContextConfiguration(locations = { "classpath:spring-test-config.xml" })
public class CarManagerRestControllerIT {

    // The random port will be autowired here.
    @LocalServerPort
    private int port;

    private final TestRestTemplate restTemplate = new TestRestTemplate();
    private final HttpHeaders headers = new HttpHeaders();

    @Test
    public void getAllCarsCheckAmountOfCarsReturnedAmountIs10() throws JSONException {
        final HttpEntity<String> entity = new HttpEntity<>(null, this.headers);
        final ResponseEntity<String> response = this.restTemplate.exchange(
                createURLWithPort("/carManagerRestApi/cars"),
                HttpMethod.GET, entity, String.class);

        final String expected = "{id:Course1,name:Spring,description:10 Steps}";
        final JSONArray obj = new JSONArray(response.getBody());
        assertThat(obj.length(), is(3));

    }

    private String createURLWithPort(final String uri) {
        return "http://localhost:" + this.port + uri;
    }
}