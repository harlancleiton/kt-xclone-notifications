package com.twitterclone.notification.domain.entities

import com.twitterclone.notification.domain.events.EventDispatcher
import com.twitterclone.notification.domain.exceptions.NotificationAlreadyReadException
import com.twitterclone.notification.domain.exceptions.NotificationAlreadySentException
import com.twitterclone.notification.domain.valueobjects.EmailRecipient
import com.twitterclone.notification.domain.valueobjects.EntityId
import com.twitterclone.notification.domain.valueobjects.Recipient
import com.twitterclone.notification.domain.valueobjects.StringContent
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import java.util.*

@SpringBootTest
class NotificationTest {
    class TestNotification(
        id: EntityId,
        sentAt: Date?,
        readAt: Date?,
        content: StringContent,
        recipient: Recipient,
        createdAt: Date = Date(),
        updatedAt: Date = Date(),
        dispatcher: EventDispatcher
    ) : Notification(id, sentAt, readAt, content, recipient, createdAt, updatedAt, dispatcher)

    private lateinit var notification: Notification

    @MockBean
    private lateinit var dispatcher: EventDispatcher

    @BeforeEach
    fun setup() {
        notification = TestNotification(
            EntityId(),
            null,
            null,
            StringContent("Test content"),
            EmailRecipient("example@mail.com"),
            dispatcher = dispatcher
        )
    }

    @Test
    fun testMarkAsSent() {
        val result = notification.markAsSent()
        assertTrue(result.isSuccess)
        assertNotNull(notification.sentAt)
    }

    @Test
    fun testMarkAsSentAlreadySent() {
        notification.markAsSent()
        val result = notification.markAsSent()
        assertTrue(result.isFailure)
        assertTrue(result.exceptionOrNull() is NotificationAlreadySentException)
    }

    @Test
    fun testMarkAsRead() {
        val result = notification.markAsRead()
        assertTrue(result.isSuccess)
        assertNotNull(notification.readAt)
    }

    @Test
    fun testMarkAsReadAlreadyRead() {
        notification.markAsRead()
        val result = notification.markAsRead()
        assertTrue(result.isFailure)
        assertTrue(result.exceptionOrNull() is NotificationAlreadyReadException)
    }
}
