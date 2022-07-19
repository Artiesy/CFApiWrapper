package com.klauncher.cfapiwrapper.schemas;

import com.google.gson.annotations.SerializedName;

public enum CoreStatus {
    @SerializedName("1") DRAFT,
    @SerializedName("2") TEST,
    @SerializedName("3") PENDING_REVIEW,
    @SerializedName("4") REJECTED,
    @SerializedName("5") APPROVED,
    @SerializedName("6") LIVE
}
