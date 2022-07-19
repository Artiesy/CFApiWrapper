package com.klauncher.cfapiwrapper.schemas;

import com.google.gson.annotations.SerializedName;

public enum ModLoaderInstallMethod {
    @SerializedName("1") FORGE_INSTALLER,
    @SerializedName("2") FORGE_JAR_INSTALL,
    @SerializedName("3") FORGE_INSTALLER_V2
}
