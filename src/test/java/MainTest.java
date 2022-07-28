import com.klauncher.cfapiwrapper.CFRequests;
import com.klauncher.cfapiwrapper.schemas.*;
import com.klauncher.cfapiwrapper.schemas.requests.*;
import com.klauncher.cfapiwrapper.schemas.responses.*;
import com.klauncher.cfapiwrapper.util.ModFileParams;
import com.klauncher.cfapiwrapper.util.ModsSearchParams;
import com.klauncher.cfapiwrapper.util.RequestManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class MainTest {



    @Test
    void TestInstances() throws Exception {

        String apiKey = "";
        RequestManager.useApiKey(apiKey);

        int gameId = 432;
        int modId = 32274;
        int fileId = 3875363;
        String version = "1.16.5";

        GetModsByIdsListRequestBody b = new GetModsByIdsListRequestBody();
        b.modIds = new ArrayList<>();
        b.modIds.add(modId);

        GetModFilesRequestBody mfrb = new GetModFilesRequestBody();
        mfrb.fileIds = new ArrayList<>();
        mfrb.fileIds.add(fileId);

        GetFingerprintMatchesRequestBody fmrb = new GetFingerprintMatchesRequestBody();
        fmrb.fingerprints = new ArrayList<>();
        fmrb.fingerprints.add(0);

        GetFuzzyMatchesRequestBody ffmrb = new GetFuzzyMatchesRequestBody();
        ffmrb.fingerprints = new ArrayList<>();
        ffmrb.fingerprints.add(new FolderFingerprint());


        Assertions.assertInstanceOf(GetGamesResponse.class, CFRequests.getGames());
        Assertions.assertInstanceOf(GetGameResponse.class, CFRequests.getGame(gameId));
        Assertions.assertInstanceOf(GetVersionsResponse.class, CFRequests.getVersions(gameId));
        Assertions.assertInstanceOf(GetVersionTypesResponse.class, CFRequests.getVersionTypes(gameId));
        Assertions.assertInstanceOf(GetCategoriesResponse.class, CFRequests.getCategories(gameId));
        Assertions.assertInstanceOf(SearchModsResponse.class, CFRequests.searchMods(gameId, new ModsSearchParams()));
        Assertions.assertInstanceOf(GetModResponse.class, CFRequests.getMod(modId));
        Assertions.assertInstanceOf(GetModsResponse.class, CFRequests.getMods(b));
        Assertions.assertInstanceOf(
                GetFeaturedModsResponse.class,
                CFRequests.getFeaturedMods(new GetFeaturedModsRequestBody(gameId, null, 1)));
        Assertions.assertInstanceOf(String.class, CFRequests.getModDescription(modId));
        Assertions.assertInstanceOf(GetModFilesResponse.class, CFRequests.getModFiles(modId, new ModFileParams()));
        Assertions.assertInstanceOf(GetModFileResponse.class, CFRequests.getModFile(modId, fileId));
        Assertions.assertInstanceOf(GetFilesResponse.class, CFRequests.getFiles(mfrb));
        Assertions.assertInstanceOf(String.class, CFRequests.getModFileChangelog(modId, fileId));
        Assertions.assertInstanceOf(String.class, CFRequests.getModFileDownloadURL(modId, fileId));

        Assertions.assertInstanceOf(GetFingerprintMatchesResponse.class, CFRequests.getFingerprintsMatches(fmrb));
        Assertions.assertInstanceOf(GetFingerprintsFuzzyMatchesResponse.class, CFRequests.getFingerprintsFuzzyMatches(ffmrb));

        Assertions.assertInstanceOf(ApiResponseOfListOfMinecraftGameVersion.class, CFRequests.getMinecraftVersions());
        Assertions.assertInstanceOf(ApiResponseOfMinecraftGameVersion.class, CFRequests.getMinecraftVersion(version));
        Assertions.assertInstanceOf(ApiResponseOfListOfMinecraftModLoaderIndex.class, CFRequests.getMinecraftModLoaders());
        Assertions.assertInstanceOf(ApiResponseOfMinecraftModLoaderVersion.class, CFRequests.getMinecraftModLoader(""));

        System.out.println("All tests had been passed");

    }
}
