@file:Suppress("unused")

package aniyomix.utils

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.withContext

/**
 * Parallel implementation of [Iterable.map].
 *
 * @since extensions-lib 16
 */
suspend inline fun <A, B> Iterable<A>.parallelMap(crossinline f: suspend (A) -> B): List<B> =
    withContext(Dispatchers.IO) {
        map { async { f(it) } }.awaitAll()
    }

/**
 * Parallel implementation of [Iterable.mapNotNull].
 *
 * @since extensions-lib 16
 */
suspend inline fun <A, B> Iterable<A>.parallelMapNotNull(crossinline f: suspend (A) -> B?): List<B> =
    withContext(Dispatchers.IO) {
        map { async { f(it) } }.awaitAll().filterNotNull()
    }

/**
 * Parallel implementation of [Iterable.flatMap].
 *
 * @since extensions-lib 16
 */
suspend inline fun <A, B> Iterable<A>.parallelFlatMap(crossinline f: suspend (A) -> Iterable<B>): List<B> =
    withContext(Dispatchers.IO) {
        map { async { f(it) } }.awaitAll().flatten()
    }

/**
 * Parallel implementation of [Iterable.flatMap], but running
 * the transformation function inside a try-catch block.
 *
 * @since extensions-lib 16
 */
@Deprecated("Use aniyomix variant instead")
suspend inline fun <A, B> Iterable<A>.parallelCatchingFlatMap(crossinline f: suspend (A) -> Iterable<B>): List<B> =
    withContext(Dispatchers.IO) {
        map {
            async {
                try { f(it) } catch (e: Throwable) {
                    e.printStackTrace()
                    emptyList()
                }
            }
        }.awaitAll().flatten()
    }
