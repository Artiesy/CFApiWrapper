package com.klauncher.cfapiwrapper.schemas;

import com.google.gson.annotations.SerializedName;

public enum ModStatus {

    @SerializedName("1") NEW,
    @SerializedName("2") CHANGES_REQUIRED,
    @SerializedName("3") UNDER_SOFT_REVIEW,
    @SerializedName("4") APPROVED,
    @SerializedName("5") REJECTED,
    @SerializedName("6") CHANGES_MADE,
    @SerializedName("7") INACTIVE,
    @SerializedName("8") ABANDONED,
    @SerializedName("9") DELETED,
    @SerializedName("10") UNDER_REVIEW
}
