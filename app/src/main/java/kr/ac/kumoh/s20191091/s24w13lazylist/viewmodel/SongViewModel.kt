package kr.ac.kumoh.s20191091.s24w13lazylist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kr.ac.kumoh.s20191091.s24w13lazylist.model.Song

class SongViewModel : ViewModel() {
    private val _songs = MutableLiveData<List<Song>>()

    val songs: LiveData<List<Song>>
        get() = _songs

    fun add(song: Song) {
        val newList = listOf(*_songs.value?.toTypedArray() ?: arrayOf(), song)
        //스프레드 연산자
        _songs.value = newList
    }
}