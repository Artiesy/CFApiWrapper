package com.klauncher.cfapiwrapper.util;

import com.klauncher.cfapiwrapper.schemas.ModLoaderType;
import com.klauncher.cfapiwrapper.schemas.ModsSearchSortField;
import com.klauncher.cfapiwrapper.schemas.SortOrder;

import java.lang.reflect.Field;

/**
 * Search params for querying (non-required)
 */
public class ModsSearchParams {

    /**
     * Filter by section id (discoverable via Categories)
     */
    public Integer classId = null;

    /**
     * Filter by category id
     */
    public Integer categoryId = null;

    /**
     * 	Filter by game version string
     */
    public String gameVersion = null;

    /**
     * Filter by free text search in the mod name and author
     */
    public String searchFilter = null;

    /**
     * Filter by ModsSearchSortField enumeration
     */
    public ModsSearchSortField sortField = null;

    /**
     * 	'ASC' if sort is in ascending order, 'DESC' if sort is in descending order
     */
    public SortOrder sortOrder = null;

    /**
     * 	Filter only mods associated to a given modloader (Forge, Fabric ...). Must be coupled with gameVersion
     */
    public ModLoaderType modLoaderType = null;

    /**
     * Filter only mods that contain files tagged with versions of the given gameVersionTypeId
     */
    public Integer gameVersionTypeId = null;

    /**
     * 	Filter by slug (coupled with classId will result in a unique result)
     */
    public String slug = null;

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

        if(classId != null)  sb.append("&classId=" + classId.intValue());
        if(categoryId != null)  sb.append("&categoryId=" + categoryId.intValue());
        if(gameVersion != null) sb.append("&gameVersion=" + gameVersion);
        if(searchFilter != null) sb.append("&searchFilter=" + searchFilter);
        if(sortField != null) sb.append("&sortField=" + (sortField.ordinal() + 1));
        if(sortOrder != null) sb.append("&sortOrder=" + (sortOrder.ordinal() + 1));
        if(modLoaderType != null) sb.append("&modLoaderType=" + (modLoaderType.ordinal() + 1));
        if(gameVersionTypeId != null) sb.append("&gameVersionTypeId=" + gameVersionTypeId.intValue());
        if(slug != null) sb.append("&slug=" + slug);
        if(index != null) sb.append("&index=" + index.intValue());
        if(pageSize != null) sb.append("&pageSize=" + pageSize.intValue());

        return sb.toString();
    }

}
