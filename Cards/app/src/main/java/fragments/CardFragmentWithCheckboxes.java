package fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.alex.myapplication.MainActivity;
import com.example.alex.myapplication.R;

import models.CheckBoxItem;
import models.CheckBoxModel;
import models.Model;

/**
 * Created by Admin on 22.03.2015.
 */
public class CardFragmentWithCheckboxes extends BaseFragment implements View.OnClickListener{



    private TextView tvQuestion;
    private LinearLayout llCheckboxContainer;
    private TextView tvSubmit;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = (MainActivity)activity;
    }





    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

         View rootView = inflater.inflate(R.layout.fragment_question_with_checkboxes,container,false);
        findViews();
        setListeners();
        return rootView;
    }

    private void findViews(){
        tvQuestion = (TextView)mActivity.findViewById(R.id.tv_question);
        llCheckboxContainer = (LinearLayout)mActivity.findViewById(R.id.ll_checkbox_container);
        tvSubmit = (TextView) mActivity.findViewById(R.id.tv_submit);
    }

    private void addCheckboxItem(){
        CheckBoxModel model= (CheckBoxModel)getModel();

        model.getQuestions().size();




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
