package com.klauncher.cfapiwrapper.schemas.responses;

import com.klauncher.cfapiwrapper.schemas.File;
import com.klauncher.cfapiwrapper.schemas.Pagination;

import java.util.List;

public class GetModFilesResponse implements Response {

    public List<File> data;

    public Pagination pagination;
}
