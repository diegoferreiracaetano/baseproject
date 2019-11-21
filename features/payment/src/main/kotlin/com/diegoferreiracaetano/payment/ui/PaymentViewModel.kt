package com.diegoferreiracaetano.payment.ui

import androidx.lifecycle.ViewModel
import com.diegoferreiracaetano.commons.asLiveData
import com.diegoferreiracaetano.domain.payment.Payment
import com.diegoferreiracaetano.domain.payment.SavePaymentInteractor
import com.diegoferreiracaetano.domain.user.FindContactsByIdInteractor

internal class PaymentViewModel(private val interactor: FindContactsByIdInteractor,
                                private val saveOrderInteractor: SavePaymentInteractor) : ViewModel() {

    fun user(id: Long) = interactor.execute(id).asLiveData()

    fun savePayment(payment: Payment) = saveOrderInteractor.execute(payment).asLiveData()
}
