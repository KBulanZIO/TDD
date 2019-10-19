import java.util.Arrays;

public class Zad1 {

    private static final int SIZE = 3;
    char[][] answers = {
            {'\0','\0','\0'},
            {'\0','\0','\0'},
            {'\0','\0','\0'}
    };

    char lastPlayer = '\0';

    private void checkAxis(int param) {
        if (param < 1 || param > 3)
            throw new RuntimeException("Wartość wykracza poza planszę");
    }

    private void setBox(int x, int y, char lastPlayer) {
        if (answers[x-1][y-1] != '\0') {
            throw new RuntimeException("Pole jest zajete");
        }
            answers[x-1][y-1] = lastPlayer;
    }

    public String play(int x, int y) {
        checkAxis(x);
        checkAxis(y);
        lastPlayer = nextPlayer();
        setBox(x,y,lastPlayer);
        if (isDraw() == "Wynik remisowy")
            return isDraw();
        return isWin();
    }

    public String isWin() {
        // Wygrana w wierszu
        for (int i=0; i<SIZE; i++) {
            if (answers[0][i] == lastPlayer &&  answers[1][i] == lastPlayer && answers[2][i] == lastPlayer)
                return "Wygral " + lastPlayer;
        }
        // Wygrana w kolumnie
        for (int i=0; i<SIZE; i++) {
            if (answers[i][0] == lastPlayer &&  answers[i][1] == lastPlayer && answers[i][2] == lastPlayer)
                return "Wygral " + lastPlayer;
        }
        // 1 przekatna
        if (answers[0][2] == lastPlayer &&  answers[1][1] == lastPlayer && answers[2][0] == lastPlayer)
            return "Wygral " + lastPlayer;
        // 2 przekatna
        if (answers[2][2] == lastPlayer &&  answers[1][1] == lastPlayer && answers[0][0] == lastPlayer)
            return "Wygral " + lastPlayer;
        return "Brak zwyciezcy";
    }

    public String isDraw() {
        for (int i=0; i<SIZE; i++) {
            for (int j=0; j<SIZE;j++) {
                if (answers[i][j] != 'X' && answers[i][j] != 'O')
                    return "Brak zwyciezcy";
            }
        }
        return "Wynik remisowy";
    }

    public char nextPlayer() {
        if (lastPlayer == '\0' || lastPlayer == 'O')
            return 'X';
        else
            return 'O';
    }



}
