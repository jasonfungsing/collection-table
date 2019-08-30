package io.foxlime.collectiontable.service

import io.foxlime.collectiontable.domain.Permission
import io.foxlime.collectiontable.domain.User
import io.foxlime.collectiontable.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    lateinit var userRepository: UserRepository

    fun createUser(): User {
        val user: User = User()
        val permissionSet = mutableSetOf(Permission.CODE, Permission.EAT, Permission.SLEEP)
        user.permissions = permissionSet

        return userRepository.save(user)
    }

    fun updateUser(id: Long) {
        val userOptional = userRepository.findById(id)
        if (userOptional.isPresent) {
            val user = userOptional.get()
            val permissionSet = mutableSetOf<Permission>(Permission.CODE, Permission.EAT, Permission.COFFEE)
            user.permissions = permissionSet

            userRepository.save(user)
        }
    }

    fun updateUser_complicated(id: Long) {
        val userOptional = userRepository.findById(id)
        if (userOptional.isPresent) {
            val user = userOptional.get()
            user.permissions.remove(Permission.SLEEP)
            user.permissions.add(Permission.COFFEE)

            userRepository.save(user)
        }
    }
}