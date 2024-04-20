package com.twitterclone.notification.domain.entities

import com.twitterclone.notification.domain.events.EventDispatcher
import com.twitterclone.notification.domain.valueobjects.Recipient
import com.twitterclone.notification.domain.valueobjects.StringContent

/**
 * An abstract base class representing a factory for creating [Notification].
 *
 * This class serves as the base for all notification factories and contains
 * a method for creating a notification. The actual implementation of the method
 * should be provided by the child classes.
 *
 * @property dispatcher An [EventDispatcher] instance which will be used for dispatching events related to notifications.
 */
abstract class AbstractNotificationFactory(protected val dispatcher: EventDispatcher) {
    /**
     * Creates a new notification given the content and the recipient.
     *
     * @param content The actual content of the notification as a [StringContent] object.
     * @param recipient The recipient of the notification as a [Recipient] object.
     * @return A new [Notification] instance.
     */
    abstract fun createNotification(
        content: StringContent,
        recipient: Recipient,
    ): Notification
}
