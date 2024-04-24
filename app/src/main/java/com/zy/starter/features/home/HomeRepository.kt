package com.zy.starter.features.home

import com.zy.starter.features.wanandroid.Banner
import com.zy.starter.network.ApiResult
import com.zy.starter.network.base.BaseResponse

class HomeRepository(val vm: HomeViewModel) {
    fun getBanner(): ApiResult<BaseResponse<List<Banner>>> {
        return ApiResult.Error(Exception("error"))
    }
}