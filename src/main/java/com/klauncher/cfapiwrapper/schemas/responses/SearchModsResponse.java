package com.klauncher.cfapiwrapper.schemas.responses;

import com.klauncher.cfapiwrapper.schemas.Mod;
import com.klauncher.cfapiwrapper.schemas.Pagination;

import java.util.List;

public class SearchModsResponse implements Response {

    public List<Mod> data;

    public Pagination pagination;
}
