package com.klauncher.cfapiwrapper.schemas;

import java.util.List;

public class FingerprintsMatchesResult {

    public boolean isCacheBuilt;

    public List<FingerprintMatch> exactMatches = null;

    public int[] exactFingerprints;

    public List<FingerprintMatch> partialMatches = null;

    public Object partialMatchFingerprints = null;

    public int[] additionalProperties;

    public int[] installedFingerprints;

    public int[] unmatchedFingerprints;
}
