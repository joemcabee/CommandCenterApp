package com.pop.commandcenter;

/**
 * Created by joemc on 7/22/2017.
 */

class Authorization
{
    public static String getBasicAuthValue() {
        String basic = "Basic ";

        return basic + R.string.auth_hash;
    }
}

class Urls
{
    public static String CommandCenter = "https://command-center.ddns.net/";

    public static String GarageWebcam = "https://command-center.ddns.net/pigarage/webcam/stream.jpg";
    public static String RobotWebcam = "https://command-center.ddns.net/pirobot/webcam/stream.jpg";
}

class Services
{
    public static String CommandCenterPing = "ping";
    public static String GaragePing = "proxy/GaragePing";
    public static String RobotPing = "proxy/RobotPing";
    public static String LeftGarageDoor = "proxy/LeftGarageDoor";
    public static String RightGarageDoor = "proxy/RightGarageDoor";
}