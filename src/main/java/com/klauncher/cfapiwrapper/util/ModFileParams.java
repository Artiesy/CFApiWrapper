package com.klauncher.cfapiwrapper.util;

import com.klauncher.cfapiwrapper.schemas.ModLoaderType;

/**
 * Params for querying Mod files
 */
public class ModFileParams {

    /**
     * Filter by game version string
     */
    public String gameVersion = null;

    /**
     * ModLoaderType enumeration
     */
    public ModLoaderType modLoaderType = null;

    /**
     * Filter only files that are tagged with versions of the given gameVersionTypeId
     */
    public Integer gameVersionTypeId = null;

    /**
     * A zero based index of the first item to include in the response
     */
    public Integer index = null;

    /**
     * The number of items to include in the response
     */
    public Integer pageSize = null;


    public String getQuery() {
        StringBuilder sb = new StringBuilder();


        if(gameVersion != null) sb.append("&gameVersion=" + gameVersion);
        if(modLoaderType != null) sb.append("&modLoaderType=" + (modLoaderType.ordinal() + 1));
        if(gameVersionTypeId != null) sb.append("&gameVersionTypeId=" + gameVersionTypeId);
        if(index != null) sb.append("&index=" + index.intValue());
        if(pageSize != null) sb.append("&pageSize=" + pageSize.intValue());

        String str = sb.toString();
        str.replaceFirst("&", "?");

        return str;
    }

}
