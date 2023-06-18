import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class TuringMachine {
    List<List<List<String>>> transitionFunction = new ArrayList<List<List<String>>>();
    private String description;
    private List<String> states;
    private List<String> alphabet;
    private int sizeOfTape;
    private List<String> tape;
    private List<String> initialTape;
    private String finalState;
    private String initialState;
    private boolean isTuringMachineValid = true;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getStates() {
        return states;
    }

    public void setStates(List<String> states) {
        this.states = states;
    }

    public List<String> getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(List<String> alphabet) {
        this.alphabet = alphabet;
    }

    public int getSizeOfTape() {
        return sizeOfTape;
    }

    public void setSizeOfTape(int sizeOfTape) {
        this.sizeOfTape = sizeOfTape;
    }

    public List<String> getTape() {
        return tape;
    }

    public void setTape(List<String> tape) {
        this.tape = tape;
    }

    public List<String> getInitialTape() {
        return initialTape;
    }

    public void setInitialTape(List<String> initialTape) {
        this.initialTape = initialTape;
    }

    public String getFinalState() {
        return finalState;
    }

    public void setFinalState(String finalState) {
        this.finalState = finalState;
    }

    public String getInitialState() {
        return initialState;
    }

    public void setInitialState(String initialState) {
        this.initialState = initialState;
    }

    public List<List<List<String>>> getTransitionFunction() {
        return transitionFunction;
    }

    public void setTransitionFunction(List<List<List<String>>> transitionFunction) {
        this.transitionFunction = transitionFunction;
    }

    public void displayTuringMachine() {
        System.out.println("\n----------------------------------------------\n");
        System.out.println("Opis: " + this.description);

        System.out.println("Stany: " + this.states);

        System.out.println("Alfabet: " + this.alphabet);

        System.out.println("Dlugosc slowa: " + this.sizeOfTape);

        System.out.println("Slowo: " + this.tape);

        System.out.println("Stan koncowy: " + this.finalState);

        System.out.println("Stan poczatkowy: " + this.initialState);

//        System.out.println("Transition function: " + Arrays.deepToString(this.transitionFunction.toArray()));
        System.out.println("Instrukcja: ");
        int i = 0;
        for (List<List<String>> lists : this.transitionFunction) {
            System.out.println((i++) + "\n" + lists);
        }
    }

    public void readTuringMachineFromFile(String fileName) {
        try {
            // open the file
            File mt = new File(fileName);

            // local variables
            String[] lineSplit;
            boolean isTransitionFunction = false;
            boolean isTransitionFunctionInstruction = false;

            // read the file with turing machine
            Scanner sc = new Scanner(mt);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.startsWith("Opis")) {
                    lineSplit = line.split(": ");
                    this.setDescription(lineSplit[1]);
                } else if (line.startsWith("stany")) {
                    lineSplit = line.split(": ");
                    this.setStates(List.of(lineSplit[1].split(",")));
                } else if (line.startsWith("alfabet")) {
                    lineSplit = line.split(": ");
                    this.setAlphabet(List.of(lineSplit[1].split(",")));
                } else if (line.startsWith("długość słowa")) {
                    lineSplit = line.split(": ");
                    this.setSizeOfTape(Integer.parseInt(lineSplit[1]));
                } else if (line.startsWith("słowo")) {
                    // remove all whitespaces
                    line = line.replaceAll("\\s+", "");
                    lineSplit = line.split(":");

                    List<String> tmp = new ArrayList<>(List.of(lineSplit[1].split("")));

                    // add '_' to the start & the end of the instruction
                    tmp.add(0, "_");
                    tmp.add("_");

                    this.setTape(tmp);
                } else if (line.startsWith("stan końcowy")) {
                    lineSplit = line.split(": ");
                    this.setFinalState(lineSplit[1]);
                } else if (line.startsWith("stan początkowy")) {
                    lineSplit = line.split(": ");
                    this.setInitialState(lineSplit[1]);
                } else if (line.startsWith("instrukcja")) {
                    isTransitionFunction = true;
                    while (isTransitionFunction && sc.hasNextLine()) {
                        line = sc.nextLine();
                        if (line.startsWith(" ")) {
                            isTransitionFunctionInstruction = true;
                            List<List<String>> transitionFunctionInstruction = new ArrayList<List<String>>();
                            while (isTransitionFunctionInstruction) {
                                // remove all whitespaces
                                line = line.replaceAll("\\s+", "");

                                // write eg. 0; 1; _;
                                lineSplit = line.split(";");
                                List<String> instructionLine = new ArrayList<String>();
                                instructionLine.add(lineSplit[0]);

                                // write instructions for above
                                instructionLine.addAll(Arrays.asList(lineSplit[1].split(",")));

                                // check if instruction line contains symbols that is not in alphabet
                                if ((!this.alphabet.contains(instructionLine.get(0)) || !this.alphabet.contains(instructionLine.get(2))) && ((!instructionLine.get(0).matches("[rlsk]+")) || (!instructionLine.get(2).matches("[rlsk]+")))) {
                                    System.out.println("Instrukcja zawiera symbol/symbole ktore nie znajduja sie w alfabecie!");
                                    isTuringMachineValid = false;
                                    return;
                                }

                                // write whole line to transition function
                                transitionFunctionInstruction.add(instructionLine);

                                // break loop if new line is new state
                                if (sc.hasNextLine()) {
                                    line = sc.nextLine();
                                }
                                if (!line.startsWith(" ")) {
                                    // write whole 2d array to tm transition function
                                    this.transitionFunction.add(transitionFunctionInstruction);
                                    isTransitionFunctionInstruction = false;
                                }
                            }
                        }
                    }
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            isTuringMachineValid = false;
            System.out.println("\nNie znaleziono pliku z taka nazwa!\n");
        }
    }

    public void runTuringMachine() {
        if (isTuringMachineValid) {
            System.out.println("\n-------------------START----------------------\n");
            // save initial tape
            this.initialTape = new ArrayList<String>(this.tape);

            // set the head position on 1 because 0 is '_'
            int headPosition = 1;

            // current state to read instructions
            String currentState = this.initialState;
            String previousState = currentState;
            int currentStateIndex = this.states.indexOf(currentState);

            // current symbol on the tape
            String currentSymbol = this.tape.get(headPosition);

            while (!Objects.equals(currentState, "k")) {
                // display
                System.out.println(this.getTape());
                String tmp = " ";
                String repeated = tmp.repeat(headPosition * 3) + " \u2191";
                System.out.println(repeated);
                repeated = tmp.repeat(headPosition * 3) + "Stan: " + currentState;
                System.out.println(repeated + "\n");

                // get instruction for the current symbol in the current state
                for (int i = 0; i < this.transitionFunction.get(currentStateIndex).size(); ++i) {
                    if (Objects.equals(currentSymbol, this.transitionFunction.get(currentStateIndex).get(i).get(0))) {
                        List<String> instruction = this.transitionFunction.get(currentStateIndex).get(i);

                        // change state
                        currentState = instruction.get(1);
                        currentStateIndex = this.states.indexOf(currentState);

                        // change symbol on the tape
                        this.tape.set(headPosition, instruction.get(2));

                        // move head and update head position
                        switch (instruction.get(3)) {
                            case "r" -> {
                                headPosition++;
                                currentSymbol = this.tape.get(headPosition);
                            }
                            case "l" -> {
                                headPosition--;
                                currentSymbol = this.tape.get(headPosition);
                            }
                            case "s" -> {
                                System.out.println(this.getTape());
                                tmp = " ";
                                repeated = tmp.repeat(headPosition * 3) + " \u2191";
                                System.out.println(repeated);
                                repeated = tmp.repeat(headPosition * 3) + "Stan: " + currentState;
                                System.out.println(repeated + "\n");
                                System.out.println("--------------------END-----------------------\n");
                                System.out.println("Dzialanie maszyny skonczylo sie sukcesem.\nMaszyna zostala zatrzymana.\n");
                                System.out.println("Slowo przed modyfikacja: " + this.getInitialTape());
                                System.out.println("Slowo po modyfikacji:    " + this.getTape());
                                System.out.println("\n----------------------------------------------\n");
                                return;
                            }
                        }
                        // skip searching for instruction because it was already executed
                        break;
                    }
                }
            }

        }
    }

    public void writeToFile() {
        try {
            FileWriter myWriter = new FileWriter(this.description + "_wynik.txt");
            myWriter.write("Nazwa instrukcji: " + this.getDescription());
            myWriter.write("\nSlowo przed modyfikacja: " + this.getInitialTape());
            myWriter.write("\nSlowo po modyfikacji:    " + this.getTape());
            myWriter.write("\nStan koncowy: " + this.getFinalState());
            myWriter.close();
            System.out.println("Wynik zapisano do pliku.");
            System.out.println("\n----------------------------------------------\n");
        } catch (IOException e) {
            System.out.println("Wystapil blad!");
            e.printStackTrace();
        }
    }
}
