package ai.tock.bot.connector.hangoutschat
/*
 * Copyright (C) 2017/2020 e-voyageurs technologies
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import ai.tock.bot.connector.hangoutschat.builder.ChatCard
import ai.tock.bot.connector.hangoutschat.builder.ChatSection
import ai.tock.bot.connector.hangoutschat.builder.toCardMessage
import ai.tock.bot.engine.message.GenericElement
import ai.tock.bot.engine.message.GenericMessage
import com.google.api.services.chat.v1.model.Message

data class HangoutsChatConnectorCardMessageOut(val card: ChatCard) : HangoutsChatConnectorMessage() {
    override fun toGoogleMessage(): Message = card.toCardMessage()

    override fun toGenericMessage(): GenericMessage? {
        return GenericMessage(this, subElements = card.children.filterIsInstance(ChatSection::class.java).map {
            GenericElement()
        })
    }
}