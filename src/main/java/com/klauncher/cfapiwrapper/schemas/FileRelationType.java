package com.klauncher.cfapiwrapper.schemas;

import com.google.gson.annotations.SerializedName;

public enum FileRelationType {
    @SerializedName("1") EMBEDDED_LIBRARY,
    @SerializedName("2") OPTIONAL_DEPENDENCY,
    @SerializedName("3") REQUIRED_DEPENDENCY,
    @SerializedName("4") TOOL,
    @SerializedName("5") INCOMPATIBLE,
    @SerializedName("6") INCLUDE

}
