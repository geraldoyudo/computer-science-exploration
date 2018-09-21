package com.gerald.comsciexploration.junit5learning;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import com.gerald.comsciexploration.learning.StringJoiner;
import org.junit.jupiter.api.Test;

public class StringJoinerTest {

    @Test
    public void joinStringTest(){
        assertThat(StringJoiner.joinString("Genevieve", " Onyearizor"),
                is(equalTo("Genevieve Onyearizor")));
    }

}
