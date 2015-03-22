package adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import constants.Constants;
import fragments.BaseFragment;
import models.CheckBoxModel;
import models.Model;
import models.MultyButtonsModel;
import models.SinlgeTextModel;
import models.UploadPhotoModel;

/**
 * Created by Alex on 3/22/2015.
 */
public class CustomPageAdapter extends FragmentPagerAdapter {

    private List<Model> cardsModels;
    private List<BaseFragment> fragments;
    private Bundle bundle = new Bundle();

    public CustomPageAdapter(FragmentManager fm) {
        super(fm);
    }



    @Override
    public Fragment getItem(int position) {
        BaseFragment fragment = null;
        Model currentCard = cardsModels.get(position);

        bundle.clear();
        bundle.putInt(Constants.MODEL_POSITION_KEY, position);


        if(CheckBoxModel.class.isInstance(currentCard)) {
            fragment = new CheckBoxFragment();

        }else if(MultyButtonsModel.class.isInstance(currentCard)) {
            fragment = new MultyButtonsFragment();

        }else if(SinlgeTextModel.class.isInstance(currentCard)){
            fragment = new SinlgeTextFragment();

        }else if(UploadPhotoModel.class.isInstance(currentCard)){
            fragment = new UploadPhotoFragment();
        }
        fragment.setArguments(bundle);

        //We will create fragments here

        return fragment;
    }



    @Override
    public int getCount() {
        if(cardsModels != null)
            return cardsModels.size();
        else return 0;
    }

    public void setCardsModels(List<Model> cardsModels) {
        this.cardsModels = cardsModels;
    }
}
