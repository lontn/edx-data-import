package com.fcu.gtml.edx.service;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fcu.gtml.edx.SupportSpringTest;
import com.fcu.gtml.edx.utils.Configuration;

public class YoutubeAPITest extends SupportSpringTest {
    private static final Logger L = LogManager.getLogger();
    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void video() throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sc = SSLContext.getInstance("TLSv1");//Java 8
        System.setProperty("https.protocols", "TLSv1");//Java 8

        TrustManager[] trustAllCerts = { new InsecureTrustManager() };
        sc.init(null, trustAllCerts, new java.security.SecureRandom());
        HostnameVerifier allHostsValid = new InsecureHostnameVerifier();
        String apiUrl = Configuration.YoutubeAPI.getURL() + "id=9H2KWHmbGA0" + "&key=" + Configuration.YoutubeAPI.getPrivateKey() + "&part=" + Configuration.YoutubeAPI.getPart();
        L.info("apiUrl:{}", apiUrl);
//        Client client = ClientBuilder.newBuilder().sslContext(sc).hostnameVerifier(allHostsValid).build();
        Client client = ClientBuilder.newClient();
        try {
            WebTarget target = client.target(apiUrl);
            Response response = target.request().get();
            String result = response.readEntity(String.class).trim();
            L.info("result:{}", result);
        } catch (Exception e) {
            L.error("Exception:{}", e);
        }
        
    }

    @Test
    public void ipCityTest() {
        String apiUrl = "http://ip-api.com/json/223.141.114.203";
        Client client = ClientBuilder.newClient();
        try {
            WebTarget target = client.target(apiUrl);
            Response response = target.request().get();
            String result = response.readEntity(String.class).trim();
            L.info("result:{}", result);
        } catch (Exception e) {
            L.error("Exception:{}", e);
        }
    }

    @Test
    public void test() {
        String str = "19";
        int aaa = (int) Math.floor(Double.parseDouble(str));
        L.info("aaa:{}", aaa);
    }
}
