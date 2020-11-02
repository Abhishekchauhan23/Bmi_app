package ab.sample.bottom_nav2.RoomComponents

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application):AndroidViewModel(application) {
//    <LiveData<User>>
    val readAllData:LiveData<List<User>>
    private val repositry:UserRepositry
    init {
        val userDao=UserDatabase.getDatabase(application).userDao()
        repositry= UserRepositry(userDao)
        readAllData=repositry.readAllData
    }

    fun addUser(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            repositry.addUser(user)
        }
    }
}