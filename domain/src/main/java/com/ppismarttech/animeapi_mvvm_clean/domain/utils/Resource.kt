package com.ppismarttech.animeapi_mvvm_clean.domain.utils

data class Resource<out T>(
    val data: T,
    val isAunthenticated:Boolean,
    val code:Int
)