def zadanie9(a, b, c):
    tmp = (a, b, c)
    for it in tmp:
        if isinstance(it, str):
            print("Nazwa typu: string, wartosc:", it, "\n")
        elif isinstance(it, int):
            print("Nazwa typu: int, wartosc:", it, "\n")
        elif isinstance(it, float):
            print("Nazwa typu: float, wartosc:", it, "\n")


def zadanie10(arr, n, mod):
    for it in arr:
        if it < n and it % mod == 0:
            print(it)


def zadanie11(arr, n, mod1, mod2):
    res = []
    for it in arr:
        if it < n and it % mod1 == 0 and it % mod2 == 0:
            res.append(it)
    return res


def zadanie12(element):
    a, b = 0, 1
    while element:
        element -= 1
        a, b = b, a + b
    return a


def zadanie13(a, b, c):
    delta = b ** 2 - (4 * a * c)
    if delta < 0.0:
        return "brak pierwiastkow"
    elif delta == 0.0:
        return -b / (2.0 * a)
    else:
        return [(-b - delta ** 0.5) / (2.0 * a), (-b + delta ** 0.5) / (2.0 * a)]


def main():
    zadanie9("hello", 6, 3.8)

    # arr = [3, 4, 9, 10, 14, 16, 21, 24]
    # zadanie10(arr, 20, 4)

    # arr = [3, 4, 9, 10, 14, 16, 21, 24]
    # print(zadanie11(arr, 22, 3, 7))

    # for it in range(20):
    #     print(zadanie12(it))

    # print(zadanie13(1, 0, 1))


if __name__ == "__main__":
    main()
