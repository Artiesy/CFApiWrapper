package com.klauncher.cfapiwrapper.schemas;

public class Pagination {

    /**
     * 	A zero based index of the first item that is included in the response
     */
    public int index;

    /**
     * The requested number of items to be included in the response
     */
    public int pageSize;

    /**
     * The actual number of items that were included in the response
     */
    public int resultCount;

    /**
     * The total number of items available by the request
     */
    public long totalCount;

}
