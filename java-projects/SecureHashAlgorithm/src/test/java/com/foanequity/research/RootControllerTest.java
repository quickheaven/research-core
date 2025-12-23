package com.foanequity.research;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ExtendWith(MockitoExtension.class)
public class RootControllerTest {

  private static final Logger logger = LoggerFactory.getLogger(RootControllerTest.class);

  @InjectMocks private RootController controller;

  private static final String TEXT = "abc";

  @Test
  public void checkGetShaByMessageDigest() {
    String actualResult = controller.getShaByMessageDigest(TEXT);
    Assertions.assertNotNull(actualResult);
    logger.info(actualResult);
  }

  @Test
  public void checkGetShaByDigestUtils() {
    String actualResult = controller.getShaByDigestUtils(TEXT);
    Assertions.assertNotNull(actualResult);
    logger.info(actualResult);
  }

  @Test
  public void checkShaResult() {
    String sha1 = controller.getShaByMessageDigest(TEXT);
    String sha2 = controller.getShaByDigestUtils(TEXT);
    Assertions.assertEquals(sha1, sha2);
  }
}
