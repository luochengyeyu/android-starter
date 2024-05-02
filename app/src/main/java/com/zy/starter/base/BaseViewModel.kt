package com.zy.starter.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<State : UiState, Event : UiEvent, Effect : UiEffect> : ViewModel() {

    /**
     * 初始状态
     * stateFlow必须有初始值
     */
    private val initialState: State by lazy { createInitialState() }
    abstract fun createInitialState(): State

    /**
     * uiState聚合页面的全部UI 状态
     */
    private val _uiState: MutableStateFlow<State> = MutableStateFlow(initialState)
    val uiState = _uiState.asStateFlow()


    /**
     * event包含用户与ui的交互（如点击操作），也有来自后台的消息（如切换自习模式）
     */
    private val _event: MutableSharedFlow<Event> = MutableSharedFlow()
    private val event = _event.asSharedFlow()


    /**
     * effect用作 事件带来的副作用，通常是 一次性事件 且 一对一的订阅关系
     * 例如：弹Toast、导航Fragment等
     */
    private val _effect: Channel<Effect> = Channel()
    val effect = _effect.receiveAsFlow()

    init {
        subscribeEvents()
    }

    private fun subscribeEvents() {
        viewModelScope.launch {
            event.collect {
                handleEvent(it)
            }
        }
    }

    protected abstract fun handleEvent(event: Event)

    fun sendEvent(event: Event) {
        viewModelScope.launch {
            _event.emit(event)
        }
    }

    protected fun setState(reduce: State.() -> State) {
        val newState = _uiState.value.reduce()
        _uiState.value = newState
    }

    protected fun setEffect(builder: () -> Effect) {
        val newEffect = builder()
        viewModelScope.launch {
            _effect.send(newEffect)
        }
    }
}


interface UiState

interface UiEvent

interface UiEffect