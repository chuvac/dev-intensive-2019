package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val parts: List<String>? = fullName?.split(" ")
        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)
        return firstName to lastName
    }

    fun transliteration(payload: String, divider: String = " "): String {
        var engName: StringBuilder = java.lang.StringBuilder()
        for (char in payload){
            val isUp: Boolean = char.isUpperCase()
            var tempChar = when(char.toLowerCase().toString()) {
                "а" -> "a"
                "б" -> "b"
                "в" -> "v"
                "г" -> "g"
                "д" -> "d"
                "е" -> "e"
                "ё" -> "e"
                "ж" -> "zh"
                "з" -> "z"
                "и" -> "i"
                "й" -> "i"
                "к" -> "k"
                "л" -> "l"
                "м" -> "m"
                "н" -> "n"
                "о" -> "o"
                "п" -> "p"
                "р" -> "r"
                "с" -> "s"
                "т" -> "t"
                "у" -> "u"
                "ф" -> "f"
                "х" -> "h"
                "ц" -> "c"
                "ч" -> "ch"
                "ш" -> "sh"
                "щ" -> "sh'"
                "ъ" -> ""
                "ы" -> "i"
                "ь" -> ""
                "э" -> "e"
                "ю" -> "yu"
                "я" -> "ya"
                " " -> divider
                else -> char.toString()
            }

            if (isUp) {
                for (index in tempChar.indices) {
                    if (index == 0)
                        engName.append(tempChar[index].toUpperCase())
                    else engName.append(tempChar[index])
                }
            } else{
                engName.append(tempChar)
            }


        }
        return engName.toString()
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        var initials: String? = "${firstName?.first()}${lastName?.first()}".trim()
        if (initials == "") return null
        return initials
    }
}

