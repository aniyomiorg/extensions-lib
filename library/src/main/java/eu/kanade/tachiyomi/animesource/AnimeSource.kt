package eu.kanade.tachiyomi.animesource

import eu.kanade.tachiyomi.animesource.model.Hoster
import eu.kanade.tachiyomi.animesource.model.Video
import eu.kanade.tachiyomi.animesource.model.SEpisode
import eu.kanade.tachiyomi.animesource.model.SAnime

/**
 * A basic interface for creating a source. It could be an online source, a local source, etc...
 */
interface AnimeSource {

    /**
     * Id for the source. Must be unique.
     */
    val id: Long

    /**
     * Name of the source.
     */
    val name: String

    /**
     * Get the updated details for an anime.
     *
     * @since extensions-lib 14
     * @param anime the anime to update.
     * @return the updated anime.
     */
    suspend fun getAnimeDetails(anime: SAnime): SAnime

    /**
     * Get all the available episodes for an anime.
     *
     * @since extensions-lib 14
     * @param anime the anime to update.
     * @return the episodes for the anime.
     */
    suspend fun getEpisodeList(anime: SAnime): List<SEpisode>

    /**
     * Get all the available seasons for an anime
     *
     * @since extensions-lib 16
     * @param anime the anime to fetch seasons for.
     * @return the anime list for the anime.
     */
    suspend fun getSeasonList(anime: SAnime): List<SAnime>

    /**
     * Get the list of hoster for an episode.
     *
     * @since extensions-lib 16
     * @param episode the episode.
     * @return the hosters for the episode.
     */
    suspend fun getHosterList(episode: SEpisode): List<Hoster>

    /**
     * Get the list of videos for a hoster.
     *
     * @since extensions-lib 16
     * @param hoster the hoster.
     * @return the videos for the hoster.
     */
    suspend fun getVideoList(hoster: Hoster): List<Video>
}
