package com.dave.kmpstudy.android.di

import com.dave.kmpstudy.android.viewmodel.LoginViewModel
import com.dave.kmpstudy.android.viewmodel.UserListViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

fun viewModelModule() = module {
    viewModel { LoginViewModel(get()) }
    viewModel { UserListViewModel(get()) }
}