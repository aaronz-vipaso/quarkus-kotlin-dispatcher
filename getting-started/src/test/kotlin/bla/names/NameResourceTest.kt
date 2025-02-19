package bla.names

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import jakarta.ws.rs.core.MediaType
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

@QuarkusTest
class NameResourceTest {
    /**
     * This unit test works fine
     */
    @Test
    fun `should create a name`() {
        val request = CreateNameRequest(name = "Aaron")

        val response = given()
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .body(request)
        .`when`()
            .post("/names")
        .then()
            .log().body()
            .statusCode(200)
            .extract().`as`(NameResponse::class.java)

        assertEquals("Aaron", response.name)
    }
}