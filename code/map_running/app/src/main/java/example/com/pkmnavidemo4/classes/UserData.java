package example.com.pkmnavidemo4.classes;

import android.util.Log;

import com.amap.api.maps.model.LatLng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UserData {
    public static boolean isFriendInfoGet=false;
    private static Map userInfo;
    private static Map friendUserInfo;
    private static Map friendPetInfo;
    private static int exp;
    private static String userName;
    private static List<String> elfList;
    private static  List<Map> elfDetailsList;
    private static  boolean onlyHave=false;
    public static boolean isFriendGet=false;
    public static List<LatLng> constraint=new ArrayList<LatLng>();
    public static Map getUserInfo(){return userInfo;}
    public static Map getElfWithId(int id){
        for (int i = 0; i < elfDetailsList.size(); i++) {
            if(elfDetailsList.get(i).get("typeID").toString().equals(id+"")){
               return elfDetailsList.get(i);
            }
        }
        return new HashMap();
    }
    public static Map getFriendInfo(String username){
        isFriendInfoGet=true;
        HttpHandler.getUserInfo(username,2);
        while(isFriendInfoGet){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //用户未设置出战精灵
        if((int)friendUserInfo.get("pet")==-1) {
            return null;
        }
        isFriendInfoGet=true;
        HttpHandler.getPetInfo(username,(int)friendUserInfo.get("pet"));
        while(isFriendInfoGet){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return friendPetInfo;

    }
    public static void setPet(int variety){
        HttpHandler.setPet(userName,variety);
        userInfo.replace("pet",variety);
    }
    public static void setFriengPetInfoMap(Map map){
        friendPetInfo=map;
    }
    public static void setUserInfoMap(Map map,int variety){
        if(variety==1)
            userInfo=map;
        if(variety==2)
            friendUserInfo=map;
    }
    public static void setUserInfo(String userName,int variety){
        HttpHandler.getUserInfo(userName,variety);
    }
    public static String getUserName(){
        return userName;
    }
    public static void setUserName(String name){
        userName=name;
    }
    public static List<List<LatLng>> recordLatLngList=new ArrayList<List<LatLng>>();
    public static List<String> startTime=new ArrayList<String>();
    public static List<String> rocordLength=new ArrayList<String>();
    public static List<String> recordLastTime=new ArrayList<String>();
    public static boolean isrecordGet=false;
    public static List<String> getElfList(){
        return elfList;
    }
    public static void setElfList( List<String> list){
        elfList=list;
    }
    public static List<String> friend=new ArrayList<String>();
    public static List <Map> getElfDetails(){
        return elfDetailsList;
    }
    public static void setElfDetails( List<Map> list){
        elfDetailsList=list;
    }
    public static void reverse(){
        onlyHave=!onlyHave;
    }
    public static void initonlyHave(){
        onlyHave=false;
    }
    public static boolean getOnlyHave(){
        return onlyHave;
    }
    public static boolean consumeExp(int num){
        if(exp>num){
            exp-=num;
            HttpHandler.changeExp(userName,0-num);
            return true;
        }
        else
            return false;
    }
    public static int getExp(){
        return exp;
    }
    public static void setExp(int num){
        exp=num;
    }
	public static void addExp(int num){
        HttpHandler.changeExp(userName,num);
        exp+=num;
    }
}
