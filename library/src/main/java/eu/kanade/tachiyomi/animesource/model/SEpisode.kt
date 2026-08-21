package eu.kanade.tachiyomi.animesource.model

import kotlinx.serialization.json.JsonObject

@Suppress("UNUSED", "PropertyName")
interface SEpisode {

    var url: String

    var name: String

    var date_upload: Long

    var episode_number: Float

    var fillermark: Boolean

    var scanlator: String?

    var summary: String?

    var preview_url: String?

    /**
     * Extra metadata associated with the episode.
     *
     * The JSON object is not visible to users and intended for internal or source-specific
     * purposes. Apps may define their own namespaced keys (e.g., `"aniyomi.*"`) for sources to populate.
     *
     * This allows apps to attach and ask for custom information without affecting the visible
     * episode data.
     *
     * @since extensions-lib 17
     */
    var memo: JsonObject

    companion object {
        fun create(): SEpisode {
            throw Exception("Stub!")
        }
    }

}