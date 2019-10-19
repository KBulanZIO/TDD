public class Zad1 {

    static char[][] answers = {
            {'\0','\0','\0'},
            {'\0','\0','\0'},
            {'\0','\0','\0'}
    };

    static char lastPlayer = '\0';

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
        for (int i=0; i<3; i++) {
            if (answers[0][i] == lastPlayer &&  answers[1][i] == lastPlayer && answers[2][i] == lastPlayer)
                return "Wygral " + lastPlayer;
        }
        return "Brak zwyciezcy";
    }

    public char nextPlayer() {
        if (lastPlayer == '\0' || lastPlayer == 'O')
            return 'X';
        else
            return 'O';
    }



}
