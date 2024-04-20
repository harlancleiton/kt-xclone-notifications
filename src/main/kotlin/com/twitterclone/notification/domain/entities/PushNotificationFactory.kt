package com.twitterclone.notification.domain.entities

import com.twitterclone.notification.domain.events.EventDispatcher
import com.twitterclone.notification.domain.valueobjects.EntityId
import com.twitterclone.notification.domain.valueobjects.Recipient
import com.twitterclone.notification.domain.valueobjects.StringContent

/**
 * This [PushNotificationFactory] class is a concrete implementation of the [AbstractNotificationFactory],
 * responsible for creating [PushNotification] instances.
 *
 * @property dispatcher An instance of [EventDispatcher] that handles events related to notifications.
 */
class PushNotificationFactory(dispatcher: EventDispatcher) : AbstractNotificationFactory(dispatcher) {
    /**
     * Overridden method from [AbstractNotificationFactory] used to create a [PushNotification] object.
     *
     * @param content The content of the notification, encapsulated in a [StringContent] instance
     * @param recipient The intended recipient of the notification, encapsulated in a [Recipient] instance
     * @return Returns a new [PushNotification] object
     */
    override fun createNotification(
        content: StringContent,
        recipient: Recipient,
    ): Notification {
        return PushNotification(
            id = EntityId(),
            sentAt = null,
            readAt = null,
            content,
            recipient,
            dispatcher = dispatcher
        )
    }
}
