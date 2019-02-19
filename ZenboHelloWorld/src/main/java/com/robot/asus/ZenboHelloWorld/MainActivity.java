package com.robot.asus.ZenboHelloWorld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.asus.robotframework.API.RobotCallback;
import com.asus.robotframework.API.RobotCmdState;
import com.asus.robotframework.API.RobotErrorCode;
import com.robot.asus.robotactivity.RobotActivity;

import org.json.JSONObject;

public class MainActivity extends RobotActivity {

    public static RobotCallback robotCallback = new RobotCallback() {
        @Override
        public void onResult(int cmd, int serial, RobotErrorCode err_code, Bundle result) {
            super.onResult(cmd, serial, err_code, result);
        }

        @Override
        public void onStateChange(int cmd, int serial, RobotErrorCode err_code, RobotCmdState state) {
            super.onStateChange(cmd, serial, err_code, state);
        }

        @Override
        public void initComplete() {
            super.initComplete();

        }
    };

    public static RobotCallback.Listen robotListenCallback = new RobotCallback.Listen() {
        @Override
        public void onFinishRegister() {

        }

        @Override
        public void onVoiceDetect(JSONObject jsonObject) {

        }

        @Override
        public void onSpeakComplete(String s, String s1) {

        }

        @Override
        public void onEventUserUtterance(JSONObject jsonObject) {

        }

        @Override
        public void onResult(JSONObject jsonObject) {

        }

        @Override
        public void onRetry(JSONObject jsonObject) {

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView membership = findViewById(R.id.withmeapp);
        membership.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent membership = new Intent();
                membership.setClass(MainActivity.this, Container.class);
                startActivity(membership);
            }
        });

        TextView button = findViewById(R.id.ex_teaching);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),SportSearchAndSort.class);
                startActivity(intent);
            }
        });

        TextView Gamebutton = findViewById(R.id.ex_game);
        Gamebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),WorkoutGame.class);
                startActivity(intent);
            }
        });

        TextView my_board = findViewById(R.id.ex_dashboard);
        my_board.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent my_board = new Intent();
                my_board.setClass(MainActivity.this, Myboard.class);
                startActivity(my_board);
            }
        });
    }

    public MainActivity() {
        super(robotCallback, robotListenCallback);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //robotAPI.robot.speak("歡迎來到sporden，跟著我一起運動吧");
    }
}
