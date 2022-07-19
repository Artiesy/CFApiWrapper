package com.klauncher.cfapiwrapper.schemas;

public class MinecraftGameVersion {

    public int id;

    public int gameVersionId;

    public String versionString;

    public String jarDownloadUrl;

    public String jsonDownloadUrl;

    public boolean approved;

    public String dateModified;

    public int gameVersionTypeId;

    public GameVersionStatus gameVersionStatus;

    public GameVersionTypeStatus gameVersionTypeStatus;
}
