package com.twitterclone.notification.domain.entities

import com.twitterclone.notification.domain.events.EventDispatcher
import com.twitterclone.notification.domain.valueobjects.EmailRecipient
import com.twitterclone.notification.domain.valueobjects.StringContent
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean

@SpringBootTest
class EmailNotificationFactoryTest {
    private lateinit var factory: EmailNotificationFactory

    @MockBean
    private lateinit var dispatcher: EventDispatcher

    @BeforeEach
    fun setup() {
        factory = EmailNotificationFactory(dispatcher)
    }

    @Test
    fun testCreateNotification() {
        val content = StringContent("Test content")
        val recipient = EmailRecipient("example@mail.com")

        val notification = factory.createNotification(content, recipient)

        assertTrue(notification is EmailNotification)
        assertEquals(content, notification.content)
        assertEquals(recipient, notification.recipient)
    }
}
