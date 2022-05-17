package com.seif.unittest

import android.content.Context

class ResourceComparer {
    fun isEqual(context: Context, resId:Int, string: String):Boolean{
        return context.resources.getString(resId) == string
    }
}