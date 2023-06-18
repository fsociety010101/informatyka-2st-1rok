def tree_print(ex, depth=0):
    print('-' * depth, ex.__name__)

    for it in ex.__subclasses__():
        tree_print(it, depth + 3)


tree_print(BaseException)
