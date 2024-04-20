package com.twitterclone.notification.domain.entities

import com.twitterclone.notification.domain.events.EventDispatcher
import com.twitterclone.notification.domain.valueobjects.EntityId
import com.twitterclone.notification.domain.valueobjects.Recipient
import com.twitterclone.notification.domain.valueobjects.StringContent

/**
 * Factory class for creating [EmailNotification] objects.
 *
 * Inherits from the [AbstractNotificationFactory] and implements the
 * `createNotification` method to produce an instance of [EmailNotification].
 *
 * @property dispatcher An [EventDispatcher] instance which will be used for dispatching events related to notifications.
 */
class EmailNotificationFactory(dispatcher: EventDispatcher) : AbstractNotificationFactory(dispatcher) {
    /**
     * Creates a new [EmailNotification].
     * The `id`, `sentAt` and `readAt` properties are set within this method.
     *
     * @param content The actual content of the notification as a [StringContent] object.
     * @param recipient The recipient of the notification as a [Recipient] object.
     * @return A newly created [EmailNotification] instance.
     */
    override fun createNotification(
        content: StringContent,
        recipient: Recipient,
    ): Notification {
        return EmailNotification(
            id = EntityId(),
            sentAt = null,
            readAt = null,
            content,
            recipient,
            dispatcher = dispatcher
        )
    }
}
