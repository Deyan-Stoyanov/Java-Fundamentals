package java_advanced_03_05_2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ChessKnight {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[][] chess = new String[8][8];
        for (int i = 0; i < 8; i++) {
            String[] row = reader.readLine().split("\\|");
            for (int j = 0; j < 8; j++) {
                chess[i][j] = row[j];
            }
        }
        String knightInitialPosition = reader.readLine();
        String command;
        List<String> takenFigures = new ArrayList<>();
        int invalidMoves = 0;
        int outOfBoundMoves = 0;
        while(!"END".equalsIgnoreCase(command = reader.readLine())) {
            String[] moves = command.split(" -> ");
            int initialX = Integer.parseInt(Character.toString(moves[0].charAt(0)));
            int initialY = Integer.parseInt(Character.toString(moves[0].charAt(1)));
            int targetX = Integer.parseInt(Character.toString(moves[1].charAt(0)));
            int targetY = Integer.parseInt(Character.toString(moves[1].charAt(1)));
            if(!isValidMove(targetX, targetY, initialX, initialY)){
                invalidMoves++;
            } else {
                if(targetX < 0 || targetX > 7 || targetY < 0 || targetY > 7){
                    outOfBoundMoves++;
                }
                else {
                    if(chess[targetX][targetY].matches("[a-zA-Z]")){
                        takenFigures.add(chess[targetX][targetY]);
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String takenFigure : takenFigures) {
            sb.append(takenFigure).append(", ");
        }
        String figures = "";
        if(!sb.toString().isEmpty()){
            figures= sb.toString().substring(0, sb.toString().length() - 2);
        }
        System.out.println("Pieces take: " + figures);
        System.out.println("Invalid moves: " + invalidMoves);
        System.out.println("Board out moves: " + outOfBoundMoves);
    }

    private static boolean isValidMove(int targetX, int targetY, int initialX, int initialY) {
        return (targetX == (initialX + 1) && targetY == (initialY + 2)) || (targetX == (initialX + 1) && targetY == (initialY - 2)) || (targetX == (initialX + 2) && targetY == (initialY + 1)) || (targetX == (initialX + 2) && targetY == (initialY - 1)) || (targetX == (initialX - 1) && targetY == (initialY + 2)) || (targetX == (initialX - 1) && targetY == (initialY - 2)) || (targetX == (initialX - 2) && targetY == (initialY + 1)) || (targetX == (initialX - 2) && targetY == (initialY - 1));
    }
}
