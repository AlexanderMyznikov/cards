package fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alex.myapplication.MainActivity;
import com.example.alex.myapplication.R;

import constants.Constants;
import models.MultyButtonsModel;


/**
 * Created by Admin on 22.03.2015.
 */
public class CardFragmentWithMultipleButtons extends BaseFragment implements View.OnClickListener {

        private TextView tvSubmit;



        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            mActivity = (MainActivity)activity;
        }
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            mRootView = inflater.inflate(R.layout.fragment_question_with_mulitple_variants,container,false);
            findViews();
            setListeners();
            setQuestion();
            return mRootView;
        }
        private void findViews(){
            tvQuestion = (TextView)mRootView.findViewById(R.id.tv_question);
            tvSubmit = (TextView) mRootView.findViewById(R.id.tv_submit);
            tvPoints = (TextView)mRootView.findViewById(R.id.tv_points);
            ivStar = (ImageView)mRootView.findViewById(R.id.iv_star);
        }
        private void setListeners(){
            tvSubmit.setOnClickListener(this);
        }
        private void setQuestion(){
            MultyButtonsModel model  =  getArguments().getParcelable(Constants.MODEL_QUESTION_KEY);
            mCardModel = model;
            setData(model);



        }
        private void sendQuestion(){

        }

        @Override
        public void onClick(View v) {
            sendQuestion();
        }
    }



