package com.klauncher.cfapiwrapper.schemas;

public class SortableGameVersion {

    /**
     * Original version name (e.g. 1.5b)
     */
    public String gameVersionName;

    /**
     * Used for sorting (e.g. 0000000001.0000000005)
     */
    public String gameVersionPadded;

    /**
     * Game version clean name (e.g. 1.5)
     */
    public String gameVersion;

    /**
     * Game version release date
     */
    public String gameVersionReleaseDate;

    /**
     * Game version type id
     */
    public Integer gameVersionTypeId;

}
