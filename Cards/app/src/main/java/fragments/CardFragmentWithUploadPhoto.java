package fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alex.myapplication.MainActivity;
import com.example.alex.myapplication.R;

import models.SinlgeTextModel;
import models.UploadPhotoModel;

/**
 * Created by Admin on 22.03.2015.
 */
public class CardFragmentWithUploadPhoto extends BaseFragment implements View.OnClickListener{

    private TextView tvQuestion;
   private ImageView ivPhoto;
    private TextView tvSubmit;




    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = (MainActivity)activity;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mRootView = inflater.inflate(R.layout.fragment_quetion_with_image,container,false);
        findViews();
        setListeners();
        setQuestion();
        return mRootView;
    }
    private void findViews(){
        ivPhoto = (ImageView)mRootView.findViewById(R.id.iv_image);
        tvSubmit = (TextView)mRootView.findViewById(R.id.tv_submit);
        tvQuestion = (TextView)mRootView.findViewById(R.id.tv_question);
    }
    private void setListeners(){
        tvSubmit.setOnClickListener(this);
    }
    private void setQuestion(){
        UploadPhotoModel model  =  (UploadPhotoModel)getModel();

    }
    private void sendQuestion(){

    }

    private void uploadImage(){

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_submit:
                sendQuestion();
            case R.id.iv_image:
                uploadImage();
        }

    }
}
