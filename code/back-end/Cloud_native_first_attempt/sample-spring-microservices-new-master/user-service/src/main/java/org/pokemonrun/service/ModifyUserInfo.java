package org.pokemonrun.service;

import org.pokemonrun.info.Coverinfo;

public interface ModifyUserInfo {
    public boolean ModifyExp(String username,int num);
    public boolean blockUser(String username);
    public boolean SetPet(String username, int pet);
    public boolean AddDistance(String username, double distance);
    public boolean addFriend(String username,String friendname);
    public boolean addCover(Coverinfo Coverinfo);
}
