package com.robot.asus.ZenboHelloWorld;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class Container extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.membership);
        MembershipFragment membershipFragment = new MembershipFragment();
        getFragmentManager().beginTransaction().add(R.id.membership_container, membershipFragment).commitAllowingStateLoss();

    }
}
