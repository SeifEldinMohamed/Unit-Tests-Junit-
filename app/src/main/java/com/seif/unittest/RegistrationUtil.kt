package com.seif.unittest


/**
 * the input is not valid when:
 * ... userName/password is empty
 * ... userName is repeated
 * ... password is less than 3 char
 * ... confirmed password is not the same as real password
 */
val existingList = listOf("Ahmed","Mohamed")

object RegistrationUtil {

    fun validRegistrationInput(
        userName: String,
        password: String,
        confirmedPassword: String
    ):Boolean{
        if(userName.isEmpty() || password.isEmpty())
            return false
        else if (existingList.contains(userName))
            return false
        else if (password.length<3)
            return false
        else return password == confirmedPassword

    }
}