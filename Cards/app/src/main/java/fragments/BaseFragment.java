package fragments;


import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alex.myapplication.MainActivity;


import models.Model;

/**
 * Created by Admin on 22.03.2015.
 */

public class BaseFragment extends Fragment {
    protected Model mCardModel;
    protected View mRootView;
    protected TextView tvQuestion;
    protected ImageView ivStar;
    protected TextView tvPoints;



    protected MainActivity mActivity;






    protected void setData(Model _model){
        tvQuestion.setText(_model.getText());

        if(_model.isFavourite()){
            ivStar.setVisibility(View.VISIBLE);
        }else {
            ivStar.setVisibility(View.GONE);
        }
        tvPoints.setText("+" + _model.getPoints());
    }


    public void cancel(){
        ((OnFragmentChanged)getActivity()).setAnswer(false, mCardModel);
    }

    public void setAnswer(){
        ((OnFragmentChanged)getActivity()).setAnswer(true,mCardModel);
    }
}
