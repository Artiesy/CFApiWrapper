package com.klauncher.cfapiwrapper.schemas;

import com.google.gson.annotations.SerializedName;

public enum FileStatus {

    @SerializedName("1") PROCESSING,
    @SerializedName("2") CHANGES_REQUIRED,
    @SerializedName("3") UNDER_REVIEW,
    @SerializedName("4") APPROVED,
    @SerializedName("5") REJECTED,
    @SerializedName("6") MALWARE_DETECTED,
    @SerializedName("7") DELETED,
    @SerializedName("8") ARCHIVED,
    @SerializedName("9") TESTING,
    @SerializedName("10") RELEASED,
    @SerializedName("11") READY_FOR_REVIEW,
    @SerializedName("12") DEPRECATED,
    @SerializedName("13") BAKING,
    @SerializedName("14") AWAITING_PUBLISHING,
    @SerializedName("15") FAILED_PUBLISHING
}
