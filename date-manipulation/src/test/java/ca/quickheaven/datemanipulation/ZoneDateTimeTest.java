package ca.quickheaven.datemanipulation;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

public class ZoneDateTimeTest {

    @Test
    public void checkZoneDateTime() throws Exception {
        // -Duser.timezone=Europe/Zurich
        /*
        When local standard time was about to reach
        Sunday, March 27, 2022, 2:00:00 am clocks were turned forward 1 hour to
        Sunday, March 27, 2022, 3:00:00 am local daylight time instead.

        When local daylight time is about to reach
        Sunday, October 30, 2022, 3:00:00 am clocks are turned backward 1 hour to
        Sunday, October 30, 2022, 2:00:00 am local standard time instead.
        */

        ZoneId zone = ZoneId.of("Europe/Zurich");
        ZonedDateTime beforeCEST = ZonedDateTime.of(2022, 3, 27, 1, 59, 0, 0, zone);
        System.out.println(beforeCEST.format(DateTimeFormatter.ISO_ZONED_DATE_TIME));

        ZonedDateTime startOfCEST = ZonedDateTime.of(2022, 3, 27, 2, 0, 0, 0, zone);
        System.out.println(startOfCEST.format(DateTimeFormatter.ISO_ZONED_DATE_TIME));

        ZonedDateTime afterCEST = ZonedDateTime.of(2022, 10, 30, 3, 0, 0, 0, zone);
        System.out.println(afterCEST.format(DateTimeFormatter.ISO_ZONED_DATE_TIME));

        // 2022-03-27T01:59+01:00[Europe/Zurich]
        // 2022-03-27T03:00+02:00[Europe/Zurich]
        // 2022-03-27T03:00+02:00[Europe/Zurich]

        String canonicalId = "Europe/Zurich";

        Date receiveDateBeforeDST = new SimpleDateFormat("MM/dd/yyyy HH:mm z").parse("03/27/2022 01:59 CET");
        boolean receiveDateBeforeDSTinDaylightTime = TimeZone.getTimeZone(canonicalId).inDaylightTime(receiveDateBeforeDST);
        System.out.println(receiveDateBeforeDST + " " + receiveDateBeforeDSTinDaylightTime);

        Date receiveDateOnDST = new SimpleDateFormat("MM/dd/yyyy HH:mm z").parse("03/27/2022 02:00 CEST");
        boolean receiveDateOnDSTinDaylightTime = TimeZone.getTimeZone(canonicalId).inDaylightTime(receiveDateOnDST);
        System.out.println(receiveDateOnDST + " " + receiveDateOnDSTinDaylightTime);

        receiveDateBeforeDST = new SimpleDateFormat("MM/dd/yyyy HH:mm z").parse("10/30/2022 01:59 CEST");
        receiveDateBeforeDSTinDaylightTime = TimeZone.getTimeZone(canonicalId).inDaylightTime(receiveDateBeforeDST);
        System.out.println(receiveDateBeforeDST + " " + receiveDateBeforeDSTinDaylightTime);

        receiveDateOnDST = new SimpleDateFormat("MM/dd/yyyy HH:mm z").parse("10/30/2022 02:00 CET");
        receiveDateOnDSTinDaylightTime = TimeZone.getTimeZone(canonicalId).inDaylightTime(receiveDateOnDST);
        System.out.println(receiveDateOnDST + " " + receiveDateOnDSTinDaylightTime);

        //Sun Mar 27 01:59:00 CET 2022 false
        //Sun Mar 27 03:00:00 CEST 2022 true
        //Sun Oct 30 01:59:00 CEST 2022 true
        //Sun Oct 30 02:00:00 CET 2022 false
    }

}
