package com.twitterclone.notification.domain.valueobjects

/**
 * `EmailRecipient` is a concrete recipient class that represents an email recipient of a notification.
 *
 * This class extends the abstract class [Recipient]. The [email] property is the email address of the recipient.
 *
 * @property email The email address of the recipient.
 */
data class EmailRecipient(val email: String) : Recipient()
