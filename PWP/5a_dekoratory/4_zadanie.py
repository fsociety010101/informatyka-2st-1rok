class Foo(object):
    memory_arr = []

    def __init__(self, arg):
        self._arg = arg

    def __call__(self, a, b):
        res = self._arg(a, b)
        self.memory_arr.append(res)
        print("\nAdded to array! ", self.memory_arr)
        return res


@Foo
def multiply(a, b):
    return (a * b, "multiply")


@Foo
def divide(a, b):
    return (a / b, "divide")


@Foo
def add(a, b):
    return (a + b, "add")


@Foo
def subtract(a, b):
    return (a - b, "subtract")


print(multiply(2, 2))
print(divide(9, 3))
print(add(3, 2))
print(subtract(15, 5))
