package org.polihania.harrypotter.core.utils

inline fun <T> T?.ifNotNull(action: (T) -> Unit) {
    if (this != null) action(this)
}

inline fun <reified T : Number> T?.orZero(): T = when (T::class) {
    Double::class -> (this ?: 0.0) as T
    Float::class -> (this ?: 0f) as T
    Long::class -> (this ?: 0L) as T
    Int::class -> (this ?: 0) as T
    Short::class -> (this ?: 0.toShort()) as T
    Byte::class -> (this ?: 0.toByte()) as T
    else -> throw IllegalArgumentException("Unsupported numeric type: ${T::class}")
}
