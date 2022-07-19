package com.klauncher.cfapiwrapper.schemas;

import com.google.gson.annotations.SerializedName;

public enum FileReleaseType {

    @SerializedName("1") RELEASE,
    @SerializedName("2") BETA,
    @SerializedName("3") ALPHA
}
