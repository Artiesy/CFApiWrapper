package com.klauncher.cfapiwrapper.util;

public class CFRequest {

    public enum RequestMethod {
        GET,
        POST
    }

    public String route;
    public RequestMethod method;
    public String body;

    public CFRequest(String route, RequestMethod method) {
        this.route = route;
        this.method = method;
    }

    public CFRequest(String route, RequestMethod method, String body) {
        this.route = route;
        this.method = method;
        this.body = body;
    }
}
