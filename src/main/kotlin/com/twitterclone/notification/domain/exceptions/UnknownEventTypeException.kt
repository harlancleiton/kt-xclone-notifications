package com.twitterclone.notification.domain.exceptions

import com.twitterclone.notification.domain.events.DomainEvent

/**
 * `UnknownEventTypeException` is a type of exception that is thrown when an unrecognized or unsupported
 * [DomainEvent] type is encountered.
 *
 * This class extends [BaseException], overriding the `isClientError()` and `isServerError()`
 * methods to return `true` and `false` respectively.
 *
 * @param event The [DomainEvent] that caused this exception to be thrown.
 */
class UnknownEventTypeException(val event: DomainEvent<Any>) : BaseException("Unknown event type") {
    /**
     * Indicates that this type of exception should be categorized as a client error.
     * This method returns `true`, classifying [UnknownEventTypeException] as a client error.
     *
     * @return `true` as this exception represents a client error
     */
    override fun isClientError(): Boolean {
        return true
    }

    /**
     * Indicates that this type of exception should not be categorized as a server error.
     * This method returns `false`, meaning that [UnknownEventTypeException] is not a server error.
     *
     * @return `false` as this exception does not represent a server error
     */
    override fun isServerError(): Boolean {
        return false
    }
}
