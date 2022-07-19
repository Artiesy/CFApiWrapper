package com.klauncher.cfapiwrapper.schemas.responses;

import com.klauncher.cfapiwrapper.schemas.Game;
import com.klauncher.cfapiwrapper.schemas.Pagination;

import java.util.List;

public class GetGamesResponse implements Response {

    public List<Game> data;
    public Pagination pagination;
}
