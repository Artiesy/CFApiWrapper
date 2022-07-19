package com.klauncher.cfapiwrapper.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.klauncher.cfapiwrapper.schemas.responses.Response;

import java.lang.reflect.Type;

public class CFResponse {

    int statusCode;
    String data;

    public CFResponse(String data, int statusCode) {

        this.data = data;
        this.statusCode = statusCode;
    }

    public <T> T getResponse(Class<T> type) throws Exception {

        if (this.statusCode != 200) {
            throw new Exception("Server returned status code: " + this.statusCode);
        } else {
            if(type == String.class) return (T) this.data;

            Gson g = new GsonBuilder().disableHtmlEscaping().create();
            return g.fromJson(this.data, type);
        }
    }

}
