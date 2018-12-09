/*
 * Copyright 2010-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the license/LICENSE.txt file.
 */

import platform.zephyr.stm32f4_disco.*
import kotlinx.cinterop.*

@kotlin.ExperimentalUnsignedTypes
fun blinky(value: Int) {

    val port = LED0_GPIO_CONTROLLER
    val led = LED0_GPIO_PIN.toUInt()
    var toggler = false
    val dev = device_get_binding(port)

    gpio_pin_configure(dev, led, GPIO_DIR_OUT)

    while (true) {
         /* Set pin to HIGH/LOW every 1 second */
         gpio_pin_write(dev, led, if (toggler) 1.toUInt() else 0.toUInt())
         toggler = !toggler
         k_sleep(1000 * value)
   }
}

fun main() {
    printk("Hello, World! (printk)")
    println("Hello again, println()")
    blinky(1)
}
