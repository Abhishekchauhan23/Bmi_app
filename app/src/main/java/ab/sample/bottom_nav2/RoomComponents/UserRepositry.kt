package ab.sample.bottom_nav2.RoomComponents

import androidx.lifecycle.LiveData

class UserRepositry(private val userDao: UserDao) {
    val readAllData:LiveData<List<User>> =userDao.readAllData()

   suspend fun addUser(user: User){
       userDao.addUser(user)

    }
}