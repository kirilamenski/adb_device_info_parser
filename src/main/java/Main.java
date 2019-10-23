import com.ansgar.adbdeviceinfoparser.AdbDeviceInfo;
import com.ansgar.adbdeviceinfoparser.Device;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        AdbDeviceInfo info = new AdbDeviceInfo();
        List<Device> devices = info.getDevices();
        for (Device device : devices) {
            System.out.println(device.toString());
        }
    }

}
