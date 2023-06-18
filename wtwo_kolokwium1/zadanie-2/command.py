from abc import ABC


class Command(ABC):
    def __init__(self, ):
        self.receiver = receiver

    def process(self):
        pass


class CommandImplementation(Command):
    def __init__(self, receiver):
        self.receiver = receiver

    def process(self):
        self.receiver.perform_action()


class Receiver:
    def __init__(self, imie, nazwisko, pkt):
        self.imie = imie
        self.nazwisko = nazwisko
        self.pkt = pkt

    def perform_action(self, ):
        print('Wydano wode.')


class Invoker:
    def command(self, cmd):
        self.cmd = cmd

    def wydawanieWody(self):
        if self.cmd.receiver.pkt < 10:
            print("Czekaj az osoby z >= 10pkt otrzymaja wode")
        elif self.cmd.receiver.pkt >= 10:
            self.cmd.process()


if __name__ == "__main__":
    receiver1 = Receiver("imie1", "nazwisko1", 45)
    receiver2 = Receiver("imie2", "nazwisko2", 9)

    cmd1 = CommandImplementation(receiver1)
    cmd2 = CommandImplementation(receiver2)

    invoker = Invoker()

    invoker.command(cmd1)
    invoker.wydawanieWody()

    invoker.command(cmd2)
    invoker.wydawanieWody()
