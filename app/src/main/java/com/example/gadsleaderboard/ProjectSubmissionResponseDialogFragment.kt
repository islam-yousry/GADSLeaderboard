package com.example.gadsleaderboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.DialogFragment

class ProjectSubmissionResponseDialogFragment : DialogFragment() {
    private lateinit var responseImageView: ImageView
    private lateinit var responseTextView: TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_project_submission_response_dialog, container, false)
        responseImageView = rootView.findViewById(R.id.project_submission_response_image_view)
        responseTextView = rootView.findViewById(R.id.project_submission_response_text_view)

        if(!arguments!!.getBoolean("success")){
            responseTextView.text = "Submission not Successful"
            responseImageView.setImageResource(R.drawable.failed_sign)
        }
        else if(arguments!!.getBoolean("success")){
            responseTextView.text = "Submission Successful"
            responseImageView.setImageResource(R.drawable.success_sign)
        }
        return rootView
    }
    override fun onResume() {
        super.onResume()
        val params: ViewGroup.LayoutParams = dialog!!.window!!.attributes
        params.width = 800
        params.height = 800
        dialog!!.window!!.attributes = params as WindowManager.LayoutParams
    }



}