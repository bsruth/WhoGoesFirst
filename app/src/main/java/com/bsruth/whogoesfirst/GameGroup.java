package com.bsruth.whogoesfirst;

import android.text.TextUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by bsruth on 9/7/15.
 */
public class GameGroup implements Serializable{
    private String groupName = new String("Unnamed Group");
    private List<String> groupMembers = new ArrayList<String>();
    private Random randomNumberGenerator = new Random();

    public void SetGroupName(String name) {
        groupName = name;
    }

    public String GetGroupName() {
        return groupName;
    }

    public List<String> GetGroupMembers() {
        return groupMembers;
    }

    public String GetRandomMember() {
        int randomNum = randomNumberGenerator.nextInt(groupMembers.size());
        return groupMembers.get(randomNum);
    }

    public void AddGroupMember(String member) {
        groupMembers.add(member);
    }
}
