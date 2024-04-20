package com.twitterclone.notification.domain.events

/**
 * This `EventDispatcher` interface represents a handler for dispatching [DomainEvent] instances.
 *
 * An Event Dispatcher is responsible for taking a [DomainEvent] object and ensuring that
 * it is processed correctly. This typically involves invoking the appropriate event handler
 * or handlers for the event.
 */
interface EventDispatcher {
    /**
     * Dispatches the given [DomainEvent] to the appropriate event handlers.
     *
     * Implementations of this method are responsible for making sure that the event
     * is delivered correctly, which could involve calling multiple handlers,
     * dealing with failure situations, etc.
     *
     * @param event The [DomainEvent] to dispatch.
     * @param T The type of the payload within the DomainEvent
     */
    fun <T : Any> dispatch(event: DomainEvent<T>)
}
