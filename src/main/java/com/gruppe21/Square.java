package com.gruppe21;

public class Square {

    String name;
    String eventText;
    int modifyValue;

    Square(String _name, String _eventText, int _modifyValue) {
        this.name = _name;
        this.eventText = _eventText;
        this.modifyValue = _modifyValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEventText() {
        return eventText;
    }

    public void setEventText(String eventText) {
        this.eventText = eventText;
    }

    public int getModifyValue() {
        return modifyValue;
    }

    public void setModifyValue(int modifyValue) {
        this.modifyValue = modifyValue;
    }


    public void handleEvent(Player player) {
        System.out.println(eventText);
        //TODO add modifyValue to bankBalance
    }


}
