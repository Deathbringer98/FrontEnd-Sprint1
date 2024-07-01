package com.keyin.http.cli;

import com.keyin.RESTClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class RESTClientTest {

    @InjectMocks
    private RESTClient restClient;

    @Mock
    private HttpClient httpClient;

    @Mock
    private HttpResponse<String> httpResponse;

    private static final String SERVER_URL = "http://localhost:8080";

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        restClient = new RESTClient(SERVER_URL);
    }

    @Test
    public void testCreateCity() throws IOException, InterruptedException {
        String json = "{\"name\": \"Toronto\", \"province\": \"ON\", \"population\": 2800000}";
        String expectedResponse = "City created successfully";

        when(httpResponse.body()).thenReturn(expectedResponse);
        when(httpClient.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class))).thenReturn(httpResponse);

        String actualResponse = restClient.createCity(json);

        assertEquals(expectedResponse, actualResponse);
        verify(httpClient, times(1)).send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class));
    }

    @Test
    public void testGetAllCities() throws IOException, InterruptedException {
        String expectedResponse = "[{\"name\": \"Halifax\", \"province\": \"NS\", \"population\": 403131}]";

        when(httpResponse.body()).thenReturn(expectedResponse);
        when(httpClient.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class))).thenReturn(httpResponse);

        String actualResponse = restClient.getAllCities();

        assertEquals(expectedResponse, actualResponse);
        verify(httpClient, times(1)).send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class));
    }

    @Test
    public void testCreateAirport() throws IOException, InterruptedException {
        String json = "{\"name\": \"Vancouver International\", \"code\": \"YVR\", \"city\": {\"name\": \"Vancouver\", \"province\": \"BC\", \"population\": 675218}}";
        String expectedResponse = "Airport created successfully";

        when(httpResponse.body()).thenReturn(expectedResponse);
        when(httpClient.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class))).thenReturn(httpResponse);

        String actualResponse = restClient.createAirport(json);

        assertEquals(expectedResponse, actualResponse);
        verify(httpClient, times(1)).send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class));
    }

    @Test
    public void testGetAllAirports() throws IOException, InterruptedException {
        String expectedResponse = "[{\"name\": \"Calgary International\", \"code\": \"YYC\", \"city\": {\"name\": \"Calgary\", \"province\": \"AB\", \"population\": 1239220}}]";

        when(httpResponse.body()).thenReturn(expectedResponse);
        when(httpClient.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class))).thenReturn(httpResponse);

        String actualResponse = restClient.getAllAirports();

        assertEquals(expectedResponse, actualResponse);
        verify(httpClient, times(1)).send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class));
    }

    @Test
    public void testCreatePassenger() throws IOException, InterruptedException {
        String json = "{\"firstName\": \"John\", \"lastName\": \"Doe\", \"phoneNum\": \"1234567890\", \"city\": {\"name\": \"Toronto\", \"province\": \"ON\", \"population\": 2800000}}";
        String expectedResponse = "Passenger created successfully";

        when(httpResponse.body()).thenReturn(expectedResponse);
        when(httpClient.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class))).thenReturn(httpResponse);

        String actualResponse = restClient.createPassenger(json);

        assertEquals(expectedResponse, actualResponse);
        verify(httpClient, times(1)).send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class));
    }

    @Test
    public void testGetAllPassengers() throws IOException, InterruptedException {
        String expectedResponse = "[{\"firstName\": \"John\", \"lastName\": \"Doe\", \"phoneNum\": \"1234567890\", \"city\": {\"name\": \"Toronto\", \"province\": \"ON\", \"population\": 2800000}}]";

        when(httpResponse.body()).thenReturn(expectedResponse);
        when(httpClient.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class))).thenReturn(httpResponse);

        String actualResponse = restClient.getAllPassengers();

        assertEquals(expectedResponse, actualResponse);
        verify(httpClient, times(1)).send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class));
    }

    @Test
    public void testGetAllAircraftForPassenger() throws IOException, InterruptedException {
        String expectedResponse = "[{\"aircraftType\": \"Boeing 737\", \"airlineName\": \"Air Canada\", \"passengerCapacity\": 180}]";

        when(httpResponse.body()).thenReturn(expectedResponse);
        when(httpClient.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class))).thenReturn(httpResponse);

        String actualResponse = restClient.getAllAircraftForPassenger(1);

        assertEquals(expectedResponse, actualResponse);
        verify(httpClient, times(1)).send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class));
    }

    @Test
    public void testGetAllAirportsForPassenger() throws IOException, InterruptedException {
        String expectedResponse = "[{\"name\": \"Pearson\", \"code\": \"YYZ\"}]";

        when(httpResponse.body()).thenReturn(expectedResponse);
        when(httpClient.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class))).thenReturn(httpResponse);

        String actualResponse = restClient.getAllAirportsForPassenger(1);

        assertEquals(expectedResponse, actualResponse);
        verify(httpClient, times(1)).send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class));
    }

    @Test
    public void testGetAllAirportsInCity() throws IOException, InterruptedException {
        String expectedResponse = "[{\"name\": \"Pearson\", \"code\": \"YYZ\"}]";

        when(httpResponse.body()).thenReturn(expectedResponse);
        when(httpClient.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class))).thenReturn(httpResponse);

        String actualResponse = restClient.getAllAirportsInCity("Toronto");

        assertEquals(expectedResponse, actualResponse);
        verify(httpClient, times(1)).send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class));
    }

    @Test
    public void testGetAllAirportsForAircraft() throws IOException, InterruptedException {
        String expectedResponse = "[{\"name\": \"Pearson\", \"code\": \"YYZ\"}]";

        when(httpResponse.body()).thenReturn(expectedResponse);
        when(httpClient.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class))).thenReturn(httpResponse);

        String actualResponse = restClient.getAllAirportsForAircraft(1);

        assertEquals(expectedResponse, actualResponse);
        verify(httpClient, times(1)).send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class));
    }
}
