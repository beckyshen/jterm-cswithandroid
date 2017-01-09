/*
 *  Copyright 2016 Google Inc. All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.google.engedu.ghost;

import android.util.Log;

import junit.framework.Assert;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class SimpleDictionaryTest {
    String[] wordsArray = {"apples","cats","dictionary","donuts","papaya","phone"};

    @Test
    public void testIsWord() {
    }

    @Test
    public void testGetAnyWordStartingWith() {
        ArrayList<String> words = new ArrayList<String>(Arrays.asList(wordsArray));

        SimpleDictionary dict = new SimpleDictionary(words,2);
        assertEquals("apples", dict.getAnyWordStartingWith("a"));
        assertEquals("apples", dict.getAnyWordStartingWith("apples"));
        //assertEquals(null, dict.getAnyWordStartingWith(""));
        System.out.print(dict.getAnyWordStartingWith(""));
    }
}
