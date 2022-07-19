package com.klauncher.cfapiwrapper.schemas.requests;

import com.klauncher.cfapiwrapper.schemas.FolderFingerprint;

import java.util.List;

public class GetFuzzyMatchesRequestBody implements RequestBody {

    public int gameId;

    public List<FolderFingerprint> fingerprints;
}
