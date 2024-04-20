package com.twitterclone.notification.domain.exceptions

/**
 * `NotificationAlreadyReadException` is thrown when an attempt is made to read a notification that has already been read.
 *
 * It extends from the [BaseException] class and overrides the `isClientError()` and `isServerError()` methods.
 */
class NotificationAlreadyReadException : BaseException("Notification already read") {
    /**
     * Returns `true` indicating that this exception is a client error.
     * A [NotificationAlreadyReadException] is typically due to client behavior
     * such as attempting to re-read a already read notification.
     */
    override fun isClientError(): Boolean {
        return true
    }

    /**
     * Returns `false` indicating that this exception is not a server error.
     * A [NotificationAlreadyReadException] is typically not due to a server error
     * but can aid in debugging client-side operations.
     */
    override fun isServerError(): Boolean {
        return false
    }
}
