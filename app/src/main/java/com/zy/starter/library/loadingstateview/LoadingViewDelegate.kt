/*
 * Copyright (c) 2019. Dylan Cai
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.zy.starter.library.loadingstateview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dylanc.loadingstateview.LoadingStateView
import com.dylanc.loadingstateview.ViewType
import com.zy.starter.R

/**
 * @author Dylan Cai
 */
class LoadingViewDelegate : LoadingStateView.ViewDelegate(ViewType.LOADING) {

  override fun onCreateView(inflater: LayoutInflater, parent: ViewGroup): View =
    inflater.inflate(R.layout.layout_loading, parent, false)
}