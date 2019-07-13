package com.ben.boonya.analytics

interface AnalyticEvent {

    val eventName: String

    val eventProperties: Map<String, Any>?
}