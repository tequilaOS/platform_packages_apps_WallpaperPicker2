/*
 * Copyright 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.wallpaper.model.wallpaper

import android.graphics.Rect
import com.android.wallpaper.asset.Asset

/** Represents set of attributes that are needed for a static wallpaper. */
data class StaticWallpaperData(
    val asset: Asset,
    val cropHints: Map<ScreenOrientation, Rect>? = null,
)
