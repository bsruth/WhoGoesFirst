package com.bsruth.whogoesfirst;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bsruth on 9/7/15.
 */
public class GroupLoader {

    private List<GameGroup> groupList = new ArrayList<GameGroup>();
    private final String ListFile = new String("group_list.csv");

    public List<GameGroup> GetAvailableGroups() {

            if (groupList.isEmpty()) {
                AddGroup("Brian and Marcia", new String []{"Brian", "Marcia"});
                AddGroup("Ehles", new String []{"Brian", "Marcia", "Dale", "Linda", "Aaron"});
            }

        return groupList;
    }

    public void AddGroup(String groupName, String[] groupMembers) {

        GameGroup newGroup = new GameGroup();
        newGroup.SetGroupName(groupName);
        for (String member : groupMembers) {
            newGroup.AddGroupMember(member);
        }
        groupList.add(newGroup);
    }


}
