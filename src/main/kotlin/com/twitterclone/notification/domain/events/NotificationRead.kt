package com.twitterclone.notification.domain.events

import com.twitterclone.notification.domain.valueobjects.EntityId
import java.util.*

/**
 * `NotificationRead` is a type of [DomainEvent] that signifies when a notification has been read.
 * This event is generated as a result of a user action involving reading a notification in the system.
 *
 * @property id A unique identifier for this event instance. By default, it is an instance of [EntityId].
 * @property aggregateId The unique identifier of the aggregate root to which this domain event belongs.
 * @property entityId The unique identifier of the entity that triggered the event.
 * @property name The name of this event. By default it is set to "NotificationRead".
 * @property occurredAt The timestamp when the event occurred. By default it is set to the time of creation.
 * @property payload Contains specific data associated with the reading of a notification. In this case, since reading a notification does not produce additional data, payload is set as empty.
 */
data class NotificationRead(
    override val id: EntityId = EntityId(),
    override val aggregateId: EntityId,
    override val entityId: EntityId,
    override val name: String = "NotificationRead",
    override val occurredAt: Date = Date(),
    override val payload: Optional<Unit> = Optional.empty()
) : DomainEvent<Unit>
