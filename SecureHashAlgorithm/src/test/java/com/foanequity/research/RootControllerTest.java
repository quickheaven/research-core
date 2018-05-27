package com.foanequity.research;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(MockitoJUnitRunner.class)
public class RootControllerTest {

  private static final Logger logger = LoggerFactory.getLogger(RootControllerTest.class);

  @InjectMocks private RootController controller;

  private static final String TEXT = "abc";

  @Test
  public void checkGetShaByMessageDigest() {
    String actualResult = controller.getShaByMessageDigest(TEXT);
    assertNotNull(actualResult);
    logger.info(actualResult);
  }

  @Test
  public void checkGetShaByDigestUtils() {
    String actualResult = controller.getShaByDigestUtils(TEXT);
    assertNotNull(actualResult);
    logger.info(actualResult);
  }

  @Test
  public void checkShaResult() {
    String sha1 = controller.getShaByMessageDigest(TEXT);
    String sha2 = controller.getShaByDigestUtils(TEXT);
    assertEquals(sha1, sha2);
  }
}
