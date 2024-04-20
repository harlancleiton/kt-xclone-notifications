package com.twitterclone.notification.domain.exceptions

/**
 * `NotificationAlreadySentException` is thrown when an attempt is made to send a notification that has already been sent.
 *
 * It extends from the [BaseException] class and overrides the `isClientError()` and `isServerError()` methods.
 */
class NotificationAlreadySentException : BaseException("Notification already sent") {
    /**
     * Returns `true` indicating that this exception is a client error.
     * A [NotificationAlreadySentException] is typically due to client behavior
     * such as attempting to re-send an already sent notification.
     */
    override fun isClientError(): Boolean {
        return true
    }

    /**
     * Returns `false` indicating that this exception is not a server error.
     * A [NotificationAlreadySentException] is typically not due to a server error
     * but can aid in debugging client-side operations.
     */
    override fun isServerError(): Boolean {
        return false
    }
}
