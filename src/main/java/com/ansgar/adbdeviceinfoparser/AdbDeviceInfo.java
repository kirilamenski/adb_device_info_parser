package com.ansgar.adbdeviceinfoparser;

import java.util.ArrayList;
import java.util.List;

public class AdbDeviceInfo {

    private final String RELEASE = "ro.build.version.release";
    private final String NAME = "ro.product.model";
    private final String SERIAL_ID = "ro.boot.serialno";


    public List<Device> getDevices() {
        List<Device> devices = new ArrayList<>();
        String command = String.format("adb shell getprop | grep -E '%s|%s|%s'", RELEASE, NAME, SERIAL_ID);
        CommandExecute execute = new CommandExecute();
        execute.execute(command, lines -> {
            Device device = new Device();
            for (String line : lines) {
                String[] deviceInf = line.replace("[", "")
                        .replace("]", "")
                        .split(": ");
                if (deviceInf.length == 2) setUpDevice(device, deviceInf);
            }
            devices.add(device);
        });

        return devices;
    }

    private void setUpDevice(Device device, String[] deviceInfo) {
        switch (deviceInfo[0]) {
            case RELEASE:
                device.setVersion(deviceInfo[1]);
                break;
            case NAME:
                if (device.getName() == null) device.setName(deviceInfo[1]);
                break;
            case SERIAL_ID:
                device.setId(deviceInfo[1]);
                break;
            default:
                break;
        }
    }

}
