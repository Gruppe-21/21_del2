package com.gruppe21;

/** Repræsenterer en virtuel terning
 * @author Hildibjørg Didriksen,
 * @author Marcus Rappenborg Kjærsgaard
 * @author Frederik Lundsbjerg
 * @author Tobias Nyholm Maneschijn
 * @author Rasmus Nylander
 * @author Troels Christoffersen
 * @author https://github.com/tobiasmaneschijn/21_del1
 */

/**
 * This class is from CDIO1 (an earlier project) by the same Authors.
 * Code descriptions, class' and methods has been translated to english.
 */

public class Die {
    /**
     * One die has at least 2 sides.
     */
    private int faceValue;

    /**
     * Current value of die.
     */
    private int value;

    public Die(){
        value = -1;
        faceValue = 6;
    }
    public Die(int FaceValue){
        value = -1;
        this.faceValue = Math.max(2, FaceValue);
    }

    /**
     * Gets the amount of die sides.
     * @return  amount og die sides
     */
    public int getFaceValue(){
        return faceValue;
    }

    /**
     * Sets die value to a given integer.
     * @param value Value which die is set to
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Get face value of die.
     * @return  Die value
     */
    public int getValue() {
        return value;
    }

    /**
     * Convert die value to a string.
     * @return Die value as a string.
     */
    @Override
    public String toString() {
        return Integer.toString(value);
    }

    /**
     * Simulates a pseudo-random die throw.
     * @return value of die after throw as an integer.
     */
    public int throwDie() {
        value = (int) (Math.random() * faceValue + 1);
        return value;
    }

}
