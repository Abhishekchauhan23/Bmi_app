package ab.sample.bottom_nav2.Fragments

import ab.sample.bottom_nav2.R
import ab.sample.bottom_nav2.RoomComponents.User
import ab.sample.bottom_nav2.RoomComponents.UserViewModel
import ab.sample.bottom_nav2.Utils.BmiCalculator
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_first.*



class FirstFragment : Fragment(R.layout.fragment_first) {
    var Weight:Double=0.0
    var Height:Double=0.0
    var FootValueLocal:Double=0.0
    var InchValueLocal:Double=0.0
    var BmiValue:Double=0.0
    lateinit var SecondView:View

    private lateinit var VerdictTv:TextView
    private lateinit var mUserViewModel:UserViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val firstFragmentView = inflater?.inflate(R.layout.fragment_first, container, false)

            mUserViewModel=ViewModelProvider(this).get(UserViewModel::class.java)


        // Textview
        val BmiTextView:TextView=firstFragmentView.findViewById(R.id.BmiOutputTextView)
        VerdictTv=firstFragmentView.findViewById(R.id.VerdicttextView)
         SecondView=firstFragmentView.findViewById(R.id.SecondView)
        // View


         //EditText
        val Value_Foot:EditText=firstFragmentView.findViewById(R.id.FootET)
        val Value_Inch:EditText=firstFragmentView.findViewById(R.id.InchET)
        val Value_Cm:EditText=firstFragmentView.findViewById(R.id.CmET)
        val Value_Kg:EditText=firstFragmentView.findViewById(R.id.KgET)
        val Value_Pounds:EditText=firstFragmentView.findViewById(R.id.PoundET)

        // Buttons Are Here
        val Feet_InchButton:Button=firstFragmentView.findViewById(R.id.Feet_InchButton)
        val Cm_Button:Button=firstFragmentView.findViewById(R.id.Cm_Button)
        val Kg_Button:Button=firstFragmentView.findViewById(R.id.Kg_Button)
        val Pounds_Button:Button=firstFragmentView.findViewById(R.id.Pounds_Button)
        val SaveButton:Button=firstFragmentView.findViewById(R.id.SaveButton)

        val Logo:ImageView=firstFragmentView.findViewById(R.id.Bmilogo)
        Logo.setImageResource(R.drawable.bmilogo)


        Feet_InchButton.setOnClickListener(View.OnClickListener {
           // Toast.makeText(requireContext(),"Check",Toast.LENGTH_SHORT).show()
            Value_Cm.visibility=View.INVISIBLE
            Value_Foot.visibility=View.VISIBLE
            Value_Inch.visibility=View.VISIBLE
            Cm_Button.visibility=View.VISIBLE
            Feet_InchButton.visibility=View.INVISIBLE
        })

        Cm_Button.setOnClickListener(View.OnClickListener {
            Value_Foot.visibility=View.INVISIBLE
            Value_Inch.visibility=View.INVISIBLE
            Value_Cm.visibility=View.VISIBLE
            Cm_Button.visibility=View.INVISIBLE
            Feet_InchButton.visibility=View.VISIBLE
        })

        Kg_Button.setOnClickListener(View.OnClickListener {
            Value_Pounds.visibility=View.INVISIBLE
            Value_Kg.visibility=View.VISIBLE
            Kg_Button.visibility=View.INVISIBLE
            Pounds_Button.visibility=View.VISIBLE

        })

        Pounds_Button.setOnClickListener(View.OnClickListener {
            Value_Pounds.visibility=View.VISIBLE
            Value_Kg.visibility=View.INVISIBLE
            Kg_Button.visibility=View.VISIBLE
            Pounds_Button.visibility=View.INVISIBLE
        })

        // Visiblty OnCreate
        Value_Cm.visibility=View.VISIBLE
        Value_Foot.visibility=View.INVISIBLE
        Value_Inch.visibility=View.INVISIBLE
        Value_Pounds.visibility=View.INVISIBLE
        SecondView.visibility=View.INVISIBLE


         Value_Foot.addTextChangedListener(object : TextWatcher {
             override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

             override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

             override fun afterTextChanged(p0: Editable?) {
                 if(Value_Foot.text.toString().isEmpty()){

                 }
                 else {
                  FootValueLocal=p0.toString().toDouble()
                     FootValueLocal*=12
                     FootValueLocal+=InchValueLocal
                     FootValueLocal*=2.54
                     FootValueLocal*=FootValueLocal
                     val finalFeetInch:Double=FootValueLocal/10_000
                     Height=finalFeetInch

                 }
             }

         })


        Value_Inch.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(p0: Editable?) {
                if(Value_Inch.text.toString().isEmpty() ){


                }
                else {
                    InchValueLocal=p0.toString().toDouble()

                }
            }
        })

        Value_Cm.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(p0: Editable?) {
                if(Value_Cm.text.toString().isEmpty()){
//                    num2=0.0
                }
                else {
                    var CmtoMeter:Double=p0.toString().toDouble()
                    CmtoMeter*=CmtoMeter
                    var meter=CmtoMeter/10_000
                    Height=meter

                }
            }
        })

        Value_Kg.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(p0: Editable?) {
                if(Value_Kg.text.toString().isEmpty()){
//                    num2=0.0
                    SecondView.visibility=View.INVISIBLE
                }
                else {
                    val Kg:Double=p0.toString().toDouble()
                    Weight=Kg
                    val out:Double=Weight/Height
                    BmiValue=out
                    BmiTextView.setText(BmiValue.toString())
                    ShowVerdictChangeBackGround()
                    SecondView.visibility=View.VISIBLE
                }
            }
        })

        Value_Pounds.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(p0: Editable?) {
                if(Value_Pounds.text.toString().isEmpty()){
                    //num2=0.0
                    SecondView.visibility=View.INVISIBLE
                }
                else {

                    val pounds:Double = p0.toString().toDouble()
                    Weight=pounds/2.205
                    val out:Double=Weight/Height
                    BmiValue=out
                    BmiTextView.setText(BmiValue.toString())
                    ShowVerdictChangeBackGround()
                }
            }
        })




        SaveButton.setOnClickListener(View.OnClickListener {
            insertDataToDatabse()
            SaveButton.visibility=View.INVISIBLE
            Toast.makeText(context,BmiValue.toString(),Toast.LENGTH_SHORT).show()
        })










        // OnCreate Ends Here....
        return firstFragmentView
    }

















    // Insert TO DataBase
    private fun insertDataToDatabse() {

       if (BmiValue==0.0){
           Toast.makeText(requireContext(), "Failed", Toast.LENGTH_SHORT).show()

       }else{
           val user = User(0,BmiValue.toString())
           mUserViewModel.addUser(user)
       }

    }


    private fun ShowVerdictChangeBackGround()
    {
        // UnderWeight 18.5
        // Normal 18.5-25
        // OverWeight 25-30
        // Obese 30+
        if (BmiValue <= 18.5)
        {
            VerdictTv.setText("Fit")
            SecondView.setBackgroundResource(R.drawable.underweight_bg)

        }
        else if (BmiValue>=18.5 && BmiValue<=25.0)
        {
            VerdictTv.setText("Normal")
            SecondView.setBackgroundResource(R.drawable.normal_bg)
        }
        else if(BmiValue>=25 && BmiValue<=30 )
        {
            VerdictTv.setText("OverWeight")
            SecondView.setBackgroundResource(R.drawable.overweight_bg)
        }
        else
        {
            VerdictTv.setText("Obese")
            SecondView.setBackgroundResource(R.drawable.obese_bg)
        }
    }
    
}