package com.PedroLins.WorkshopMongo.Resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class url {

    public static String DecodeParam(String txt) {
        try {
            return URLDecoder.decode(txt, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return ("");
        }
    }
}
