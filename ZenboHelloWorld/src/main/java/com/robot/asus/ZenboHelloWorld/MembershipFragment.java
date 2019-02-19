package com.robot.asus.ZenboHelloWorld;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MembershipFragment extends android.app.Fragment {

    private MembershipFragment2 membershipFragment2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_membership, container, false);
        TextView nextpage = view.findViewById(R.id.nextpage);
        nextpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(membershipFragment2 == null)
                    membershipFragment2 = new MembershipFragment2();
                getFragmentManager().beginTransaction().replace(R.id.membership_container, membershipFragment2).commitAllowingStateLoss();
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}