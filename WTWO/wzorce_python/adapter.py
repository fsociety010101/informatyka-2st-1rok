class Target:
    """
    The Target defines the domain-specific interface used by the client code.
    """

    def request(self) -> str:
        return "Target: The default target's behavior."


class Adaptee:
    """
    The Adaptee contains some useful behavior, but its interface is incompatible
    with the existing client code. The Adaptee needs some adaptation before the
    client code can use it.
    """

    def specific_request(self) -> str:
        return "Vroooom!"


class Adapter(Target, Adaptee):
    """
    The Adapter makes the Adaptee's interface compatible with the Target's
    interface via multiple inheritance.
    """

    def request(self) -> str:
        if self.specific_request() == "Vroooom!":
            return "Car is accelerating..."


if __name__ == "__main__":
    target = Target()
    print(target.request() + '\n')

    adaptee = Adaptee()
    print(adaptee.specific_request() + '\n')

    adapter = Adapter()
    print(adapter.request() + '\n')
