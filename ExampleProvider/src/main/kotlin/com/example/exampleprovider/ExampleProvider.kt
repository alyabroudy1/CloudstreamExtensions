package com.example.exampleprovider

import com.lagradost.cloudstream3.*
import com.lagradost.cloudstream3.utils.*

class ExampleProvider : MainAPI() {
    override var mainUrl = "https://example.com"
    override var name = "ExampleProvider"
    override val supportedTypes = setOf(TvType.Movie)
    override var lang = "en"
    override val hasMainPage = true

    override suspend fun getMainPage(page: Int, request: MainPageRequest): HomePageResponse? {
        val items = listOf(
            newMovieSearchResponse("Example Movie", "example_movie_id") {
                this.posterUrl = "https://via.placeholder.com/300x450"
            }
        )
        return newHomePageResponse(HomePageList("Featured", items))
    }

    override suspend fun load(url: String): LoadResponse? {
        return newMovieLoadResponse("Example Movie", url, TvType.Movie, url) {
            this.posterUrl = "https://via.placeholder.com/300x450"
            this.plot = "This is an example movie description."
        }
    }

    override suspend fun loadLinks(
        data: String,
        isCasting: Boolean,
        subtitleCallback: (SubtitleFile) -> Unit,
        callback: (ExtractorLink) -> Unit
    ): Boolean {
        callback.invoke(
            newExtractorLink(
                "Big Buck Bunny",
                "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
                "",
                ExtractorLinkType.VIDEO
            ) {
                this.quality = Qualities.P720.value
            }
        )
        return true
    }
}
