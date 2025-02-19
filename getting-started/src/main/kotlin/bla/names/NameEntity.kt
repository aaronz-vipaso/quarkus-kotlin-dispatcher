package bla.names

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.util.UUID

@Entity(name = "names")
class NameEntity {
    @Id
    lateinit var id: UUID

    @Column(nullable = false)
    lateinit var name: String
}