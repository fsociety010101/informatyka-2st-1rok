import javax.swing.*;
import java.awt.*;
import java.beans.Transient;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class CellularAutomaton extends JPanel {
    private final int[] B, S;
    private final int gridWidth, gridHeight;
    private final String boundaryCondition;
    private int[][] grid;
    private int generationCounter;

    public CellularAutomaton(int gridWidth, int gridHeight, int[] s, int[] b, String boundaryCondition) {
        this.gridWidth = gridWidth;
        this.gridHeight = gridHeight;
        this.grid = new int[gridWidth][gridHeight];
        this.S = s;
        this.B = b;
        this.boundaryCondition = boundaryCondition;
        this.generationCounter = 0;
    }

    public void readFromFile(String fileName) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            for (int i = 0; i < this.gridHeight; i++) {
                String[] gridLine = br.readLine().trim().split(" ");
                for (int j = 0; j < gridWidth; j++) {
                    this.grid[i][j] = Integer.parseInt(gridLine[j]);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void randomizeGrid() {
        System.out.println("\nLosowanie siatki...");
        Random random = new Random();
        for (int i = 0; i < this.gridHeight; ++i) {
            for (int j = 0; j < this.gridWidth; ++j) {
                if (random.nextDouble() < 0.6) continue;
                this.grid[i][j] = random.nextInt(2);
            }
        }
    }

    public void evaluateGrid() {
        int[][] tempGrid = new int[gridWidth][gridHeight];

        for (int i = 0; i < this.gridWidth; i++) {
            for (int j = 0; j < this.gridHeight; j++) {
                int neighboursCount = countNeighbours(i, j);
                if (grid[i][j] == 1) {
                    if (Arrays.stream(S).anyMatch(it -> it == neighboursCount)) {
                        tempGrid[i][j] = 1;
                    } else {
                        tempGrid[i][j] = 0;
                    }
                } else if (grid[i][j] == 0) {
                    if (Arrays.stream(B).anyMatch(it -> it == neighboursCount)) {
                        tempGrid[i][j] = 1;
                    } else {
                        tempGrid[i][j] = 0;
                    }
                }
            }
        }

        // traktujemy 0Row, 0Rol, sizeRow i sizeCol jako komorki zza krawedzia dla lepszej wizualizacji
        if (this.boundaryCondition.equals("przenikajace")) {
            // przenosimy zywe komorki zza krawedzia na przeciwlegla krawedz
            for (int i = 0; i < this.gridWidth; ++i) {
                if (tempGrid[0][i] == 1) {
                    tempGrid[0][i] = 0;
                    tempGrid[this.gridHeight - 2][i] = 1;
                }
                if (tempGrid[i][0] == 1) {
                    tempGrid[i][0] = 0;
                    tempGrid[i][this.gridWidth - 2] = 1;
                }
                if (tempGrid[this.gridHeight - 1][i] == 1) {
                    tempGrid[this.gridHeight - 1][i] = 0;
                    tempGrid[1][i] = 1;
                }
                if (tempGrid[i][this.gridWidth - 1] == 1) {
                    tempGrid[i][this.gridWidth - 1] = 0;
                    tempGrid[i][1] = 1;
                }
            }
        }
        this.grid = tempGrid.clone();
    }

    private int countNeighbours(int currIRow, int currJCol) {
        int count = 0;
        if (this.boundaryCondition.equals("odbijajace") && this.grid[currIRow][currJCol] == 0) {
            if (currIRow == 0 && currJCol == 0) count += 5;
            else if (currIRow == 0 && currJCol == this.gridHeight - 1) count += 5;
            else if (currIRow == this.gridWidth - 1 && currJCol == 0) count += 5;
            else if (currIRow == this.gridWidth - 1 && currJCol == this.gridHeight - 1) count += 5;
            else if (currIRow == 0 || currIRow == this.gridWidth - 1) count += 3;
            else if (currJCol == 0 || currJCol == this.gridHeight - 1) count += 3;
        }

        // sprawdzamy kazdy poziom dla i i j (index kolumny oraz wiersza)
        // -1 -1 -1
        //  0  0  0 dla kolumny
        //  1  1  1

        // -1  0  1
        // -1  0  1 dla wiersza
        // -1  0  1
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                // to jest komorka dla ktorej sprawdzamy sasiadow
                if (i == 0 && j == 0) {
                    continue;
                }
                int tempRow = currIRow + i;
                int tempCol = currJCol + j;
                // sprawdzamy czy index nie jest ujemny oraz sprawdzamy czy index nie "wychodzi" za wiersz/kolumne
                if (tempRow >= 0 && tempRow < this.gridWidth && tempCol >= 0 && tempCol < this.gridHeight) {
                    if (this.boundaryCondition.equals("przenikajace")) {
                        if (grid[tempRow][tempCol] == 1) {
                            // przenikajaca - jezeli komorka jest zywa zza "krawedzia" nie dodajemy sasiada
                            if (!(tempRow == 0 || tempCol == 0 || tempRow == this.gridWidth - 1 || tempCol == this.gridHeight - 1)) {
                                count++;
                            }
                        }
                    } else {
                        // sasiad zyje -> count++
                        if (grid[tempRow][tempCol] == 1) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    // wyswietlenie w konsoli ??
    private void displayGrid() {
        for (int i = 0; i < gridHeight; i++) {
            for (int j = 0; j < gridWidth; j++) {
                System.out.print(this.grid[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.println("\nEND\n");
    }

    @Override
    @Transient
    public Dimension getPreferredSize() {
        return new Dimension(this.gridWidth * 6, this.gridHeight * 6);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Color gColor = g.getColor();

        g.drawString("Generacja: " + generationCounter++, 0, 10);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    g.setColor(Color.black);
                    g.fillRect(j * 6, i * 6, 6, 6);
                }
            }
        }
        g.setColor(gColor);
    }
}
