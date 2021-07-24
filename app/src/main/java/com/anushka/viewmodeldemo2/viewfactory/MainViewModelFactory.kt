package com.anushka.viewmodeldemo2.viewfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.anushka.viewmodeldemo2.viewmodel.MainViewModel
import java.lang.IllegalArgumentException

//viewModel에 생성자를 만들기 위해서는 viewModel의 Factory 인터페이스가 필요합니다.
//이렇게 생성해두면 추후에 매개변수만 변경하면서 쉽게 재사용이 가능합니다.
class MainViewModelFactory(private val starTingTotal : Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(starTingTotal) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}