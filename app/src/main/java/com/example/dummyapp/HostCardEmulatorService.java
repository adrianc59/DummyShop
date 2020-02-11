package com.example.dummyapp;

import android.nfc.cardemulation.HostApduService;
import android.os.Bundle;
import android.util.Log;

public class HostCardEmulatorService extends HostApduService {

    private static String tag = "Host Card Emulator";
    public static String message = "";
    private static String status_success = "0";
    private static String status_failed = "6F00";
    private static String cla_not_supported = "6E00";
    private static String ins_not_supported = "6D00";
    private static String aid = "00A4040007A0000002471002";
    private static String select_ins = "A4";
    private static String default_cla = "00";
    private static int min_apdu_length = 12;

    private Session session;

    @Override
    public void onDeactivated(int i) {
        message = "";
        session = new Session(this);

        session.setScanned(true);
    }

    @Override
    public byte[] processCommandApdu(byte[] commandApdu, Bundle bundle) {
        if(commandApdu == null){
            return Utils.hexStringToByteArray(status_failed);
        }

        String hexCommandApdu = Utils.toHex(commandApdu);

        if(hexCommandApdu.length() < min_apdu_length){
            return Utils.hexStringToByteArray(status_failed);
        }

        if (!hexCommandApdu.substring(0, 2).equals(default_cla)) {
            return Utils.hexStringToByteArray(cla_not_supported);
        }

        if (!hexCommandApdu.substring(2, 4).equals(select_ins)) {
            return Utils.hexStringToByteArray(ins_not_supported);
        }

        if (hexCommandApdu.substring(0, 24).equals(aid))  {
            return Utils.hexStringToByteArray(message);
        }
        else {
            return Utils.hexStringToByteArray(status_failed);
        }
    }
}
