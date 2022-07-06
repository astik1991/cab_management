package com.phonepe.utils;

public class CabUtils {

    public static double distance(double lat1, double lon1, double lat2, double lon2, String sr) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        if (sr.equals("K")) {
            dist = dist * 1.609344;
        } else if (sr.equals("N")) {
            dist = dist * 0.8684;
        }
        return Math.round(dist);
    }
    public static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }
    public static double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }

    public static Integer calculateAmountFromDistance(double distance){
        if(distance>=20&& distance<=50)
            return 300;
        else if(distance>=50&& distance<=99)
            return 800;

        return 250;
    }
}
