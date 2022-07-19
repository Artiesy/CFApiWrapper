package com.klauncher.cfapiwrapper.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class RequestManager {

    private static String baseUrl = "https://api.curseforge.com";
    private static String apiKey = null;

    public static void setBaseUrl(String url) {
        baseUrl = url;
    }

    public static String getBaseUrl() {
        return baseUrl;
    }

    public static void useApiKey(String key) {
        apiKey = key;
    }


    public static CFResponse makeRequest(CFRequest request) throws Exception {
        if(apiKey == null && baseUrl.equals("https://api.curseforge.com")) throw new Exception("Api Key not specified");

        URL obj = new URL(baseUrl + request.route);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestProperty("x-api-key", apiKey);

        if(request.method == CFRequest.RequestMethod.GET)
            con.setRequestMethod("GET");
        else if(request.method == CFRequest.RequestMethod.POST) {
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");

            con.setDoOutput(true);
            byte[] out = request.body.getBytes(StandardCharsets.UTF_8);
            try(OutputStream os = con.getOutputStream()) {
                os.write(out);
            }
        }

        int responseCode = con.getResponseCode();

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }

        in.close();
        return new CFResponse(response.toString(), responseCode);
    }

}
