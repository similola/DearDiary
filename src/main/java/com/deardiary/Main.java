package com.deardiary;

import java.util.concurrent.Future;
import com.microsoft.cognitiveservices.speech.*;
import static com.deardiary.utils.Validator.*;

public class Main {
    public static void main(String[] args) {
        try {
            if(args.length>2||args.length<2||args[0]==null||args[1]==null){
                System.out.println("Run program like this: java -cp target/* com.deardiary.Main <subscriptionkey> <serviceregion>");
                throw new Exception("Exception thrown because of incorrect arguments");
            }
            String speechSubscriptionKey = args[0];
            String serviceRegion = args[1];

            int exitCode = 1;
            SpeechConfig config = SpeechConfig.fromSubscription(speechSubscriptionKey, serviceRegion);
            assert(checkConfig(config));

            SpeechRecognizer reco = new SpeechRecognizer(config);
            assert(checkSpeechRecog(reco));

            System.out.println("Say something...");

            Future<SpeechRecognitionResult> task = reco.recognizeOnceAsync();
            assert(checkTask(task));

            SpeechRecognitionResult result = task.get();
            assert(checkResult(result));

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



    }

