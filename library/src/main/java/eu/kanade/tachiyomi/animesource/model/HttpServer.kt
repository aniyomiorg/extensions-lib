package eu.kanade.tachiyomi.animesource.model

import fi.iki.elonen.NanoHTTPD

/**
 * Class for NanoHTTPD server.
 *
 * The app starts and stops the server and the extension may not all the .start() and .stop().
 * The server will be started if the videoUrl or any of the Track urls matches [PLACEHOLDER_URL]. The
 * url getter will return the scheme, domain, and port for the local server.
 *
 * Since multiple servers may be running at the same time, even for the same source, it is recommended
 * for the server not to share any state with the main extension class, nor is it recommended to use
 * it for any functionality in the source other than fetching the video.
 *
 * @since extensions-lib 17
 */
open class HttpServer : NanoHTTPD(0) {
    val url: String = throw Exception("Stub!")

    companion object {
        const val PLACEHOLDER_URL = "http://localhost:1"
    }
}
