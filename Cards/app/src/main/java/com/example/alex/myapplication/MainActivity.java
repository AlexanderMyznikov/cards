package com.example.alex.myapplication;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import adapters.CustomPageAdapter;
import animations.ZoomOutPageTransformer;
import constants.Constants;
import fragments.OnFragmentChanged;
import models.CheckBoxModel;
import models.Model;
import models.MultyButtonsItem;
import models.MultyButtonsModel;
import models.SinlgeTextModel;
import models.UploadPhotoModel;
import rest.CadsApi;
import rest.RestCallback;

import static constants.Constants.*;

public class MainActivity extends ActionBarActivity implements OnFragmentChanged {

    private List<Model> cardsModels;
    private ProgressDialog pbLoading;
    private CustomPageAdapter cardsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pbLoading = new ProgressDialog(this);


        getQuestions();




    }

    private void setAdapter() {
        ViewPager pager = (ViewPager)findViewById(R.id.vp_pager);
         pager.setPageTransformer(true , new ZoomOutPageTransformer());
        cardsAdapter = new CustomPageAdapter(getSupportFragmentManager());
        cardsAdapter.setCardsModels(cardsModels);
        pager.setAdapter(cardsAdapter);
    }


    @Override
    public void setAnswer(boolean isAnswered, Model answeredModel) {
        if(isAnswered){
            removeQuestionSendResult(answeredModel);
        }
    }

    private void removeQuestionSendResult(Model answeredModel) {
        cardsModels.remove(answeredModel);
        cardsAdapter.notifyDataSetChanged();
    }

    public List<Model> getCardsModels(){
        return cardsModels;
    }

    private void parseData(JSONObject jsonObject){
        cardsModels = new ArrayList<>();
        try {
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            for(int i = 0 ; i < jsonArray.length(); i++){
                JSONObject object = jsonArray.getJSONObject(i);
                String type = object.getString("card_type");
                Model model = null;
                switch (type){
                    case TYPE_TEXT:
                        model =  new Gson().fromJson(object.toString(), SinlgeTextModel.class);
                        break;
                    case TYPE_SELECT:
                        model = new Gson().fromJson(object.toString(), CheckBoxModel.class);
                        break;
                    case TYPE_MULITIPLE:
                        model = new Gson().fromJson(object.toString(),MultyButtonsModel.class);
                        break;
                    case TYPE_IMAGE_UPLOAD:
                        model = new Gson().fromJson(object.toString(), UploadPhotoModel.class);
                        break;
                }

                cardsModels.add(model);
            }
            setAdapter();

        }catch(JSONException e){
            e.printStackTrace();
        }
    }

    private void getQuestions(){
        pbLoading.show();
        CadsApi.requestJsonObject(Constants.BASE_URL, "tag", new RestCallback() {
            @Override
            public void onSuccess(Object response) {
                parseData((JSONObject)response);

                pbLoading.dismiss();

            }

            @Override
            public void onFailure(String error) {
                pbLoading.dismiss();
            }
        });

    }


}
