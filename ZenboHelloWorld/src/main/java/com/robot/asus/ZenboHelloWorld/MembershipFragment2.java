package com.robot.asus.ZenboHelloWorld;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Objects;

public class MembershipFragment2 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_membership_fragment2, container, false);
        return view;
    }

    @Override
    public void onActivityCreated( @Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        TextView previouspage = Objects.requireNonNull(getView()).findViewById(R.id.previous_page);
        previouspage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MembershipFragment membershipFragment1 = new MembershipFragment();
                getFragmentManager().beginTransaction()
                        .replace(R.id.membership_container, membershipFragment1)
                        .commitAllowingStateLoss();
            }
        });
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }


}