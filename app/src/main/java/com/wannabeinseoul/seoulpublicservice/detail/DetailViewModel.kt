package com.wannabeinseoul.seoulpublicservice.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.wannabeinseoul.seoulpublicservice.SeoulPublicServiceApplication
import com.wannabeinseoul.seoulpublicservice.databases.ReservationEntity
import com.wannabeinseoul.seoulpublicservice.databases.ReservationRepository
import com.wannabeinseoul.seoulpublicservice.databases.firebase.ReviewRepository
import com.wannabeinseoul.seoulpublicservice.databases.firebase.ServiceRepository
import com.wannabeinseoul.seoulpublicservice.databases.firebase.UserRepository
import com.wannabeinseoul.seoulpublicservice.dialog.review.ReviewItem
import com.wannabeinseoul.seoulpublicservice.pref.IdPrefRepository
import com.wannabeinseoul.seoulpublicservice.pref.SavedPrefRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class DetailViewModel(
    private val reservationRepository: ReservationRepository,
    private val idPrefRepository: IdPrefRepository,
    private val reviewRepository: ReviewRepository,
    private val userRepository: UserRepository,
    private val serviceRepository: ServiceRepository,
    private val savedPrefRepository: SavedPrefRepository
) : ViewModel() {
    private var _serviceData = MutableLiveData<ReservationEntity>()
    val serviceData: LiveData<ReservationEntity> get() = _serviceData

    // 닫기 이벤트
    private var _closeEvent = MutableLiveData<Boolean>()
    val closeEvent: LiveData<Boolean> get() = _closeEvent

    private val _myLocationCallback = MutableLiveData<Boolean>()
    val myLocationCallback:LiveData<Boolean> get() = _myLocationCallback

    private var _textState = MutableLiveData<Boolean>()
    val textState: LiveData<Boolean> get() = _textState

    private var _reviewUiState: MutableLiveData<List<ReviewItem>> = MutableLiveData()
    val reviewUiState: LiveData<List<ReviewItem>> get() = _reviewUiState

    private var _savedID: MutableLiveData<Boolean> = MutableLiveData()
    val savedID: LiveData<Boolean> get() = _savedID

    private var _favoriteChanged: MutableLiveData<Boolean> = MutableLiveData()
    val favoriteChanged: LiveData<Boolean> get() = _favoriteChanged

    fun getData(svcID: String) {
        viewModelScope.launch{
            val result = viewModelScope.async(Dispatchers.IO) {
                reservationRepository.getService(svcID)
            }.await()
            result.let {
                _serviceData.value = result
            }
        }
    }

    fun close(event: Boolean) {
        _closeEvent.value = event
    }

    fun myLocationCallbackEvent(event: Boolean) {
        _myLocationCallback.value = event
    }

    fun textOpened(event: Boolean) {
        _textState.value = event
    }

    fun savedID(id: String) {
        _savedID.value = savedPrefRepository.contains(id)
    }

    fun changeFavorite(id: String) {
        if(savedPrefRepository.contains(id)) {
            savedPrefRepository.remove(id)
            _favoriteChanged.value = false
        } else {
            savedPrefRepository.addSvcid(id)
            _favoriteChanged.value = true
        }
    }

    fun setReviews(svcId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val data = serviceRepository.getServiceReviews(svcId)

            _reviewUiState.postValue(data)
        }
    }

    fun close() {
        _savedID = MutableLiveData()
        _favoriteChanged = MutableLiveData()
        _textState = MutableLiveData()
        _reviewUiState = MutableLiveData()
        _closeEvent = MutableLiveData()
        _serviceData = MutableLiveData()
    }

    companion object {
        val factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as SeoulPublicServiceApplication)
                val container = application.container
                DetailViewModel(
                    reservationRepository = container.reservationRepository,
                    idPrefRepository = container.idPrefRepository,
                    reviewRepository = container.reviewRepository,
                    userRepository = container.userRepository,
                    serviceRepository = container.serviceRepository,
                    savedPrefRepository = container.savedPrefRepository
                )
            }
        }
    }
}