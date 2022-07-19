package com.klauncher.cfapiwrapper.schemas;

import com.google.gson.annotations.SerializedName;

public enum GameVersionStatus {
    @SerializedName("1") APPROVED,
    @SerializedName("2") DELETED,
    @SerializedName("3") NEW
}
