package com.gerald.comsciexploration.junit5learning;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Hashtable;
import org.junit.jupiter.api.Test;

public class HashTableTest {

    @Test
    public void hashTableTest(){
        Hashtable<String, String> hashtable = new Hashtable<>();
        hashtable.put("key", "one");
        assertThat(hashtable.get("key"), is(equalTo("one")));
    }

}
