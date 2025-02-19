package bla.names

import jakarta.ws.rs.Consumes
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response

@Path("/names")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
class NameResource(
    private val service: NameService
) {
    @POST
    suspend fun create(request: CreateNameRequest): Response {
        val response = service.create(request.name)

        return Response.ok(response).build()
    }
}