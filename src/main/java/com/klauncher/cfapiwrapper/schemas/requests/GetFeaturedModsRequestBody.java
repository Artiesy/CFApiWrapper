package com.klauncher.cfapiwrapper.schemas.requests;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class GetFeaturedModsRequestBody implements RequestBody {

    public int gameId;

    public List<Integer> excludedModsId = new ArrayList<>();

    public Integer gameVersionTypeId;

    public GetFeaturedModsRequestBody(int _gameId, List<Integer> _excludedModsId, Integer _gameVersionTypeId) {
        gameId = _gameId;
        excludedModsId = _excludedModsId == null? new ArrayList<>() : _excludedModsId;
        gameVersionTypeId = _gameVersionTypeId;
    }

}
