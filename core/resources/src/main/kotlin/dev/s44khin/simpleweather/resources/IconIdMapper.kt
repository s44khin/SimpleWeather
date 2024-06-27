package dev.s44khin.simpleweather.resources

fun rawfromIconId(iconId: String) = when (iconId) {
    "01d" -> CoreRaw.ic_01d
    "01n" -> CoreRaw.ic_01n

    "02d" -> CoreRaw.ic_02d
    "02n" -> CoreRaw.ic_02n

    "03d" -> CoreRaw.ic_03d
    "03n" -> CoreRaw.ic_03n

    "04d" -> CoreRaw.ic_04d
    "04n" -> CoreRaw.ic_04n

    "09d" -> CoreRaw.ic_09d
    "09n" -> CoreRaw.ic_09n

    "10d" -> CoreRaw.ic_10d
    "10n" -> CoreRaw.ic_10n

    "11d" -> CoreRaw.ic_11d
    "11n" -> CoreRaw.ic_11n

    "13d" -> CoreRaw.ic_13d
    "13n" -> CoreRaw.ic_13n

    "50d" -> CoreRaw.ic_50d
    "50n" -> CoreRaw.ic_50n

    else -> CoreRaw.ic_01d
}