package com.twitterclone.notification.domain.entities

import com.twitterclone.notification.domain.events.EventDispatcher
import com.twitterclone.notification.domain.valueobjects.EntityId
import com.twitterclone.notification.domain.valueobjects.Recipient
import com.twitterclone.notification.domain.valueobjects.StringContent
import java.util.*

/**
 * This class represents an PushNotification Entity in our domain.
 *
 * @property id The unique identifier of the PushNotification. Instances of [EntityId].
 * @property sentAt The date when the email notification was sent. Can be null if the email hasn't been sent yet.
 * @property readAt The date when the email notification was read by the recipient. Can be null if the email hasn't been read yet.
 * @property content The content of the email, represented by instances of [StringContent].
 * @property recipient The recipient of the push notification, represented by [Recipient] instances.
 * @property createdAt The date when the PushNotification was created. Defaults to the current date and time.
 * @property updatedAt The date when the PushNotification was last updated. Defaults to the current date and time.
 * @property dispatcher The [EventDispatcher] used to manage events associated with the PushNotification.
 */
class PushNotification(
    id: EntityId,
    sentAt: Date?,
    readAt: Date?,
    content: StringContent,
    recipient: Recipient,
    createdAt: Date = Date(),
    updatedAt: Date = Date(),
    override val dispatcher: EventDispatcher
) : Notification(id, sentAt, readAt, content, recipient, createdAt, updatedAt, dispatcher)
