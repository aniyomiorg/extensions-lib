@file:Suppress("Unused", "UnusedReceiverParameter", "RedundantSuspendModifier")

package eu.kanade.tachiyomi.network

import okhttp3.Call
import okhttp3.Response

suspend fun Call.await(): Response = throw Exception("Stub!")

/**
 * @since extensions-lib 14
 */
suspend fun Call.awaitSuccess(): Response = throw Exception("Stub!")
