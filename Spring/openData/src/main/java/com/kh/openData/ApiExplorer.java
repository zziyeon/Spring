package com.kh.openData;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class ApiExplorer {
    private static final String serviceKey="0FqrGqLAdB%2FW%2FQHq%2FIDFUDUVg%2BVS5Xf9s1evIyDFe7vVtDtLMqI%2FDuZf9vVxnGyn6ugNtt%2FFmU0hA7HyxSmoxg%3D%3D";
    public static void main(String[] args) throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/6310000/ulsanrestaurant/getulsanrestaurantList"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" +serviceKey); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("perPage","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 크기(기본20)*/
        urlBuilder.append("&" + URLEncoder.encode("pageIndex","UTF-8") + "=" + URLEncoder.encode("0", "UTF-8")); /*시작 페이지(기본1)*/
        urlBuilder.append("&" + URLEncoder.encode("city","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*시군구*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("accept", "application/xml");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());

        String xmlStr = sb.toString();
        //xml to json
        XmlMapper xmlMapper = new XmlMapper();
        JsonNode node = xmlMapper.readTree(xmlStr);
        ObjectMapper jsonMapper = new ObjectMapper();
        String json = jsonMapper.writeValueAsString(node);
        System.out.println(json);

        //xml to java Object
        RfcOpenApi res= xmlMapper.readValue(xmlStr, RfcOpenApi.class);
        System.out.println(res);
        for(RfcOpenApi.Body.Lists list:res.getBody().getData()){
            System.out.print("회사명: "+ list.getCompany()+", ");
            System.out.print("위도: "+ list.getLat()+", ");
            System.out.print("경도: "+ list.getLng()+", ");
            System.out.print("업종: "+ list.getFoodType()+", ");
            System.out.print("구역: "+ list.getCity()+", ");
            System.out.print("주소: "+ list.getAddress()+", ");
            System.out.println("전화번호: "+ list.getPhoneNumber());
        }

//        //json to java Object
//        RfcOpenApi res2= xmlMapper.readValue(json, RfcOpenApi.class);
//        System.out.println(res2);
//        for(RfcOpenApi.Body.Lists list:res.getBody().getData()){
//            System.out.print("회사명: "+ list.getCompany()+", ");
//            System.out.println("위도: "+ list.getLat());
//        }
    }
}