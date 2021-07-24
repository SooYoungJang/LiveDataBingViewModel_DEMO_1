package com.anushka.viewmodeldemo2.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.anushka.viewmodeldemo2.R
import com.anushka.viewmodeldemo2.databinding.ActivityMainBinding
import com.anushka.viewmodeldemo2.viewfactory.MainViewModelFactory
import com.anushka.viewmodeldemo2.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var viewModelFactory: MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main) //MainActivity의 바인딩 생성
        viewModelFactory = MainViewModelFactory(100) // ViewModel에서 생성자로서 값을 가지기위해서는 Factory가 필요합니다.
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java) //MainActivity의 ViewModel textView의 초기값을 주기 위하여 factory 를 사용하여 생성자를 주었습니다.

        //LiveData를 사용하여 MainViewModel에 있는 totalData를 항시 observing하고 있습니다.
        viewModel.totalData.observe(this, Observer {
            binding.textView.text = it.toString()
        })

        binding.button.setOnClickListener {
            viewModel.setSum(binding.editText.text.toString())
        }

    }
}