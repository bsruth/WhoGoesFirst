package com.bsruth.whogoesfirst;

import android.os.Handler;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;

/**
 * A placeholder fragment containing a simple view.
 */
public class RollResultActivityFragment extends Fragment implements View.OnClickListener {

    private GameGroup m_group = null;
    public RollResultActivityFragment() {
    }

    private static final String DESCRIBABLE_KEY = "describable_key";
    private Serializable mDescribable;

    public static RollResultActivityFragment newInstance(Serializable describable) {
        RollResultActivityFragment fragment = new RollResultActivityFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(DESCRIBABLE_KEY, describable);
        fragment.setArguments(bundle);

        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        Bundle args = getArguments();
        if(args != null) {
            Serializable passedArg = args.getSerializable(DESCRIBABLE_KEY);
            if (passedArg != null) {
                m_group = (GameGroup) (passedArg);

            }
        }
        View myView = inflater.inflate(R.layout.fragment_roll_result, container, false);

        Button b = (Button) myView.findViewById(R.id.nextGameBtn);
        b.setOnClickListener(this);
       GetRandomMember(myView);

        return  myView;
    }

    private void setWinner(final View view, final String winner) {
        TextView nameView = (TextView) view.findViewById(R.id.winnerName);
        nameView.setText(winner);
        TextView goesFirstText = (TextView) view.findViewById(R.id.goesFirstText);
        goesFirstText.setVisibility(View.VISIBLE);

    }

    private void ShowRolling(View v) {
        TextView nameView = (TextView) v.findViewById(R.id.winnerName);
        nameView.setText("...");
        TextView goesFirstText = (TextView) v.findViewById(R.id.goesFirstText);
        goesFirstText.setVisibility(View.INVISIBLE);
    }
    public void nextGameClicked(View view) {
        // Do something in response to button

        GetRandomMember(getView());
    }

    private void GetRandomMember(View v) {
        if(m_group != null) {
            ShowRolling(v);
            final View innerView = v;
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    String winner = m_group.GetRandomMember();
                    setWinner(innerView, winner);
                }
            }, 2000);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.nextGameBtn:
                nextGameClicked(getView());
                break;
        }
    }
}
