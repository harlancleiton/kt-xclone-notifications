package com.twitterclone.notification.domain.events

import com.twitterclone.notification.domain.valueobjects.EntityId
import java.util.*

/**
 * This `DomainEvent` interface represents a domain event in the system.
 *
 * Domain events are instances of domain-specific events that happened in the past.
 * They are used to model side effects in your domain that are triggered by commands.
 *
 * @property id The unique identifier for this event instance.
 * @property aggregateId The unique id of the aggregate root that the domain event belongs to.
 * @property entityId The unique id of the entity that triggered the event.
 * @property name The name of the event.
 * @property occurredAt The timestamp when the event occurred.
 * @property payload The actual event data, encapsulated in a [T] instance. It may be `null` if there's no data associated with the event.
 * @param T The type of the payload. If there's no payload associated with the event, use [Unit].
 */
interface DomainEvent<T : Any> {
    val id: EntityId
    val aggregateId: EntityId
    val entityId: EntityId
    val name: String
    val occurredAt: Date
    val payload: Optional<T>
}
