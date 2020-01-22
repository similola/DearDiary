package com.deardiary.utils;

import com.microsoft.cognitiveservices.speech.SpeechConfig;
import com.microsoft.cognitiveservices.speech.SpeechRecognitionResult;
import com.microsoft.cognitiveservices.speech.SpeechRecognizer;
import org.junit.jupiter.api.Test;
import java.util.concurrent.Future;
import static com.deardiary.utils.Validator.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class ValidatorTest {

//Goal of these tests are to catch that methods will return false if the earlier object fails. This is what we want to avoid in production.

    @Test
    void checkConfigAssertsFalse() {
        SpeechConfig config = null;
        assertFalse(checkConfig(config));
        if(!checkConfig(config)){
            System.out.println("checkConfigAssertsFalse()  passed");
        }
        else{
            System.out.println("checkConfigAssertsFalse()  failed");
        }
    }


    @Test
    void checkSpeechRecogAssertsFalse() {
        SpeechRecognizer reco = null;
        assertFalse(checkSpeechRecog(reco));
        if(!checkSpeechRecog(reco)){
            System.out.println("checkSpeechRecogAssertsFalse() passed");
        }
        else{
            System.out.println("checkSpeechRecogAssertsFalse() failed");
        }
    }

    @Test
    void checkTaskAssertsFalse() {
        Future<SpeechRecognitionResult> task = null;
        assertFalse(checkTask(task));
        if(!checkTask(task)){
            System.out.println("checkTaskAssertsFalse() passed");
        }
        else{
            System.out.println("checkTaskAssertsFalse() failed");
        }
    }

    @Test
    void checkResultAssertsFalse() {
        SpeechRecognitionResult result = null;
        assertFalse(checkResult(result));
        if(!checkResult(result)){
            System.out.println("checkResultAssertsFalse() passed");
        }
        else{
            System.out.println("checkResultAssertsFalse() failed");
        }
    }
}