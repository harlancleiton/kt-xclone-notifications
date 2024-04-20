package com.twitterclone.notification.domain.valueobjects

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import java.util.*

@SpringBootTest
class EntityIdTest {
    @Test
    fun testValue() {
        val uuid = UUID.randomUUID()
        val entityId = EntityId(uuid)
        assertEquals(uuid, entityId.value)
    }

    @Test
    fun testAsString() {
        val uuid = UUID.randomUUID()
        val entityId = EntityId(uuid)
        assertEquals(uuid.toString(), entityId.asString())
    }

    @Test
    fun testRandomUUID() {
        val entityId1 = EntityId()
        val entityId2 = EntityId()
        assertNotEquals(entityId1.value, entityId2.value)
    }
}
