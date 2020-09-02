package com.r.foodproject.ui.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.r.foodproject.R
import com.r.foodproject.ui.activity.LoginActivity
import com.r.foodproject.ui.model.DatabaseHelper
import com.vansuita.pickimage.bean.PickResult
import com.vansuita.pickimage.bundle.PickSetup
import com.vansuita.pickimage.dialog.PickImageDialog
import kotlinx.android.synthetic.main.fragment_sign_up.*
import kotlinx.android.synthetic.main.fragment_sign_up.view.*


class SignUpFragment : Fragment() {
    var ImageURI: Uri? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_sign_up, container, false)

        val db = DatabaseHelper(requireContext())
        root.btn_signUp.setOnClickListener {

            if (root.username.text.isEmpty() && root.email.text.isEmpty() && root.password.text.isEmpty()) {
                Toast.makeText(requireContext(), "Please enter data", Toast.LENGTH_LONG).show()
            } else {

                var user_name = root.username.text.toString()
                var e_mail = root.email.text.toString()
                var pwd = root.password.text.toString()

                db.addUser(ImageURI.toString(), user_name, e_mail, pwd)
                //Toast.makeText(requireContext(), "Login Successfully", Toast.LENGTH_LONG).show()
                val i = Intent(requireContext(), LoginActivity::class.java)
                i.putExtra("flag", "signup")
                i.putExtra("name",user_name)
                i.putExtra("img",ImageURI.toString())
                startActivity(i)
                requireActivity().finish()

            }


        }
        root.signin_txt.setOnClickListener {

            val i= Intent(requireActivity(),LoginActivity::class.java)
            startActivity(i)
          //  requireActivity().finish()
        }

        root.pick_img.setOnClickListener {
            //PickImageDialog.build(PickSetup()).show(requireActivity())

            PickImageDialog.build(PickSetup())
                .setOnPickResult {
                    it
                    Toast.makeText(requireContext(), "image+ ${it.uri}", Toast.LENGTH_LONG).show()
                    profile_Photo.setImageURI(it.uri)
                    ImageURI = it.uri
                }
                .setOnPickCancel {
                    //TODO: do what you have to if user clicked cancel
                }.show(requireActivity().getSupportFragmentManager())
        }
    return root
    }

//    override fun onPickResult(r: PickResult?) {
//        if (r!!.error == null) {
//            Toast.makeText(requireContext(), "image+ ${r.uri}", Toast.LENGTH_LONG).show()
//            profile_Photo.setImageURI(r.uri)
//            ImageURI = r.uri
//        }
//    }

}
