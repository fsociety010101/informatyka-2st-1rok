import re


class PcnnErrException(Exception):
    """pcnn is not valid"""

    pass


class IpErrException(Exception):
    """ip is not valid"""

    pass


class MaskErrException(Exception):
    """mask is not valid"""

    pass


class IpConfig:
    def __init__(self, pcnn_name, ip_addr, nn_mask):
        # pcnn check
        if re.search("^[\w]+", pcnn_name) is not None:
            self.__pcnn_name = pcnn_name
        else:
            try:
                raise PcnnErrException(pcnn_name, " is not valid PCnn!")
            except PcnnErrException as ex:
                print(ex)

        # ip addr check
        if re.search("^((25[0-5]|(2[0-4]|1[0-9]|[1-9]|)[0-9])(\.(?!$)|$)){4}$", ip_addr) is not None:
            self.__ip_addr = ip_addr
        else:
            try:
                raise IpErrException(ip_addr, " is not valid IP!")
            except IpErrException as ex:
                print(ex)

        # nn mask check
        if re.search("^([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})$", nn_mask) is not None:
            self.__nn_mask = nn_mask
        else:
            try:
                raise MaskErrException(nn_mask, " is not valid mask!")
            except MaskErrException as ex:
                print(ex)


def main():
    """
    Enter PCnn: pcnn-test
    Enter IP: 1.1.1.1
    Enter mask: 3D:F2:C9:A6:B3:4F
    """

    pcnn_name = input("Enter PCnn: ")
    ip_addr = input("Enter IP: ")
    nn_mask = input("Enter mask: ")

    test = IpConfig(pcnn_name, ip_addr, nn_mask)
    print(vars(test))


if __name__ == "__main__":
    main()
