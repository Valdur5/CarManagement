package de.pandigo.cars.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.json.JSONArray;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import de.pandigo.cars.MainApplication;

@AutoConfigureMockMvc
// Enables the Spring context for this test.
@RunWith(SpringRunner.class)
// SpringBootTest is used to run Spring Boot Applications.
@SpringBootTest(classes = MainApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

// WE HAVE HERE A BIG PROBLEM NOT SOLVED YET: This Test Implementation takes the whole MainApplication
// and starts it on a random port to test the REST calls. So far so fine but it directly takes the
// CarsServiceDao with an (not existing but expected) database connection. This of cause is not
// use able for integration tests because the data in the database is subject to change.

// I have tried different options but many options are intended to replace the mock using some kind
// of tool like mockit for an given object. Because we just use the REST interface it is not possible
// to override some method to provide the mock instead of an real database.

public class CarManagerRestControllerIT {

	// The random port will be autowired here.
	@LocalServerPort
	private int port;

	private final TestRestTemplate restTemplate = new TestRestTemplate();
	private final HttpHeaders headers = new HttpHeaders();

	@Test
	public void getAllCarsCheckAmountOfCarsReturnedAmountIs10() throws JSONException {
		final HttpEntity<String> entity = new HttpEntity<>(null, this.headers);
		final ResponseEntity<String> response = this.restTemplate.exchange(createURLWithPort("/carManagerRestApi/cars"), HttpMethod.GET, entity,
		        String.class);

		final JSONArray obj = new JSONArray(response.getBody());
		assertThat(obj.length(), is(10));
	}

	private String createURLWithPort(final String uri) {
		return "http://localhost:" + this.port + uri;
	}
}