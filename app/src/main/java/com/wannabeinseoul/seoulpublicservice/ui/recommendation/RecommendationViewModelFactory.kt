package com.wannabeinseoul.seoulpublicservice.ui.recommendation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.wannabeinseoul.seoulpublicservice.databases.ReservationDAO
import com.wannabeinseoul.seoulpublicservice.databases.ReservationRepository
import com.wannabeinseoul.seoulpublicservice.pref.RecommendPrefRepository
import com.wannabeinseoul.seoulpublicservice.usecase.GetAll2000UseCase


//class RecommendationViewModelFactory(
//    private val reservationRepository: ReservationRepository,
//    private val recommendPrefRepository: RecommendPrefRepository,
//    private val reservationDAO: ReservationDAO,
//    private val getAll2000UseCase: GetAll2000UseCase
//) : ViewModelProvider.Factory {
//    @Suppress("UNCHECKED_CAST")
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(RecommendationViewModel::class.java)) {
//            return RecommendationViewModel(reservationRepository,
//                recommendPrefRepository,
//                reservationDAO,
//                getAll2000UseCase
//            ) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")
//    }
//}