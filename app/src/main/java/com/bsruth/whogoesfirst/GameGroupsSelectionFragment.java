package com.bsruth.whogoesfirst;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class GameGroupsSelectionFragment extends Fragment {

    private List<GameGroup> m_groups = null;
    private GroupLoader m_groupLoader = new GroupLoader();
    private GroupListArrayAdapter m_adapter;
    private Runnable viewGroups;

    public GameGroupsSelectionFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        m_groups = m_groupLoader.GetAvailableGroups();
        this.m_adapter = new GroupListArrayAdapter(this.getContext(), R.layout.group_list_item_layout,
                (ArrayList<GameGroup>) m_groups);

        View thisView = inflater.inflate(R.layout.fragment_game_groups_selection, container, false);
        GridView listView = (GridView)(thisView.findViewById(R.id.allGroupView));

        listView.setAdapter(m_adapter);

        return thisView;
    }

}
