import logging

mylogger = logging.getLogger(__name__)
mylogger.setLevel(logging.DEBUG)


def mydiv(a, b):
    try:
        c = a / b

    except Exception as e:
        mylogger.error(f"Message: function: {'mydiv'}, exception: {e}.")
    else:
        return c


if __name__ == '__main__':
    mydiv(4, 0)
