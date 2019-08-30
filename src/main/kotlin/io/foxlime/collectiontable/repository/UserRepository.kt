package io.foxlime.collectiontable.repository

import io.foxlime.collectiontable.domain.User
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : PagingAndSortingRepository<User, Long> {
}