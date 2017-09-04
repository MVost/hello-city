import java.time.Clock;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public class HelloCity {
    String cityName;

    public HelloCity(String cityName) {
        this.cityName = cityName;
    }

    public String getHello() {
        String result = new String();

        if (!cityName.contains("/")) {
            List<String> zoneList = new ArrayList<>(ZoneId.getAvailableZoneIds());

            for (String element : zoneList) {
                if (element.contains(cityName)) {
                    cityName = element;
                }
            }
        }

        if (!cityName.contains("/")) {
            return "Указанного населенного пункта в базе часовых зон нет!";
        } else {


            TimeZone tz = TimeZone.getTimeZone(cityName);

            Calendar c = Calendar.getInstance(tz);
            int hour = c.get(Calendar.HOUR_OF_DAY);

            cityName = cityName.substring(cityName.indexOf('/') + 1);

            if (hour >= 6 && hour < 9) {
                result = ("Good morning, " + cityName + "!\n" +
                        "Доброе утро, " + cityName + "!\n");
            }

            if (hour >= 9 && hour < 19) {
                result = ("Good day, " + cityName + "!\n" +
                        "Добрый день, " + cityName + "!\n");
            }

            if (hour >= 19 && hour < 23) {
                result = ("Good evening, " + cityName + "!\n" +
                        "Добрый вечер, " + cityName + "!\n");
            }

            if (hour >= 23 || hour >= 0 && hour < 6) {
                result = ("Good night, " + cityName + "!\n" +
                        "Доброй ночи, " + cityName + "!\n");
            }

            return result;
        }
    }
}
