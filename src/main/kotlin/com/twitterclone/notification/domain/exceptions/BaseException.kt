package com.twitterclone.notification.domain.exceptions

import com.twitterclone.notification.domain.valueobjects.EntityId
import java.time.Instant

/**
 * `BaseException` is an abstract base class for all exceptions in the domain.
 * It encapsulates common properties and behaviors of a domain exception.
 *
 * @property message The detail message string of this throwable.
 * @property cause The cause of this throwable or `null` if the cause is nonexistent or unknown.
 */
abstract class BaseException(message: String, cause: Throwable? = null) : Exception(message, cause) {
    /**
     * A unique identifier for this exception instance, an instance of [EntityId].
     */
    val id = EntityId()

    /**
     * The name of the exception.
     * It removes the need to hard-code exception names.
     */
    val name: String
        get() = this.javaClass.simpleName

    /**
     * The timestamp when the exception occurred.
     */
    val timestamp = Instant.now()

    /**
     * Returns `true` if the exception is a client error, `false` otherwise.
     * To be implemented by child classes.
     */
    abstract fun isClientError(): Boolean

    /**
     * Returns `true` if the exception is a server error, `false` otherwise.
     * To be implemented by child classes.
     */
    abstract fun isServerError(): Boolean
}
