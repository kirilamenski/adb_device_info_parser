## About

Adb Device Infp Parser - library for receiving information about the android device via USB using adb.

## Usage

1. Add following code into build.gradle of your project:

```gradle

apply plugin: 'maven'


repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.kirilamenski:adb_device_info_parser:0.1.0'
}

```

2. Connect android via USB
3. Make sure you install [adb](https://developer.android.com/studio/command-line/adb) on your computer
4. Add java code:
```java
    public static void main(String[] args) {
        AdbDeviceInfo deviceInfo = new AdbDeviceInfo();
        List<Device> devices = deviceInfo.getDevices();
        if (devices.size() > 0) {
            Device device = devices.get(0);
            System.out.println(device.toString());
        }
    }
```
