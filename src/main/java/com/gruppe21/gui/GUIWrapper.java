package com.gruppe21.gui;

import com.gruppe21.Player;
import com.gruppe21.Square;
import gui_fields.*;
import gui_main.GUI;

import java.util.ArrayList;
import java.util.List;

public class GUIWrapper {
    private GUI gui;
    private List<GUI_Field> fields;
    private List<GUI_Player> players;

    public GUIWrapper() {
        fields = new ArrayList<GUI_Field>();
        GUI_Field start = new GUI_Start();
        start.setTitle("Start");
        start.setSubText("");
        fields.add(start);
        players = new ArrayList<GUI_Player>();
    }


    // Add a list of squares and turn them into fields.
    private void addSquares(List<Square> squareList) {
        for (Square square : squareList) {
            GUI_Field field = new GUI_Street();
            field.setTitle(square.getName());
            field.setSubText("" + square.getModifyValue());
            field.setDescription(square.getEventText());
            fields.add(field);
        }
    }

    // Has to be called every time new squares are added; Most likely only in the start of the game.
    public void reloadGUI(List<Square> squareList) {
        if (gui != null)
            gui.close();

        addSquares(squareList);
        gui = new GUI(fields.toArray(new GUI_Field[0]));
    }

    // First add players after gui reload
    public void addPlayer(Player player) {

        // Don't add if player is null
        if (player == null)
            return;
        // Check if player is already added
        for (GUI_Player pl : players) {
            if (pl.getName() == player.getName())
                return;
        }

        GUI_Player guiPlayer = new GUI_Player(player.getName());
        guiPlayer.setBalance(player.getBankBalance().getBalance());
        gui.addPlayer(guiPlayer);
    }

    public void setDice(int val1, int val2) {
        gui.setDice(val1, val2);
    }

    // Show message to player
    public void showMessage(String message) {
        gui.showMessage(message);
    }

    // Get a string input from player
    public String getStringInput(String message) {
        return gui.getUserString(message);

    }

    public GUI_Player getPlayer(int index) {
        return players.get(index);
    }

    public GUI_Player getPlayer(String name) {
        for (GUI_Player player : players) {
            if (player.getName() == name)
                return player;
        }
        return null;
    }


}
