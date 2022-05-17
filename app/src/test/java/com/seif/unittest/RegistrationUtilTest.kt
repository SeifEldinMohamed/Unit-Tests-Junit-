package com.seif.unittest

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class RegistrationUtilTest(
   private val userName: String,
   private val password: String,
   private val confirmedPassword: String,
   private val scenario: String
){
    companion object{

        @JvmStatic
        @Parameterized.Parameters(name = "RegistrationTestOf: {3}")
        fun todos() = listOf(
            arrayOf("", "123", "123", "empty userName, ValidPassword, ConfirmedPassword"),
            arrayOf("Mohamed", "123", "123", "repeated userName, ValidPassword, ConfirmedPassword"),
            arrayOf("Seif", "", "", "Valid userName, Password empty, ConfirmedPassword"),
            arrayOf("Seif", " ", " ", "Valid userName, InvalidPassword, ConfirmedPassword"),
            arrayOf("Seif", "1234", "123", "Valid userName, ValidPassword, Wrong ConfirmedPassword"),
            // Registration is Valid
            //arrayOf("Seif", "123", "123", "Valid userName, ValidPassword, ConfirmedPassword")
        )
    }
    @Test
    fun `username is empty return false`(){ // `` is called backticks inside it we can but anything we want to be the name of the function (used only in tests, avoid it in real code)
        val actual = RegistrationUtil.validRegistrationInput(
            userName,
            password,
            confirmedPassword
        )
        assertThat(actual).isFalse() // equals to assertEquals(false, actual)

    }
}