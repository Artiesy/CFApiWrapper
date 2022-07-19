package com.klauncher.cfapiwrapper.schemas.requests;

import com.google.gson.Gson;

public interface RequestBody {

    default String getBody() {
        return new Gson().toJson(this);
    }

}
