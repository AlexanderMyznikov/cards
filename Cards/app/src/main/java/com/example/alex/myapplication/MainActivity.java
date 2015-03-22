package com.example.alex.myapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import fragments.OnFragmentChanged;
import models.CheckBoxModel;
import models.Model;
import models.MultyButtonsModel;
import models.SinlgeTextModel;
import models.UploadPhotoModel;


public class MainActivity extends ActionBarActivity implements OnFragmentChanged {

    private List<Model> cardsModels;
    public Model currentCardModel;
    private int currentCardPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getQuestions();
        setAdapter();
    }

    private void setAdapter() {
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setAnswer(boolean isAnswered, Model answeredModel) {
        if(isAnswered){
            removeQuestionSendResult(answeredModel);
        }else {
            nextQuestion(answeredModel);
        }
    }

    private void removeQuestionSendResult(Model answeredModel) {
        currentCardPosition = cardsModels.indexOf(answeredModel);
        cardsModels.remove(answeredModel);

        if(currentCardPosition > cardsModels.size()|| currentCardPosition == -1){
            currentCardPosition = 0;
        }
        currentCardModel = cardsModels.get(currentCardPosition);
    }

    private void nextQuestion(Model answeredModel){
        currentCardPosition = cardsModels.indexOf(answeredModel);
        if(currentCardPosition > cardsModels.size()){
            currentCardPosition = 0;
        }else {
            currentCardPosition++;
        }

        currentCardModel = cardsModels.get(currentCardPosition);
    }

    private void changeFragment(){

    }

    private void getQuestions(){
        cardsModels = new ArrayList<>();
        Model multiButtonsModel = new MultyButtonsModel();
        Model checkBoxModel = new CheckBoxModel();
        Model singleTextModel = new SinlgeTextModel();
        Model uploadPhotoModel = new UploadPhotoModel();

        cardsModels.add(multiButtonsModel);
        cardsModels.add(checkBoxModel);
        cardsModels.add(singleTextModel);
        cardsModels.add(uploadPhotoModel);
    }
}
