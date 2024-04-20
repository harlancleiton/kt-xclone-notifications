package com.twitterclone.notification.domain.entities

import com.twitterclone.notification.domain.events.DomainEvent
import com.twitterclone.notification.domain.events.EventDispatcher
import com.twitterclone.notification.domain.valueobjects.EntityId
import java.util.*

/**
 * [BaseEntity] is an abstract base class for all entities in the domain.
 * It encapsulates the common properties and behaviors of a domain entity.
 *
 * @param id A unique identifier for the entity instance.
 * @param createdAt The timestamp signifying when the entity was created.
 * @param updatedAt The timestamp signifying when the entity was last updated.
 * @param dispatcher An [EventDispatcher] which will be used for dispatching events related to the entity.
 */
abstract class BaseEntity(
    var id: EntityId = EntityId(),
    var createdAt: Date = Date(),
    var updatedAt: Date = Date(),
    open val dispatcher: EventDispatcher,
) {
    private val events = mutableListOf<DomainEvent<*>>()

    /**
     * Apply a [DomainEvent] to this entity and store it in the list of uncommitted events.
     *
     * This method should be used in methods of domain entities that execute domain actions.
     * Such methods should create new domain events and apply them to the entity
     * using this method.
     *
     * @param event A [DomainEvent] to apply to the entity.
     * @return A [Result] indicating the success or failure of the operation.
     */
    open fun <T : Any> apply(event: DomainEvent<T>): Result<Unit> {
        events.add(event)
        return Result.success(Unit)
    }

    /**
     * Commit the changes made to the entity.
     *
     * This method dispatches events that were recorded within the entity, and then clears the event list.
     * Use case example: Commit changes after applying one or more domain events to the entity.
     */
    fun commit() {
        events.forEach { event ->
            dispatcher.dispatch(event)
        }
        events.clear()
    }
}
