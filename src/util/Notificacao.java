/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.alee.extended.time.ClockType;
import com.alee.extended.time.WebClock;
import com.alee.managers.notification.NotificationIcon;
import com.alee.managers.notification.NotificationManager;

public class Notificacao {

    public static void infoBox(String infoMessage, boolean sucess) {

        NotificationManager.setLocation(NotificationManager.LEFT);
        if (sucess) {
            NotificationManager.showInnerNotification(infoMessage, NotificationIcon.information.getIcon());
        } else {
            NotificationManager.showInnerNotification(infoMessage, NotificationIcon.error.getIcon());
        }
        new Thread() {

            @Override
            public void run() {
                final WebClock clock = new WebClock();
                clock.setClockType(ClockType.timer);
                clock.setTimeLeft(3000);
                clock.start();
                while (true) {
                    if (clock.getTimeLeft() <= 0) {
                        NotificationManager.hideAllNotifications();
                        break;
                    } else {
                        NotificationManager.updateNotificationLayouts();
                    }
                }
            }
        }.start();
    }
}
