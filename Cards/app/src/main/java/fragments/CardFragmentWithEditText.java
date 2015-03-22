package fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.alex.myapplication.MainActivity;
import com.example.alex.myapplication.R;

import models.SinlgeTextModel;

/**
 * Created by Admin on 22.03.2015.
 */
public class CardFragmentWithEditText extends BaseFragment implements View.OnClickListener {


    private TextView tvQuestion;
    private EditText etAnswer;
    private TextView tvSubmit;



    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = (MainActivity)activity;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mRootView = inflater.inflate(R.layout.fragment_question_edittext,container,false);
        findViews();
        setListeners();
        setQuestion();
        return mRootView;
    }
    private void findViews(){
        etAnswer = (EditText)mRootView.findViewById(R.id.et_Answer);
        tvSubmit = (TextView)mRootView.findViewById(R.id.tv_submit);
        tvQuestion = (TextView)mRootView.findViewById(R.id.tv_question);
    }
    private void setListeners(){
        tvSubmit.setOnClickListener(this);
    }
    private void setQuestion(){
        SinlgeTextModel model  =  (SinlgeTextModel)getModel();
        tvQuestion.setText(model.question);
    }
    private void sendQuestion(){

    }

    @Override
    public void onClick(View v) {
        sendQuestion();
    }
}
