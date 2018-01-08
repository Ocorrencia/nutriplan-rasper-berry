/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPin;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import dao.EventosDao;
import dao.RefugoDao;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import pojo.Refugo;
import tela.TelaOP;
import tela.TelaRefugo;

/**
 *
 * @author diogo.melo
 */
public class ListenGPIO {

    Refugo refugo;
    RefugoDao refugoDao = new RefugoDao();
    EnviarEmail enviarEmail = new EnviarEmail();
    boolean b1 = false;
    boolean b2 = false;

    public ListenGPIO() {
        try {
            new Thread() {
                @Override
                public void run() {
                    final GpioController gpio = GpioFactory.getInstance();
                    final GpioPinDigitalInput botaoRefugo = gpio.provisionDigitalInputPin(RaspiPin.GPIO_02, PinPullResistance.PULL_DOWN);
                    final GpioPinDigitalInput botao1 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_25, PinPullResistance.PULL_DOWN);
                    final GpioPinDigitalInput botao2 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_05, PinPullResistance.PULL_DOWN);
                    final GpioPinDigitalInput botao3 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_06, PinPullResistance.PULL_DOWN);
                    botaoRefugo.setShutdownOptions(true);
                    botaoRefugo.addListener(new GpioPinListenerDigital() {
                        @Override
                        public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                            if (event.getState() == PinState.HIGH && event.getPin() == botaoRefugo) {
                                enviarRefugo();
                            }
                        }
                    });
                    botao1.addListener(new GpioPinListenerDigital() {
                        @Override
                        public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                            if (event.getState() == PinState.HIGH && event.getPin() == botao1) {
                                b1 = true;
                            }
                        }
                    });
                    botao2.addListener(new GpioPinListenerDigital() {
                        @Override
                        public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                            if (event.getState() == PinState.HIGH && event.getPin() == botao2) {
                                if (b1) {
                                    b2 = true;
                                } else {
                                    Notificacao.infoBox("ORDEM DE INJEÇÃO INCORRETA", false);
                                    try {
                                        enviarEmail.enviaEmail("INJETORA COM PROBLEMA", "ORDEM INCORRETA NA INJEÇÃO DE PLÁSTICO");
                                    } catch (MessagingException ex) {
                                        Logger.getLogger(EventosDao.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                  //  relay(false);
                                }
                            }
                        }
                    });
                    botao3.addListener(new GpioPinListenerDigital() {
                        @Override
                        public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                            System.out.println("b3");
                            if (event.getState() == PinState.HIGH && event.getPin() == botao3 && b1 && b2) {
                                DadosRaspberry.QUANTIDADEPRODUZIDA = DadosRaspberry.QUANTIDADEPRODUZIDA + 1;
                                TelaOP.getTela().controleProducao();
                                b1 = false;
                                b2 = false;
                                System.out.println("b3 ok");
                            } else {
                                b1 = false;
                                b2 = false;
                            }
                        }
                    });
                }
            }.start();
        } catch (UnsatisfiedLinkError e) {
            System.out.println(e.getMessage());
            Notificacao.infoBox("BOTÃO DE REFUGO NÃO ESTÁ ATIVO", true);
            try {
                enviarEmail.enviaEmail(e.getMessage(), "PROBLEMA NO BOTAO DE REFUGO");
            } catch (MessagingException ex) {
                Logger.getLogger(EventosDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Notificacao.infoBox("BOTÃO DE REFUGO NÃO ESTÁ ATIVO", true);
            try {
                enviarEmail.enviaEmail(e.getMessage(), "PROBLEMA NO BOTAO DE REFUGO");
            } catch (MessagingException ex) {
                Logger.getLogger(EventosDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void relay(boolean energy) {
        final GpioController gpio = GpioFactory.getInstance();
        final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_23, "RELAY", PinState.LOW);

        if (energy) {
            pin.setShutdownOptions(true, PinState.HIGH);
            pin.low();
        } else {
            pin.toggle();
        }
    }

    public void enviarRefugo() {
        if (Enums.STATUSTELA == 2) {
            if (Integer.parseInt(TelaOP.tela.campoQuantidadeProgramada.getText().replace("UN", "").trim()) <= Enums.REFUGOSJUSTIFICADOS + Enums.REFUGOSNAOIDENTIFICADOS) {
                Notificacao.infoBox("QUANTIDADE EXCEDE A PROGRAMADA", false);
            } else if (Integer.parseInt(TelaOP.tela.campoQuantidadeRealizada.getText().replace("UN", "").trim()) == 0) {
                Notificacao.infoBox("QUANTIDADE REALIZADA AINDA É 0", false);
            } else if (Enums.REFUGOSNAOIDENTIFICADOS > Consulta.CONSULTAINT("nutri_op.op900eoq", "SUM(QTDRE1)", "EXPERP = 0 AND QTDRE1 = 1")) {
                Notificacao.infoBox("NÃO HÁ SALDO PARA REFUGO", false);
            } else if (Integer.parseInt(TelaOP.tela.campoQuantidadeProgramada.getText().replace("UN", "").trim()) <= Integer.parseInt(TelaOP.tela.campoQuantidadeRealizada.getText().replace("UN", "").trim())) {
            } else {
                Enums.REFUGOSNAOIDENTIFICADOS = Enums.REFUGOSNAOIDENTIFICADOS + 1;
                if (TelaRefugo.tela != null) {
                    TelaRefugo.tela.campoQuantidadeNaoJustificados.setText("0" + Enums.REFUGOSNAOIDENTIFICADOS);
                }
                TelaOP.tela.campoQuantidadeRefugo.setText(Enums.REFUGOSJUSTIFICADOS + Enums.REFUGOSNAOIDENTIFICADOS + " UN");
                TelaOP.tela.adicionarRefugo(1);
                Refugo.setQuantidade(1);
                refugoDao.atualizar();
            }
        } else {
            Notificacao.infoBox("BOTÃO BLOQUEADO", false);
        }
    }

    public void enviarCiclo() {

        final long time = 4000; // a cada X ms
        Timer timer = new Timer();

        TimerTask tarefa = new TimerTask() {
            public void run() {
                try {

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        timer.scheduleAtFixedRate(tarefa, time, time);
    }
}

/* */
