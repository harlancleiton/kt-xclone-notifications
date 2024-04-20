package com.twitterclone.notification.domain.valueobjects

/**
 * `Content` represents an abstract Notification content base class.
 *
 * This class can be extended to create more specific Notification content classes with domain-specific
 * validation and manipulation methods.
 *
 * @property value The actual content value of any type. Depending on how the class is extended,
 * this might need to adhere certain validation rules.
 */
abstract class Content(val value: Any)
