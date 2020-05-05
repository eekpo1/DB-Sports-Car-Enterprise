package edu.csub.service

interface UserCreationService {
    fun create(user: Any, password: String);
}