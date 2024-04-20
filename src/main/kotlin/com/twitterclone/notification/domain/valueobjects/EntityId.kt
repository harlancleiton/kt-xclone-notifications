package com.twitterclone.notification.domain.valueobjects

import java.util.*

/**
 * `EntityId` class is a value object which represents an entity's unique identifier.
 *
 * It encapsulates a [UUID] which by default is a randomly generated UUID.
 *
 * @param value The value of the id which defaults to a random UUID if not provided.
 */
class EntityId(value: UUID = UUID.randomUUID()) {
    /**
     * A private property, `_value`, to hold the [UUID] used as an id.
     */
    private val _value: UUID = value

    /**
     * A property, `value`, to access the [_value] without modifying it.
     */
    val value: UUID
        get() = _value

    /**
     * Method `asString` is used to convert UUID into its string representation.
     * @return The string representation of the UUID.
     */
    fun asString() = _value.toString()
}
