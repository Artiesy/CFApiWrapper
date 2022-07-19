package com.klauncher.cfapiwrapper.schemas.responses;

import com.klauncher.cfapiwrapper.schemas.GameVersionsByType;

import java.util.List;

public class GetVersionsResponse implements Response {

    public List<GameVersionsByType> data;
}
