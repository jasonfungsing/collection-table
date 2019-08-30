package io.foxlime.collectiontable.domain

import javax.persistence.*

@Entity
class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    @ElementCollection
    @CollectionTable(name = "permission", joinColumns = [JoinColumn(name = "user_id", referencedColumnName = "id")])
    @Column(name = "permission", nullable = false)
    @Enumerated(EnumType.STRING)
    lateinit var permissions: MutableSet<Permission>

}