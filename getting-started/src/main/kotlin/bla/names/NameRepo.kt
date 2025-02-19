package bla.names

import io.quarkus.hibernate.reactive.panache.kotlin.PanacheRepositoryBase
import jakarta.enterprise.context.ApplicationScoped
import java.util.*

@ApplicationScoped
class NameRepo : PanacheRepositoryBase<NameEntity, UUID>