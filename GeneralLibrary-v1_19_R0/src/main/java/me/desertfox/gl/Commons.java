package me.desertfox.gl;

import java.util.Random;

public class Commons {

    public static boolean roll(double chance){
        return (new Random().nextDouble() * 100) <= chance;
    }

    public static long convertToSeconds(String time) {
        time = time.toLowerCase();
        long seconds = 0;
        int index = 0;
        if (!(time.contains("s") || time.contains("m") || time.contains("h") || time.contains("d")
                || time.contains("w") || time.contains("y"))) {
            return -1;
        }
        while (!time.equals("")) {
            char ch = time.charAt(index);
            switch (ch) {
                case 's':
                    seconds += Integer.parseInt(time.substring(0, index));
                    if (time.length() > index + 1) {
                        time = time.substring(index + 1);
                        index = 0;
                    } else {
                        return seconds;
                    }
                    break;
                case 'm':
                    if (time.charAt(index + 1 >= time.length() ? index : index + 1) == 'o') {
                        seconds += Long.parseLong(time.substring(0, index)) * 30 * 24 * 60 * 60;
                        if (time.length() > index + 2) {
                            time = time.substring(index + 2);
                            index = 0;
                        } else {
                            return seconds;
                        }
                    } else {
                        seconds += Long.parseLong(time.substring(0, index)) * 60;
                        if (time.length() > index + 1) {
                            time = time.substring(index + 1);
                            index = 0;
                        } else {
                            return seconds;
                        }
                    }
                    break;
                case 'h':
                    seconds += Long.parseLong(time.substring(0, index)) * 60 * 60;
                    if (time.length() > index + 1) {
                        time = time.substring(index + 1);
                        index = 0;
                    } else {
                        return seconds;
                    }
                    break;
                case 'd':
                    seconds += Long.parseLong(time.substring(0, index)) * 60 * 60 * 24;
                    if (time.length() > index + 1) {
                        time = time.substring(index + 1);
                        index = 0;
                    } else {
                        return seconds;
                    }
                case 'w':
                    seconds += Long.parseLong(time.substring(0, index)) * 60 * 60 * 24 * 7;
                    if (time.length() > index + 1) {
                        time = time.substring(index + 1);
                        index = 0;
                    } else {
                        return seconds;
                    }
                case 'y':
                    seconds += Long.parseLong(time.substring(0, index)) * 60 * 60 * 24 * 365;
                    if (time.length() > index + 1) {
                        time = time.substring(index + 1);
                        index = 0;
                    } else {
                        return seconds;
                    }
            }
            index++;
        }
        return seconds;
    }
}
