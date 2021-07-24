package com.anushka.viewmodeldemo2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(starTingTotal : Int) : ViewModel() {
    private var sum  = MutableLiveData<Int>() // 입출력등이 가능한 LiveData 변수생성.
    val totalData : LiveData<Int> // MutableLiveData를 캡슐화 하기위하여 LiveData를 사용하였습니다.
    get() = sum

    //viewModel 에서 init으로 생성자를 만들어준 이후,ViewModelFactory에서 추가 작업이 이루어져야 컴파일시 오류가 생기지 않으며,
    //MainActivity에 있는 viewModel 객체가 정상적으로 생성되어 집니다.
    init {
        sum.value  = starTingTotal
    }

    fun setSum(number: String) : Unit {
        sum.value = (sum.value)?.plus(number.toIntOrNull() ?: 0)
    }
}