package com.ansgar.adbdeviceinfoparser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class CommandExecute {

    void execute(String command, CommandExecuteListener listener) {
        Process process = null;
        BufferedReader stream = null;

        try {
            process = Runtime.getRuntime().exec(command);
            stream = new BufferedReader(new InputStreamReader(process.getInputStream()));
            List<String> lines = new ArrayList<>();
            String line;
            while ((line = stream.readLine()) != null) {
                lines.add(line);
            }
            listener.onFinished(lines);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (process != null) process.destroyForcibly();
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
