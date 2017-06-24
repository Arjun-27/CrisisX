package emergency.com.crisisx.services;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

import emergency.com.crisisx.MainActivity;
import emergency.com.crisisx.MainMapActivity;
import emergency.com.crisisx.R;
import emergency.com.crisisx.fragments.MainMapFragment;
import emergency.com.crisisx.pojo.TypeEmergencyConfirmation;

/**
 * Created by Arjun on 27-Mar-2017 for CrisisX.
 */

public class CrisisFirebaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = "MyFirebaseMsgService";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // [START_EXCLUDE]
        // There are two types of messages data messages and notification messages. Data messages are handled
        // here in onMessageReceived whether the app is in the foreground or background. Data messages are the type
        // traditionally used with GCM. Notification messages are only received here in onMessageReceived when the app
        // is in the foreground. When the app is in the background an automatically generated notification is displayed.
        // When the user taps on the notification they are returned to the app. Messages containing both notification
        // and data payloads are treated as notification messages. The Firebase console always sends notification
        // messages. For more see: https://firebase.google.com/docs/cloud-messaging/concept-options
        // [END_EXCLUDE]

        // TODO(developer): Handle FCM messages here.
        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
        Log.d(TAG, "From: " + remoteMessage.getFrom());

        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());

//            if (/* Check if data needs to be processed by long running job */ true) {
//                // For long-running tasks (10 seconds or more) use Firebase Job Dispatcher.
//                scheduleJob();
//            } else {
//                // Handle message within 10 seconds
//                handleNow();
//            }
            sendNotification(remoteMessage.getData());
        }

        // Check if message contains a notification payload.
        else if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
        }

        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated. See sendNotification method below.
    }
    // [END receive_message]

    /**
     * Schedule a job using FirebaseJobDispatcher.
     */
//    private void scheduleJob() {
//        // [START dispatch_job]
//        FirebaseJobDispatcher dispatcher = new FirebaseJobDispatcher(new GooglePlayDriver(this));
//        Job myJob = dispatcher.newJobBuilder()
//                .setService(MyJobService.class)
//                .setTag("my-job-tag")
//                .build();
//        dispatcher.schedule(myJob);
//        // [END dispatch_job]
//    }

    /**
     * Handle time allotted to BroadcastReceivers.
     */
//    private void handleNow() {
//        Log.d(TAG, "Short lived task is done.");
//    }

    /**
     * Create and show a simple notification containing the received FCM message.
     *
     * @param messageBody FCM message body received.
     */
    private void sendNotification(Map messageBody) {
        Intent intent = new Intent(this, MainMapActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 1234 /* Request code */, intent,
                PendingIntent.FLAG_ONE_SHOT);

        TypeEmergencyConfirmation confirmation = new TypeEmergencyConfirmation();
        confirmation.setNotification_type((String) messageBody.get("Notification_type"));

        Log.d(TAG, "" + confirmation.getNotification_type());

        String title = "", msg = "";
        switch (confirmation.getNotification_type()) {
            case "0":
                title = "Emergency Confirmed..";
                msg = "Your emergency has been served..";

                confirmation.setAmbulance_no((String) messageBody.get("Ambulance_Number"));
                confirmation.setHospital_name((String) messageBody.get("Hospital_Name"));
                confirmation.setStaff_name((String) messageBody.get("Staff_Name"));
                confirmation.setMobile_no((String) messageBody.get("Mobile_NO"));
                break;

            case "1":
                sendBroadcast(new Intent("LOCATIONS").putExtra("location", ((String) messageBody.get("Location"))));
                return;
        }

        Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.alarm)
                .setContentTitle(title)
                .setContentText(msg)
                .setAutoCancel(false)
                .addAction(android.R.drawable.ic_media_play, "Live Track", pendingIntent)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(1234, notificationBuilder.build());
    }
}
