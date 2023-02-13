package com.argon.sos.testing.test;

import init.biomes.TERRAINS;
import init.paths.PATHS;
import init.sprite.UI.UI;
import init.tech.TECHS;
import snake2d.CORE;

import static org.assertj.core.api.Assertions.assertThat;

public class BeforeGameCreatedAvailabilityTest {
    public static void test() {
        testCORE();
        testTERRAINS();
        testPATHS();
        testUI();
        testTECHS();
    }

    private static void testTECHS() {
        assertThat(TECHS.INFO()).as("TECHS.INFO()").isNotNull();
    }

    private static void testUI() {
        assertThat(UI.decor()).as("UI.decor()").isNotNull();
        assertThat(UI.FONT()).as("UI.FONT()").isNotNull();
        assertThat(UI.PANEL()).as("UI.PANEL()").isNotNull();
    }

    private static void testPATHS() {
        assertThat(PATHS.BASE()).as("PATHS.BASE()").isNotNull();
        assertThat(PATHS.CONFIG()).as("PATHS.CONFIG()").isNotNull();
        assertThat(PATHS.INIT()).as("PATHS.INIT()").isNotNull();
        assertThat(PATHS.RACE()).as("PATHS.RACE()").isNotNull();
        assertThat(PATHS.CACHE_DATA()).as("PATHS.CACHE_DATA()").isNotNull();
        assertThat(PATHS.CACHE_SCRIPT()).as("PATHS.CACHE_SCRIPT()").isNotNull();
        assertThat(PATHS.CACHE_TEXTURE()).as("PATHS.CACHE_TEXTURE()").isNotNull();
        assertThat(PATHS.DICTIONARY()).as("PATHS.DICTIONARY()").isNotNull();
        assertThat(PATHS.INIT_SETTLEMENT()).as("PATHS.INIT_SETTLEMENT()").isNotNull();
        assertThat(PATHS.INIT_WORLD()).as("PATHS.INIT_WORLD()").isNotNull();
        assertThat(PATHS.local()).as("PATHS.local()").isNotNull();
        assertThat(PATHS.MISC()).as("PATHS.MISC()").isNotNull();
        assertThat(PATHS.NAMES()).as("PATHS.NAMES()").isNotNull();
        assertThat(PATHS.SCRIPT()).as("PATHS.SCRIPT()").isNotNull();
        assertThat(PATHS.SOUND()).as("PATHS.SOUND()").isNotNull();
        assertThat(PATHS.SPRITE()).as("PATHS.SPRITE()").isNotNull();
        assertThat(PATHS.SPRITE_GAME()).as("PATHS.SPRITE_GAME()").isNotNull();
        assertThat(PATHS.SPRITE_SETTLEMENT()).as("PATHS.SPRITE_SETTLEMENT()").isNotNull();
        assertThat(PATHS.SPRITE_SETTLEMENT_MAP()).as("PATHS.SPRITE_SETTLEMENT_MAP()").isNotNull();
        assertThat(PATHS.SPRITE_UI()).as("PATHS.SPRITE_UI()").isNotNull();
        assertThat(PATHS.SPRITE_WORLD()).as("PATHS.SPRITE_WORLD()").isNotNull();
        assertThat(PATHS.TEXT()).as("PATHS.TEXT()").isNotNull();
        assertThat(PATHS.TEXT_CONFIG()).as("PATHS.TEXT_CONFIG()").isNotNull();
        assertThat(PATHS.TEXT_MISC()).as("PATHS.TEXT_MISC()").isNotNull();
        assertThat(PATHS.TEXT_SETTLEMENT()).as("PATHS.TEXT_SETTLEMENT()").isNotNull();
        assertThat(PATHS.TEXT_WORLD()).as("PATHS.TEXT_WORLD()").isNotNull();
        assertThat(PATHS.currentMods()).as("PATHS.currentMods()").isNotEmpty();
    }



    private static void testTERRAINS() {
        assertThat(TERRAINS.INFO()).as("TERRAINS.INFO()").isNotNull();
        assertThat(TERRAINS.MAP()).as("TERRAINS.MAP()").isNotNull();
        assertThat(TERRAINS.FOREST()).as("TERRAINS.FOREST()").isNotNull();
        assertThat(TERRAINS.WET()).as("TERRAINS.WET()").isNotNull();
        assertThat(TERRAINS.MOUNTAIN()).as("TERRAINS.MOUNTAIN()").isNotNull();
        assertThat(TERRAINS.NONE()).as("TERRAINS.NONE()").isNotNull();
        assertThat(TERRAINS.OCEAN()).as("TERRAINS.OCEAN()").isNotNull();
        assertThat(TERRAINS.ALL()).as("TERRAINS.ALL()").isNotEmpty();
    }

    private static void testCORE() {
        assertThat(CORE.getSoundCore()).as("CORE.getSoundCore()").isNotNull();
        assertThat(CORE.getGraphics()).as("CORE.getGraphics()").isNotNull();
        assertThat(CORE.getUpdateInfo()).as("CORE.getUpdateInfo()").isNotNull();
        assertThat(CORE.renderer()).as("CORE.renderer()").isNotNull();
        assertThat(CORE.GLThread()).as("CORE.GLThread()").isNotNull();
        assertThat(CORE.getInput()).as("CORE.getInput()").isNotNull();
    }
}
