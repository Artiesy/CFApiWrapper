# CFApiWrapper
Unofficial CurseForge API Wrapper, that helps you fetch information from CurseForge

## Features
- API/Non-API (proxy) usage
- All schemas from https://docs.curseforge.com/ with route to fetch data
- Fast and lightweight, using native Java 8 functions and Gson
- Free to use

## Usage

1) Include .jar file to your project
2) Configure Request Manager to use your API token (if exists) and set (if necessary) alternative base url (default: `https://api.curseforge.com`) using methods `RequestManager.useApiKey(apiKey)` and `RequestManager.setBaseUrl()`
3) Use `Routes` class with defined methods to fetch data from CurseForge API (the naming of methods are same that they named in documentation, example: getFeaturedMods)
