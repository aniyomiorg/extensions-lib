package eu.kanade.tachiyomi.network

import android.content.Context
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

@Suppress("unused_parameter")
class NetworkHelper(context: Context) {

    val client: OkHttpClient = throw Exception("Stub!")

    val cloudflareClient: OkHttpClient = throw Exception("Stub!")
}
