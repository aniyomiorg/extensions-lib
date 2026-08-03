package eu.kanade.tachiyomi.animesource.model

import kotlinx.serialization.json.JsonObject

@Suppress("UNUSED", "PropertyName")
interface SAnime {

    var url: String

    var title: String

    var artist: String?

    var author: String?

    var description: String?

    /**
     * A string containing list of all genres separated with `", "`
     */
    var genre: String?

    /**
     * An "enum" value. Refer to the values in the [SAnime companion object](https://github.com/jmir1/extensions-lib/blob/a2afb04d892e94d21cd4ade7094dca27f4c0c180/library/src/main/java/eu/kanade/tachiyomi/animesource/model/SAnime.kt#L25).
     */
    var status: Int

    var thumbnail_url: String?

    var background_url: String?

    /**
     * Useful to exclude animes/movies that will always only have the same episode list
     * from the global updates.
     */
    var update_strategy: AnimeUpdateStrategy

    var fetch_type: FetchType

    var season_number: Double

    /**
     * Extra metadata associated with the anime.
     *
     * The JSON object is not visible to users and intended for internal or source-specific
     * purposes. Apps may define their own namespaced keys (e.g., `"aniyomi.*"`) for sources to populate.
     *
     * This allows apps to attach and ask for custom information without affecting the visible
     * anime data.
     *
     * @since extensions-lib 17
     */
    var memo: JsonObject

    /**
     * Tells the app if it should call [getAnimeXXXUpdate].
     */
    var initialized: Boolean

    companion object {
        const val UNKNOWN = 0
        const val ONGOING = 1
        const val COMPLETED = 2
        const val LICENSED = 3
        const val PUBLISHING_FINISHED = 4
        const val CANCELLED = 5
        const val ON_HIATUS = 6

        fun create(): SAnime {
            throw Exception("Stub!")
        }
    }

}
