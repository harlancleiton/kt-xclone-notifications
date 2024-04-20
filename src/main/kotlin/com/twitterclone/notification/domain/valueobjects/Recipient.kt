package com.twitterclone.notification.domain.valueobjects

/**
 * `Recipient` is an abstract class that represents a recipient of a notification.
 *
 * This class forms the base for more specific recipient classes, such as [EmailRecipient] or [PushRecipient].
 * The exact details of the recipient (like email address or push token), are expected to be stored in the concrete subclass.
 */
abstract class Recipient
