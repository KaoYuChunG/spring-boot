package com.kao.oauth.repostiory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;


/**
 * .
 *
 */
@DataJpaTest
public class SysClientDetailsTest {
    @Autowired
    private SysClientDetailsRepository sysClientDetailsRepository;

    @Test
    public void autowiredSuccessWhenPassed() {
        assertNotNull(sysClientDetailsRepository);
    }

}
