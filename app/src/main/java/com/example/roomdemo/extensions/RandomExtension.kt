package com.example.roomdemo.extensions

import java.util.*

/**
 * Created by uzafar
 * on 03 Feb, 2019
 * at 11:14 AM
 * as part of Saal For Education Android Application
 * usama@saal.ai
 * www.saal.ai
 */

fun ClosedRange<Int>.random() =
    Random().nextInt((endInclusive + 1) - start) + start