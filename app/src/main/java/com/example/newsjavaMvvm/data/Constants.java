package com.example.newsjavaMvvm.data;

public class Constants  {
        public static final String mediaURL = "http://img.thezagelapp.com/";
        public static String loadSourceImg(int sourceID) {
            return mediaURL + "img/source/" + sourceID + ".jpg";
        }
}
