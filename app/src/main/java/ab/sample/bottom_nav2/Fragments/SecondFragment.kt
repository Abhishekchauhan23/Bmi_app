package ab.sample.bottom_nav2.Fragments
import ab.sample.bottom_nav2.Adapter.BmiAdapter
import ab.sample.bottom_nav2.R
import ab.sample.bottom_nav2.RoomComponents.UserViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_second.view.*

class SecondFragment : Fragment(R.layout.fragment_second) {
    private lateinit var mUserViewModel: UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val secondFragmentView = inflater.inflate(R.layout.fragment_second,
            container, false)

        //Recyclerview
       val adapter= BmiAdapter()
        val recyclerView=secondFragmentView.recyclerview
        recyclerView.adapter=adapter
        recyclerView.layoutManager= LinearLayoutManager(requireContext())

        //UserViewModel
        mUserViewModel= ViewModelProvider(this).get(UserViewModel::class.java)
        mUserViewModel.readAllData.observe(viewLifecycleOwner, Observer {
            adapter.setData(it)
        })

        return secondFragmentView
    }
}