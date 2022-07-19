package com.klauncher.cfapiwrapper.schemas;

import com.google.gson.annotations.SerializedName;

public enum ModsSearchSortField {

    @SerializedName("1") FEATURED,
    @SerializedName("2") POPULARITY,
    @SerializedName("3") LAST_UPDATED,
    @SerializedName("4") NAME,
    @SerializedName("5") AUTHOR,
    @SerializedName("6") TOTAL_DOWNLOADS,
    @SerializedName("7") CATEGORY,
    @SerializedName("8") GAME_VERSION
}