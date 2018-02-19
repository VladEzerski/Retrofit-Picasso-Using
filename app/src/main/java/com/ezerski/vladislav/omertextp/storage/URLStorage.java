package com.ezerski.vladislav.omertextp.storage;

import java.util.ArrayList;
import java.util.List;

public class URLStorage {
    public static final String URL1 = "https://i.imgur.com/tXtwrPd.jpg";
    public static final String URL2 = "https://i.imgur.com/sduLRvf.jpg";
    public static final String URL3 = "https://i.imgur.com/PnSeZX3.jpg";
    public static final String URL4 = "https://i.imgur.com/QguApMA.jpg";
    public static final String URL5 = "https://i.imgur.com/Xulubox.jpg";
    public static final String URL6 = "https://i.imgur.com/tXtwrPd.jpg";
    public static final String URL7 = "https://i.imgur.com/fNXT1wc.jpg";
    public static final String URL8 = "https://i.imgur.com/gjEZAJ7.jpg";
    public static final String URL9 = "https://i.imgur.com/JHHx0AD.jpg";
    public static final String URL10 = "https://i.imgur.com/PnSeZX3.jpg";

    public static List<String> urls = new ArrayList<>();

    public static void addUrlToList(){
        urls.add(URL1);
        urls.add(URL2);
        urls.add(URL3);
        urls.add(URL4);
        urls.add(URL5);
        urls.add(URL6);
        urls.add(URL7);
        urls.add(URL8);
        urls.add(URL9);
        urls.add(URL10);
    }
}
