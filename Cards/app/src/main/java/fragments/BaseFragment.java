package fragments;

import android.app.Fragment;

import com.example.alex.myapplication.MainActivity;

import models.Model;

/**
 * Created by Admin on 22.03.2015.
 */
<<<<<<< HEAD
public class BaseFragment extends Fragment{
    private Model cardModel;
    public void getModel(){
        cardModel = ((MainActivity) getActivity()).currentCardModel;
    }

    public void cancel(){
        ((OnFragmentChanged)getActivity()).setAnswer(false, cardModel);
    }

    public void setAnswer(){
        ((OnFragmentChanged)getActivity()).setAnswer(true, cardModel);
    }
=======
public abstract class BaseFragment extends Fragment{

    //private getQuestions()

>>>>>>> origin/master
}
