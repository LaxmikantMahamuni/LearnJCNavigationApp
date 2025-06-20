package com.example.learnjcnavigationapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.learnjcnavigationapp.repository.TweetsyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(private val respository: TweetsyRepository) : ViewModel() {
    val categories: StateFlow<List<String>>
        get() = respository.categories

    init {
        viewModelScope.launch {
            respository.getCategories()
        }
    }
}