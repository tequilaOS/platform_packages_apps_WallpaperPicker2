/*
 * Copyright (C) 2021 The Android Open Source Project
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
package com.android.wallpaper.module

import android.app.WallpaperManager
import android.util.Log
import com.android.wallpaper.compat.WallpaperManagerCompat
import java.io.IOException

/** Default implementation of [WallpaperStatusChecker]. */
class DefaultWallpaperStatusChecker(
    private val wallpaperManager: WallpaperManager,
    private val wallpaperManagerCompat: WallpaperManagerCompat,
) : WallpaperStatusChecker {
    override fun isHomeStaticWallpaperSet(): Boolean {
        val systemWallpaperFile =
            wallpaperManagerCompat.getWallpaperFile(WallpaperManagerCompat.FLAG_SYSTEM)
        return if (systemWallpaperFile != null) {
            try {
                systemWallpaperFile.close()
            } catch (e: IOException) {
                Log.e(TAG, "Unable to close system wallpaper ParcelFileDescriptor", e)
            }
            true
        } else {
            false
        }
    }

    override fun isLockWallpaperSet(): Boolean {
        return wallpaperManager.getWallpaperId(WallpaperManager.FLAG_LOCK) > 0
    }

    companion object {
        private const val TAG = "DefaultWallpaperStatusChecker"
    }
}
