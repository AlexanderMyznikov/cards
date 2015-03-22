package fragments;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.alex.myapplication.MainActivity;
import com.example.alex.myapplication.R;

import constants.Constants;
import models.CheckBoxItem;
import models.CheckBoxModel;
import models.Variant;

/**
 * Created by Admin on 22.03.2015.
 */
public class CardFragmentWithCheckboxes extends BaseFragment implements View.OnClickListener{


    private static float CARDS_SWIPE_LENGTH = 700;
    private float originalX = 0;
    private float originalY = 0;
    private float startMoveX = 0;
    private float startMoveY = 0;
    private CheckBox [] arrayOfCheckBoxes;

    private EditText etAnswer;
    private TextView tvSubmit;
    private LinearLayout llCheckboxContainer;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = (MainActivity)activity;
    }





    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

         mRootView= inflater.inflate(R.layout.fragment_question_with_checkboxes,container,false);
        findViews();
        setListeners();
        addCheckboxItems();
        return mRootView;
    }


    private void findViews(){
        tvQuestion = (TextView)mRootView.findViewById(R.id.tv_question);
        etAnswer = (EditText)mRootView.findViewById(R.id.et_Answer);
        llCheckboxContainer = (LinearLayout)mRootView.findViewById(R.id.ll_checkbox_container);
        tvSubmit = (TextView) mRootView.findViewById(R.id.tv_submit);
        tvPoints = (TextView)mRootView.findViewById(R.id.tv_points);
        ivStar = (ImageView)mRootView.findViewById(R.id.iv_star);
    }

    private void addCheckboxItems(){
        CheckBoxModel model= getArguments().getParcelable(Constants.MODEL_QUESTION_KEY);
        mCardModel = model;
        LayoutInflater inflater = LayoutInflater.from(mActivity);
        arrayOfCheckBoxes = new CheckBox[model.variants.length];
        for (int i = 0 ; i < model.variants.length; i++){
            View view =  inflater.inflate(R.layout.item_checkbox , null);
            arrayOfCheckBoxes[i]  = (CheckBox)view.findViewById(R.id.cb_item_choice);
            ((TextView)view.findViewById(R.id.tv_item_answer)).setText(model.variants[i].getText());

            llCheckboxContainer.addView(view);
            setData(model);
        }

    }

    private void setListeners(){
        tvSubmit.setOnClickListener(this);
    }


    private void sendAnswers(){

    }

    @Override
    public void onClick(View v) {
        sendAnswers();
    }
}
