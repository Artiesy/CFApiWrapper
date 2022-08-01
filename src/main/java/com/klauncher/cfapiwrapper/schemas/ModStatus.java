package com.klauncher.cfapiwrapper.schemas;


import com.sun.org.apache.bcel.internal.generic.NEW;
import org.omg.PortableInterceptor.INACTIVE;

public class ModStatus {

    public static final int NEW = 1;
    public static final int CHANGES_REQUIRED = 2;
    public static final int UNDER_SOFT_REVIEW = 3;
    public static final int APPROVED = 4;
    public static final int REJECTED = 5;
    public static final int CHANGES_MADE = 6;
    public static final int INACTIVE = 7;
    public static final int ABANDONED = 8;
    public static final int DELETED = 9;
    public static final int UNDER_REVIEW = 10;
}
