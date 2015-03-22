package fragments;



import android.support.v4.app.Fragment;

import com.example.alex.myapplication.MainActivity;

import constants.Constants;
import models.Model;

/**
 * Created by Admin on 22.03.2015.
 */

public class BaseFragment extends Fragment {
    protected Model cardModel;




    protected MainActivity mActivity;

    public Model getModel(){
        int pos = getArguments().getInt(Constants.MODEL_POSITION_KEY);
        cardModel = ((MainActivity)getActivity()).getCardsModels().get(pos);
        return cardModel;
    }

    public void cancel(){
        ((OnFragmentChanged)getActivity()).setAnswer(false, cardModel);
    }

    public void setAnswer(){
        ((OnFragmentChanged)getActivity()).setAnswer(true, cardModel);
    }
}
