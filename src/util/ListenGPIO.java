/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;

/**
 *
 * @author diogo.melo
 */
public class ListenGPIO {

    public ListenGPIO() {
        try {
            System.out.println("ESPERANDO SINAIS DO REFUGO...");
            // create gpio controller
            final GpioController gpio = GpioFactory.getInstance();
            // provision gpio pin #02 as an input pin with its internal pull down resistor enabled
            final GpioPinDigitalInput myButton = gpio.provisionDigitalInputPin(RaspiPin.GPIO_02, PinPullResistance.PULL_DOWN);
            // set shutdown state for this input pin
            myButton.setShutdownOptions(true);
            // create and register gpio pin listener
            myButton.addListener(new GpioPinListenerDigital() {
                @Override
                public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                    // display pin state on console
                    System.out.println("EVENTO REFUGO: " + event.getPin() + " = " + event.getState());
                }
            });
            System.out.println("COMLETO CIRCUITO GPIO #02");

            while (true) {
                Thread.sleep(500);
            }
        } catch (UnsatisfiedLinkError e) {
            System.err.println("platform does not support this driver");
        } catch (Exception e) {
            System.err.println("platform does not support this driver");

        }
    }
}
