package ai.tock.bot.connector.hangoutschat

import ai.tock.bot.connector.ConnectorMessage
import ai.tock.bot.connector.ConnectorType
import ai.tock.bot.connector.hangoutschat.builder.hangoutsChatConnectorType
import com.fasterxml.jackson.annotation.JsonIgnore


abstract class HangoutsChatConnectorMessage : ConnectorMessage {

    override val connectorType: ConnectorType @JsonIgnore get() = hangoutsChatConnectorType

}
