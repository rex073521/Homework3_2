package com.example.rex.homework3_2;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    private TextView txtWord;
    private Button startBtn, stopBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    public void findViews() {
        txtWord = (TextView) findViewById(R.id.txtWord);
        startBtn = (Button) findViewById(R.id.startBtn);
        stopBtn = (Button) findViewById(R.id.stopBtn);
        getAnimationSet();

    }

    private AnimationSet getAnimationSet(){
        TranslateAnimation translateAnimation = getTranslateAnimation();
        RotateAnimation rotateAnimation=getRotateAnimation();
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(rotateAnimation);
        return  animationSet;
    }



    public void onStartClick(View view) {
        txtWord.startAnimation(getTranslateAnimation());
        txtWord.startAnimation(getRotateAnimation());

        Animation anim= AnimationUtils.loadAnimation(MainActivity.this,R.anim.anim);
        txtWord.startAnimation(anim);

    }

    public void onStopClick(View view){
        txtWord.clearAnimation();
    }

    private TranslateAnimation getTranslateAnimation() {
        View parentView = (View) txtWord.getParent();
        // 球移動的距離
        float distance = parentView.getWidth() - 100;
        TranslateAnimation translateAnimation = new TranslateAnimation(100,distance,100,1000);
        translateAnimation.setDuration(1000);
        translateAnimation.setRepeatMode(Animation.RESTART);
        translateAnimation.setRepeatCount(Animation.INFINITE);
        return translateAnimation;
    }

    private RotateAnimation getRotateAnimation() {
        RotateAnimation rotateAnimation = new RotateAnimation(
                0,360,
                Animation.RELATIVE_TO_SELF,1f,
                Animation.RELATIVE_TO_SELF,1f);
        rotateAnimation.setDuration(300);
        rotateAnimation.setRepeatMode(Animation.RESTART);
        rotateAnimation.setRepeatCount(Animation.INFINITE);
        return rotateAnimation;
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



}
