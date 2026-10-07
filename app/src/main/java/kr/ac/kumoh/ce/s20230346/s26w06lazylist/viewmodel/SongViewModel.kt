package kr.ac.kumoh.ce.s20230346.s26w06lazylist.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kr.ac.kumoh.ce.s20230346.s26w06lazylist.model.Song

class SongViewModel : ViewModel() {
    private val _songs = MutableStateFlow<List<Song>>(emptyList())
    val songs = _songs.asStateFlow()
//    val songs: StateFlow<List<Song>> = _songs.asStateFlow()

    init {
        var id = 1

        repeat(30) { index ->
            add(Song(id++, "Neon Horizon $index", "Pixel Wave"))
            add(Song(id++, "Midnight Coffee $index", "The Afterhours"))
            add(Song(id++, "Gravity Reset $index", "Lunarcat"))
        }
    }

    fun add(song: Song) {
        // 새로운 리스트를 만들고 song 추가
        // Shallow copy
        _songs.update { it + song }
    }

//    fun add(song: Song) {
//        // update() 함수를 사용하여 여러 Thread로부터 요청이 한꺼번에 몰릴 때도 안전하게 변경
//        // update()는 현재 값을 인자로 받아 새로운 값 반환
//        _songs.update { currentList ->
//            currentList + song
//        }
//    }
}