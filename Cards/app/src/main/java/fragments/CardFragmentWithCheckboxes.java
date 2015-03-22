package fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.alex.myapplication.MainActivity;
import com.example.alex.myapplication.R;

import models.CheckBoxItem;
import models.CheckBoxModel;

/**
 * Created by Admin on 22.03.2015.
 */
public class CardFragmentWithCheckboxes extends BaseFragment implements View.OnClickListener{



    private TextView tvQuestion;
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
        llCheckboxContainer = (LinearLayout)mRootView.findViewById(R.id.ll_checkbox_container);
        tvSubmit = (TextView) mRootView.findViewById(R.id.tv_submit);
    }

    private void addCheckboxItems(){
        CheckBoxModel model= (CheckBoxModel)getModel();
        LayoutInflater inflater = LayoutInflater.from(mActivity);
        for (CheckBoxItem item :model.getQuestions()){
            View view =  inflater.inflate(R.layout.item_checkbox , null);
            llCheckboxContainer.addView(view);
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
