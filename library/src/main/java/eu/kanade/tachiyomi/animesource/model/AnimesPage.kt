package eu.kanade.tachiyomi.animesource.model

@Suppress("Unused")
class AnimesPage(val animes: List<SAnime>, val hasNextPage: Boolean) {

    @Deprecated("AnimesPage is now a regular class")
    operator fun component1(): List<SAnime> = throw Exception("Stub!")

    @Deprecated("AnimesPage is now a regular class")
    operator fun component2(): Boolean = throw Exception("Stub!")

    @Deprecated("AnimesPage is now a regular class")
    fun copy(animes: List<SAnime> = this.animes, hasNextPage: Boolean = this.hasNextPage): AnimesPage = throw Exception("Stub!")
}
