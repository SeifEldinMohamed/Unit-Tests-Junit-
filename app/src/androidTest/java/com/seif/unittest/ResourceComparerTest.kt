package com.seif.unittest

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test

class ResourceComparerTest {
    //  val resourceComparer =  ResourceComparer()   bad practice to init this object global bec as we know each test case must be independent from each other
    private lateinit var resourceComparer: ResourceComparer

    @Before
    fun setUp() { // will run before each test case
        resourceComparer = ResourceComparer()
    }

    @After
    fun tearUp() { // will run after each test case and used for end or reset objects

    }

    @Test
    fun stringResourceSameAsGivenString_returnsTrue() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val actual = resourceComparer.isEqual(context, R.string.app_name, "Unit Test")
        assertThat(actual).isTrue()
    }

    @Test
    fun stringResourceDifferentFromGivenString_returnsFalse() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val actual = resourceComparer.isEqual(context, R.string.app_name, "seif")
        assertThat(actual).isFalse()
    }
}