package topdownparser;

public class TopDownParser {
    private char[] parseStringCharacterArray;
    private int index = 0;

    public TopDownParser(char[] parseStringCharacterArray) {
        this.parseStringCharacterArray = parseStringCharacterArray;
    }

    private boolean match(char currentChar) {
        if(index >= parseStringCharacterArray.length) {
            return false;
        } else if(parseStringCharacterArray[index] == currentChar) {
            index += 1;
            return true;
        } else {
            return false;
        }
    }

    private boolean F() {
        if(match('(')) {
            if(E()) {
                if(match(')')) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else if(match('x')) {
            return true;
        } else {
            return false;
        }
    }

    private boolean Tx() {
        if(match('*')) {
            if(F()) {
                if(Tx()) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

    private boolean T() {
        if(F()) {
            if(Tx()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean Ex() {
        if(match('+')) {
            if(T()) {
                if(Ex()) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

    private boolean E() {
        if(T()) {
            if(Ex()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean result() {
        if(E()) {
            if(this.index == this.parseStringCharacterArray.length) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
