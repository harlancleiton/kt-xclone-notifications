package com.twitterclone.notification.domain.events

import com.twitterclone.notification.domain.valueobjects.EntityId
import java.util.*

data class NotificationSent(
    override val id: EntityId = EntityId(),
    override val aggregateId: EntityId,
    override val entityId: EntityId,
    override val name: String = "NotificationSent",
    override val occurredAt: Date = Date(),
    override val payload: Optional<Unit> = Optional.empty()
) : DomainEvent<Unit>
