package com.example.seoulpublicservice.ui.notifications

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.seoulpublicservice.SeoulPublicServiceApplication
import com.example.seoulpublicservice.seoul.Row
import com.example.seoulpublicservice.usecase.GetAllFirst1000UseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.random.Random

class NotificationsViewModel(
    private val getAllFirst1000UseCase: GetAllFirst1000UseCase
) : ViewModel() {

    private val _text: MutableLiveData<String> =
        MutableLiveData("_text 라이브데이터 초기값 ㅁㄴㅇㄹㅁㄴㅇㄹ")
    val text: LiveData<String> = _text

    private var rowList: List<Row>? = null
    private val random = Random

    fun setRandomOne() {
        if (rowList.isNullOrEmpty()) viewModelScope.launch(Dispatchers.IO) {
            rowList = getAllFirst1000UseCase()
            val row = rowList!!.firstOrNull()
            if (row == null) {
                _text.postValue("rowList.size: ${rowList!!.size}\n\nrowList empty")
                Log.w("jj-노티뷰모델", "rowList is empty")
            } else {
                _text.postValue("rowList.size: ${rowList!!.size}\n\n$row")
                Log.d("jj-노티뷰모델", "id: ${row.svcid}")
            }
        }
        else {
            val row = rowList!![random.nextInt(0, rowList!!.size)]
            _text.postValue("rowList.size: ${rowList!!.size}\n\n$row")
            Log.d("jj-노티뷰모델", "id: ${row.svcid}")
        }
    }

    companion object {
        /** Factory for [NotificationsViewModel] that takes [GetAllFirst1000UseCase] as a dependency*/
        val factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as SeoulPublicServiceApplication)
                val getAllFirst1000UseCase = application.container.getAllFirst1000UseCase
                NotificationsViewModel(getAllFirst1000UseCase = getAllFirst1000UseCase)
            }
        }
    }

}
