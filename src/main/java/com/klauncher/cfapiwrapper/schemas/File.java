package com.klauncher.cfapiwrapper.schemas;

import java.util.List;

public class File {

    /**
     * The file id
     */
    public int id;

    /**
     * The game id related to the mod that this file belongs to
     */
    public int gameId;

    /**
     * The mod id
     */
    public int modId;

    /**
     * Whether the file is available to download
     */
    public boolean isAvailable;

    /**
     * Display name of the file
     */
    public String displayName;

    /**
     * Exact file name
     */
    public String fileName;

    /**
     * The file release type
     */
    public FileReleaseType releaseType;

    /**
     * Status of the file
     */
    public FileStatus fileStatus;

    /**
     * The file hash (i.e. md5 or sha1)
     */
    public List<FileHash> hashes = null;

    /**
     * The file timestamp
     */
    public String fileDate;

    /**
     * The file length in bytes
     */
    public long fileLength;

    /**
     * The number of downloads for the file
     */
    public long downloadCount;

    /**
     * The file download URL
     */
    public String downloadUrl;

    /**
     * List of game versions this file is relevant for
     */
    public List<String> gameVersions = null;

    /**
     * Metadata used for sorting by game versions
     */
    public List<SortableGameVersion> sortableGameVersions = null;

    /**
     * List of dependencies files
     */
    public List<FileDependency> dependencies = null;

    public Boolean exposeAsAlternative = null;

    public Integer parentProjectFileId = null;

    public Integer alternateFileId = null;

    public Boolean isServerPack = null;

    public Integer serverPackFileId = null;

    public Long fileFingerprint = null;

    public List<FileModule> modules = null;

}
