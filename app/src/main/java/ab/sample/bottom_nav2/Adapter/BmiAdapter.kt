package ab.sample.bottom_nav2.Adapter

import ab.sample.bottom_nav2.R
import ab.sample.bottom_nav2.RoomComponents.User
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import kotlinx.android.synthetic.main.adapter_layout.view.*
import kotlinx.android.synthetic.main.fragment_first.view.*

class BmiAdapter:RecyclerView.Adapter<BmiAdapter.Viewholder>() {
    private var userList= emptyList<User>()
    class Viewholder(itemView: View):RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
       return Viewholder(LayoutInflater.from(parent.context).inflate(R.layout.adapter_layout,parent,false))
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        val currentItem=userList[position]
        holder.itemView.Date_textView.text=currentItem.id.toString()
        holder.itemView.Bmi_textView.text=currentItem.ResultAdd.toString()

    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun setData(user: List<User>){
        this.userList=user
        notifyDataSetChanged()
    }
}