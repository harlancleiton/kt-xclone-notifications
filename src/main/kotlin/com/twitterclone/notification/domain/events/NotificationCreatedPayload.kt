package com.twitterclone.notification.domain.events

import com.twitterclone.notification.domain.valueobjects.Content
import com.twitterclone.notification.domain.valueobjects.Recipient

/**
 * `NotificationCreatedPayload` is a data class holding the specific data associated with the creation of a notification.
 *
 * It is part of the [NotificationCreated] domain event and contains values that uniquely belong to
 * the said event type. This payload is unique to the notification creation event and will be carried by it for
 * the duration of the event's lifecycle.
 *
 * @property content The [Content] of the notification that was created.
 * @property recipient The [Recipient] of the notification that was created.
 */
data class NotificationCreatedPayload(val content: Content, val recipient: Recipient)
