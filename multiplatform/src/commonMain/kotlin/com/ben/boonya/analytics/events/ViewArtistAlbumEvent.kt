package com.ben.boonya.analytics.events

import com.ben.boonya.analytics.AnalyticEvent

class ViewArtistAlbumEvent() : AnalyticEvent {
    override val eventName: String
        get() = "view_artist_album_event"
    override val eventProperties: Map<String, Any>?
        get() = null
}