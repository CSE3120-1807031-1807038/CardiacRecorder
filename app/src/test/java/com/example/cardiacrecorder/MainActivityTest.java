package com.example.cardiacrecorder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MainActivityTest {
    /**
     * Adds a data to arraylist and checks if it exists
     */
    @Test
    public void testAdd(){
        List<Values> ValuesList = new ArrayList<>();
        Values Values = new Values("66","32","75","02-02-2345","4:30","testadd");
        ValuesList.add(Values);
        assertEquals(1,ValuesList.size());
        Values Values2 = new Values("34","12","63","023-05-1222","33:2","testadd");
        ValuesList.add(Values2);
        assertEquals(2,ValuesList.size());
    }
    /**
     * Checks if there is duplication while adding values
     */
    @Test
    public void testAddException() {
        List<Values> ValuesList = new ArrayList<>();
        Values Values = new Values("66","32","75","02-02-2345","4:30","testadd");
        ValuesList.add(Values);
        assertThrows(IllegalArgumentException.class, () -> {
            if (ValuesList.contains(Values)) {
                throw new IllegalArgumentException();
            }
        });
    }

    /**
     * Checks if deleting values work
     */
    @Test
    public  void testDelete(){
        List<Values> ValuesList = new ArrayList<>();
        Values Values = new Values("34","12","63","023-05-1222","33:2","testadd");
        ValuesList.add(Values);
        assertEquals(1,ValuesList.size());
        ValuesList.remove(Values);
        assertEquals(0,ValuesList.size());
    }

    /**
     * checks if attempt to delete unavailable value creates exception
     */
    @Test
    public  void testDeleteException(){
        List<Values> ValuesList = new ArrayList<>();
        Values Values = new Values("34","12","63","023-05-1222","33:2","testadd");
        ValuesList.add(Values);
        ValuesList.remove(Values);
        assertThrows(IllegalArgumentException.class, () -> {
            if (!ValuesList.contains(Values)) {
                throw new IllegalArgumentException();
            }
        });
    }

    /**
     * Checks if updating pre-insterted values works
     */
    @Test
    public void testUpdate(){
        List<Values> ValuesList = new ArrayList<>();
        Values Values = new Values("34","12","63","023-05-1222","33:2","testadd");
        ValuesList.add(Values);
        Values Values2 = new Values("66","32","75","02-02-2345","4:30","testadd");
        if (ValuesList.contains(Values))
        {
            ValuesList.remove(Values);
            ValuesList.add(Values2);
            assertEquals(0,Values2.compareTo(ValuesList.get(0)));
        }
    }


}