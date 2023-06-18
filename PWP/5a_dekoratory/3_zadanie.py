def get_temp_by_unit(old_fun):
    def new_fun(temp, unit):
        if unit == "celsius":
            return old_fun(temp - 273.15, unit)
        elif unit == "fahrenheit":
            return old_fun((1.8 * temp - 273) + 32, unit)
        else:
            print("Bad unit!")

    return new_fun


@get_temp_by_unit
def get_temp(temp, unit):
    print(temp, unit)


get_temp(15, "celsius")
get_temp(15, "fahrenheit")
get_temp(15, "test")
