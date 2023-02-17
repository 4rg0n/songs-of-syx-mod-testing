package com.github.argon.sos.testing.test;

import game.GAME;
import view.main.VIEW;

import static org.assertj.core.api.Assertions.assertThat;

public class RunningGameAvailabilityTest {
    public static void test() {
        testGAME();
        testVIEW();
    }

    private static void testGAME() {
        assertThat(GAME.texture()).as("GAME.texture()").isNotNull();
    }

    private static void testVIEW() {
        assertThat(VIEW.s()).as("VIEW.s()").isNotNull();
        assertThat(VIEW.b()).as("VIEW.b()").isNotNull();
        assertThat(VIEW.world()).as("VIEW.world()").isNotNull();
        assertThat(VIEW.messages()).as("VIEW.messages()").isNotNull();
        assertThat(VIEW.mouse()).as("VIEW.mouse()").isNotNull();
        assertThat(VIEW.saver()).as("VIEW.saver()").isNotNull();
        assertThat(VIEW.hoverBox()).as("VIEW.hoverBox()").isNotNull();
        assertThat(VIEW.inters()).as("VIEW.inters()").isNotNull();
        assertThat(VIEW.UI()).as("VIEW.UI()").isNotNull();
    }
}
