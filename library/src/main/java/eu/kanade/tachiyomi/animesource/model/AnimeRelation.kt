package eu.kanade.tachiyomi.animesource.model

/**
 * A named group of anime, that are related to a specific anime entry
 *
 * Will need [SAnime.url], [SAnime.title] and [SAnime.thumbnail_url] to be filled in
 *
 * @since extensions-lib 17
 * @param name label shown above the row, e.g. "Sequels", "Recommended" etc
 * @param animes the related entries, in the order they should be shown
 */
@Suppress("Unused")
class AnimeRelation(
    val name: String,
    val animes: List<SAnime>,
)
