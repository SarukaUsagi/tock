package ai.tock.bot.connector.hangoutschat

import ai.tock.bot.connector.ConnectorMessage
import ai.tock.bot.connector.ConnectorType
import ai.tock.bot.connector.hangoutschat.builder.hangoutsChatConnectorType
import com.fasterxml.jackson.annotation.JsonIgnore
import com.google.api.services.chat.v1.model.Message


abstract class HangoutsChatConnectorMessage : ConnectorMessage {

    override val connectorType: ConnectorType @JsonIgnore get() = hangoutsChatConnectorType

    abstract fun toGoogleMessage(): Message

}
