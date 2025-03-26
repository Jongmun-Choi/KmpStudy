package com.dave.kmpstudy.android.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dave.kmpstudy.data.model.User
import com.dave.kmpstudy.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class UserListViewModel(
    private val repository: UserRepository
): ViewModel() {

    //MutableStateFlow
    private val _userList = MutableStateFlow<MutableList<User>>(mutableListOf())
    val userList : StateFlow<List<User>> = _userList.asStateFlow()
    private var pageCount = 1


    fun getUserList(query: String, reset : Boolean = false) {

        if(reset) {
            pageCount = 0
            _userList.value = mutableListOf()
        }
        viewModelScope.launch {
            try {
                val userList = _userList.value.toMutableList()
                userList.addAll(repository.searchUserList(query, pageCount).users)
                _userList.emit(userList)
                pageCount++
            }catch (e : Exception) {

            }
        }

    }

}