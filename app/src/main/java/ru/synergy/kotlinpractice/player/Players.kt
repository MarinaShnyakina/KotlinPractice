package ru.synergy.kotlinpractice.player

import android.provider.MediaStore

// ПРАВИЛА ПЕРЕОПРЕДЕЛЕНИЯ

/*
open class Video {
    open fun play() {
        print("Play video")
    }
}

interface AudioPlayer {
    fun play() {
        print("Play audio")
    }
}

class MediaPlayer(): Video(), AudioPlayer {
    override fun play() {
        super<Video>.play()
        super<AudioPlayer>.play()
    }
}

 */