package com.deardiary;

import java.util.concurrent.Future;
import com.microsoft.cognitiveservices.speech.*;

public class Main {
    public static void main(String[] args) {
        try {
            // Replace below with your own subscription key
            String speechSubscriptionKey = "YourSubscriptionKey";
            // Replace below with your own service region (e.g., "westus").
            String serviceRegion = "YourServiceRegion";

            int exitCode = 1;
            SpeechConfig config = SpeechConfig.fromSubscription(speechSubscriptionKey, serviceRegion);
            checkConfig(config);

            SpeechRecognizer reco = new SpeechRecognizer(config);
            checkSpeechRecog(reco);

            System.out.println("Say something...");

            Future<SpeechRecognitionResult> task = reco.recognizeOnceAsync();
            checkTask(task);

            SpeechRecognitionResult result = task.get();
            checkResult(result);

            if (result.getReason() == ResultReason.RecognizedSpeech) {
                System.out.println("We recognized: " + result.getText());
                exitCode = 0;
            }
            else if (result.getReason() == ResultReason.NoMatch) {
                System.out.println("NOMATCH: Speech could not be recognized.");
            }
            else if (result.getReason() == ResultReason.Canceled) {
                CancellationDetails cancellation = CancellationDetails.fromResult(result);
                System.out.println("CANCELED: Reason=" + cancellation.getReason());

                if (cancellation.getReason() == CancellationReason.Error) {
                    System.out.println("CANCELED: ErrorCode=" + cancellation.getErrorCode());
                    System.out.println("CANCELED: ErrorDetails=" + cancellation.getErrorDetails());
                    System.out.println("CANCELED: Did you update the subscription info?");
                }
            }

            reco.close();

            System.exit(exitCode);
        } catch (Exception ex) {
            System.out.println("Unexpected exception: " + ex.getMessage());

            assert(false);
            System.exit(1);
        }
    }

    public static void checkConfig(SpeechConfig config){
        if(config==null){
            System.out.println("SpeechConfig object is null. Please check subscription key and region.");
            throw new NullPointerException();
        }
        assert(config!=null);
    }

    public static void checkSpeechRecog(SpeechRecognizer recog){
        if(recog==null){
            System.out.println("SpeechRecognizer object is null.");
            throw new NullPointerException();
        }
        assert(recog!=null);
    }

    public static void checkTask(Future<SpeechRecognitionResult> task){
        if(task==null){
            System.out.println("Future<SpeechRecognitionResult> object is null.");
            throw new NullPointerException();
        }
        assert(task!=null);
    }

    public static void checkResult(SpeechRecognitionResult result){
        if(result==null){
            System.out.println("SpeechRecognitionResult object is null.");
            throw new NullPointerException();
        }
        assert(result!=null);
    }

    }

