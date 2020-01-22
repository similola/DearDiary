//package com.deardiary.utils;
//
//import com.microsoft.cognitiveservices.speech.SpeechConfig;
//import com.microsoft.cognitiveservices.speech.SpeechRecognitionResult;
//import com.microsoft.cognitiveservices.speech.SpeechRecognizer;
//import org.junit.jupiter.api.Test;
//import java.util.concurrent.Future;
//import static com.deardiary.utils.Validator.*;
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//
//class ValidatorTest {
//
//    @Test
//    void checkConfigAssertsTrue() {
//        SpeechConfig config = SpeechConfig.fromSubscription("testkey","testregion");
//        assertTrue(checkConfig(config));
//        if(checkConfig(config)){
//            System.out.println("checkConfigAssertsTrue() passed");
//        }
//        else{
//            System.out.println("checkConfigAssertsTrue() failed");
//        }
//
//    }
//
//
//    @Test
//    void checkConfigAssertsFalse() {
//        SpeechConfig config = null;
//        assertFalse(checkConfig(config));
//        if(!checkConfig(config)){
//            System.out.println("checkConfigAssertsFalse()  passed");
//        }
//        else{
//            System.out.println("checkConfigAssertsFalse()  failed");
//        }
//    }
//
//    @Test
//    void checkSpeechRecogAssertsTrue() {
//        SpeechConfig config = SpeechConfig.fromSubscription("testkey","testregion");
//        SpeechRecognizer reco = new SpeechRecognizer(config);
//        assertTrue(checkSpeechRecog(reco));
//        if(checkSpeechRecog(reco)){
//            System.out.println("checkSpeechRecogAssertsTrue() passed");
//        }
//        else{
//            System.out.println("checkSpeechRecogAssertsTrue() failed");
//        }
//    }
//
//    @Test
//    void checkSpeechRecogAssertsFalse() {
//        SpeechRecognizer reco = null;
//        assertFalse(checkSpeechRecog(reco));
//        if(!checkSpeechRecog(reco)){
//            System.out.println("checkSpeechRecogAssertsFalse() passed");
//        }
//        else{
//            System.out.println("checkSpeechRecogAssertsFalse() failed");
//        }
//    }
//
//    @Test
//    void checkTaskAssertsTrue() {
//        SpeechConfig config = SpeechConfig.fromSubscription("testkey","testregion");
//        SpeechRecognizer reco = new SpeechRecognizer(config);
//        Future<SpeechRecognitionResult> task = reco.recognizeOnceAsync();
//        assertTrue(checkTask(task));
//        if(checkTask(task)){
//            System.out.println("checkTaskAssertsTrue() passed");
//        }
//        else{
//            System.out.println("checkTaskAssertsTrue() failed");
//        }
//    }
//
//    @Test
//    void checkTaskAssertsFalse() {
//        Future<SpeechRecognitionResult> task = null;
//        assertFalse(checkTask(task));
//        if(!checkTask(task)){
//            System.out.println("checkTaskAssertsFalse() passed");
//        }
//        else{
//            System.out.println("checkTaskAssertsFalse() failed");
//        }
//    }
//
//    @Test
//    void checkResultAssertsTrue() {
//        SpeechConfig config = SpeechConfig.fromSubscription("testkey", "testregion");
//        SpeechRecognizer reco = new SpeechRecognizer(config);
//        Future<SpeechRecognitionResult> task = reco.recognizeOnceAsync();
//        SpeechRecognitionResult result = null;
//        try {
//            result = task.get();
//            assertTrue(checkResult(result));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        if(checkResult(result)){
//            System.out.println("checkResultAssertsTrue() passed");
//        }
//        else{
//            System.out.println("checkResultAssertsTrue() failed");
//        }
//    }
//
//    @Test
//    void checkResultAssertsFalse() {
//        SpeechRecognitionResult result = null;
//        assertFalse(checkResult(result));
//        if(!checkResult(result)){
//            System.out.println("checkResultAssertsFalse() passed");
//        }
//        else{
//            System.out.println("checkResultAssertsFalse() failed");
//        }
//    }
//}