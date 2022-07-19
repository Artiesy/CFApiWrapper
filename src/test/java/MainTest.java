import com.klauncher.cfapiwrapper.Routes;
import com.klauncher.cfapiwrapper.schemas.*;
import com.klauncher.cfapiwrapper.schemas.requests.*;
import com.klauncher.cfapiwrapper.schemas.responses.*;
import com.klauncher.cfapiwrapper.util.CFRequest;
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


        Assertions.assertInstanceOf(GetGamesResponse.class, Routes.getGames());
        Assertions.assertInstanceOf(GetGameResponse.class, Routes.getGame(gameId));
        Assertions.assertInstanceOf(GetVersionsResponse.class, Routes.getVersions(gameId));
        Assertions.assertInstanceOf(GetVersionTypesResponse.class, Routes.getVersionTypes(gameId));
        Assertions.assertInstanceOf(GetCategoriesResponse.class, Routes.getCategories(gameId));
        Assertions.assertInstanceOf(SearchModsResponse.class, Routes.searchMods(gameId, new ModsSearchParams()));
        Assertions.assertInstanceOf(GetModResponse.class, Routes.getMod(modId));
        Assertions.assertInstanceOf(GetModsResponse.class, Routes.getMods(b));
        Assertions.assertInstanceOf(
                GetFeaturedModsResponse.class,
                Routes.getFeaturedMods(new GetFeaturedModsRequestBody(gameId, null, 1)));
        Assertions.assertInstanceOf(String.class, Routes.getModDescription(modId));
        Assertions.assertInstanceOf(GetModFilesResponse.class, Routes.getModFiles(modId, new ModFileParams()));
        Assertions.assertInstanceOf(GetModFileResponse.class, Routes.getModFile(modId, fileId));
        Assertions.assertInstanceOf(GetFilesResponse.class, Routes.getFiles(mfrb));
        Assertions.assertInstanceOf(String.class, Routes.getModFileChangelog(modId, fileId));
        Assertions.assertInstanceOf(String.class, Routes.getModFileDownloadURL(modId, fileId));

        Assertions.assertInstanceOf(GetFingerprintMatchesResponse.class, Routes.getFingerprintsMatches(fmrb));
        Assertions.assertInstanceOf(GetFingerprintsFuzzyMatchesResponse.class, Routes.getFingerprintsFuzzyMatches(ffmrb));

        Assertions.assertInstanceOf(ApiResponseOfListOfMinecraftGameVersion.class, Routes.getMinecraftVersions());
        Assertions.assertInstanceOf(ApiResponseOfMinecraftGameVersion.class, Routes.getMinecraftVersion(version));
        Assertions.assertInstanceOf(ApiResponseOfListOfMinecraftModLoaderIndex.class, Routes.getMinecraftModLoaders());
        Assertions.assertInstanceOf(ApiResponseOfMinecraftModLoaderVersion.class, Routes.getMinecraftModLoader(""));

        System.out.println("All tests had been passed");

    }
}
