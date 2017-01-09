/* Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.engedu.ghost;

import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static android.R.attr.value;

public class SimpleDictionary implements GhostDictionary {
    private static final String TAG = "SampleDictionary";
    private ArrayList<String> words;
    private Random mRandom;

    public SimpleDictionary(InputStream wordListStream) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(wordListStream));
        words = new ArrayList<>();
        mRandom = new Random();
        String line = null;
        while((line = in.readLine()) != null) {
            String word = line.trim();
            if (word.length() >= MIN_WORD_LENGTH)
              words.add(line.trim());
        }
    }

    @VisibleForTesting
    public SimpleDictionary(ArrayList<String> words, long randomSeed) {
        this.words = words;
        mRandom = new Random(randomSeed);
    }

    @Override
    public boolean isWord(String word) {
        return words.contains(word);
    }

    @Override
    public String getAnyWordStartingWith(String prefix) {
        if (prefix.equals("")){
            return words.get(mRandom.nextInt(words.size()));

        }else {
            int length = prefix.length();
            int low = 0;
            int high = this.words.size() - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                String midWord = this.words.get(mid);
                String comparedPart = "";
                if(length > midWord.length()){
                    comparedPart = midWord;
                }else {
                    comparedPart = this.words.get(mid).substring(0, length);
                } int compare = comparedPart.compareTo(prefix);
                if (compare > 0) {
                    high = mid - 1;
                } else if (compare < 0) {
                    low = mid + 1;
                } else {
                    return this.words.get(mid);
                }
            }
            return null;
        }
    }
    @Override
    public String getGoodWordStartingWith(String prefix) {
        String selected = null;
        return selected;
    }
}
