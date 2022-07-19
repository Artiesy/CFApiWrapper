package com.klauncher.cfapiwrapper.schemas.requests;

import java.util.ArrayList;
import java.util.List;

public class GetModsByIdsListRequestBody implements RequestBody {

    public List<Integer> modIds = new ArrayList<>();
}
