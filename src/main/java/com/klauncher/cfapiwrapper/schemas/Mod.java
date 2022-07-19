package com.klauncher.cfapiwrapper.schemas;

import java.util.List;

public class Mod {

    /**
     * The mod id
     */
    public int id;

    /**
     * 	The game id this mod is for
     */
    public int gameId;

    /**
     * 	The name of the mod
     */
    public String name;

    /**
     * 	The mod slug that would appear in the URL
     */
    public String slug;

    /**
     * Relevant links for the mod such as Issue tracker and Wiki
     */
    public ModLinks links;

    /**
     * Mod summary
     */
    public String summary;

    /**
     * 	Current mod status
     */
    public ModStatus status;

    /**
     * Number of downloads for the mod
     */
    public long downloadCount;

    /**
     * Whether the mod is included in the featured mods list
     */
    public boolean isFeatured;

    /**
     * 	The main category of the mod as it was chosen by the mod author
     */
    public int primaryCategoryId;

    /**
     * 	List of categories that this mod is related to
     */
    public List<Category> categories = null;

    /**
     * The class id this mod belongs to
     */
    public Integer classId;

    /**
     * 	List of the mod's authors
     */
    public List<ModAuthor> authors = null;

    /**
     * The mod's logo asset
     */
    public ModAsset logo;

    /**
     * 	List of screenshots assets
     */
    public List<ModAsset> screenshots = null;

    /**
     * The id of the main file of the mod
     */
    public int mainFileId;

    /**
     * List of latest files of the mod
     */
    public List<File> latestFiles = null;

    /**
     * List of file related details for the latest files of the mod
     */
    public List<FileIndex> latestFilesIndexes = null;

    /**
     * 	The creation date of the mod
     */
    public String dateCreated;

    /**
     * The last time the mod was modified
     */
    public String dateModified;

    /**
     * The release date of the mod
     */
    public String dateReleased;

    /**
     * Is mod allowed to be distributed
     */
    public Boolean allowModDistribution;

    /**
     * The mod popularity rank for the game
     */
    public int gamePopularityRank;

    /**
     * Is the mod available for search. This can be false when a mod is experimental, in a deleted state or has only alpha files
     */
    public boolean isAvailable;

    /**
     * The mod's thumbs up count
     */
    public int thumbsUpCount;

}
