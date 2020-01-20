package com.deardiary.utils;

import com.microsoft.cognitiveservices.speech.SpeechConfig;
import com.microsoft.cognitiveservices.speech.SpeechRecognitionResult;
import com.microsoft.cognitiveservices.speech.SpeechRecognizer;

import java.util.concurrent.Future;

public class Validator {

    public static boolean checkConfig(SpeechConfig config){
        if(config==null){
            System.out.println("SpeechConfig object is null. Please check subscription key and region.");
            return false;
        }
        return true;
    }

    public static boolean checkSpeechRecog(SpeechRecognizer recog){
        if(recog==null){
            System.out.println("SpeechRecognizer object is null.");
            return false;
        }
        return true;
    }

    public static boolean checkTask(Future<SpeechRecognitionResult> task){
        if(task==null){
            System.out.println("Future<SpeechRecognitionResult> object is null.");
            return false;
        }
        return true;
    }

    public static boolean checkResult(SpeechRecognitionResult result){
        if(result==null){
            System.out.println("SpeechRecognitionResult object is null.");
            return false;
        }
        return true;
    }
}
