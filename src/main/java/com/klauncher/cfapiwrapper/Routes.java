package com.klauncher.cfapiwrapper;

import com.google.gson.Gson;
import com.klauncher.cfapiwrapper.schemas.ApiResponseOfListOfMinecraftGameVersion;
import com.klauncher.cfapiwrapper.schemas.ApiResponseOfListOfMinecraftModLoaderIndex;
import com.klauncher.cfapiwrapper.schemas.ApiResponseOfMinecraftGameVersion;
import com.klauncher.cfapiwrapper.schemas.ApiResponseOfMinecraftModLoaderVersion;
import com.klauncher.cfapiwrapper.schemas.requests.*;
import com.klauncher.cfapiwrapper.schemas.responses.*;
import com.klauncher.cfapiwrapper.util.*;

public class Routes {

    /**
     * Get all games that are available to the provided API key
     * @return Get Games Response
     * @throws Exception If response doesn't have 200 status code (OK)
     */
    public static GetGamesResponse getGames() throws Exception {
        CFRequest request = new CFRequest("/v1/games", CFRequest.RequestMethod.GET);
        CFResponse response = RequestManager.makeRequest(request);

        return response.getResponse(GetGamesResponse.class);
    }

    /**
     * Get all games that are available to the provided API key
     * @param index A zero based index of the first item to include in the response, the limit is: (index + pageSize <= 10,000)
     * @param pageSize The number of items to include in the response, the default/maximum value is 50
     * @return Get Games Response
     * @throws Exception If response doesn't have 200 status code (OK)
     */
    public static GetGamesResponse getGames(int index, int pageSize) throws Exception {
        CFRequest request = new CFRequest("/v1/games" + "?index=" + index + "&pageSize=" + pageSize, CFRequest.RequestMethod.GET);
        CFResponse response = RequestManager.makeRequest(request);

        return response.getResponse(GetGamesResponse.class);
    }

    /**
     * Get a single game. A private game is only accessible by its respective API key
     * @param gameId Game id provided
     * @return Get Game Response
     * @throws Exception If response doesn't have 200 status code (OK)
     */
    public static GetGameResponse getGame(int gameId) throws Exception {
        CFRequest request = new CFRequest("/v1/games/" + gameId, CFRequest.RequestMethod.GET);
        CFResponse response = RequestManager.makeRequest(request);

        return response.getResponse(GetGameResponse.class);
    }

    /**
     * Get all available versions for each known version type of the specified game. A private game is only accessible
     * to its respective API key
     * @param gameId Game id provided
     * @return Get Versions Response
     * @throws Exception If response doens't have 200 status code (OK)
     */
    public static GetVersionsResponse getVersions(int gameId) throws Exception {
        CFRequest request = new CFRequest("/v1/games/" + gameId + "/versions", CFRequest.RequestMethod.GET);
        CFResponse response = RequestManager.makeRequest(request);

        return response.getResponse(GetVersionsResponse.class);
    }

    /**
     * Get all available version types of the specified game.
     *
     * A private game is only accessible to its respective API key.
     *
     * Currently, when creating games via the CurseForge Core Console, you are limited to a single game version type.
     * This means that this endpoint is probably not useful in most cases and is relevant mostly when handling existing
     * games that have multiple game versions such as World of Warcraft and Minecraft (e.g. 517 for wow_retail).
     * @param gameId Game id provided
     * @return Get Version Types Response
     * @throws Exception If response doens't have 200 status code (OK)
     */
    public static GetVersionTypesResponse getVersionTypes(int gameId) throws Exception {
        CFRequest request = new CFRequest("/v1/games/" + gameId + "/version-types", CFRequest.RequestMethod.GET);
        CFResponse response = RequestManager.makeRequest(request);

        return response.getResponse(GetVersionTypesResponse.class);
    }


    /**
     * Get all available classes and categories of the specified game. Specify a game id for a list of all
     * game categories, or a class id for a list of categories under that class
     * @param gameId Game id provided
     * @return Get Categories Response
     * @throws Exception If response doens't have 200 status code (OK)
     */
    public static GetCategoriesResponse getCategories(int gameId) throws Exception {
        CFRequest request = new CFRequest("/v1/categories?gameId=" + gameId, CFRequest.RequestMethod.GET);
        CFResponse response = RequestManager.makeRequest(request);

        return response.getResponse(GetCategoriesResponse.class);
    }

    /**
     * Get all available classes and categories of the specified game. Specify a game id for a list of all
     * game categories, or a class id for a list of categories under that class
     * @param gameId Game id provided
     * @param classId A class unique id
     * @return Get Categories Response
     * @throws Exception If response doens't have 200 status code (OK)
     */
    public static GetCategoriesResponse getCategories(int gameId, int classId) throws Exception {
        CFRequest request = new CFRequest("/v1/categories?gameId=" + gameId + "&classId=" + classId, CFRequest.RequestMethod.GET);
        CFResponse response = RequestManager.makeRequest(request);

        return response.getResponse(GetCategoriesResponse.class);
    }

    /**
     * Get all mods that match the search criteria
     * @param gameId Game id provided
     * @param searchParams Search params for querying
     * @return Search Mods Response
     * @throws Exception If response doens't have 200 status code (OK)
     */
    public static SearchModsResponse searchMods(int gameId, ModsSearchParams searchParams) throws Exception {
        if(searchParams == null)
            throw new Exception("searchParams cannot be null. If you want to exclude params, " +
                                "create empty object and pass it to this method");

        CFRequest request = new CFRequest("/v1/categories?gameId=" + gameId + searchParams.getQuery(), CFRequest.RequestMethod.GET);
        CFResponse response = RequestManager.makeRequest(request);

        return response.getResponse(SearchModsResponse.class);
    }


    /**
     * Get a single mod
     * @param modId The mod id
     * @return Get Mod Response
     * @throws Exception If response doens't have 200 status code (OK)
     */
    public static GetModResponse getMod(int modId) throws Exception {
        CFRequest request = new CFRequest("/v1/mods/" + modId, CFRequest.RequestMethod.GET);
        CFResponse response = RequestManager.makeRequest(request);

        return response.getResponse(GetModResponse.class);
    }

    /**
     * Get a list of mods
     * @param requestBody Request body containing an array of mod ids
     * @return Get Mods Response
     * @throws Exception If response doens't have 200 status code (OK)
     */
    public static GetModsResponse getMods (GetModsByIdsListRequestBody requestBody) throws Exception {
        CFRequest request = new CFRequest("/v1/mods", CFRequest.RequestMethod.POST, new Gson().toJson(requestBody));
        CFResponse response = RequestManager.makeRequest(request);

        return response.getResponse(GetModsResponse.class);
    }

    /**
     * Get a list of featured, popular and recently updated mods
     * @param requestBody Match results for a game and exclude specific mods
     * @return Get Featured Mods Response
     * @throws Exception If response doens't have 200 status code (OK)
     */
    public static GetFeaturedModsResponse getFeaturedMods (GetFeaturedModsRequestBody requestBody) throws Exception {
        CFRequest request = new CFRequest("/v1/mods/featured", CFRequest.RequestMethod.POST, new Gson().toJson(requestBody));
        CFResponse response = RequestManager.makeRequest(request);

        return response.getResponse(GetFeaturedModsResponse.class);
    }

    /**
     * Get the full description of a mod in HTML format
     * @param modId The mod id
     * @return Full description in HTML
     * @throws Exception If response doens't have 200 status code (OK)
     */
    public static String getModDescription (int modId) throws Exception {
        CFRequest request = new CFRequest("/v1/mods/" + modId + "/description", CFRequest.RequestMethod.GET);
        CFResponse response = RequestManager.makeRequest(request);

        return response.getResponse(String.class);
    }

    /**
     * Get the full description of a mod in HTML format
     * @param modId The mod id
     * @return Get Mod File Response
     * @throws Exception If response doens't have 200 status code (OK)
     */
    public static GetModFileResponse getModFile (int modId, int fileId) throws Exception {
        CFRequest request = new CFRequest("/v1/mods/" + modId + "/files/" + fileId, CFRequest.RequestMethod.GET);
        CFResponse response = RequestManager.makeRequest(request);

        return response.getResponse(GetModFileResponse.class);
    }

    /**
     * Get all files of the specified mod
     * @param modId The mod id
     * @param params The parameters object to pass in
     * @return Get Mod Files Response
     * @throws Exception If response doens't have 200 status code (OK)
     */
    public static GetModFilesResponse getModFiles (int modId, ModFileParams params) throws Exception {
        CFRequest request = new CFRequest("/v1/mods/" + modId + "/files" + params.getQuery(), CFRequest.RequestMethod.GET);
        CFResponse response = RequestManager.makeRequest(request);

        return response.getResponse(GetModFilesResponse.class);
    }


    /**
     * Get a list of files
     * @param requestBody Request body containing a list of file ids to fetch
     * @return Get Files Response
     * @throws Exception If response doens't have 200 status code (OK)
     */
    public static GetFilesResponse getFiles (GetModFilesRequestBody requestBody) throws Exception {
        CFRequest request = new CFRequest("/v1/mods/files", CFRequest.RequestMethod.POST, requestBody.getBody());
        CFResponse response = RequestManager.makeRequest(request);

        return response.getResponse(GetFilesResponse.class);
    }


    /**
     * Get the changelog of a file in HTML format
     * @param modId The mod id the file belongs to
     * @param fileId The file id
     * @return Changelog of file
     * @throws Exception If response doens't have 200 status code (OK)
     */
    public static String getModFileChangelog (int modId, int fileId) throws Exception {
        CFRequest request = new CFRequest("/v1/mods/" + modId + "/files/" + fileId + "/changelog", CFRequest.RequestMethod.GET);
        CFResponse response = RequestManager.makeRequest(request);

        return response.getResponse(String.class);
    }


    /**
     * Get a download url for a specific file
     * @param modId The mod id the file belongs to
     * @param fileId The file id
     * @return File download URL
     * @throws Exception If response doens't have 200 status code (OK)
     */
    public static String getModFileDownloadURL (int modId, int fileId) throws Exception {
        CFRequest request = new CFRequest("/v1/mods/" + modId + "/files/" + fileId + "/download-url", CFRequest.RequestMethod.GET);
        CFResponse response = RequestManager.makeRequest(request);

        return response.getResponse(String.class);
    }


    /**
     * Get mod files that match a list of fingerprints
     * @param requestBody The request body containing an array of fingerprints
     * @return 	Get Fingerprint Matches Response
     * @throws Exception If response doens't have 200 status code (OK)
     */
    public static GetFingerprintMatchesResponse getFingerprintsMatches (GetFingerprintMatchesRequestBody requestBody) throws Exception {
        CFRequest request = new CFRequest("/v1/fingerprints", CFRequest.RequestMethod.POST, requestBody.getBody());
        CFResponse response = RequestManager.makeRequest(request);

        return response.getResponse(GetFingerprintMatchesResponse.class);
    }


    /**
     * Get mod files that match a list of fingerprints using fuzzy matching
     * @param requestBody Game id and folder fingerprints options for the fuzzy matching
     * @return 	Get Fingerprint Matches Response
     * @throws Exception If response doens't have 200 status code (OK)
     */
    public static GetFingerprintsFuzzyMatchesResponse getFingerprintsFuzzyMatches (GetFuzzyMatchesRequestBody requestBody) throws Exception {
        CFRequest request = new CFRequest("/v1/fingerprints/fuzzy", CFRequest.RequestMethod.POST, requestBody.getBody());
        CFResponse response = RequestManager.makeRequest(request);

        return response.getResponse(GetFingerprintsFuzzyMatchesResponse.class);
    }


    /**
     * Get Minecraft Versions
     * @return 	Get Minecraft Versions Response
     * @throws Exception If response doens't have 200 status code (OK)
     */
    public static ApiResponseOfListOfMinecraftGameVersion getMinecraftVersions () throws Exception {
        CFRequest request = new CFRequest("/v1/minecraft/version", CFRequest.RequestMethod.GET);
        CFResponse response = RequestManager.makeRequest(request);

        return response.getResponse(ApiResponseOfListOfMinecraftGameVersion.class);
    }

    /**
     * Get Specific Minecraft Version
     * @return 	Get Specific Minecraft Version Response
     * @throws Exception If response doens't have 200 status code (OK)
     */
    public static ApiResponseOfMinecraftGameVersion getMinecraftVersion (String gameVersionString) throws Exception {
        CFRequest request = new CFRequest("/v1/minecraft/version/" + gameVersionString, CFRequest.RequestMethod.GET);
        CFResponse response = RequestManager.makeRequest(request);

        return response.getResponse(ApiResponseOfMinecraftGameVersion.class);
    }

    /**
     * Get Minecraft ModLoaders
     * @return 	Get Minecraft Modloaders Response
     * @throws Exception If response doens't have 200 status code (OK)
     */
    public static ApiResponseOfListOfMinecraftModLoaderIndex getMinecraftModLoaders () throws Exception {
        CFRequest request = new CFRequest("/v1/minecraft/modloader", CFRequest.RequestMethod.GET);
        CFResponse response = RequestManager.makeRequest(request);

        return response.getResponse(ApiResponseOfListOfMinecraftModLoaderIndex.class);
    }

    /**
     * Get Minecraft ModLoaders
     * @return 	Get Minecraft Modloaders Response
     * @throws Exception If response doens't have 200 status code (OK)
     */
    public static ApiResponseOfListOfMinecraftModLoaderIndex getMinecraftModLoaders (String version) throws Exception {
        CFRequest request = new CFRequest("/v1/minecraft/modloader?version=" + version, CFRequest.RequestMethod.GET);
        CFResponse response = RequestManager.makeRequest(request);

        return response.getResponse(ApiResponseOfListOfMinecraftModLoaderIndex.class);
    }

    /**
     * Get Minecraft ModLoaders
     * @return 	Get Minecraft Modloaders Response
     * @throws Exception If response doens't have 200 status code (OK)
     */
    public static ApiResponseOfListOfMinecraftModLoaderIndex getMinecraftModLoaders (String version, boolean includeAll) throws Exception {
        CFRequest request = new CFRequest("/v1/minecraft/modloader?version=" + version + "&includeAll=" + includeAll, CFRequest.RequestMethod.GET);
        CFResponse response = RequestManager.makeRequest(request);

        return response.getResponse(ApiResponseOfListOfMinecraftModLoaderIndex.class);
    }


    /**
     * Get Minecraft ModLoaders
     * @return 	Get Minecraft Modloaders Response
     * @throws Exception If response doens't have 200 status code (OK)
     */
    public static ApiResponseOfMinecraftModLoaderVersion getMinecraftModLoader (String modLoaderName) throws Exception {
        CFRequest request = new CFRequest("/v1/minecraft/modloader/" + modLoaderName, CFRequest.RequestMethod.GET);
        CFResponse response = RequestManager.makeRequest(request);

        return response.getResponse(ApiResponseOfMinecraftModLoaderVersion.class);
    }


}
