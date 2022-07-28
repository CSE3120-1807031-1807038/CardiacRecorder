package com.example.cardiacrecorder;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.util.AndroidRuntimeException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;

@RunWith(RobolectricTestRunner.class)
public class DatabaseTest {

    String sp,dp,heart_rate,date,time,comment;
    Database database;

    /**
     * Sets up a new database connection
     */
    public void setUp(){
        database = new Database(RuntimeEnvironment.application);
    }

    /**
     * tests inserting mock value into the database and checks
     */
    @Test
    public void insert_user_data() {
        setUp();

        sp="120";
        dp="80";
        heart_rate="60";
        date = "02-02-2022";
        time = "05:14";
        comment = "morning";
        database.insert_user_data(sp,dp,heart_rate,date,time,comment);
        assertTrue(database.checkIfDataExists(sp,dp,heart_rate,date,time,comment));
        database.deleteData(sp, dp, heart_rate);
        database.close();
    }

    /**
     * Tests if deleting function works as intended
     */
    @Test
    public void testDelete() {
        setUp();

        sp="120";
        dp="80";
        heart_rate="60";
        date = "02-02-2022";
        time = "05:14";
        comment = "morning";
        database.insert_user_data(sp,dp,heart_rate,date,time,comment);
        assertTrue(database.checkIfDataExists(sp,dp,heart_rate,date,time,comment));
        database.deleteData(sp, dp, heart_rate);
        assertFalse(database.checkIfDataExists(sp,dp,heart_rate,date,time,comment));

        database.close();
    }

    /**
     * Tests if updating function works as intended
     */
    @Test
    public void testUpdate() {
        setUp();

        sp = "120";
        dp = "72";
        heart_rate = "67";
         date = "02-02-2022";
         time = "05:14";
         comment = "after running";
        database.insert_user_data(sp,dp,heart_rate,date,time,comment);
        assertTrue(database.checkIfDataExists(sp,dp,heart_rate,date,time,comment));

        String sp1 = "115";
        String dp1 = "75";
        String heart_rate1 = "55";
        String date1 = "06-02-2022";
        String time1 = "09:15";
        String comment1 = "night";

        database.updateData(sp, dp, heart_rate, sp1, dp1, heart_rate1, date1, time1, comment1);
        assertTrue(database.checkIfDataExists(sp1,dp1,heart_rate1,date1,time1,comment1));

        database.close();
    }


}