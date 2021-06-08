package ru.vsibi.presentation.screens.hotels.info

import ru.vsibi.presentation.screens.hotels.main.HotelsModel

sealed class HotelsInfoEvent {
    class ConfigureArgs(val data: HotelsModel) : HotelsInfoEvent()
}
