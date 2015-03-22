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

import constants.Constants;
import models.SinlgeTextModel;
import models.UploadPhotoModel;

/**
 * Created by Admin on 22.03.2015.
 */
public class CardFragmentWithUploadPhoto extends BaseFragment implements View.OnClickListener{


   private ImageView ivPhoto1;
   private ImageView ivPhoto2;
   private ImageView ivPhoto3;
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
        ivPhoto1 = (ImageView)mRootView.findViewById(R.id.iv_image1);
        ivPhoto2 = (ImageView)mRootView.findViewById(R.id.iv_image2);
        ivPhoto3 = (ImageView)mRootView.findViewById(R.id.iv_image3);
        tvQuestion = (TextView)mRootView.findViewById(R.id.tv_question);
        tvSubmit = (TextView) mRootView.findViewById(R.id.tv_submit);
        tvPoints = (TextView)mRootView.findViewById(R.id.tv_points);
        ivStar = (ImageView)mRootView.findViewById(R.id.iv_star);
    }
    private void setListeners(){
        tvSubmit.setOnClickListener(this);
    }
    private void setQuestion(){
        UploadPhotoModel model  =  getArguments().getParcelable(Constants.MODEL_QUESTION_KEY);
        mCardModel= model;
        setData(model);

    }
    private void sendQuestion(){

    }

    private void uploadImage1(){

    }
 private void uploadImage2(){

    }
 private void uploadImage3(){

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_submit:
                sendQuestion();
                break;
            case R.id.iv_image1:
                uploadImage1();
                break;
            case R.id.iv_image2:
                uploadImage2();
                break;
            case R.id.iv_image3:
                uploadImage3();
                break;
        }

    }
}
