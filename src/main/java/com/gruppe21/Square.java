package com.gruppe21;

import com.gruppe21.gui.GUIWrapper;

enum SquareType {
    Normal,
    ExtraTurn
}

public class Square {

    private String name;
    private String eventText;
    private int modifyValue;


    private SquareType squareType;

    Square(String _name, String _eventText, int _modifyValue, SquareType _squareType) {
        this.name = _name;
        this.eventText = _eventText;
        this.modifyValue = _modifyValue;
        this.squareType = _squareType;
    }

    public SquareType getSquareType() { return squareType; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getEventText() { return eventText; }

    public void setEventText(String eventText) { this.eventText = eventText; }

    public int getModifyValue() { return modifyValue; }

    public void setModifyValue(int modifyValue) { this.modifyValue = modifyValue; }


    public void handleEvent(Player player, GUIWrapper guiWrapper) {
        guiWrapper.showMessage(eventText);
        player.getBankBalance().addBalance(this.getModifyValue());
    }


}
