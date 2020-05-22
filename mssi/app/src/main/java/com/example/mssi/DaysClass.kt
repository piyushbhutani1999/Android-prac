package com.example.mssi

import java.time.LocalDateTime
import java.util.*

class DaysClass (
    var date:Date,
    var isDietTaken:Boolean = true,
    var extraItemsList : List<String> = mutableListOf<String>()
)