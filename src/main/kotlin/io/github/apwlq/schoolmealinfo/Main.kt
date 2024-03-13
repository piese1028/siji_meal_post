package io.github.apwlq.schoolmealinfo

/*
 * @author Bruce0203, apwlq
 * @license MIT License
 */

import io.github.apwlq.schoolmealinfo.*
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    publish()
}

fun publish() {
    println("publishing...")
    val client = login()
    client.actions()
        .timeline()
        .uploadPhoto(genTimelineImage("${getLunch()}"),"${getNowDate()} 급식")
        .thenAccept {
            println(
                """
                    --------------------------
                   "Successfully uploaded timeline!" 
                    --------------------------
                """.trimIndent()
            )
        }
        .join() // block current thread until complete
}

