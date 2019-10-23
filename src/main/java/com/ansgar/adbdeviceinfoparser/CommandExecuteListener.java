package com.ansgar.adbdeviceinfoparser;

import java.util.List;

interface CommandExecuteListener {

    void onFinished(List<String> lines);

}
