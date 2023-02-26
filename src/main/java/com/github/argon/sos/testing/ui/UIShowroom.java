package com.github.argon.sos.testing.ui;

import init.sprite.SPRITES;
import settlement.main.SETT;
import snake2d.util.datatypes.DIR;
import snake2d.util.gui.GuiSection;
import snake2d.util.gui.clickable.CLICKABLE;
import snake2d.util.gui.renderable.RENDEROBJ;
import util.gui.misc.*;
import util.info.GFORMAT;
import view.interrupter.ISidePanel;

/**
 * An {@link ISidePanel} can be displayed on the left side in the game ui.
 */
public class UIShowroom extends ISidePanel {

    private final static String TEXT = "OK";

    private final static RENDEROBJ renderDummy = new RENDEROBJ.RenderDummy(40, 40);

    /**
     * a GStat can be used as a live updatable value to display in UI elements
     */
    private final GStat statDummy;

    public UIShowroom() {
        this.statDummy = new GStat() {
            @Override
            public void update(GText text) {
                // Current amount of rooms in settlement (just a dummy)
                GFORMAT.i(text, SETT.CITY().rooms.nrOfRooms());
            }
        };

        titleSet(ISidePanel.class.getName());

        // A GuiSection will give the ISidePanel a body to add other ui elements into
        this.section = new GuiSection();
        section.hoverInfoSet(GuiSection.class.getName());

        // Place GuiSections underneath with 10px space in between
        section.addRelBody(10, DIR.S, buttons());
        section.addRelBody(10, DIR.S, muhSection());
        section.addRelBody(10, DIR.S, chart());
        section.addRelBody(10, DIR.S, grid());
    }

    /**
     * Buttons and simple clickable stuff in the game.
     *
     * @return a gui section containing buttons of the game
     */
    private GuiSection buttons() {
        GuiSection guiSection = new GuiSection();

        // A GButt.BSection is a clickable box, which in itself can have other ui elements
        GuiSection buttonSection = new GButt.BSection().hoverInfoSet(GButt.BSection.class.getName());
        buttonSection.add(renderDummy);
        guiSection.addRight(10, buttonSection);

        // Transparent background; background glows on hover
        guiSection.addRight(10, new GButt.Panel(TEXT)
                .hoverInfoSet(GButt.Panel.class.getName()));
        // Clickable icon as button
        guiSection.addRight(10, new GButt.Icon(SPRITES.icons().m.arrow_right)
                .hoverInfoSet(GButt.Icon.class.getName()));
        // Clickable text or icon; color pulsates when hovered
        guiSection.addRight(10, new GButt.Glow(TEXT)
                .hoverInfoSet(GButt.Glow.class.getName()));
        // Extrovert button with icon
        guiSection.addRight(10, new GButt.Standalone(SPRITES.icons().m.arrow_right)
                .hoverInfoSet(GButt.Standalone.class.getName()));
        // Simple checkbox
        guiSection.addRight(10, new GButt.Checkbox()
                .hoverInfoSet(GButt.Checkbox.class.getName()));
        // Checkbox with text next to it
        guiSection.addRight(10, new GButt.CheckboxTitle(TEXT)
                .hoverInfoSet(GButt.CheckboxTitle.class.getName()));
        // Clickable area with text or icon and an updatable stat
        guiSection.addRight(10, new GButt.BStat2(TEXT, statDummy)
                .hoverInfoSet(GButt.BStat2.class.getName()));
        // Introvert button with text or icon
        guiSection.addRight(10, new GButt.ButtPanel(TEXT)
                .hoverInfoSet(GButt.ButtPanel.class.getName()));
        // A red X
        guiSection.addRight(10, new GButt.ButtPanelCheck()
                .hoverInfoSet(GButt.ButtPanelCheck.class.getName()));

        // A box where you can put two ui elements together
        guiSection.addRight(10, new CLICKABLE.Pair(
                new GButt.Icon(SPRITES.icons().m.arrow_right),
                new GButt.Icon(SPRITES.icons().m.arrow_left)
        ).hoverInfoSet(CLICKABLE.Pair.class.getName()));

        return guiSection;
    }

    private GuiSection muhSection() {
        GuiSection guiSection = new GuiSection();

        // DropDown with selections
        GDropDown<CLICKABLE> dropDown = new GDropDown<>("DropDown");
        dropDown.hoverInfoSet(GDropDown.class.getName());
        dropDown.add(new GButt.Glow("1"));
        dropDown.add(new GButt.Glow("2"));
        dropDown.add(new GButt.Glow("3"));
        dropDown.init(); // has to be initialized after adding
        guiSection.addRight(10, dropDown);

        // A box with a nice little frame, where you can put other ui elements into
        GBox gBox = new GBox();
        gBox.text(GBox.class.getName());
        guiSection.addRight(10, gBox);

        // I don't know how to get this thing to show up
//        GButtablePanel buttablePanel = new GButtablePanel();
//        buttablePanel.addTitle(TEXT);
//        buttablePanel.addButtons(
//            new GButt.Standalone(SPRITES.icons().m.arrow_left),
//            new GButt.Standalone(SPRITES.icons().m.arrow_right),
//            new GButt.Standalone(SPRITES.icons().m.arrow_down),
//            new GButt.Standalone(SPRITES.icons().m.arrow_up)
//        );
//        buttablePanel.hoverInfoSet(GButtablePanel.class.getName());
//        guiSection.addRight(10, buttablePanel);


        return guiSection;
    }

    private GuiSection chart() {
        GuiSection guiSection = new GuiSection();

        GChart chart = new GChart();
        chart.add(SETT.FACTION().kingdom().realm().population().total());
        chart.hoverInfoSet(GChart.class.getName());

        guiSection.add(chart);

        return guiSection;
    }

    private GuiSection grid() {
        GuiSection guiSection = new GuiSection();
        guiSection.hoverTitleSet(GGrid.class.getName());
        
        GGrid grid = new GGrid(guiSection, 100, 2, 0, 0, 0);
        grid.add(new GButt.Standalone(SPRITES.icons().m.arrow_left));
        grid.add(new GButt.Standalone(SPRITES.icons().m.arrow_right));
        grid.add(new GButt.Standalone(SPRITES.icons().m.arrow_down));
        grid.add(new GButt.Standalone(SPRITES.icons().m.arrow_up));

        return guiSection;
    }
}
