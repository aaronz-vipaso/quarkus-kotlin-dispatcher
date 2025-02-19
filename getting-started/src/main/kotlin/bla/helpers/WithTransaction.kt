package bla.helpers

import io.quarkus.hibernate.reactive.panache.Panache
import io.smallrye.mutiny.coroutines.asUni
import io.smallrye.mutiny.coroutines.awaitSuspending
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

@OptIn(ExperimentalCoroutinesApi::class)
suspend fun <T> withTransaction(block: suspend () -> T): T = coroutineScope {
    Panache.withTransaction {
        this.async { block() }.asUni()
    }.awaitSuspending()
}