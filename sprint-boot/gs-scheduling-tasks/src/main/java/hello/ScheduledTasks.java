package hello;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

  private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

  private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

  /*
  @Scheduled(fixedRate = 5000)
  public void reportCurrentTime() {
    log.info("The time now is {}", dateFormat.format(new Date()));
  }
  */

  @Scheduled(fixedRate = 20000)
  public void myRequirements() {
    log.info("***** Scheduled Task Enter The time now is {}", dateFormat.format(new Date()));

    List<String> list = new ArrayList<>();
    list.add("Foo");
    list.add("Bar");

    List<String> emptyList = new ArrayList<>();

    // simulate the case of keep retrieving and processing the records until there is no longer available records to process.

    int min = 0;
    int max = 10;
    while (true) {
      log.info("");

      int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);

      log.info("random number is {}", randomNum);

      // an even random number will result to processing of records otherwise if it is odd, used an empty list.
      List<String> listToProcess = (randomNum % 2 == 0) ? list : emptyList;

      log.info("number of records to process {}", listToProcess.size());

      if (listToProcess.isEmpty()) {
        log.info("no record to process exiting the task.");
        break;
      }

      for (String e : list) {
        log.info("Processing {}", e);
      }
    }
    log.info("****** Scheduled Task Exit The time now is {}", dateFormat.format(new Date()));
  }
}
