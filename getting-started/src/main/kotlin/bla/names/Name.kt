package bla.names

import java.util.UUID

data class CreateNameRequest(
    val name: String
)

data class NameResponse(
    val id: UUID,
    val name: String
)