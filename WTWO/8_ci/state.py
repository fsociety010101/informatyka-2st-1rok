from __future__ import annotations

from abc import ABC, abstractmethod


# Context
class Metro:
    _state = None

    def __init__(self, state: State) -> None:
        self.set_metro(state)

    # change the state of the object
    def set_metro(self, state: State):
        self._state = state
        self._state.metro = self
        self.present_state()
        self.wait_for_passangers()

    def present_state(self):
        print(f"Metro is in {type(self._state).__name__}.\n")

    # methods for executing functionality
    def next_station(self):
        print("Metro moving to the next station...")
        self._state.next_station()

    def previous_station(self):
        print("Metro moving to the previous station...")
        self._state.previous_station()

    # wait for passengers
    def wait_for_passangers(self) -> None:
        print("Metro is waiting for passengers...\n")


# state interface
class State(ABC):
    @property
    def metro(self) -> Metro:
        return self._metro

    @metro.setter
    def metro(self, metro: Metro) -> None:
        self._metro = metro

    @abstractmethod
    def next_station(self) -> None:
        pass

    @abstractmethod
    def previous_station(self) -> None:
        pass


# states
class StationOne(State):
    def next_station(self) -> None:
        self.metro.set_metro(StationTwo())

    def previous_station(self) -> None:
        print("This is the first station. Cannot go back!\n")


class StationTwo(State):
    def next_station(self) -> None:
        self.metro.set_metro(StationThree())

    def previous_station(self) -> None:
        self.metro.set_metro(StationOne())


class StationThree(State):
    def next_station(self) -> None:
        print("This is the last station. Cannot go further!\n")

    def previous_station(self) -> None:
        self.metro.set_metro(StationTwo())


if __name__ == "__main__":
    myMetro = Metro(StationOne())

    myMetro.next_station()
    myMetro.next_station()
    myMetro.next_station()

    myMetro.previous_station()
    myMetro.previous_station()
    myMetro.previous_station()
