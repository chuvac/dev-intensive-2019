package ru.skillbranch.devintensive.extensions

fun String.truncate(size: Int = 16): String {
    var str = this.trim()
    if (str.length > size) {
        return str.substring(0 until size).trim().plus("...")
    }
    return str
}

fun String.stripHtml(): String {
    return this.replace("<.+?>".toRegex(), "").replace("""&[^А-я ]+?;""".toRegex(), "").replace("[ ]+".toRegex(), " ")
}