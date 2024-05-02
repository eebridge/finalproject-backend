package edu.iu.eebridge.finalproject.model;


public enum Occasion {
    MOTHERS_DAY, BIRTHDAY, THANK_YOU;

    @Override
    public String toString() {
        switch (this) {
            case MOTHERS_DAY:
                return "Mother's Day";
            case BIRTHDAY:
                return "Birthday";
            case THANK_YOU:
                return "Thank You";
            default:
                return null;
        }
    }

    public static Occasion toEnum(String value) {
        switch (value.toLowerCase()) {
            case "mother's day":
                return Occasion.MOTHERS_DAY;
            case "birthday":
                return Occasion.BIRTHDAY;
            case "thank you":
                return Occasion.THANK_YOU;
            default:
                return null;
        }
    }
}
