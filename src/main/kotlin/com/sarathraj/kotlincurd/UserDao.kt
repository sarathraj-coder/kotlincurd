package com.sarathraj.kotlincurd

import java.util.concurrent.atomic.AtomicInteger

/**
 * Created by sarathraj on 28/05/17.
 */

class UserDao {

    val users = hashMapOf(
            0 to User(name = "saarath", email = "sarathraj@sample.com", id = 0),
            1 to User(name = "raju", email = "raju@braju.com", id = 1),
            2 to User(name = "rim", email = "ram@ram.com", id = 2),
            3 to User(name = "dev", email = "dev@dev.com", id = 3),
            4 to User(name = "kin", email = "kin@kin.com", id = 3)
    )

    var lastId: AtomicInteger = AtomicInteger(users.size - 1)

    fun save(name: String, email: String) {
        val id = lastId.incrementAndGet()
        users.put(id, User(name = name, email = email, id = id))
    }

    fun findById(id: Int): User? {
        return users[id]
    }

    fun findByEmail(email: String): User? {
        return users.values.find { it.email == email }
    }

    fun update(id: Int, name: String, email: String) {
        users.put(id, User(name = name, email = email, id = id))
    }

    fun delete(id: Int) {
        users.remove(id)
    }

}
