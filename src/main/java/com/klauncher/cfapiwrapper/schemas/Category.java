package com.klauncher.cfapiwrapper.schemas;

public class Category {

    /**
     * The category id
     */
    public int id;

    /**
     * The game id related to the category
     */
    public int gameId;

    /**
     * Category name
     */
    public String name;

    /**
     * The category slug as it appear in the URL
     */
    public String slug;

    /**
     * The category URL
     */
    public String url;

    /**
     * URL for the category icon
     */
    public String iconUrl;

    /**
     * Last modified date of the category
     */
    public String dateModified;

    /**
     * A top level category for other categories
     */
    public String isClass;

    /**
     * The class id of the category, meaning - the class of which this category is under
     */
    public int classId;

    /**
     * The parent category for this category
     */
    public int parentCategoryId;

    /**
     * The display index for this category
     */
    public int displayIndex;
}
