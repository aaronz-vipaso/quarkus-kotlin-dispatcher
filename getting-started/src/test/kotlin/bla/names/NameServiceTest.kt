package bla.names

import io.quarkus.test.junit.QuarkusTest
import io.quarkus.test.vertx.RunOnVertxContext
import io.vertx.core.Vertx
import io.vertx.kotlin.coroutines.dispatcher
import jakarta.inject.Inject
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.withContext
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

@QuarkusTest
class NameServiceTest {
    @Inject
    private lateinit var nameService: NameService

    /**
     * This unit test has issues
     */
    @Test
    @RunOnVertxContext
    fun `should create a name`() = runTest {
        val vertxDispatcher = Vertx.currentContext()!!.dispatcher()

        withContext(vertxDispatcher) {
            /*
            How can I call service class methods that access the DB (requires the Vert.x context)?
             */
            val response = nameService.create("Aaron")

            assertEquals("Aaron", response.name)
        }
    }

    /**
     * This unit test works fine.
     *
     * Accessing suspended functions that don't require the Vert.x context works.
     */
    @Test
    fun `should concat two names`() = runTest {
        val fullName = nameService.concat("John", "Doe")
        assertEquals("John Doe", fullName)
    }

}