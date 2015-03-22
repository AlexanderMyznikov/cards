package fragments;

import android.app.Fragment;
import android.view.View;
import android.widget.TextView;

import com.example.alex.myapplication.MainActivity;

import org.w3c.dom.Text;

import models.Model;

/**
 * Created by Admin on 22.03.2015.
 */

public class BaseFragment extends Fragment{
    private Model cardModel;
    protected View mRootView;



    protected MainActivity mActivity;

    public Model getModel(){
       return cardModel = ((MainActivity) getActivity()).currentCardModel;
    }

    public void cancel(){
        ((OnFragmentChanged)getActivity()).setAnswer(false, cardModel);
    }

    public void setAnswer(){
        ((OnFragmentChanged)getActivity()).setAnswer(true, cardModel);
    }
}
