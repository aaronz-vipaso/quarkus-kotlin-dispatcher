package bla.names

import bla.helpers.withTransaction
import io.quarkus.logging.Log
import io.smallrye.mutiny.coroutines.awaitSuspending
import jakarta.enterprise.context.ApplicationScoped
import kotlinx.coroutines.delay
import java.util.*
import kotlin.coroutines.coroutineContext

@ApplicationScoped
class NameService(
    private val repo: NameRepo
) {
    suspend fun create(name: String): NameResponse = withTransaction {
        Log.debug("🔍 current coroutine context: $coroutineContext")

        val entity = NameEntity().apply {
            this.id = UUID.randomUUID()
            this.name = name
        }

        repo.persist(entity).awaitSuspending()

        NameResponse(entity.id, entity.name)
    }

    suspend fun concat(first: String, last: String): String {
        delay(1) // make it a suspend function
        return listOf(first, last).joinToString(" ")
    }
}