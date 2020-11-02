package ab.sample.bottom_nav2.RoomComponents

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User (
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val ResultAdd:String
)