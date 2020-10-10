package com.takiya.Offer;

import java.util.HashMap;
import java.util.Map;

public class Offer_20 {
    public boolean isNumber(String s) {
        Map<State, Map<CharType, State>> transfer = new HashMap<>();

        Map<CharType, State> initMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_SPACE, State.STATE_INIT);
            put(CharType.CHAR_SIGN, State.STATE_INT_SIGN);
            put(CharType.CHAR_NUM, State.STAT_INTEGER);
            put(CharType.CHAR_POINT, State.STATE_POINT_WITHOUT_NUM);
        }};
        transfer.put(State.STATE_INIT, initMap);

        Map<CharType, State> integerMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUM, State.STAT_INTEGER);
            put(CharType.CHAR_POINT, State.STATE_POINT);
            put(CharType.CHAR_EXP, State.STATE_EXP);
            put(CharType.CHAR_SPACE, State.STATE_END);
        }};
        transfer.put(State.STAT_INTEGER, integerMap);

        Map<CharType, State> pointMap = new HashMap<CharType, State>() {{
           put(CharType.CHAR_NUM, State.STATE_FRACTION);
           put(CharType.CHAR_EXP, State.STATE_EXP);
           put(CharType.CHAR_SPACE, State.STATE_END);
        }};
        transfer.put(State.STATE_POINT, pointMap);

        Map<CharType, State> pointWithoutNumMap = new HashMap<CharType, State>() {{
           put(CharType.CHAR_NUM, State.STATE_FRACTION);
        }};
        transfer.put(State.STATE_POINT_WITHOUT_NUM, pointWithoutNumMap);

        Map<CharType, State> fractionMap = new HashMap<CharType, State>() {{
           put(CharType.CHAR_NUM, State.STATE_FRACTION);
           put(CharType.CHAR_SPACE, State.STATE_END);
           put(CharType.CHAR_EXP, State.STATE_EXP);
        }};
        transfer.put(State.STATE_FRACTION, fractionMap);

        Map<CharType, State> expMap = new HashMap<CharType, State>() {{
           put(CharType.CHAR_NUM, State.STATE_EXP_NUM);
           put(CharType.CHAR_SIGN, State.STATE_EXP_SIGN);
        }};
        transfer.put(State.STATE_EXP, expMap);

        Map<CharType, State> expNumMap = new HashMap<CharType, State>() {{
           put(CharType.CHAR_NUM, State.STATE_EXP_NUM);
           put(CharType.CHAR_SPACE, State.STATE_END);
        }};
        transfer.put(State.STATE_EXP_NUM, expNumMap);

        Map<CharType, State> expSignMap = new HashMap<CharType, State>() {{
           put(CharType.CHAR_NUM, State.STATE_EXP_NUM);
        }};
        transfer.put(State.STATE_EXP_SIGN, expSignMap);

        Map<CharType, State> intSignMap = new HashMap<CharType, State>() {{
           put(CharType.CHAR_NUM, State.STAT_INTEGER);
           put(CharType.CHAR_POINT, State.STATE_POINT_WITHOUT_NUM);
        }};
        transfer.put(State.STATE_INT_SIGN, intSignMap);

        Map<CharType, State> endMap = new HashMap<CharType, State>() {{
           put(CharType.CHAR_SPACE, State.STATE_END);
        }};
        transfer.put(State.STATE_END, endMap);

        State state = State.STATE_INIT;
        for (char c : s.toCharArray()) {
            CharType charType = toCharType(c);
            if (transfer.get(state).containsKey(charType)) {
                state = transfer.get(state).get(charType);
            } else {
                return false;
            }
        }
        return state == State.STATE_END ||
                state == State.STAT_INTEGER ||
                state == State.STATE_FRACTION ||
                state == State.STATE_EXP_NUM ||
                state == State.STATE_POINT;
    }
    enum CharType {
        CHAR_NUM,
        CHAR_POINT,
        CHAR_EXP,
        CHAR_SIGN,
        CHAR_SPACE,
        CHAR_ILLEGAL,
    }

    enum State {
        STATE_INIT,
        STAT_INTEGER,
        STATE_END,
        STATE_INT_SIGN,
        STATE_POINT,
        STATE_POINT_WITHOUT_NUM,
        STATE_FRACTION,
        STATE_EXP_NUM,
        STATE_EXP_SIGN,
        STATE_EXP,
    }

    private CharType toCharType(char c) {
        if (c >= '0' && c <= '9')
            return CharType.CHAR_NUM;
        else if (c == 'e' || c == 'E')
            return CharType.CHAR_EXP;
        else if (c == '.')
            return CharType.CHAR_POINT;
        else if (c == '+' || c == '-')
            return CharType.CHAR_SIGN;
        else if (c == ' ')
            return CharType.CHAR_SPACE;
        else
            return CharType.CHAR_ILLEGAL;
    }

    public static void main(String[] args) {
        System.out.println(+.8);
    }
}
