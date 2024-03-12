package utils

import kotlin.math.PI

fun getPercentageOff(amount: Int, percentage: Float): Int = (amount * (1 - percentage / 100)).toInt()

fun toRadians(deg: Double): Double = deg / 180.0 * PI

fun toDegrees(rad: Double): Double = rad * 180.0 / PI
