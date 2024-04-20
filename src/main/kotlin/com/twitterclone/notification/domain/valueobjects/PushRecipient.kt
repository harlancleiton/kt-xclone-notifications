package com.twitterclone.notification.domain.valueobjects

/**
 * `PushRecipient` is a concrete recipient class that represents a recipient of push notifications.
 *
 * This class extends the abstract class [Recipient]. The [pushToken] property uniquely identifies the
 * recipient for the push notification service.
 *
 * @property pushToken The unique push notification token for the recipient.
 */
data class PushRecipient(val pushToken: String) : Recipient()
