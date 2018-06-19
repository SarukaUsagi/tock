/*
 * Copyright (C) 2017 VSCT
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package fr.vsct.tock.shared

/**
 * Extract a namespace from a qualified name (ie namespace:name).
 */
fun String.namespace(): String = namespaceAndName().first

/**
 * Extract a name from a qualified name (ie namespace:name).
 */
fun String.name(): String = namespaceAndName().second

/**
 * Extract namespace and name from a qualified name (ie namespace:name).
 */
fun String.namespaceAndName(): Pair<String, String> = this.split(":").let { it[0] to it[1] }

/**
 * Add the specified namespace to a name if the name does not contains yet a namespace,
 * and return the result.
 */
fun String.withNamespace(namespace: String): String = if (contains(":")) this else "$namespace:$this"

/**
 * Remove the specified namespace from a qualified name if this qualified name contains the namespace,
 * and return the result.
 */
fun String.withoutNamespace(namespace: String? = null): String =
    if (contains(":")) namespace().let { if (namespace == null || it == namespace) name() else this }
    else this

internal fun String.endWithPunctuation(): Boolean =
    endsWith(".") || endsWith("!") || endsWith("?") || endsWith(",") || endsWith(";") || endsWith(":")

/**
 * Concat two strings and manage intermediate punctuation.
 */
fun concat(s1: String?, s2: String?): String {
    val s = s1?.trim() ?: ""
    return s + (if (s.isEmpty() || s.endWithPunctuation()) " " else ". ") + (s2?.trim() ?: "")
}