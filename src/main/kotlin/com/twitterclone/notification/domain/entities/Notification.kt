package com.twitterclone.notification.domain.entities

import com.twitterclone.notification.domain.events.*
import com.twitterclone.notification.domain.exceptions.NotificationAlreadyReadException
import com.twitterclone.notification.domain.exceptions.NotificationAlreadySentException
import com.twitterclone.notification.domain.exceptions.UnknownEventTypeException
import com.twitterclone.notification.domain.valueobjects.Content
import com.twitterclone.notification.domain.valueobjects.EntityId
import com.twitterclone.notification.domain.valueobjects.Recipient
import java.util.*

/**
 * This is an abstract base class for all Notification related entities in the domain.
 *
 * @property id Uniquely identifies this Notification instance.
 * @property sentAt The Date when notification was sent. Can be null if the notification is not sent yet.
 * @property readAt The Date when the notification was read. Can be null if the notification is not read yet.
 * @property content The content of the notification.
 * @property recipient The Recipient of the notification.
 * @property createdAt When the notification was created.
 * @property updatedAt When the notification was last updated.
 * @property dispatcher Is responsible for handling events.
 */
abstract class Notification(
    id: EntityId,
    sentAt: Date?,
    readAt: Date?,
    val content: Content,
    val recipient: Recipient,
    createdAt: Date = Date(),
    updatedAt: Date = Date(),
    override val dispatcher: EventDispatcher
) :
    BaseEntity(
        id = id,
        createdAt = createdAt,
        updatedAt = updatedAt,
        dispatcher = dispatcher
    ) {
    private var _sentAt: Date? = sentAt
    val sentAt: Date?
        get() = _sentAt

    private var _readAt: Date? = readAt
    val readAt: Date?
        get() = _readAt

    /**
     * Check if the notification has been sent.
     */
    val sent: Boolean
        get() = _sentAt != null

    /**
     * Check if the notification has been read.
     */
    val read: Boolean
        get() = _readAt != null

    /**
     * Handles the application of the events to this notification.
     *
     * @param event The domain event to be applied.
     * @return The result of applying the event. Can be a success or a failure.
     *
     * @throws UnknownEventTypeException if the event is unknown
     */
    override fun <T : Any> apply(event: DomainEvent<T>): Result<Unit> {
        when (event) {
            is NotificationRead -> {
                _readAt = event.occurredAt
                updatedAt = event.occurredAt
            }

            is NotificationSent -> {
                _sentAt = event.occurredAt
                updatedAt = event.occurredAt
            }

            is NotificationCreated -> {
                id = event.entityId
                _sentAt = null
                _readAt = null
                createdAt = event.occurredAt
                updatedAt = event.occurredAt
            }

            else -> {
                val unknownEvent = object : DomainEvent<Any> {
                    override val id: EntityId = event.id
                    override val aggregateId: EntityId = event.aggregateId
                    override val entityId: EntityId = event.entityId
                    override val name: String = event.name
                    override val occurredAt: Date = event.occurredAt
                    override val payload: Optional<Any> = event.payload.map { it as Any }
                }
                return Result.failure(UnknownEventTypeException(unknownEvent))
            }
        }

        return super.apply(event)
    }

    /**
     *  Marks the notification as sent.
     *
     *  @return Result of operation. It can be a success or failure if the notification is already sent.
     */
    fun markAsSent(): Result<Unit> {
        if (sent) return Result.failure(NotificationAlreadySentException())

        apply(NotificationSent(entityId = id, aggregateId = id))
        return Result.success(Unit)
    }

    /**
     *  Marks the notification as read.
     *
     *  @return Result of operation. It can be a success or failure if the notification is already read.
     */
    fun markAsRead(): Result<Unit> {
        if (read) return Result.failure(NotificationAlreadyReadException())

        apply(NotificationRead(entityId = id, aggregateId = id))
        return Result.success(Unit)
    }
}

