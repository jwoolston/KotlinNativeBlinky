/*
 * Copyright 2010-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the license/LICENSE.txt file.
 */

import platform.zephyr.stm32f4_disco.*

val port = LED0_GPIO_CONTROLLER

@ExperimentalUnsignedTypes
val led0 = 12.toUInt()
@ExperimentalUnsignedTypes
val led1 = 13.toUInt()
@ExperimentalUnsignedTypes
val led2 = 14.toUInt()
@ExperimentalUnsignedTypes
val led3 = 15.toUInt()

val dev = device_get_binding(port)
var count = 0

@kotlin.ExperimentalUnsignedTypes
fun blinky(value: Int) {

    gpio_pin_configure(dev, led0, GPIO_DIR_OUT)
    gpio_pin_configure(dev, led1, GPIO_DIR_OUT)
    gpio_pin_configure(dev, led2, GPIO_DIR_OUT)
    gpio_pin_configure(dev, led3, GPIO_DIR_OUT)

    while (true) {
        /* Increment the light bar every 0.5 seconds */
        when (count) {
            0 -> gpio_pin_write(dev, led0, 1.toUInt())
            1 -> gpio_pin_write(dev, led1, 1.toUInt())
            2 -> gpio_pin_write(dev, led2, 1.toUInt())
            3 -> gpio_pin_write(dev, led3, 1.toUInt())
            4 -> allOff()
        }

        count++
        if (count > 4) {
            count = 0
        }
        k_sleep(100 * value)
    }
}

@ExperimentalUnsignedTypes
fun allOff() {
    gpio_pin_write(dev, led0, 0.toUInt())
    gpio_pin_write(dev, led1, 0.toUInt())
    gpio_pin_write(dev, led2, 0.toUInt())
    gpio_pin_write(dev, led3, 0.toUInt())
    count
}

@ExperimentalUnsignedTypes
fun main() {
    println("Hello, world (Kotlin)!")
    blinky(5)
}
