package com.example.databinding

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {
    val firstName = MutableLiveData("")
    val lastName = MutableLiveData("")

    // combine both first and last name MutableLiveData in the view model!
    val fullName: MediatorLiveData<String> =
        MediatorLiveData<String>().apply {
            addSource(firstName) {
                value = "$it ${lastName.value}"
            }
            addSource(lastName) {
                value = "${firstName.value} $it"
            }
        }
}