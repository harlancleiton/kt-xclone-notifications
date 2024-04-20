package com.twitterclone.notification.domain.events

import com.twitterclone.notification.domain.valueobjects.EntityId
import java.util.*

/**
 * `NotificationCreated` is a type of [DomainEvent] signifying the creation of a notification.
 * This event is generated as a result of a notification being created in the system and contains relevant information.
 *
 * @property id A unique identifier for this event instance. By default, it is an instance of [EntityId].
 * @property aggregateId The unique identifier of the aggregate root that this domain event belongs to.
 * @property entityId The unique identifier of the entity that triggered the event.
 * @property name The name of this event. By default, it is set to "NotificationCreated".
 * @property occurredAt The timestamp when the event occurred. By default, it is set to the time of creation.
 * @property payload Contains specific data associated with the creation of a notification. It's an Optional of type [NotificationCreatedPayload].
 */
data class NotificationCreated(
    override val id: EntityId = EntityId(),
    override val aggregateId: EntityId,
    override val entityId: EntityId,
    override val name: String = "NotificationCreated",
    override val occurredAt: Date = Date(),
    override val payload: Optional<NotificationCreatedPayload>
) : DomainEvent<NotificationCreatedPayload>
