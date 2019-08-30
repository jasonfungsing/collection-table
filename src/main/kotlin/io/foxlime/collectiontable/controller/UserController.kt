package io.foxlime.collectiontable.controller

import io.foxlime.collectiontable.domain.User
import io.foxlime.collectiontable.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {

    @Autowired
    lateinit var userService: UserService

    @PostMapping
    fun createUser(): User {
        return userService.createUser()
    }

    @PutMapping("/{id}")
    fun updateUser(@PathVariable id: Long) {


        userService.updateUser(id)
    }

    @PutMapping("/complicate/{id}")
    fun updateUser_complicated(@PathVariable id: Long) {


        userService.updateUser_complicated(id)
    }
}