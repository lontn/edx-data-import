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

import org.apache.commons.lang.Validate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import com.fasterxml.jackson.databind.JsonNode;
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

    public void ipCity() {
        String[] ipArr ={"10.0.1.1",
                "140.134.40.30",
                "140.134.40.132",
                "140.134.220.141",
                "140.134.220.142",
                "140.134.227.9",
                "140.134.220.144",
                "42.78.82.75",
                "140.134.227.4",
                "163.13.146.40",
                "140.134.220.130",
                "140.134.228.15",
                "140.134.228.12",
                "140.134.241.237",
                "110.30.2.254",
                "140.134.239.38",
                "140.134.222.85",
                "140.134.222.86",
                "1.165.181.114",
                "1.165.146.100",
                "140.134.239.37",
                "140.134.235.234",
                "140.134.249.12",
                "140.134.223.195",
                "140.134.230.86",
                "114.41.130.40",
                "140.134.228.10",
                "140.134.239.36",
                "140.134.228.9",
                "140.134.228.8",
                "123.240.66.177",
                "140.134.227.12",
                "140.134.241.182",
                "111.82.238.210",
                "140.134.227.15",
                "140.134.248.21",
                "140.134.248.12",
                "203.222.24.35",
                "140.134.239.178",
                "110.28.158.172",
                "140.134.203.15",
                "140.134.203.64",
                "140.134.203.60",
                "140.134.203.65",
                "140.134.203.22",
                "140.134.242.144",
                "140.134.131.114",
                "140.134.228.11",
                "140.134.146.184",
                "140.134.228.18",
                "101.14.7.120",
                "140.134.220.131",
                "140.134.214.164",
                "36.234.172.170",
                "140.134.214.157",
                "39.9.144.170",
                "140.134.46.103",
                "110.26.30.167",
                "140.134.131.2",
                "140.134.220.77",
                "140.134.227.13",
                "140.134.220.90",
                "140.134.220.139",
                "122.118.7.133",
                "140.134.241.77",
                "220.142.66.12",
                "140.134.227.11",
                "118.170.139.77",
                "140.134.246.172",
                "117.19.68.192",
                "111.253.76.221",
                "140.134.241.210",
                "140.134.236.145",
                "140.134.240.50",
                "125.231.223.121",
                "58.114.202.7",
                "39.9.151.241",
                "118.232.57.169",
                "117.19.160.30",
                "140.134.247.45",
                "114.38.27.217",
                "140.134.220.91",
                "140.134.220.92",
                "101.14.129.224",
                "140.134.146.146",
                "140.134.220.78",
                "118.170.203.152",
                "140.134.222.84",
                "140.134.220.146",
                "140.134.245.42",
                "61.223.254.237",
                "140.134.228.165",
                "140.134.241.199",
                "111.83.17.148",
                "140.134.246.170",
                "140.134.18.40",
                "140.134.220.80",
                "140.134.241.47",
                "36.235.141.28",
                "140.134.228.76",
                "140.134.229.171",
                "140.134.226.1",
                "163.16.249.211",
                "140.134.234.5",
                "140.134.230.84",
                "114.44.216.72",
                "140.134.240.179",
                "61.224.250.159",
                "140.134.238.212",
                "36.232.127.102",
                "1.168.72.216",
                "111.82.236.147",
                "220.133.219.65",
                "1.165.195.46",
                "36.233.98.231",
                "111.255.51.69",
                "61.224.240.217",
                "1.168.69.64",
                "140.134.222.156",
                "114.36.73.170",
                "223.139.201.230",
                "123.110.23.109",
                "36.234.91.151",
                "140.134.248.75",
                "114.41.203.251",
                "36.236.50.12",
                "114.26.239.226",
                "114.26.169.82",
                "36.234.166.197",
                "140.134.214.200",
                "125.230.96.221",
                "140.134.238.147",
                "140.134.216.232",
                "140.134.220.83",
                "114.38.99.24",
                "114.26.170.167",
                "140.134.228.167",
                "123.110.9.238",
                "60.249.48.3",
                "140.134.228.77",
                "140.134.228.75",
                "140.134.216.230",
                "125.230.18.16",
                "36.232.113.180",
                "140.134.236.104",
                "1.165.192.169",
                "140.134.220.143",
                "140.134.238.211",
                "140.134.18.46",
                "1.172.253.143",
                "140.134.204.142",
                "140.134.204.143",
                "140.134.228.78",
                "140.134.223.199",
                "140.134.238.93",
                "140.134.146.155",
                "140.134.146.79",
                "140.134.146.91",
                "140.134.146.74",
                "140.134.146.80",
                "140.134.146.82",
                "140.134.242.21",
                "140.134.248.50",
                "140.134.240.93",
                "106.104.81.186",
                "1.168.81.127",
                "61.224.174.236",
                "140.134.239.24",
                "140.134.241.111",
                "140.134.18.42",
                "203.71.232.228",
                "140.134.51.41",
                "140.134.131.115",
                "61.62.29.205",
                "140.134.228.13",
                "1.165.145.131",
                "140.134.51.102",
                "140.134.216.184",
                "140.134.146.156",
                "59.126.155.40",
                "123.110.10.22",
                "140.134.222.158",
                "140.134.222.160",
                "125.230.7.33",
                "140.134.146.81",
                "140.134.146.77",
                "140.134.146.83",
                "140.134.146.85",
                "140.134.146.52",
                "111.83.10.11",
                "140.134.146.84",
                "140.134.146.73",
                "140.134.146.75",
                "122.118.34.249",
                "39.10.143.179",
                "140.134.228.178",
                "140.134.228.175",
                "114.46.208.175",
                "140.134.248.151",
                "140.134.229.90",
                "140.134.227.5",
                "140.134.230.23",
                "110.26.83.227",
                "123.204.132.88",
                "114.26.13.155",
                "140.134.241.15",
                "120.109.151.57",
                "114.46.189.196",
                "36.234.170.117",
                "140.134.220.79",
                "125.230.99.224",
                "106.104.82.34",
                "140.134.247.182",
                "111.82.9.66",
                "140.134.220.135",
                "140.134.226.76",
                "180.217.20.169",
                "120.96.118.134",
                "140.134.224.43",
                "61.224.70.221",
                "140.134.228.58",
                "140.134.228.57",
                "140.134.229.65",
                "114.26.160.27",
                "61.224.235.54",
                "101.15.53.254",
                "140.134.247.48",
                "140.134.217.7",
                "140.134.217.5",
                "140.134.217.6",
                "140.134.241.179",
                "140.134.40.147",
                "140.134.18.56",
                "140.134.18.34",
                "101.8.83.58",
                "140.134.131.112",
                "59.126.19.60",
                "101.12.93.255",
                "27.185.139.149",
                "125.224.242.202",
                "140.134.236.105",
                "114.46.188.30",
                "140.134.249.184",
                "122.118.38.235",
                "1.168.80.102",
                "140.134.222.154",
                "140.134.227.10",
                "140.134.228.143",
                "140.134.222.153",
                "140.134.217.2",
                "140.134.217.3",
                "111.83.76.133",
                "140.134.228.142",
                "140.134.228.141",
                "114.41.105.132",
                "211.23.17.142",
                "122.118.20.30",
                "140.134.222.159",
                "140.134.228.139",
                "140.134.235.182",
                "101.12.93.49",
                "140.134.51.101",
                "118.170.122.238",
                "114.38.102.21",
                "49.214.241.129",
                "140.134.228.163",
                "140.134.228.164",
                "106.1.10.11",
                "220.137.115.229",
                "123.204.123.229",
                "140.134.228.136",
                "36.233.96.193",
                "106.104.66.162",
                "114.38.15.29",
                "122.118.138.243",
                "219.81.226.17",
                "101.12.42.228",
                "125.230.144.56",
                "36.228.39.137",
                "114.43.206.87",
                "61.228.214.242",
                "114.39.209.246",
                "140.134.228.174",
                "140.134.247.91",
                "140.134.247.89",
                "122.118.112.29",
                "123.240.128.47",
                "123.204.25.73",
                "140.134.228.160",
                "140.134.228.161",
                "140.134.216.228",
                "140.134.241.22",
                "140.134.240.195",
                "59.126.240.115",
                "114.46.5.167",
                "140.134.229.174",
                "140.134.228.169",
                "59.126.240.81",
                "163.26.206.201",
                "49.216.150.84",
                "140.134.196.156",
                "60.249.48.10",
                "140.134.146.72",
                "140.134.146.76",
                "180.217.19.90",
                "111.253.57.29",
                "61.224.86.148",
                "140.134.216.183",
                "140.134.146.171",
                "223.138.77.61",
                "1.165.164.202",
                "123.240.186.6",
                "140.134.223.211",
                "110.26.137.95",
                "140.134.216.226",
                "61.62.36.129",
                "220.133.171.237",
                "140.134.239.239",
                "140.134.228.168",
                "140.134.249.174",
                "101.14.128.208",
                "140.134.216.185",
                "140.134.26.79",
                "140.113.181.174",
                "140.134.26.88",
                "140.134.230.37",
                "140.134.216.174",
                "140.134.18.60",
                "140.134.248.72",
                "140.134.216.231",
                "140.134.239.40",
                "220.132.207.165",
                "140.134.240.183",
                "114.41.116.106",
                "61.224.75.98",
                "36.233.96.166",
                "180.217.31.42",
                "140.134.227.8",
                "1.168.72.91",
                "140.134.242.70",
                "36.234.140.8",
                "140.134.246.13",
                "140.134.216.187",
                "140.134.18.52",
                "60.249.48.12",
                "140.134.240.198",
                "140.134.236.146",
                "123.240.229.236",
                "118.170.153.231",
                "140.134.228.70",
                "123.192.244.117",
                "60.249.48.5",
                "60.249.48.8",
                "140.134.239.226",
                "140.134.239.168",
                "61.221.52.112",
                "39.13.194.64",
                "140.134.246.220",
                "111.83.220.171",
                "114.26.77.111",
                "123.204.3.152",
                "42.72.227.6",
                "140.134.18.44",
                "111.83.47.33",
                "140.134.248.31",
                "106.104.83.69",
                "114.26.12.202",
                "122.118.38.30",
                "39.10.6.155",
                "61.224.77.106",
                "110.28.226.173",
                "140.134.197.31",
                "49.214.243.153",
                "140.134.248.19",
                "140.134.245.12",
                "140.134.18.33",
                "182.155.160.187",
                "60.249.48.9",
                "140.134.236.111",
                "140.134.146.174",
                "140.134.18.41",
                "36.234.156.220",
                "120.117.59.1",
                "104.131.19.173",
                "140.121.140.152",
                "61.224.88.151",
                "36.235.95.249",
                "140.134.242.233",
                "140.134.18.43",
                "114.46.48.181",
                "60.249.48.11",
                "61.224.69.122",
                "61.221.52.114",
                "60.249.48.7",
                "140.134.223.189",
                "140.134.241.14",
                "60.249.48.6",
                "61.221.52.113",
                "27.243.133.189",
                "211.23.144.162",
                "49.216.82.54",
                "203.72.235.10",
                "36.238.64.111",
                "118.170.152.238",
                "125.230.20.238",
                "140.134.236.106",
                "60.249.48.4",
                "36.238.39.112",
                "106.104.83.156",
                "61.224.242.109",
                "114.46.40.39",
                "140.134.209.4",
                "140.134.249.183",
                "114.46.247.202",
                "140.134.180.6",
                "61.221.52.115",
                "36.234.117.217",
                "111.253.63.243",
                "36.234.38.211",
                "140.134.209.36",
                "1.165.153.80",
                "36.232.119.161",
                "140.134.18.45",
                "42.72.234.122",
                "114.46.244.130",
                "114.46.239.166",
                "122.118.42.188",
                "140.134.115.251",
                "61.224.242.90",
                "61.224.86.56",
                "122.118.2.105",
                "49.214.243.236",
                "101.12.43.160",
                "125.224.250.225",
                "140.134.214.160",
                "37.165.38.187",
                "1.165.151.135",
                "140.134.180.171",
                "140.134.197.50",
                "106.104.42.81",
                "140.134.216.233",
                "114.39.211.76",
                "36.233.96.183",
                "39.13.221.175",
                "61.224.167.200",
                "36.233.177.157",
                "1.168.69.246",
                "140.134.238.223",
                "211.22.185.114",
                "101.12.42.123",
                "140.134.228.166",
                "140.134.214.190",
                "49.158.116.82",
                "1.168.71.161",
                "211.21.42.163",
                "140.134.214.159",
                "140.134.18.35",
                "163.18.75.103",
                "36.239.176.143",
                "36.237.237.63",
                "114.26.72.151",
                "36.234.41.237",
                "122.118.13.67",
                "140.134.18.49",
                "125.224.239.240",
                "140.134.216.182",
                "140.134.199.33",
                "140.134.209.66",
                "163.20.119.249",
                "61.228.155.161",
                "140.134.18.57",
                "61.223.247.47",
                "118.233.201.247",
                "114.38.115.196",
                "61.224.47.134",
                "75.25.129.190",
                "1.165.157.53",
                "36.233.96.213",
                "113.61.132.214",
                "140.134.223.194",
                "118.170.142.85",
                "140.134.230.45",
                "1.170.232.96",
                "140.134.146.168",
                "140.134.18.39",
                "140.134.226.195",
                "36.232.117.227",
                "122.118.146.133",
                "140.134.40.113",
                "123.240.175.5",
                "223.141.121.133",
                "140.134.201.57",
                "114.41.144.192",
                "1.165.156.122",
                "114.46.13.62",
                "1.165.168.10",
                "118.233.216.213",
                "106.1.210.38",
                "140.134.230.54",
                "223.141.114.203",
                "42.79.94.170",
                "27.245.2.8",
                "39.9.154.21",
                "39.10.23.175",
                "42.79.82.144",
                "36.232.115.27",
                "60.249.43.70",
                "140.134.18.55",
                "140.121.140.141",
                "61.70.76.4",
                "59.126.91.242",
                "122.146.94.20",
                "36.236.20.120",
                "36.234.45.21",
                "101.12.42.58",
                "114.26.107.36",
                "36.236.20.153",
                "140.134.41.161",
                "118.170.24.205",
                "122.118.48.3",
                "140.134.230.41",
                "113.61.132.210",
                "118.170.204.90",
                "1.165.112.226",
                "1.168.67.196",
                "140.134.240.173",
                "49.216.44.76",
                "123.240.139.223",
                "59.126.19.57",
                "175.96.142.120",
                "61.219.36.36",
                "1.165.166.78",
                "36.232.124.53",
                "36.236.20.99",
                "140.134.242.35",
                "114.38.115.125",
                "140.134.240.171",
                "1.165.126.85",
                "101.10.52.154",
                "220.133.137.236",
                "223.141.92.150",
                "223.141.78.27",
                "192.83.195.244",
                "114.46.224.31",
                "140.134.209.56",
                "140.134.18.51",
                "106.104.81.145",
                "114.42.74.131",
                "1.168.80.239",
                "140.134.18.149",
                "220.134.233.250",
                "111.252.215.33",
                "182.155.40.102",
                "36.236.17.58",
                "36.236.19.178",
                "140.134.208.177",
                "140.124.104.244",
                "140.118.99.78",
                "111.83.78.223",
                "223.142.209.220",
                "114.41.22.36",
                "140.117.20.65",
                "123.110.54.159",
                "140.134.209.38",
                "36.233.125.78",
                "36.236.20.243",
                "36.236.19.144",
                "140.134.217.9",
                "49.213.129.209",
                "123.118.253.171",
                "140.134.40.115",
                "140.134.223.196",
                "175.180.108.10",
                "42.79.56.191",
                "112.104.65.29",
                "175.181.126.108",
                "180.217.29.138",
                "1.161.22.70",
                "1.168.69.111",
                "36.236.17.157",
                "120.107.173.101",
                "110.26.0.2",
                "61.224.70.93",
                "140.134.242.100",
                "119.77.157.40",
                "36.236.19.222",
                "183.198.25.138",
                "183.198.24.99",
                "183.198.212.168",
                "66.228.43.245",
                "61.219.98.93",
                "139.162.19.201",
                "188.166.212.145",
                "106.186.31.122",
                "45.79.74.76",
                "140.134.26.85",
                "85.159.214.118",
                "111.253.238.203",
                "115.43.158.202",
                "1.172.250.102",
                "178.62.209.182",
                "61.224.100.146",
                "140.122.97.14",
                "210.70.252.217",
                "59.124.142.191",
                "218.164.175.202",
                "114.26.99.198",
                "1.168.172.70",
                "59.124.142.190",
                "220.132.185.54",
                "183.198.249.86",
                "1.168.148.176",
                "36.233.96.227",
                "140.134.62.13",
                "118.233.204.14",
                "140.134.40.206",
                "123.240.208.71",
                "140.134.40.7"
        };
        for (String ip : ipArr) {
            String apiUrl = "http://ip-api.com/json/" + ip;
            Client client = ClientBuilder.newClient();
            try {
                WebTarget target = client.target(apiUrl);
                Response response = target.request().get();
                String result = response.readEntity(String.class).trim();
                L.info("result:{}", result);
                JsonNode nodes = mapper.readTree(result);
                String city = nodes.get("city") != null ? nodes.get("city").asText() : null;
                String regionName = nodes.get("regionName") != null ? nodes.get("regionName").asText() : null;
                L.info("ip:{}, city:{}, regionName:{}", ip, city, regionName);
            } catch (Exception e) {
                L.error("Exception:{}", e);
            }
        }
    }
}
