'''
1.  Context:
    define the strategy field for storing a reference to a strategy object,
    and two methods, setStrategy and executeStrategy.

2.  Strategy:
    The Strategy interface has an abstract method that you can alter in concrete strategies.

3.  Concrete strategies:
    Define the concrete strategies which should implement the Strategy interface.
    These concrete strategies must have a common method that overrides the execute method of the Strategy interface.
'''

import random
from abc import ABC, abstractmethod


# Strategy interface
class Strategy(ABC):
    @abstractmethod
    def selection(self) -> None:
        pass


# Concrete strategies
class Rock(Strategy):
    def selection(self) -> str:
        return "Rock"


class Paper(Strategy):
    def selection(self) -> str:
        return "Paper"


class Scissors(Strategy):
    def selection(self) -> str:
        return "Scissors"


class Random(Strategy):
    def selection(self) -> str:
        options = ["Rock", "Paper", "Scissors"]
        return random.choice(options)


# Context class
class Game:
    strategy: Strategy

    def __init__(self, strategy: Strategy = None) -> None:
        if strategy is not None:
            self.strategy = strategy
        else:
            self.strategy = Random()

    def play(self, sec) -> None:
        s1 = self.strategy.selection()
        s2 = sec.strategy.selection()
        if s1 == s2:
            print("It's a tie")
        elif s1 == "Rock":
            if s2 == "Scissors":
                print("Player 1 wins!")
            else:
                print("Player 2 wins!")
        elif s1 == "Scissors":
            if s2 == "Paper":
                print("Player 1 wins!")
            else:
                print("Player 2 wins!")
        elif s1 == "Paper":
            if s2 == "Rock":
                print("Player 1 wins!")
            else:
                print("Player 2 wins!")


# PLayer 1 can select his strategy
player1 = Game(Paper())

# Player 2 gets to select
player2 = Game(Rock())

# After the second player choice, we call the play method
player1.play(player2)
