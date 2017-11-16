package com.ericsson.upg.runtime;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ShellCommandTest {
    public static void main(String[] args) {

        String USER360_DEPLOY_PATH = "/home/upg/user360/deploy/";
        String GET_ACTIVE_ALARMS_SH = "getActiveAlarms.sh";
        String command = USER360_DEPLOY_PATH + GET_ACTIVE_ALARMS_SH;
        // String command = "host -t a google.com";
        // String command = "route";
        // String command = "find ~ -type f -exec ls -l {} \\;";
        // String command = "find ~ -type f";

        // String output = execteCommand(command);
        String output2 = execteCommand("ls ~/workspace");
        // System.out.println(output);
        System.out.println(output2);
    }

    private static String execteCommand(String command) {
        StringBuffer stringBuffer = new StringBuffer();
        Process process;
        try {
            process = Runtime.getRuntime().exec(command);
            int i = process.waitFor();
            // System.out.println(i);
            BufferedReader bReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = bReader.readLine()) != null) {
                stringBuffer.append(line + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }
}
