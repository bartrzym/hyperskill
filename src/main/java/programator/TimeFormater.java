package programator;

class TimeFormater {


    static String formatter(long time) {
        String formatted;
        int min = (int) (time / 1000 / 60);
        int sec = (int) ((time - (min * 1000 * 60)) / 1000);
        int ms = (int) (time - ((min * 1000 * 60) + (sec * 1000)));

        formatted = " " + min + "min. " + sec + "sec. " + ms + "ms.";

        return formatted;

    }
}
